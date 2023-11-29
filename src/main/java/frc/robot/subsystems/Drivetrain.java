package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

    // Victors = 3 black boxes on our electronics board
    VictorSP leftMotor;
    VictorSP rightMotor; 

    public Drivetrain() {
        // CB channel = port you plugged victors in on ur roborio. REPLACE THE 0 AND 1 AFTER they're just placeholders
        leftMotor = new VictorSP(0);
        rightMotor= new VictorSP(1);
        leftMotor.setInverted(true);

        /*  If motor is inverted.. or right motor depending on robot
            leftMotor.setInverted(true);
        */
    }

    // function that sets motors to a certain value
    public void drive(double left, double right) {
        leftMotor.set(left);
        rightMotor.set(right);
    }
}
