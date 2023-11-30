package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    VictorSP motor;
    
    public Intake() {
        motor = new VictorSP(3);
    }

    public void setSpeed(double speed) {
        motor.set(speed);
    }

    public double getSpeed() {
        return motor.get();
    }

    public void stop() {
        motor.stopMotor();
    }

}
