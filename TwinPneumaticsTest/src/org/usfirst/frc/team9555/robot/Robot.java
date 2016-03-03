
package org.usfirst.frc.team9555.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

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
	Joystick primary= new Joystick (0);
	Compressor compressor= new Compressor(0);
	DoubleSolenoid lifter= new DoubleSolenoid(0,0,1);
	DoubleSolenoid grabber= new DoubleSolenoid (0,2,3);
	Timer time;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousInit(){
    	time.start();
    }
    public void autonomousPeriodic() {
    	if (time.get()<3){
    		left.set(-.6);
    		right.set(-.6);
    	}
    	else if (time.get()<15){
    		right.set(0);
    		left.set(0);
    	}
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	compressor.setClosedLoopControl(true);
       
    	
    	if(primary.getRawButton(1)){
    		lifter.set(DoubleSolenoid.Value.kForward);
    	}
    	else if(primary.getRawButton(2)){
    		lifter.set(DoubleSolenoid.Value.kReverse);
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
