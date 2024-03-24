package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="AutoBlue2Yellow2", group = "Demo")

public class AutoBlue2Yellow2 extends LinearOpMode {

    private DcMotor frontLeftMotor;
    private DcMotor backLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backRightMotor;
    private Servo PixelRight;
    private Servo PixelLeft;
    private Servo  angleServo;


    @Override public void runOpMode() {
        //motors set ups
        frontRightMotor = hardwareMap.get(DcMotor.class, "FrontL");
        frontLeftMotor = hardwareMap.get(DcMotor.class, "Frontr");
        backLeftMotor = hardwareMap.get(DcMotor.class, "BackL");
        backRightMotor = hardwareMap.get(DcMotor.class, "BackR");
        // motors on one side need to br reverse and on the other side forward
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        // conecting and setting up servos
        PixelLeft = hardwareMap.get(Servo.class, "PixelLeft");
        PixelLeft.setPosition(0.3);
        PixelRight = hardwareMap.get(Servo.class, "PixelRight");
        PixelRight.setPosition(0.3);
        angleServo = hardwareMap.get(Servo.class, "angleServo");
        angleServo.setPosition(0.8);

        // Wait for driver to press start
        telemetry.addData("Camera preview on/off", "3 dots, Camera Stream");
        telemetry.addData(">", "Touch Play to start OpMode");
        telemetry.update();

        waitForStart();
        telemetry.addData("motors", "going to center blue mark");

        frontLeftMotor.setPower(0.6);
        backLeftMotor.setPower(0.6);
        frontRightMotor.setPower(0.6);
        backRightMotor.setPower(0.6);
        sleep(1500);
      /*  telemetry.addData("PixelLeft", "turning left to blue marker1");
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0.5);
        backRightMotor.setPower(0.5);
        sleep(2000);
        telemetry.addData("motors", "going back to give space for perpul pixel");
        frontLeftMotor.setPower(-0.5);
        backLeftMotor.setPower(-0.5);
        frontRightMotor.setPower(-0.5);
        backRightMotor.setPower(-0.5);
        sleep(1000); */
        telemetry.addData("servos", "putting perpul pixel in place");
        angleServo.setPosition(0.2);
        PixelLeft.setPosition(0.3);
        sleep(2000);
        telemetry.addData("full robot", "terning tords backstage");
        angleServo.setPosition(0.8);
        PixelLeft.setPosition(0);
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0.6);
        backRightMotor.setPower(0.6);
        sleep(2000);
        telemetry.addData("robot", "going to backstage");
        angleServo.setPosition(0.8);
        PixelLeft.setPosition(0);
        frontLeftMotor.setPower(0.5);
        backLeftMotor.setPower(0.5);
        frontRightMotor.setPower(0.5);
        backRightMotor.setPower(0.5);
        sleep(2000);
        telemetry.addData("motors", "going left to put yellow pixel in place");
        frontLeftMotor.setPower(0.5);
        backLeftMotor.setPower(0.5);
        frontRightMotor.setPower(-0.5);
        backRightMotor.setPower(-0.5);
        sleep(1300);
        telemetry.addData("robot", "puting yellow pixel in place");
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);
        PixelRight.setPosition(0);
        sleep(2000);
        telemetry.addData("robot", "finisht");


    }

}