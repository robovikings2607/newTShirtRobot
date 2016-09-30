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
	private int cnt = 0;
	
	public void disabledInit() {
		// TODO Auto-generated method stub
//		super.disabledInit();
	}

	public void disabledPeriodic() {
		// TODO Auto-generated method stub
//		super.disabledPeriodic();
	}

	public void robotInit() {
		// TODO Auto-generated method stub
//		super.robotInit();
		transmissionL = new Transmission ("Left", Constants.leftMotorPorts) ;
		transmissionR = new Transmission ("Right", Constants.rightMotorPorts) ;
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
//		super.teleopPeriodic();
		
		robotDrive.arcadeDrive(-joystick.getRawAxis(RobovikingStick.xBoxLeftStickY + 1), -joystick.getRawAxis(RobovikingStick.xBoxRightStickX + 1));
		if (joystick.getRawButton(RobovikingStick.xBoxLeftBumper)){
			turntable.set(.6); 
		} else if (joystick.getRawButton(RobovikingStick.xBoxRightBumper)) {
				turntable.set(-.6);
		} else {
			turntable.set(0.0);
		}
	}

	public void testPeriodic() {
		if (joystick.getRawButton(RobovikingStick.xBoxButtonY)) {
			robotDrive.arcadeDrive(.3,0.0);
		} else if (joystick.getRawButton(RobovikingStick.xBoxButtonA)) {
			robotDrive.arcadeDrive(-.3, 0.0);
		} else {
			robotDrive.arcadeDrive(0.0,0.0);
		}
		if (++cnt > 50) {
			System.out.println(transmissionL.getMotorOutputs());
			System.out.println(transmissionR.getMotorOutputs());
			System.out.println("");
			cnt = 0;
		}
	}
}
