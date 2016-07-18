package caesarCipher;

public class ThreadCaesarCipher extends Thread {
	private Decript decripter;
	private String word;
	private int number;
	public ThreadCaesarCipher(Decript decript){
		decripter = decript;
	}
	
	public ThreadCaesarCipher(String word, int num){
		this.word = word;
		number = num;
	}
	
	public void run(){
		System.out.println("Running");
	}
	
	public static void main(String[] args)
	{
	}
}
