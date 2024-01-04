package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous
public class auto extends LinearOpMode {
    protected DcMotor driveR;
    protected DcMotor driveL;
    protected Servo graberS;
    protected Servo armS;


    @Override
    public void runOpMode() throws InterruptedException {
        //      name of motor or servo
        driveR = hardwareMap.get(DcMotor.class, "driveR");
        driveL = hardwareMap.get(DcMotor.class, "driveL");
        graberS = hardwareMap.get(Servo.class, "graberS");
        armS = hardwareMap.get(Servo.class, "armS");
    }
}
