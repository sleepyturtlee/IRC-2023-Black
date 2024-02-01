package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
    Drivetrain drivetrain;
    
    // joysticks we will use to control our robot
    Joystick leftJ;
    Joystick rightJ;

    public Drive(Drivetrain d, Joystick l, Joystick r) {
        drivetrain = d;
        leftJ = l;
        rightJ = r;

        // to make sure our command works on edge cases/justin case..prevents intereference
        addRequirements(d);
    }

    public void initialize() {
        drivetrain.drive(0, 0);

    }

    // execute function runs repeatedly
    public void execute() {
        drivetrain.drive(-leftJ.getY(), rightJ.getY());
    }

    public boolean isFinished() {
        return false;
    }

    public void end(boolean i) {
        drivetrain.drive(0, 0);
    }
}
