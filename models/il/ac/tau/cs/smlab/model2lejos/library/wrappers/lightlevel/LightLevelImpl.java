package il.ac.tau.cs.smlab.model2lejos.library.wrappers.lightlevel;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class LightLevelImpl extends LightLevel {
	LightSensor lightSensor;

	public LightLevelImpl(SensorPort sensorPort) {
		super(sensorPort);
	}

	@Override
	public void setUp()
	{
		super.setUp();
		this.lightSensor = new LightSensor(sensorPort);	
		this.lightSensor.setFloodlight(true);
	}

	@Override
	public void compute() {
		this.lightLevel.setNextValue(lightSensor.readValue());
		super.compute();
	}

}
