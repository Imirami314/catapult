package frc.robot.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Catapult extends SubsystemBase {
    private CANSparkMax motor = new CANSparkMax(17, CANSparkMax.MotorType.kBrushless);
    private double REFERENCE_ANGLE = 0.75;

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

    public Command getAdjustCommand() {
        return Commands.run(() -> {
            SparkPIDController pid = motor.getPIDController();
            pid.setReference(REFERENCE_ANGLE, CANSparkBase.ControlType.kPosition);

            System.out.println("adjusting...");
        });
    }
}
