package Bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Caller {
	private String name;
	private int value;
	private Hopper hopper;
	private ArrayList<PingPong> calledBalls;
	private PingPong ball;
	private pingPongComparator pingPong;

	// constructor
	public Caller()
	{
		addBalls();
		calledBalls = new ArrayList();
		pingPong = new pingPongComparator();
		Collections.sort(calledBalls, pingPong);
	}

	class pingPongComparator implements Comparator<PingPong> {

		@Override
		public int compare(PingPong o1, PingPong o2)
		{
			return o1.compareTo(o2);
		}

	}

	// assign ball names
	private void addBalls()
	{
		hopper = new Hopper(75);
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= 15; j++) {
				name = name(i);
				value = j + (i * 15);
				name += " " + value;
				hopper.addPingPongBalls(new PingPong(name));
			}
		}
	}

	// assigning B-I-N-G-O to balls and card
	private String name(int val)
	{
		if (val == 0) {
			name = "B";
		} else if (val == 1) {
			name = "I";
		} else if (val == 2) {
			name = "N";
		} else if (val == 3) {
			name = "G";
		} else {
			name = "O";
		}
		return name;
	}

	public ArrayList<PingPong> getCalledBalls()
	{
		return calledBalls;
	}
	public PingPong getBall(){
		return ball;
	}
	// call the ball
	public void printBall()
	{
		ball = hopper.getWinner();
		System.out.println(ball);
		calledBalls.add(ball);
	}

	public void printCalledBalls()
	{
		Collections.sort(calledBalls, pingPong);
		for (PingPong ping : calledBalls) {
			System.out.println(ping);
		}
	}
	public void printCalledLetter(char c){
		Collections.sort(calledBalls, pingPong);
		for (PingPong ping : calledBalls) {
			if(ping.getValue().charAt(0) == c)
				System.out.println(ping);
		}
	}
}
