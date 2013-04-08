package com.tomerfiliba.nxt;

import java.util.HashMap;
import java.util.Map;

public class Moves {
	static abstract class DanceMove
	{
		protected Robot robot;
		
		public DanceMove(Robot robot) 
		{
			this.robot = robot;
		}
		
		abstract String getCode();
		abstract void move();
	}
	
	static class MoveFwd extends DanceMove
	{
		public MoveFwd(Robot robot) {
			super(robot);
		}

		@Override
		String getCode()
		{
			return "BB";
		}
		
		@Override
		void move()
		{
			robot.motorR.forward();
			robot.motorL.forward();
		}

		@Override
		public String toString()
		{
			return "<FWD>";
		}
	}

	static class MoveBwd extends DanceMove
	{
		public MoveBwd(Robot robot) {
			super(robot);
		}

		@Override
		String getCode()
		{
			return "BR";
		}

		@Override
		void move()
		{
			robot.motorR.backward();
			robot.motorL.backward();
		}

		@Override
		public String toString()
		{
			return "<BACK>";
		}
	}

	/*static class Pause extends DanceMove
	{
		public Pause(Robot robot) {
			super(robot);
		}

		@Override
		String getCode()
		{
			return "BRB";
		}

		@Override
		void move()
		{
			robot.motorR.stop();
			robot.motorL.stop();
		}

		@Override
		public String toString()
		{
			return "<PAUSE>";
		}
	}*/

	class TurnLeft extends DanceMove
	{
		public TurnLeft(Robot robot) {
			super(robot);
		}

		@Override
		String getCode()
		{
			return "RR";
		}
		
		@Override
		void move()
		{
			robot.motorR.forward();
			robot.motorL.flt();
		}
		
		@Override
		public String toString()
		{
			return "<LEFT>";
		}
	}

	class TurnLeftBwd extends DanceMove
	{
		public TurnLeftBwd(Robot robot) {
			super(robot);
		}

		@Override
		String getCode()
		{
			return "YR";
		}
		
		@Override
		void move()
		{
			robot.motorR.forward();
			robot.motorL.flt();
		}
		
		@Override
		public String toString()
		{
			return "<B-LEFT>";
		}
	}

	
	class TurnRight extends DanceMove
	{
		public TurnRight(Robot robot) {
			super(robot);
		}

		@Override
		String getCode()
		{
			return "RB";
		}

		@Override
		void move()
		{
			robot.motorR.flt();
			robot.motorL.forward();
		}
		
		@Override
		public String toString()
		{
			return "<RIGHT>";
		}
	}

	class TurnRightBwd extends DanceMove
	{
		public TurnRightBwd(Robot robot) {
			super(robot);
		}

		@Override
		String getCode()
		{
			return "YB";
		}

		@Override
		void move()
		{
			robot.motorR.flt();
			robot.motorL.forward();
		}
		
		@Override
		public String toString()
		{
			return "<B-RIGHT>";
		}
	}
	
	public MoveFwd moveFwd;
	public MoveBwd moveBwd;
	//public Pause pause;
	public TurnLeft turnLeft;
	public TurnLeftBwd turnLeftBwd;
	public TurnRight turnRight;
	public TurnRightBwd turnRightBwd;
	
	public DanceMove[] allMoves;
	@SuppressWarnings("deprecation")
	public Map<String, DanceMove> codesToMoves = new HashMap<String, DanceMove>();
	
	public Moves(Robot robot)
	{
		moveFwd = new MoveFwd(robot);
		moveBwd = new MoveBwd(robot);
		//pause = new Pause(robot);
		turnLeft = new TurnLeft(robot);
		turnLeftBwd = new TurnLeftBwd(robot);
		turnRight = new TurnRight(robot);
		turnRightBwd = new TurnRightBwd(robot);
		
		allMoves = new DanceMove[]{moveFwd, moveBwd, turnLeft, turnLeftBwd, 
				turnRight, turnRightBwd};
		for (DanceMove m : allMoves) {
			if (codesToMoves.containsKey(m.getCode())) {
				throw new RuntimeException("Duplicate key " + m.getCode());
			}
			codesToMoves.put(m.getCode(), m);
		}
	}
	
}
