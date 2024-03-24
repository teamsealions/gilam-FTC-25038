package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="AutoPerpulPixelYellow1", group = "Demo")

public class AutoPerpulPixelYellow1 extends LinearOpMode {
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



    @Override public void runOpMode() {
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
           // conecting and setting up servos
        pixelLeft.setPosition(0);
        pixelRight.setPosition(0.25);
        angleServo.setPosition(0.8);

         // Wait for driver to press start
        telemetry.addData("Camera preview on/off", "3 dots, Camera Stream");
        telemetry.addData(">", "Touch Play to start OpMode");
        telemetry.update();

    waitForStart();
    pixelLeft.setPosition(0);
    pixelRight.setPosition(0.25);
    telemetry.addData("motors", "going to midle red mark");
    angleServo.setPosition(0.2);
    sleep(700);
    frontLeftMotor.setPower(0.6);
    backLeftMotor.setPower(0.6);
    frontRightMotor.setPower(0.6);
    backRightMotor.setPower(0.6);
    sleep(700);
    frontLeftMotor.setPower(-0.5);
    backLeftMotor.setPower(-0.5);
    frontRightMotor.setPower(-0.5);
    backRightMotor.setPower(-0.5);
    sleep(500);
    telemetry.addData("PixelLeft", "putting perpul pixel in spot");
    frontLeftMotor.setPower(0);
    backLeftMotor.setPower(0);
    frontRightMotor.setPower(0);
    backRightMotor.setPower(0);
    pixelLeft.setPosition(0.3);
    sleep(1000);
    telemetry.addData("full robot", "terning tords backstage");
    angleServo.setPosition(0.8);
    sleep(900);
    pixelLeft.setPosition(0);
    frontLeftMotor.setPower(0.6);
    backLeftMotor.setPower(0.6);
    frontRightMotor.setPower(0);
    backRightMotor.setPower(0);
    sleep(1500);
    frontLeftMotor.setPower(0.5);
    backLeftMotor.setPower(0.5);
    frontRightMotor.setPower(0.5);
    backRightMotor.setPower(0.5);
    sleep(600);
    telemetry.addData("motors", "going right to put yellow pixel in place");
//    frontLeftMotor.setPower(0.5);
//    backLeftMotor.setPower(0.5);
//    frontRightMotor.setPower(-0.5);
//    backRightMotor.setPower(-0.5);
//    sleep(250);
    telemetry.addData("robot", "puting yellow pixel in place");
    angleServo.setPosition(0.55);
    frontLeftMotor.setPower(0);
    backLeftMotor.setPower(0);
    frontRightMotor.setPower(0);
    backRightMotor.setPower(0);
    pixelRight.setPosition(0);
    sleep(350);
    angleServo.setPosition(0.8);
    frontLeftMotor.setPower(-0.5);
    backLeftMotor.setPower(-0.5);
    frontRightMotor.setPower(-0.5);
    backRightMotor.setPower(-0.5);
    pixelRight.setPosition(-0.5);
    sleep(150);
    telemetry.addData("robot", "finisht");
    angleServo.setPosition(0.8);
    frontLeftMotor.setPower(-0.5);
    backLeftMotor.setPower(0.5);
    frontRightMotor.setPower(0.5);
    backRightMotor.setPower(-0.5);
    sleep(800);
    }

}
