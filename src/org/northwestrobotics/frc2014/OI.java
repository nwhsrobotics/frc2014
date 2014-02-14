/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 FRC Team #4638 (Northwest Jagbotics)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.northwestrobotics.frc2014;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.northwestrobotics.frc2014.commands.launcher.GrabBall;
import org.northwestrobotics.frc2014.commands.launcher.PassBall;
import org.northwestrobotics.frc2014.commands.launcher.ShootBall;
import org.northwestrobotics.frc2014.utils.MessageWindow;

/**
 * Operator interface class
 * 
 * Binds controller buttons to commands and command groups.
 * 
 * @author Saagar Ahluwalia <saagar_ahluwalia@outlook.com>
 */
public class OI 
{
    // Button objects
    private final Joystick driverGamepad = new Joystick(RobotMap.Gamepad.DRIVER_GAMEPAD);
    private final Joystick actuatorGamepad = new Joystick(RobotMap.Gamepad.ACTUATOR_GAMEPAD);
    
    // Actuator's buttons
    private final Button shootButton = new JoystickButton(actuatorGamepad, RobotMap.Button.RIGHT_TRIGGER);
    private final Button passButton = new JoystickButton(actuatorGamepad, RobotMap.Button.B_BUTTON);
    private final Button grabButton = new JoystickButton(actuatorGamepad, RobotMap.Button.A_BUTTON);
    
    // Driver's buttons
    // ???
    
    // Commands
    private final Command shootCommand;
    private final Command passCommand;
    private final Command grabCommand;
    
    /**
     * Creates the operator interface and binds controller buttons.
     */
    public OI() {
        // Actuator's bindings
        shootButton.whenReleased(shootCommand = new ShootBall(getShootForce()));
        passButton.whenReleased(passCommand = new PassBall(getPassForce()));
        grabButton.whenReleased(grabCommand = new GrabBall());
        
        // Driver's bindings
        // ???
    }
    
    /**
     * Returns the force of the pressed shoot speed modifier.
     * 
     * @return int Force of the command (0-100)
     */
    private int getShootForce() {
       int force;

       if(isDpadSouthPressed(actuatorGamepad)) {
           force = RobotMap.Force.SHOOT_FORCE_LOW;
       } else if(isDpadEastPressed(actuatorGamepad)) {
           force = RobotMap.Force.SHOOT_FORCE_MED;
       } else if(isDpadNorthPressed(actuatorGamepad)) {
           force = RobotMap.Force.SHOOT_FORCE_HIGH;
       } else if(isDpadWestPressed(actuatorGamepad)) {
           force = RobotMap.Force.SHOOT_FORCE_MAX;
       } else {
           force = 0;
       }

       return force;
    }
    
    /**
     * Returns the force of the pressed pass speed modifier.
     * 
     * @return int Force of the command (0-100)
     */
    private int getPassForce() {
       int force;

       if(isDpadSouthPressed(actuatorGamepad)) {
           force = RobotMap.Force.PASS_FORCE_LOW;
       } else if(isDpadEastPressed(actuatorGamepad)) {
           force = RobotMap.Force.PASS_FORCE_MED;
       } else if(isDpadNorthPressed(actuatorGamepad)) {
           force = RobotMap.Force.PASS_FORCE_HIGH;
       } else if(isDpadWestPressed(actuatorGamepad)) {
           force = RobotMap.Force.PASS_FORCE_MAX;
       } else {
           force = 0;
       }

       return force;
    }
    
    /**
     * Returns the command that shoots the ball.
     * 
     * @return The command
     */
    public Command getShootCommand() {
        return shootCommand;
    }

    /**
     * Returns the command that passes the ball.
     * 
     * @return The command
     */
    public Command getPassCommand() {
        return passCommand;
    }

    /**
     * Returns the command that grabs the ball.
     * 
     * @return The command
     */
    public Command getGrabCommand() {
        return grabCommand;
    }
    
    /**
     * Returns the gamepad that the driver is using.
     * 
     * @return The gamepad
     */
    public Joystick getDriverGamepad() {
        return driverGamepad;
    }

    /**
     * Returns the gamepad that the actuator is using.
     * 
     * @return The gamepad
     */
    public Joystick getActuatorGamepad() {
        return actuatorGamepad;
    }
    
    /**
     * Gets the value of the left stick from a gamepad.
     * 
     * @param gamepad The gamepad to get the value from
     * @return Left stick value
     */
    public double getLeftStickValue(Joystick gamepad) {
        return -gamepad.getRawAxis(RobotMap.Button.LEFT_STICK);
    }
    
    /**
     * Gets the value of the right stick from a gamepad.
     * 
     * @param gamepad The gamepad to get the value from
     * @return Right stick value
     */
    public double getRightStickValue(Joystick gamepad) {
        return -gamepad.getRawAxis(RobotMap.Button.RIGHT_STICK);
    }
    
    /**
     * Gets the value of the D-Pad from a gamepad.
     * 
     * @param gamepad The gamepad to get the value from
     * @return The value of the D-Pad
     */
    public double getDpadValue(Joystick gamepad) {
        MessageWindow.write("DPAD: " + Double.toString(gamepad.getRawAxis(RobotMap.Button.D_PAD)));
        return gamepad.getRawAxis(RobotMap.Button.D_PAD);
    }

    /**
     * Checks if the D-Pad north button is pressed.
     * 
     * @param gamepad The gamepad to check
     * @return Whether or not the button is pressed
     */
    public boolean isDpadNorthPressed(Joystick gamepad) {
        double dpadVal = getDpadValue(gamepad);
        return (dpadVal < 0);
    }
    
    /**
     * Checks if the D-Pad south button is pressed.
     * 
     * @param gamepad The gamepad to check
     * @return Whether or not the button is pressed
     */
    public boolean isDpadSouthPressed(Joystick gamepad) {
        double dpadVal = getDpadValue(gamepad);
        return (dpadVal < 0);
    }
    
    /**
     * Checks if the D-Pad east button is pressed.
     * 
     * @param gamepad The gamepad to check
     * @return Whether or not the button is pressed
     */
    public boolean isDpadEastPressed(Joystick gamepad) {
        double dpadVal = getDpadValue(gamepad);
        return (dpadVal > 0.5);
    }
    
    /**
     * Checks if the D-Pad north button is pressed.
     * 
     * @param gamepad The west to check
     * @return Whether or not the button is pressed
     */
    public boolean isDpadWestPressed(Joystick gamepad) {
        double dpadVal = getDpadValue(gamepad);
        return (dpadVal < -0.5);
    }
}