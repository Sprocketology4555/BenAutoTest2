
package org.usfirst.frc.team9555.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Talon left= new Talon (0);
	Talon right= new Talon (1);
	RobotDrive drive= new RobotDrive(left, right);
	Victor lift= new Victor(2);
	Joystick primary= new Joystick (0);
	
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	drive.arcadeDrive(primary);
    	
    	if (primary.getRawButton(1)){
    		lift.set(.3);
    	}
    	else if (primary.getRawButton(2)){
    		lift.set(-.3);
    	}
    	else{
    		lift.set(0);
    	}
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
