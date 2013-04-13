package il.ac.tau.cs.smlab.model2lejos.library.wrappers.soundlevel;

import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;

public class SoundLevelImpl extends SoundLevel {
	SoundSensor soundSensor;

	public SoundLevelImpl(SensorPort sensorPort) {
		super(sensorPort);
	}
	
	@Override
	public void setUp()
	{
		super.setUp();
		this.soundSensor = new SoundSensor(sensorPort);	
	}
	
	@Override
	public void compute()
	{
		this.soundLevel.setNextValue(soundSensor.readValue());
		super.compute();
	}

}
