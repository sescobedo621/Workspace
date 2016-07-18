package Blackjack;

public class Card {
	String number;
	//Suit suit;
	int num;
	public Card(String number, int num)
	{
		this.number = number;
		//this.suit = suit;
		this.num = num;
	}
	public Card(String number){
		this(number, 10);
	}
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number = number;
	}
//	public Suit getSuit()
//	{
//		return suit;
//	}
//	public void setSuit(Suit suit)
//	{
//		this.suit = suit;
//	}
	@Override
	public String toString()
	{
		return "Card " + number;
	}
	
	public int getNum()
	{
		return num;
	}
	public void setNum(int num)
	{
		this.num = num;
	}
	
}
