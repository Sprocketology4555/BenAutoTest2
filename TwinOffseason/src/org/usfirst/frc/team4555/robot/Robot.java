
package org.usfirst.frc.team4555.robot;

import edu.wpi.first.wpilibj.CameraServer;
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
	RobotDrive drive= new RobotDrive (left, right);
	Talon mech1= new Talon (2);
	Victor mech2= new Victor (3);
	RobotDrive mechdrive= new RobotDrive (mech1, mech2);
	Joystick primary= new Joystick (0);
	Joystick mechjs= new Joystick (1);
	CameraServer server;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam2");

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
    	drive.tankDrive(primary.getRawAxis(5), primary.getRawAxis(1));
    	mechdrive.tankDrive(mechjs.getRawAxis(5), mechjs.getRawAxis(1));
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
