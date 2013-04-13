package Travolta;

import il.ac.tau.cs.smlab.model2lejos.library.wrappers.motors.MotorDirection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lejos.nxt.comm.RConsole;
import lejos.robotics.Color;

class TravoltaImpl extends Travolta {
	enum RobotState {
		ReadInstructions, WaitForMusic, DanceDanceDance, WaitDance, WaitFinish
	}

	private RobotState state;
	private Boolean ready;
	private String currColor;
	private ArrayList<MotorCommand> moves = new ArrayList<MotorCommand>();

	public TravoltaImpl() {
		super();
	}

	
	@Override
	public void init()
	{
		RConsole.openUSB(3000);
		super.init();
	}
	
	@Override
	public void setUp() {
		super.setUp();
		state = RobotState.ReadInstructions;
		ready = false;
		currColor = "";
	}
	
	static class MotorCommand {
		MotorDirection dirR, dirL;

		public MotorCommand(MotorDirection dirR, MotorDirection dirL) {
			this.dirR = dirR;
			this.dirL = dirL;
		}
		
		@Override
		public String toString()
		{
			return "<" + this.dirR + ", " + this.dirL + ">";
		}
	}

	@Override
	public void compute() {
		super.compute();
		switch (state) {
		case ReadInstructions:
			readInstruction();
			break;
		case WaitForMusic:
			waitForMusic();
			break;
		case DanceDanceDance:
			danceDanceDance();
			break;
		case WaitDance:
			waitDance();
			break;
		case WaitFinish:
			waitFinish();
			break;
		}
	}

	@SuppressWarnings("deprecation")
	static Map<String, MotorCommand> colorToCommand = new HashMap<String, MotorCommand>() {
		{
			put("BB", new MotorCommand(MotorDirection.Forward,
					MotorDirection.Forward));
			put("BR", new MotorCommand(MotorDirection.Backward,
					MotorDirection.Backward));
			put("RB", new MotorCommand(MotorDirection.Float,
					MotorDirection.Forward));
			put("YB", new MotorCommand(MotorDirection.Float,
					MotorDirection.Backward));
			put("RR", new MotorCommand(MotorDirection.Forward,
					MotorDirection.Float));
			put("YR", new MotorCommand(MotorDirection.Backward,
					MotorDirection.Float));
		}
	};

	private void readInstruction() {
		Integer color = this.colorVal.getCurrentValue();
		if (color == null) {
			return;
		}
		Integer brightness = this.lightVal.getCurrentValue();
		if (brightness == null) {
			return;
		}

		dirR.setCurrentValue(MotorDirection.Forward);
		dirL.setCurrentValue(MotorDirection.Forward);
		
		if (brightness >= 58) {
			powerR.setCurrentValue(20);
			powerL.setCurrentValue(10);
		} else {
			powerR.setCurrentValue(10);
			powerL.setCurrentValue(20);
		}
		
		switch (color) {
		case Color.BLACK:
			RConsole.println("black");
			state = RobotState.WaitForMusic;
			dirR.setCurrentValue(MotorDirection.Stop);
			dirL.setCurrentValue(MotorDirection.Stop);
			return;
		case Color.WHITE:
			ready = true;
			return;
		case Color.RED:
			if (ready) {
				RConsole.println("red");
				currColor += "R";
				ready = false;
			}
			break;
		case Color.BLUE:
			if (ready) {
				RConsole.println("blue");
				currColor += "B";
				ready = false;
			}
			break;
		case Color.YELLOW:
			if (ready) {
				RConsole.println("yellow");
				currColor += "Y";
				ready = false;
			}
			break;
		}

		if (currColor.length() < 2) {
			return;
		}
		MotorCommand cmd = colorToCommand.get(currColor);
		if (cmd != null) {
			RConsole.println("added " + cmd);
			moves.add(cmd);
		}
		currColor = "";
	}

	private void waitForMusic() {
		if (this.soundVal.getCurrentValue() > 50) {
			RConsole.println("got music");
			state = RobotState.DanceDanceDance;
		}
	}

	private void danceDanceDance() {
		if (moves.isEmpty()) {
			state = RobotState.WaitFinish;
			dirR.setCurrentValue(MotorDirection.Stop);
			dirL.setCurrentValue(MotorDirection.Stop);
			return;
		}

		MotorCommand cmd = moves.remove(0);
		powerR.setCurrentValue(60);
		powerL.setCurrentValue(60);
		dirR.setCurrentValue(cmd.dirR);
		dirL.setCurrentValue(cmd.dirL);
		RConsole.println("dancing " + cmd);
		state = RobotState.WaitDance;
	}
	
	private void waitDance()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		state = RobotState.DanceDanceDance;
	}
	
	private void waitFinish()
	{
		RConsole.println("Done!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		System.exit(0);
	}

}
