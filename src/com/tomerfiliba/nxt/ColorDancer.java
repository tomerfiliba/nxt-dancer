package com.tomerfiliba.nxt;

import java.util.ArrayList;
import java.util.List;

import com.tomerfiliba.nxt.Moves.DanceMove;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.comm.RConsole;
import lejos.robotics.Color;


public class ColorDancer 
{
	Robot robot = new Robot();
	Moves moves = new Moves(robot);

    protected List<DanceMove> readMoves(int motorSpeed)
    {
		ArrayList<DanceMove> moveList = new ArrayList<DanceMove>();
		Boolean ready = true;
		String curr = "";

		robot.lightSensor.setFloodlight(true);
		robot.colorSensor.setFloodlight(Color.WHITE);
		robot.motorR.setPower(motorSpeed);
		robot.motorL.setPower(motorSpeed);
		robot.motorR.forward();
		robot.motorL.forward();
		
		while (!Button.ESCAPE.isDown()) {
			int level = robot.lightSensor.readValue();
			int color = robot.colorSensor.getColor().getColor();
	        LCD.clear();
			LCD.drawInt(color, 3, 0, 0);

			if (level >= 58) {
				robot.motorR.setPower(motorSpeed * 2);
				robot.motorL.setPower(motorSpeed);
			}
			else {
				robot.motorR.setPower(motorSpeed);
				robot.motorL.setPower(motorSpeed * 2);
			}
			
			if (color == Color.BLACK) {
				break;
			}
			if (color == Color.WHITE) {
				ready = true;
				continue;
			}
			if (!ready) {
				continue;
			}

			switch (color) {
			case Color.RED:
				curr += "R";
				break;
			case Color.GREEN:
				curr += "G";
				break;
			case Color.BLUE:
				curr += "B";
				break;
			case Color.YELLOW:
				curr += "Y";
				break;
			default:
				/* ignore all other colors */
				continue;
			}
			
			ready = false;
			if (curr.length() < 2) {
				continue;
			}
			
			RConsole.println("Detected " + curr);
			DanceMove m = moves.codesToMoves.get(curr);
			curr = "";

			if (m != null) {
				RConsole.println("Move: " + m);
				moveList.add(m);
			}
		}

		robot.motorR.stop();
		robot.motorL.stop();
		robot.colorSensor.setFloodlight(Color.NONE);
		robot.lightSensor.setFloodlight(false);
		
		return moveList;
    }
    
    protected void doDance(List<DanceMove> danceMoves) throws Exception
    {
		robot.motorR.setPower(60);
		robot.motorL.setPower(60);
    	
		LCD.clear();
    	LCD.drawString("Let's dance!", 0, 0);
    	for (DanceMove m : danceMoves) {
        	LCD.drawString(m.toString(), 0, 1);
    		RConsole.println(m.toString());
    		m.move();
			Thread.sleep(1000);
    	}
    	LCD.drawString("Done", 0, 1);
    	robot.motorR.stop();
    	robot.motorL.stop();
    }
    
	public static void main(String [] args) throws Exception
    {
		RConsole.openAny(3000);
    	(new ColorDancer()).run();
		LCD.drawString("ESC..", 11, 7);
		RConsole.close();
		while (!Button.ESCAPE.isDown()) {};
	}
	
	void run() throws Exception
	{
    	List<DanceMove> danceMoves = readMoves(10);
		LCD.drawString("Got " + danceMoves.size() + " moves", 0, 1);
		Thread.sleep(1000);
		LCD.drawString("Waiting for music", 0, 2);
		while (!Button.ESCAPE.isDown() && robot.soundSensor.readValue() < 50) {
		}
		doDance(danceMoves);
	}

}
