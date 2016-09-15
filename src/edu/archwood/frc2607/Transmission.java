package edu.archwood.frc2607;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class Transmission implements SpeedController {
public Victor victor1, victor2;
private int cnt = 0;
private String name;
public Transmission ( String name, int[] deviceID ) {
	victor1 = new Victor (deviceID[0]);
	victor2 = new Victor (deviceID[1]);
	this.name = name;
}
	public void pidWrite(double arg0) {
		// TODO Auto-generated method stub

	}

	public void disable() {
		// TODO Auto-generated method stub

	}

	public double get() {
		// TODO Auto-generated method stub
		return victor1.get();
	}

	public void set(double arg0) {
		// TODO Auto-generated method stub
		victor1.set(arg0) ;
		victor2.set(arg0) ;
		if (++cnt > 50) {
			System.out.println(name + ": " + arg0);
			cnt = 0;
		}
	}

	public void set(double arg0, byte arg1) {
		// TODO Auto-generated method stub
		set(arg0);
	}

}
