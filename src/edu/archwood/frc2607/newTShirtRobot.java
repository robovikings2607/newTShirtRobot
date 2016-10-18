package edu.archwood.frc2607;

import javax.microedition.midlet.MIDletStateChangeException;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

public class newTShirtRobot extends IterativeRobot {
	
	public Transmission transmissionL, transmissionR ;
	public Victor armTiltinator ;
	public RobotDrive robotDrive ;
	public Relay blinkyLight ;
	public Relay honkyHorn ;
	public RobovikingStick joystick ;
	public Victor turntable ;
	private int cnt = 0;
	public Compressor compressor ;
	
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
		
		blinkyLight = new Relay(Constants.lightRelayPort) ;
		honkyHorn = new Relay(Constants.hornRelayPort);
		joystick = new RobovikingStick (Constants.controllerPort) ;
		turntable = new Victor (Constants.turntableMotorPort) ;
		compressor = new Compressor (1,2) ;
		compressor.start() ;
	}

	public void teleopInit() {
		// TODO Auto-generated method stub
		super.teleopInit();
	}

	public void teleopPeriodic() {
		// TODO Auto-generated method stub
//		super.teleopPeriodic();
		
		//Driving the Robot
		robotDrive.arcadeDrive(-joystick.getRawAxis(RobovikingStick.xBoxLeftStickY + 1), 
				-joystick.getRawAxis(RobovikingStick.xBoxRightStickX + 1));
		
		//Turning the turn-table
		if (joystick.getRawButton(RobovikingStick.xBoxLeftBumper)){
			System.out.println("Left Bumper");
			turntable.set(.6); 
		} else if (joystick.getRawButton(RobovikingStick.xBoxRightBumper)) {
			System.out.println("Right Bumper");
			turntable.set(-.6);
		} else {
			turntable.set(0.0);
		}
		
		//Blinking the Light
		if (joystick.getRawButton(RobovikingStick.xBoxButtonY)) {
			System.out.print("BLINKING (Y button)");
			blinkyLight.set(Relay.Value.kForward);	
		} else {
			blinkyLight.set(Relay.Value.kOff);
		}
		
		//Honking the horn
		if(joystick.getRawButton(RobovikingStick.xBoxButtonX)){
			System.out.println("HONKING!!! (X Button)");
			honkyHorn.set(Relay.Value.kForward);
		} else {
			honkyHorn.set(Relay.Value.kOff);
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
