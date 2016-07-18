package threadPractice;

public class ThreadApp2 {
	 public static void main(String[] args)
	{
		PrintNumbers3 odds = new PrintNumbers3(1,2);
		PrintNumbers3 evens = new PrintNumbers3(2, 2);
		odds.setThreadName("Odds");
		evens.setThreadName("Evens");
		odds.startThread();
		evens.startThread();
	}
}

class PrintNumbers3 implements Runnable{
	private int start = 0;
	private int increment = 1;
	private Thread theThread;
	
	public PrintNumbers3(int st, int inc){
		start = st;
		increment = inc;
		theThread = new Thread(this);
	}
	
	public void print() throws Exception{
		int i, j;
		for(i = start, j = 0; j<20; j++, i+= increment){
			System.out.println(theThread.getName()+" "+i);
			Thread.yield();
		}
	}
	
	public void run(){
		try {
			print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startThread(){
		theThread.start();
	}
	
	public void setThreadName(String name){
		theThread.setName(name);
	}
}
