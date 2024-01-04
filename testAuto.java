package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous
public class testAuto extends LinearOpMode {

// הוספת מכשירים שמחוברים לרובוט
    protected DcMotor driveR;
    protected DcMotor driveL;
    protected Servo graberS;
    protected Servo armS;


    @Override
        public void runOpMode() throws InterruptedException {
//      name of motor or servo שמות של מנועים או סרבוים
        driveR = hardwareMap.get(DcMotor.class, "driveR");
        driveL = hardwareMap.get(DcMotor.class, "driveL");
        graberS = hardwareMap.get(Servo.class, "graberS");
        armS = hardwareMap.get(Servo.class, "armS");
//      direction כיוון נסיעה או זווית של סרבוים
        driveR.setDirection(DcMotorSimple.Direction.REVERSE);
        driveL.setDirection(DcMotorSimple.Direction.FORWARD);
        armS.setDirection(Servo.Direction.FORWARD);
        graberS.setDirection(Servo.Direction.FORWARD);
//      autonomus forward drive נסיעה קדימה אוטומטיט ללא שליטה של איש
        telemetry.addData("App", "driving forward");
        waitForStart();

        driveR.setPower(0.5);
        driveL.setPower(0.5);
        sleep(5000);
        driveR.setPower(0);
        driveL.setPower(0);
//      right tern פנייה ימינה
        telemetry.addData("App", "terning right");
        start();
//        driveR.setDirection(DcMotorSimple.Direction.REVERSE);
//        driveL.setDirection(DcMotorSimple.Direction.FORWARD);
       driveR.setPower(0); // על 0 בגלל שאני רוצה שהוא יפנה ימינה
       driveL.setPower(0.5);
       sleep(3000);
       driveR.setPower(0);
       driveL.setPower(0);
//     left tern פנייה שמאלה
        telemetry.addData("App", "terning left");
        start();
//        driveR.setDirection(DcMotorSimple.Direction.REVERSE);
//        driveL.setDirection(DcMotorSimple.Direction.FORWARD);
        driveR.setPower(0.5);
        driveL.setPower(0);// על 0 בגלל שאני רוצה שהוא יפנה שמאלה
        sleep(3000);
        driveR.setPower(0);
        driveL.setPower(0);
//    revers drive נסיעה אחורה
        telemetry.addData("App", "driving backwords");
        start();
        driveR.setDirection(DcMotorSimple.Direction.FORWARD);
        driveL.setDirection(DcMotorSimple.Direction.REVERSE);// שיניתי את כיוון הנסיעה בין מנוע driveR ל-driveL
        driveR.setPower(0.5);
        driveL.setPower(0.5);
        sleep(5000);
        driveR.setPower(0);
        driveL.setPower(0);
//      arm servo down זרוע יורדת
        telemetry.addData("App", "arm servo going down");
        start();
        armS.setPosition(0.45);// זוהי הזווית הרצויה לדעתנו
        sleep(2000);
        armS.setPosition(0.45);
//      graber servo closing הצבט נסגר בשביל לתפוס דיסקיות
        telemetry.addData("App", "grabing pixal");
        start();
        graberS.setPosition(0.5);// זווית סגירה
        sleep(2000);
        graberS.setPosition(0.5);// ללא שינוי משום שאנחנו רוצים שהצבט לא ישחרר את הדיסקית
//      arm servo up זרוע עולה
        telemetry.addData("App", "arm servo going up");
        start();
        armS.setPosition(1);// זוהי זווית העלייה
        sleep(2000);
        armS.setPosition(1);
//      graber servo opening שחרור דיסקיות
        telemetry.addData("App", "graber servo opening");
        start();
        graberS.setPosition(0.1);// זוהי זווית השחרור
        sleep(2000);
        graberS.setPosition(0.5);
//      work finish סיום עבודה
        telemetry.addData("App", "robot going to sleep");
    }
    // חוזר על עצמו שוב כדי שהרובוט יקבל מידע מדויק יותר השינויים היחידים הם המספרים למילים כמו
    // כוח זמן זווית
    public void moveForward (int power, int Position, int time){
        //      autonomus forward drive
        telemetry.addData("App", "driving forward");
        waitForStart();

        driveR.setPower(power);// כוח
        driveL.setPower(power);
        sleep(time);// זמן
        driveR.setPower(power);
        driveL.setPower(power);
//      right tern
        telemetry.addData("App", "terning right");
        start();
//        driveR.setDirection(DcMotorSimple.Direction.REVERSE);
//        driveL.setDirection(DcMotorSimple.Direction.FORWARD);
        driveR.setPower(power);
        driveL.setPower(power);
        sleep(time);
        driveR.setPower(power);
        driveL.setPower(power);
//     left tern
        telemetry.addData("App", "terning left");
        start();
//        driveR.setDirection(DcMotorSimple.Direction.REVERSE);
//        driveL.setDirection(DcMotorSimple.Direction.FORWARD);
        driveR.setPower(power);
        driveL.setPower(power);
        sleep(time);
        driveR.setPower(power);
        driveL.setPower(power);
//    revers drive
        telemetry.addData("App", "driving backwords");
        start();
        driveR.setDirection(DcMotorSimple.Direction.FORWARD);
        driveL.setDirection(DcMotorSimple.Direction.REVERSE);
        driveR.setPower(power);
        driveL.setPower(power);
        sleep(time);
        driveR.setPower(power);
        driveL.setPower(power);
//      arm servo down
        telemetry.addData("App", "arm servo going down");
        start();
        armS.setPosition(Position);// זווית
        sleep(time);
        armS.setPosition(Position);
//      graber servo closing
        telemetry.addData("App", "grabing pixal");
        start();
        graberS.setPosition(Position);
        sleep(time);
        graberS.setPosition(Position);
//      arm servo up
        telemetry.addData("App", "arm servo going up");
        start();
        armS.setPosition(Position);
        sleep(time);
        armS.setPosition(Position);
//      graber servo opening
        telemetry.addData("App", "graber servo opening");
        start();
        graberS.setPosition(Position);
        sleep(time);
        graberS.setPosition(Position);
//      work finish
        telemetry.addData("App", "robot is going to sleep");
    }
}
