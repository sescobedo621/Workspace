package caesarCipher;

import java.util.Scanner;

public class Decript {
	private char[] cipher;
	private int shift;
	private char[] returnArray;
	
	public Decript(String message, int num){
		cipher = message.toUpperCase().toCharArray();
		shift = num;
		returnArray = decriptCipher();
	}
	
	public Decript(char[] array, int num){
		cipher = array;
		shift = num;
		returnArray = decriptCipher();
	}
	
	public char[] getCipher()
	{
		return cipher;
	}

	public void setCipher(char[] array)
	{
		cipher = array;
	}

	public int getShift()
	{
		return shift;
	}

	public void setShift(int shiftNum)
	{
		shift = shiftNum;
	}

	private char[] decriptCipher()
	{
		returnArray = new char[cipher.length];
		for (int i = 0; i < cipher.length; i++) {
			char letterNumber = cipher[i];
			if (letterNumber == ' ' || letterNumber == '.' || letterNumber == '!' || letterNumber == ',' || letterNumber == '?') {
				returnArray[i] = letterNumber;
				continue;
			}
			letterNumber -= shift;
			if (letterNumber > 'Z') {
				letterNumber = (char)((int)letterNumber - 91 + 65);
			} else if (letterNumber < 'A') {
				letterNumber = (char)((int)letterNumber - 65 + 91);
			}
			returnArray[i] = letterNumber;

		}
		return returnArray;
	}

	public String toString(){
		String word = "";
		for (char c : returnArray) {
			word+= c;
		}
		return word;
	}
}
