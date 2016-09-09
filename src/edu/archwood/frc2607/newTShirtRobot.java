package edu.archwood.frc2607;

import javax.microedition.midlet.MIDletStateChangeException;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

public class newTShirtRobot extends IterativeRobot {
	
	public Transmission transmissionL, transmissionR ;
	public RobotDrive robotDrive ;
	public Relay horn ;
public RobovikingStick joystick ;
	public Victor turntable ;

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
		joystick = new RobovikingStick (1) ;
		turntable = new Victor (Constants.turntableMotorPort) ;
	}

	public void teleopInit() {
		// TODO Auto-generated method stub
		super.teleopInit();
	}

	public void teleopPeriodic() {
		// TODO Auto-generated method stub
		super.teleopPeriodic();
		robotDrive.arcadeDrive(-joystick.getRawAxisWithDeadzone(RobovikingStick.xBoxLeftStickY), joystick.getRawAxisWithDeadzone(RobovikingStick.xBoxRightStickX));
		if (joystick.getRawButton(RobovikingStick.xBoxLeftBumper)){
			turntable.set(.6); 
		} else if (joystick.getRawButton(RobovikingStick.xBoxRightBumper)) {
				turntable.set(-.6);
		} else {
			turntable.set(0.0);
		}
	}


}
