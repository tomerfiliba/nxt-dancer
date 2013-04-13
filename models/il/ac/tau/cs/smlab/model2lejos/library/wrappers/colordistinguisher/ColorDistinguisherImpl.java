package il.ac.tau.cs.smlab.model2lejos.library.wrappers.colordistinguisher;

import lejos.nxt.ColorSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.ColorSensor.Color;

public class ColorDistinguisherImpl extends ColorDistinguisher {
	ColorSensor colorSensor;

	public ColorDistinguisherImpl(SensorPort sensorPort) {
		super(sensorPort);
	}

	@Override
	public void setUp() {
		super.setUp();
		this.colorSensor = new ColorSensor(sensorPort);
		this.colorSensor.setFloodlight(Color.WHITE);
	}

	@Override
	public void compute() {
		this.colorValue.setNextValue(colorSensor.getColor().getColor());
		super.compute();
	}

}
