package Bingo;

import java.util.*;

public class Hopper {
	private ArrayList<PingPong> hopper;
	
	public Hopper(){
		hopper = new ArrayList<>();
		
	}
	
	public Hopper(int value)
	{
		hopper = new ArrayList<>(value);
	}
	public void addPingPongBalls(PingPong ball){
		hopper.add(ball);
	}
	public PingPong getWinner(){
		Collections.shuffle(hopper);
		PingPong winner = hopper.remove(0);
		return winner;
	}

	public ArrayList<PingPong> getHopper()
	{
		return hopper;
	}

	public void setHopper(ArrayList<PingPong> hopper)
	{
		this.hopper = hopper;
	}

	
}
