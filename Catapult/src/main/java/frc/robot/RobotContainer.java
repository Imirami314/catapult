// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Catapult;

public class RobotContainer {
  private Catapult catapult = new Catapult();
  private CommandXboxController controller = new CommandXboxController(1);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    controller.a().whileTrue(getAutonomousCommand());
  }

  public Command getAutonomousCommand() {
    // return Commands.print("No autonomous command configured");
    return catapult.getShootCommand();
  }
}
