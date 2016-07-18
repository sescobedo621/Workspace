package caesarCipher;

import java.util.Scanner;

public class CaesarCipher {
	private Scanner keyboard;
	private Cipher encript;
	private Decript decript;
	
	public CaesarCipher()
	{
		
		cipher();
	}

	private void encriptOrDecript(char cript)
	{
		switch (cript) {
		case 'E':
			encript();
			break;
		case 'D':
			decript();
			break;
		default:
			System.out.println("Wrong Action");
		}
	}

	private void encript()
	{
		keyboard = new Scanner(System.in);
		char[] letters;
		int shift;
		
		System.out.print("What would you like to encrypt? ");
		letters = keyboard.nextLine().toUpperCase().toCharArray();
		System.out.print("How many spaces do you want to shift? ");
		shift = keyboard.nextInt();
		encript = new Cipher(letters, shift);
		System.out.println(encript.toString());
	}

	private void decript()
	{
		keyboard = new Scanner(System.in);
		char[] letters;
		int shift;
		System.out.print("What would you like to decript? ");
		letters = keyboard.nextLine().toUpperCase().toCharArray();
		System.out.print("How many spaces do you want to shift? ");
		shift = keyboard.nextInt();
		decript = new Decript(letters, shift);
		System.out.println(decript.toString());
	}

	private void cipher()
	{
		keyboard = new Scanner(System.in);
		System.out.println("Do you want to encript or decript?");
		System.out.print("E for Encript and D for decript ");
		encriptOrDecript(keyboard.next().toUpperCase().charAt(0));
		keyboard.close();
	}

	
	public static void main(String[] args)
	{
		new CaesarCipher();
	}
}
