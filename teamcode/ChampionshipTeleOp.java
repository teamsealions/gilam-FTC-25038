package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class ChampionshipTeleOp extends OpMode {
    public RobotConfig robot = new RobotConfig();

    @Override
    public void init() {
    robot.build(hardwareMap);
    robot.StartPosition();
    }
    @Override
    public void loop() {
    // Drive
    robot.Drive(gamepad1.right_trigger,gamepad1.left_stick_x,gamepad1.left_stick_y,gamepad1.right_stick_x,gamepad1.right_stick_y);
    // Pixels
    if (gamepad1.right_bumper) {
        robot.RightPixelClose();
    }
    else {
        robot.RightPixelOpen();
    }
    if (gamepad1.left_bumper) {
        robot.LeftPixelClose();
    }
    else {
        robot.LeftPixelOpen();
    }
    //Airplane
    if (gamepad1.a) {
        robot.LaunchAirplane();
    }
    else {
        robot.HoldAirplane();
    }
    if (gamepad1.dpad_up){
        robot.BoardPos();
    }
    if (gamepad1.dpad_down) {
        robot.PickupPos();
    }
    if (gamepad1.dpad_right) {
        robot.BeforeHangingPos();
    }
    if (gamepad1.dpad_left) {
        robot.AfterHangingPos();
    }
    }
}
