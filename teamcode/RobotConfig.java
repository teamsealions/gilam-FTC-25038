package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class RobotConfig {
    HardwareMap hardwareMap;
    // Public motors and servos
    public DcMotor frontLeftMotor;
    public DcMotor backLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor backRightMotor;
    public DcMotor liftRight;
    public DcMotor liftLeft;

    //Servos
    public Servo angleServo;
    public Servo airplane;
    public Servo pixelRight;
    public Servo pixelLeft;

    // Static Variables
    public static final int ticks = 288;
    public static final double high_speed = 0.8;
    public static final double low_speed = 0.4;
    public static double speed_adjust = 0;
    public static double new_target = 0;
    public static double balance = 0.05;
    public static final double left_pixel_open_pos = 0;
    public static final double left_pixel_close_pos = 0.3;
    public static final double right_pixel_open_pos = 0.3;
    public static final double right_pixel_close_pos = 0;

    public static final double airplane_launch = 1;
    public static final double airplane_hold = 0.85;

    // Static arms and pixel angle positions
    public static final double arms_pickup_pos = 0.1;
    public static final double pixels_pickup_pos = 0;
    public static final double power_pickup_pos = 0.3;

    public static final double arms_board_pos = 0.3;
    public static final double pixels_board_pos = 0.5;
    public static final double power_board_pos = 0.5;

    public static final double arms_before_hanging_pos = 1.1;
    public static final double pixels_before_hanging_pos = 0;
    public static final double power_before_hanging_pos = 0.6;

    public static final double arms_after_hanging_pos = 0;
    public static double pixels_after_hanging_pos = 0;
    public static final double power_after_hanging_pos = 1;

    public void build(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
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
    }
    public void StartPosition(){
        SetArmsPos(0,0.5);
        liftLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        angleServo.setPosition(0.8);
        airplane.setPosition(0.85);
    }
    // Positions
    public void PickupPos() {
        SetArmsPos(arms_pickup_pos,power_pickup_pos);
        angleServo.setPosition(pixels_pickup_pos);
    }
    public void BoardPos() {
        SetArmsPos(arms_board_pos,power_board_pos);
        angleServo.setPosition(pixels_board_pos);
    }
    public void BeforeHangingPos() {
        SetArmsPos(arms_before_hanging_pos,power_before_hanging_pos);
        angleServo.setPosition(pixels_before_hanging_pos);
    }
    public void AfterHangingPos() {
        SetArmsPos(arms_after_hanging_pos,power_after_hanging_pos);
    }
    public void Drive(double right_trigger, double x, double y, double rx, double rightY) {
        speed_adjust = Range.clip(right_trigger,low_speed, high_speed);
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = ((y + x + rx) / denominator) * speed_adjust;
        double backLeftPower = ((y - x+ rx + balance) / denominator) * speed_adjust;
        double frontRightPower = ((y - x - rx) / denominator) * speed_adjust;
        double backRightPower = ((y + x - rx + balance) / denominator) * speed_adjust;

        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }
    public void LeftPixelOpen() {
        pixelLeft.setPosition(left_pixel_open_pos);
    }
    public void LeftPixelClose() {
        pixelLeft.setPosition(left_pixel_close_pos);
    }
    public void RightPixelOpen() {
        pixelRight.setPosition(right_pixel_open_pos);
    }
    public void RightPixelClose() {
        pixelRight.setPosition(right_pixel_close_pos);
    }
    public void LaunchAirplane () {
        airplane.setPosition(airplane_launch);
    }
    public void HoldAirplane () {
        airplane.setPosition(airplane_hold);
    }

    // Helper Methods

    public void run_encoder(double turnage, double power, DcMotor motor) {
        new_target = ticks * turnage;
        motor.setTargetPosition((int) new_target);
        motor.setPower(power);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void SetArmsPos(double turnage, double power) {
        run_encoder(turnage,power,liftLeft);
        run_encoder(turnage,power,liftRight);
    }
}
