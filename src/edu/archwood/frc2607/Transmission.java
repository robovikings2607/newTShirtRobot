package edu.archwood.frc2607;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class Transmission implements SpeedController {
public Victor victor1, victor2;
public Transmission ( int[] deviceID ) {
	victor1 = new Victor (deviceID[0]);
	victor2 = new Victor (deviceID[1]);
}
	public void pidWrite(double arg0) {
		// TODO Auto-generated method stub

	}

	public void disable() {
		// TODO Auto-generated method stub

	}

	public double get() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void set(double arg0) {
		// TODO Auto-generated method stub
		victor1.set(arg0) ;
		victor2.set(arg0) ;
	}

	public void set(double arg0, byte arg1) {
		// TODO Auto-generated method stub

	}

}
