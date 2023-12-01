package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoDrive;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;

public class RobotContainer {
  Joystick leftJoystick = new Joystick(0);
  Joystick rightJoystick = new Joystick(1);
  JoystickButton raiseArm = new JoystickButton(rightJoystick, 2);
  JoystickButton lowerArm = new JoystickButton(rightJoystick, 1);
  JoystickButton intakeIn = new JoystickButton(leftJoystick, 1);
  JoystickButton intakeOut = new JoystickButton(leftJoystick, 2);

  Drivetrain drivetrain = new Drivetrain();
  Arm arm = new Arm();
  Intake intake = new Intake();
  

  public RobotContainer() {
    drivetrain.setDefaultCommand(new InstantCommand(() -> drivetrain.drive(leftJoystick.getY(), rightJoystick.getY()), drivetrain));
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    raiseArm.whileTrue(new InstantCommand(() -> arm.moveArm(0.5)));
    lowerArm.whileTrue(new InstantCommand(() -> arm.moveArm(0)));
    intakeIn.whileTrue(new InstantCommand(() -> intake.setSpeed(0.5)));
    intakeOut.whileTrue(new InstantCommand(() -> intake.setSpeed(-0.5)));
    intakeIn.onFalse(new InstantCommand(() -> intake.setSpeed(0)));
    intakeOut.onFalse(new InstantCommand(() -> intake.setSpeed(0)));
  }

  public Command getAutonomousCommand() {
    return new AutoDrive(drivetrain, 0.5, 0.5, 2);
  }
}
