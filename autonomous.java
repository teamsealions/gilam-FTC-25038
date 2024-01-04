package org.firstinspires.ftc.teamcode;

import androidx.core.widget.TextViewCompat;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "name")
public class autonomous extends LinearOpMode {

    protected DcMotor driveR;
    protected DcMotor driveL;
    protected Servo graberS;
    protected Servo armS;
    protected DcMotor armL;
    protected DcMotor armR;

    @Override
    public void runOpMode() throws InterruptedException {
        driveR = hardwareMap.get(DcMotor.class, "driveR");
        driveL = hardwareMap.get(DcMotor.class, "driveL");
        graberS = hardwareMap.get(Servo.class, "graberS");
        armS = hardwareMap.get(Servo.class, "armS");
        armL = hardwareMap.get(DcMotor.class, "armL");
        armR = hardwareMap.get(DcMotor.class, "armR");

        driveR.setDirection(DcMotorSimple.Direction.REVERSE);
        driveL.setDirection(DcMotorSimple.Direction.FORWARD);
        armR.setDirection(DcMotorSimple.Direction.FORWARD);
        armL.setDirection(DcMotorSimple.Direction.REVERSE);
        armS.setDirection(Servo.Direction.FORWARD);
        graberS.setDirection(Servo.Direction.FORWARD);

        waitForStart();

        driveR.setPower(0.5);
        driveL.setPower(0.5);
        sleep(2000);
        driveR.setPower(0);
        driveL.setPower(0);
        start();
        armS.setPosition(0.45);
        sleep(2000);
        armS.setPosition(0.9);
        start();
        graberS.setPosition(0.3);
        sleep(2000);
        start();
        armR.setDirection(DcMotorSimple.Direction.REVERSE);
        armL.setDirection(DcMotorSimple.Direction.FORWARD);
        armL.setPower(0.4);
        armR.setPower(0.4);
        sleep(2000);
        armR.setPower(0);
        armL.setPower(0);

    }
    public void moveForward (int power, int Position, int time){
        driveR.setPower(power);
        driveL.setPower(power);
        sleep(time);
        driveR.setPower(power);
        driveL.setPower(power);
        start();
        armS.setPosition(Position);
        sleep(time);
        armS.setPosition(Position);
        start();
        graberS.setPosition(Position);
        sleep(time);
        start();
        armR.setDirection(DcMotorSimple.Direction.REVERSE);
        armL.setDirection(DcMotorSimple.Direction.FORWARD);
        armL.setPower(power);
        armR.setPower(power);
        sleep(time);
        armR.setPower(power);
        armL.setPower(power);

    }
}
