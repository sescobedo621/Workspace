package test;

public class test {

	public static void main(String[] args)
	{
		switch(45){
		case 2: case 3: case 'a':
			System.out.println("it works this way");
			break;
		case 4:
			System.out.println("it works");
			break;
		default:
			System.out.println("in default");
		}
	}
}
