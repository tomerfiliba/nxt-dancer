package com.tomerfiliba.nxt;

import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;

public class Robot {
	NXTMotor motorR = new NXTMotor(MotorPort.B);
	NXTMotor motorL = new NXTMotor(MotorPort.C);
	SoundSensor soundSensor = new SoundSensor(SensorPort.S1);
	ColorSensor colorSensor = new ColorSensor(SensorPort.S3);
	LightSensor lightSensor = new LightSensor(SensorPort.S4);
	
	public Robot() {}
}
