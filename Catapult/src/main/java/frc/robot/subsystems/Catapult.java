package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Catapult extends SubsystemBase {
    private CANSparkMax motor = new CANSparkMax(17, CANSparkMax.MotorType.kBrushless);

    public Catapult() {
        setDefaultCommand(Commands.run(() -> {
            System.out.println("motor is stopped");
            motor.set(0);
        },this));

    }

    @Override
    public void periodic() {
        motor.set(0.2);
    }

    public Command getShootCommand() {
        return Commands.runOnce(() -> {
            System.out.println("shooting...");
            motor.set(0.3);
        });
    }
}
