package il.ac.tau.cs.smlab.model2lejos.library.wrappers.motors;

import lejos.nxt.LCD;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;
import lejos.nxt.comm.RConsole;

public class MotorControlImpl extends MotorControl {
	private NXTMotor motor;

	public MotorControlImpl(MotorPort motorPort) {
		super(motorPort);
	}
	
	@Override
	public void setUp()
	{
		super.setUp();
		this.motor = new NXTMotor(motorPort);
	}

	@Override
	public void compute() {
		super.compute();
		if (this.direction.getCurrentValue() == null || this.power.getCurrentValue() == null) {
			//RConsole.println("Motor: NULL");
			motor.stop();
			return;
		}
		switch (this.direction.getCurrentValue()) {
		case Stop:
			motor.stop();
			break;
		case Forward:
			motor.forward();
			break;
		case Backward:
			motor.backward();
			break;
		case Float:
			motor.flt();
			break;
		}
		motor.setPower(this.power.getCurrentValue());
	}

}
