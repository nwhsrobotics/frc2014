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

/**
 * Robot constants map
 * 
 * Maps robot port values to constants accessible in the rest of the program.
 * 
 * @todo Finalize button numbers
 */
public class RobotMap 
{    
    
    /*
     * Driver Gamepad switch to X
     */
    public static class DriverGamepad
    {
        public static final int PORT_NUMBER = 1;
        
        public static final int TRIGGER_AXIS = 3;
        public static final int RIGHT_BUMPER = 6;
        public static final int LEFT_BUMPER = 5;
        public static final int LEFT_STICK = 2;  // Left stick Y Value
        public static final int RIGHT_STICK_Y = 5; // Right stick Y Value
        public static final int RIGHT_STICK_X = 4;
        public static final int X_BUTTON = 3;
        public static final int Y_BUTTON = 4;
        public static final int A_BUTTON = 1;
        public static final int B_BUTTON = 2;
        public static final int BACK_BUTTON = 7;
        public static final int START_BUTTON = 8;
        
        //adjustments are more than likely necessary
        public static final double MAX_SPEED_DELTA = 0.01;
                
        public static final double MAX_TURN_VALUE = 0.75;
        
    }
    
    /*
     * Launcher Gamepad switch to D
     */
    public static class LauncherGamepad
    {
        public static final int PORT_NUMBER = 2;
        
        public static final int RIGHT_TRIGGER = 8;
        public static final int LEFT_TRIGGER = 7;
        public static final int RIGHT_BUMPER = 6;
        public static final int LEFT_BUMPER = 5;
        public static final int D_PAD_X = 5;
        public static final int D_PAD_Y = 6;
        public static final int LEFT_STICK = 2;  // Left stick Y Value
        public static final int RIGHT_STICK = 5; // Right stick Y Value
        public static final int X_BUTTON = 1;
        public static final int Y_BUTTON = 4;
        public static final int A_BUTTON = 2;
        public static final int B_BUTTON = 3;
        public static final int BACK_BUTTON = 9;
        public static final int START_BUTTON = 10;
        
        public static final int SHOOT_BALL_COMMAND = 0;
        public static final int PASS_BALL_COMMAND = 1;
        
    }
    
    /**
     * Gamepad constants.
     */
    public static class Gamepad 
    {
        private Gamepad() {}
        
        //public static final int DRIVER_GAMEPAD = 1;
        //public static final int ACTUATOR_GAMEPAD = 2;
    }
    
    /**
     * Motor constants.
     */
    public static class Motor 
    {
        private Motor() {}
        
        // Front left motor controller
        public static final int FRONT_LEFT_MOTOR = 1;
        
        // Front right motor controller
        public static final int FRONT_RIGHT_MOTOR = 4;
        
        // Rear left motor controller
        public static final int REAR_LEFT_MOTOR = 2;
        
        // Rear right motor controller
        public static final int REAR_RIGHT_MOTOR = 5;
        
        // Winch motors
        public static final int LEFT_WINCH_MOTOR = 3;
        public static final int RIGHT_WINCH_MOTOR = 6;
    }
    
    /**
     * Pneumatic constants.
     */
    public static class Pneumatic 
    {
        private Pneumatic() {}
    
        public static final int PRESSURE_SWITCH = 1;
        public static final int COMPRESSOR = 1;
        public static final int HARD_STOP = 2;
        
        public static final int DOOR_LATCHES = 1;
    }
    
    /**
     * Relay constants.
     */
    public static class Relay
    {
        private Relay() {}
        
        
        public static final int COMPRESSOR_RELAY = 2;
    }
    
    /**
     * Analog Input Constants
     */
    public static class AnalogInput
    {
        private AnalogInput() {}
        
        public static final int ANALOG_BREAKOUT_MODULE = 1;
        
        public static final int BALL_SENSOR_CHANNEL = 1;
        
        //if the sensor voltage is less than this, the ball is in the robot
        public static final int BALL_IN_ROBOT_CUTOFF = 256;
    }
    
    /**
     * Force constants.
     */
    public static class Force 
    {
        private Force() {}
        
        public static final String DOOR_FORCE_KEY = "Door Force (0-100): ";
        public static final boolean GET_FORCE_FROM_SMART_DASHBOARD = true;
        
        // Shoot force constants
        public static final int SHOOT_FORCE_LOW = 70;
        public static final int SHOOT_FORCE_MED = 80;
        public static final int SHOOT_FORCE_HIGH = 90;
        public static final int SHOOT_FORCE_MAX = 100;
        
        // Pass force constants
        public static final int PASS_FORCE_LOW = 15;
        public static final int PASS_FORCE_MED = 30;
        public static final int PASS_FORCE_HIGH = 45;
        public static final int PASS_FORCE_MAX = 60;
        
        // Winch force constants
        public static final int GRAB_FORCE = 100;
        
        // idle power for doors to stay shut
        public static final int IDLE_DOOR_FORCE = 15;
        
        //motor power for minute turns
        public static final double MINUTE_TURN_FORCE = 0.05;
        
        //variable to potentially limit the robots max speed
        //0.0 - 1.0
        public static final double MAX_DRIVETRAIN_VALUE = 0.75;
        
        public static final double MIN_DRIVETRAIN_VALUE = 0.25;

        
    }
    
    /**
     * Time constants.
     */
    public static class Time 
    {
        
        private Time() {}
        
        private static final int s = 1;
        
        public static final int LATCH_RELEASE_TIME = 1*s;
        
        public static final float TIME_TO_SHOOT_BALL = 2.0f * s;
        public static final float TIME_TO_PASS_BALL = 0.4f * s;
        public static final float TIME_TO_GRAB_BALL = 1.35f * s;
    }
    
    /**
     * Defines autonomous constants.
     */
    public static class Autonomous 
    {
        public static final String MODE_KEY = 
                "Autonomous mode (0 = stand still, 1 = drive forward, 2 = turn "
                + "left and score, 3 = turn right and score) ";
        private Autonomous() {}
        
        // Time constants (in msec)
        public static final double TIME_TO_TURN = 1;
        public static final double TIME_TO_DRIVE_STRAIGHT = 1;
        public static final double TIME_TO_REACH_WALL = 1.5;
        public static final double TIME_TO_REACH_GOAL = 1;
    }

    /**
     * Direction constants.
     */
    public static class Direction
    {
        private Direction() {}
        
        public static final int FORWARD = 1;
        public static final int BACKWARD = -1;
    }
}