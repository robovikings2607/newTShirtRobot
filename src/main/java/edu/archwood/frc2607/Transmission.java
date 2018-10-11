package edu.archwood.frc2607;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class Transmission implements SpeedController {
public Jaguar jag1, jag2;
private int cnt = 0;
private String name;
public Transmission ( String name, int[] deviceID ) {
	jag1 = new Jaguar (deviceID[0]);
	jag2 = new Jaguar (deviceID[1]);
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
		return jag1.get();
	}

	public String getMotorOutputs() {
		return name + ": m1: " + jag1.get() + " m2: " + jag2.get();
	}
	
	public void set(double arg0) {
		// TODO Auto-generated method stub
		jag1.set(arg0) ;
		jag2.set(arg0) ;
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
