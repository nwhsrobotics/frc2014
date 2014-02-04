package org.northwestrobotics.frc2014.commands.autonomous;

import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.TimedCommand;

/**
 *
 * @author Saagar
 */
public class Rotate extends DirectionalCommand
{   
    public Rotate(int direction) {
        super(direction, RobotMap.Autonomous.TIME_TO_TURN);
    }

    // Called just before this Command runs the first time
    protected void commence() {
        drivetrain.tankMove(getDirection(), -getDirection());
    }
}