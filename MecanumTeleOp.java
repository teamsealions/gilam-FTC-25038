package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class MecanumTeleOp extends OpMode {

    //Variables
    double ticks = 288;
    double newTarget;
    double liftSpeed = 0.8;
    double speedMultiplier = 0.7;

    double liftWatchDog = 10;
    
    boolean manualMode;

    // Declare our motors
    // Make sure your ID's match your configuration
    DcMotor frontLeftMotor;
    DcMotor backLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backRightMotor;
    DcMotor liftRight;
    DcMotor liftLeft;

    //Servos
    Servo angleServo;
    Servo airplane;
    Servo pixelRight;
    Servo pixelLeft;
    double speed = 0.7;


    @Override
    public void init() {
        // Motors
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor"); //0
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
        liftRight = hardwareMap.dcMotor.get("liftRightMotor"); //0
        liftLeft = hardwareMap.dcMotor.get("liftLeftMotor"); //1
        //Servos
         angleServo = hardwareMap.servo.get("angleServo");
         airplane = hardwareMap.servo.get("airplaneServo");
         pixelRight = hardwareMap.servo.get("pixelRight");
         pixelLeft = hardwareMap.servo.get("pixelLeft");


        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        liftRight.setDirection(DcMotorSimple.Direction.REVERSE);
        liftLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        liftRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        run_encoder(0, 0.5, liftLeft);
        run_encoder(0, 0.5, liftRight);
        liftLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        angleServo.setPosition(0.8);
        manualMode = false;
    }
        @Override
        public void loop() {
            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = -gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            if(gamepad1.y){
                if (speed == 0.7){
                    speed = 0.3;
                }else{
                    speed = 0.7;
                }

            }
            speed = Range.clip(gamepad1.right_trigger*0.7,0.3,0.7);


//            if (!gamepad1.right_bumper)
//                speed = gamepad1.right_trigger;
            double balance = 0.00; //C.G corrector
            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = ((y + x + rx) / denominator) * speed;
            double backLeftPower = ((y - x+ rx + balance) / denominator) * speed;
            double frontRightPower = ((y - x - rx) / denominator) * speed;
            double backRightPower = ((y + x - rx + balance) / denominator) * speed;

            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);

            //Pixel Operation:
            if (gamepad2.right_bumper) {
                pixelRight.setPosition(0);
                telemetry.addData("servo", "right");
            } else {
                pixelRight.setPosition(0.3);
            }
            if (gamepad2.left_bumper) {
                pixelLeft.setPosition(0.3);
                telemetry.addData("servo", "left");
            } else {
                pixelLeft.setPosition(0);
            }
            // Airplane Servo
            if (gamepad2.a) {
                airplane.setPosition(1);
            } else {
                airplane.setPosition(0.8);
            }

            //Lift Modes
            if (gamepad2.dpad_up) { // Controls Pixel arm Position - UP
                run_encoder(0.5, liftSpeed, liftRight);
                run_encoder(0.5, liftSpeed, liftLeft);
                angleServo.setPosition(0.45);//armServo position - UP

            }
            if (gamepad2.dpad_down) { // Controls Pixel arm Position - UP
                run_encoder(0.13, liftSpeed, liftRight);
                run_encoder(0.13, liftSpeed, liftLeft);
                angleServo.setPosition(0);//armServo position - DOWN
            }
            if (gamepad2.dpad_right) { // Prepare for lift
                run_encoder(1.2, 1, liftLeft);
                run_encoder(1.2, 1, liftRight);
                angleServo.setPosition(0);
            }
            if (gamepad2.dpad_left) { // Lift entire Robot
                run_encoder(0, 1, liftLeft);
                run_encoder(0, 1, liftRight);
                angleServo.setPosition(0.3);
            }

            if (gamepad2.b) {
                angleServo.setPosition(angleServo.getPosition() + 0.005);
            }
            if (gamepad2.x) {
                angleServo.setPosition(angleServo.getPosition() - 0.005);
            }



            telemetry.addData("lift Power:", liftLeft.getPower());
            telemetry.addData("Manual Mode:", manualMode);


            int version = 2;
            telemetry.addData("speed: ",speed);
            telemetry.addData("version:" ,version );
            telemetry.addData("left front speed:",frontLeftPower);
            telemetry.addData("left back speed:",backLeftPower);
            telemetry.addData("right front speed:",frontRightPower);
            telemetry.addData("right back speed:",backRightPower);
            telemetry.addData("lift position:", liftRight.getCurrentPosition());
            telemetry.addData("lift power:", liftLeft.getPower());
        }

    public void run_encoder(double turnage, double power, DcMotor motor) {
        newTarget = ticks * turnage;
        motor.setTargetPosition((int) newTarget);
        motor.setPower(power);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}