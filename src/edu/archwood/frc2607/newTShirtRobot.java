package edu.archwood.frc2607;

import javax.microedition.midlet.MIDletStateChangeException;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;

public class newTShirtRobot extends IterativeRobot {
	
	public Transmission transmissionL, transmissionR ;
	public RobotDrive robotDrive ;
	public Relay horn ;

	public void disabledInit() {
		// TODO Auto-generated method stub
		super.disabledInit();
	}

	public void disabledPeriodic() {
		// TODO Auto-generated method stub
		super.disabledPeriodic();
	}

	public void robotInit() {
		// TODO Auto-generated method stub
		super.robotInit();
		transmissionL = new Transmission (Constants.leftMotorPorts) ;
		transmissionR = new Transmission (Constants.rightMotorPorts) ;
		robotDrive = new RobotDrive (transmissionL, transmissionR) ;
		horn = new Relay (7) ;
	}

	public void teleopInit() {
		// TODO Auto-generated method stub
		super.teleopInit();
	}

	public void teleopPeriodic() {
		// TODO Auto-generated method stub
		super.teleopPeriodic();
	}


}
