package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "pushbot" )
  // motor's and servo's name's
public class pushbot extends OpMode {
    public Servo armS;
    public Servo graberS;
    DcMotor driveR;
    DcMotor driveL;
    DcMotor armR;
    DcMotor armL;
    double ticks = 288;
    double newTarget;
    double left_bump;
    double right_bump;
    double powerMultiplier = 1;
    double rightToggle;
    boolean flag_arm = false;

    @Override
    public void init() {

        armS = hardwareMap.get(Servo.class, "armS");
        graberS = hardwareMap.get(Servo.class, "graberS");

        armL = hardwareMap.get(DcMotor.class, "armL");
        armL.setDirection(DcMotor.Direction.REVERSE);
        armL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armR = hardwareMap.get(DcMotor.class, "armR");
        armR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        driveR = hardwareMap.get(DcMotor.class, "driveR");
        driveL = hardwareMap.get(DcMotor.class, "driveL");
        driveL.setDirection(DcMotorSimple.Direction.REVERSE);


        //set start position
        armS.setPosition(0.9);
        graberS.setPosition(0);

        //set scale
        //armS.scaleRange(0.4, 1);
        //graberS.scaleRange(0.2, 0.8);

        telemetry.addData("App", "working");
    }
     //controls
    @Override
    public void loop() {
        rightToggle = gamepad1.right_trigger;
        telemetry.addData("Controls","b/y for graber. x/a for servo arm");
        telemetry.addData("Controls","RB for powerAdjusting, RT for arm");
        telemetry.addData("RT",rightToggle);
        if (gamepad1.a) {
            armS.setPosition(1);
        }
        if (gamepad1.x) {
            armS.setPosition(0.4 );
        }

        if (gamepad1.b) {
            graberS.setPosition(0.5);
        }
        if (gamepad1.y) {
            graberS.setPosition(0.1);
        }
        right_bump = gamepad1.right_trigger;
        left_bump = gamepad1.left_trigger;

        /*armL.setPower(right_bump - left_bump);
        armR.setPower(right_bump - left_bump);
        telemetry.addData("arm" , "move");*/

        if (gamepad1.right_bumper) {
            run_encoder(1.9, 0.7, armR);
            run_encoder(1.9, 0.7, armL);
        }
        if (gamepad1.left_bumper){
            run_encoder(0.0, 0.5, armR);
            run_encoder(0.0, 0.5, armL);
        }

        double forward = gamepad1.left_stick_y;
        telemetry.addData("forward value:",forward);
        double side = gamepad1.right_stick_x;
        telemetry.addData("side value:", side);

        driveR.setPower((-side+forward)*0.7);
        driveL.setPower((side+forward)*0.7);




    }


    public void run_encoder(double turnage, double power, DcMotor motor) {
        newTarget = ticks * turnage;
        motor.setTargetPosition((int) newTarget);
        motor.setPower(power);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}
