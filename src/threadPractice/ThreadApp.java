package threadPractice;

public class ThreadApp {
	 public static void main(String[] args)
	{
		PrintNumbers2 odds = new PrintNumbers2(1,2);
		PrintNumbers2 evens = new PrintNumbers2(2, 2);
		odds.start();
		evens.start();
	}
}

class PrintNumbers2 extends Thread{
	private int start = 0;
	private int increment = 1;
	
	public PrintNumbers2(int st, int inc){
		start = st;
		increment = inc;
	}
	
	public void print(){
		int i, j;
		for(i = start, j = 0; j<20; j++, i+= increment){
			System.out.println(i);
		}
	}
	
	public void run(){
		print();
	}
}
