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

package org.northwestrobotics.frc2014.commands.launcher;

import org.northwestrobotics.frc2014.RobotMap;
import org.northwestrobotics.frc2014.commands.TimedCommand;

/**
 * Pick up ball command
 * 
 * Makes the robot pick up a ball within range of the doors.
 * 
 * @author Joshua Fleming <js.fleming@outlook.com>
 */
public class PickUpBall extends TimedCommand 
{    
    public PickUpBall() {
        super(RobotMap.Launcher.TIME_TO_CLOSE_DOORS);
        requires(launcher);
    }

    /**
     * Closes the doors slowly.
     */
    protected void commence() {
        launcher.startClosingDoors();
    }

    /**
     * Stops closing the doors.
     */
    protected void cease() {
        launcher.stopClosingDoors();
    }
}