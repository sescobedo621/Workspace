package caesarCipher;

import java.util.Scanner;

public class Cipher {
	private char[] cipher;
	private int shift;
	private char[] returnArray;
	
	public Cipher(char[] array, int num){
		cipher = array;
		shift = num;
		returnArray = encriptCipher();
	}
	
	public char[] getReturnArray(){
		return returnArray;
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

	private char[] encriptCipher()
	{
		returnArray = new char[cipher.length];
		for (int i = 0; i < cipher.length; i++) {
			char letterNumber = cipher[i];
			if (letterNumber == ' ' || letterNumber == '.' || letterNumber == '!' || letterNumber == ',' || letterNumber == '?') {
				returnArray[i] = letterNumber;
				continue;
			}
			letterNumber += shift;
			if (letterNumber > 'Z') {
				letterNumber = (char)(letterNumber - 91 + 65);
			} else if (letterNumber < 'A') {
				letterNumber = (char)(letterNumber - 65 + 91);
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
