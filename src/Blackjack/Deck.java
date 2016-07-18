package Blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<>(52);
	private Card card1;
	private Card card2;
	private Card card3 = new Card("0", 0);
	private Card dealerCard1;
	private Card dealerCard2;
	private Card dealerCard3 = new Card("0", 0);
	private Scanner keyboard = new Scanner(System.in);
	private int totalNum;
	private int placeholder = 0;
	private int dealerTotal;

	// getters and setters
	public ArrayList<Card> getDeck()
	{
		return deck;
	}
	public void setDeck(ArrayList<Card> deck)
	{
		this.deck = deck;
	}
	public Card getCard1()
	{
		return card1;
	}
	public void setCard1(Card card1)
	{
		this.card1 = card1;
	}
	public Card getCard2()
	{
		return card2;
	}
	public void setCard2(Card card2)
	{
		this.card2 = card2;
	}
	public Card getCard3()
	{
		return card3;
	}
	public void setCard3(Card card3)
	{
		this.card3 = card3;
	}
	public Card getDealerCard1()
	{
		return dealerCard1;
	}
	public void setDealerCard1(Card dealerCard1)
	{
		this.dealerCard1 = dealerCard1;
	}
	public Card getDealerCard2()
	{
		return dealerCard2;
	}
	public void setDealerCard2(Card dealerCard2)
	{
		this.dealerCard2 = dealerCard2;
	}
	public Card getDealerCard3()
	{
		return dealerCard3;
	}
	public void setDealerCard3(Card dealerCard3)
	{
		this.dealerCard3 = dealerCard3;
	}
	public Scanner getKeyboard()
	{
		return keyboard;
	}
	public void setKeyboard(Scanner keyboard)
	{
		this.keyboard = keyboard;
	}
	public int getTotalNum()
	{
		return totalNum;
	}
	public void setTotalNum(int totalNum)
	{
		this.totalNum = totalNum;
	}
	public int getPlaceholder()
	{
		return placeholder;
	}
	public void setPlaceholder(int placeholder)
	{
		this.placeholder = placeholder;
	}
	public int getDealerTotal()
	{
		return dealerTotal;
	}
	public void setDealerTotal(int dealerTotal)
	{
		this.dealerTotal = dealerTotal;
	}

	// creating a deck of cards
	public void createCards()
	{
		for (int i = 0; i < 4; i++) {
			deck.add(new Card("2", 2));
			deck.add(new Card("3", 3));
			deck.add(new Card("4", 4));
			deck.add(new Card("5", 5));
			deck.add(new Card("6", 6));
			deck.add(new Card("7", 7));
			deck.add(new Card("8", 8));
			deck.add(new Card("9", 9));
			deck.add(new Card("10"));
			deck.add(new Card("Jack"));
			deck.add(new Card("Queen"));
			deck.add(new Card("King"));
			deck.add(new Card("Ace", 11));
		}
	}

	// inner class a card comparator
	public class CardComparator implements Comparator<Card> {
		@Override
		public int compare(Card o1, Card o2)
		{
			if (o1.num < o2.num) {
				return -1;
			} else if (o1.num > o2.num) {
				return 1;
			} else {
				return 0;
			}
		}

	}

	// shuffling the deck
	public void shuffleCards()
	{
		CardComparator shuffle = new CardComparator();
		Collections.shuffle(deck);
		// for (Card card : deck) {
		// System.out.println(card);
		// }
	}

	// dealing the cards
	public void dealCards()
	{

		card1 = deck.get(0);
		card2 = deck.get(2);
		System.out.println("You have " + card1 + " " + card2);
		dealerCard1 = deck.get(1);
		dealerCard2 = deck.get(3);
		System.out.println("Dealer shows " + dealerCard1);

	}

	// to decide what to do;
	public String hitHold()
	{
		System.out.println("Do you want to hit or hold? ");
		return keyboard.next().toUpperCase();

	}

	// for the total of the two cards you have
	public int addCards()
	{
		return card1.getNum() + card2.getNum();// + deck.get(2).getNum();
	}

	// playing the game
	public void playGame()
	{
		totalNum = addCards();
		System.out.println("You have a total of " + totalNum);
		String answer = hitHold();
		while (answer.equals("HIT") && totalNum <= 21) {
			card3 = deck.remove(0);
			System.out.println("You get " + card3);
			aceValue();
			totalNum += card3.getNum();
			placeholder += card3.getNum();
			System.out.println("You now have a total of " + totalNum);
			if(playerBusted()){
				break;
			}
			answer = hitHold();
		}
	}

	// like the dealer's total
	public int dealerTotal()
	{
		dealerTotal = dealerCard1.getNum() + dealerCard2.getNum();
		return dealerTotal;
	}

	// the dealer now plays
	public void dealerPlays()
	{
		System.out.println("Dealer has " + dealerCard1 + " " + dealerCard2);
		dealerTotal = dealerTotal();
		placeholder = 0;
		System.out.println("Dealer has a total of " + dealerTotal);
		while (dealerTotal <= 16) {
			dealerCard3 = deck.remove(0);
			System.out.println("Dealer has " + dealerCard3);
			aceValue();
			dealerTotal += dealerCard3.getNum();
			placeholder += dealerCard3.getNum();
			System.out.println("Dealer has a total of " + dealerTotal);
		}
	}

	// what happens if total is more than 21
	public boolean playerBusted()
	{
		if (totalNum > 21) {
			System.out.println("You Bust");
			return true;
		}
		return false;
	}

	// what happens if the dealer has over 21
	public boolean dealerBusted()
	{
		if (dealerTotal > 21) {
			System.out.println("Dealer Bust");
			return true;
		}
		return false;
	}

	// how to get blackjack
	public boolean blackjack()
	{
		if (((card1.getNum() == 10 && card2.getNumber().equals("Ace"))
				|| (card2.getNum() == 10 && card1.getNumber().equals("Ace")))) {
			System.out.println("BlackJack!");
			return true;
		}
		return false;
	}

	// how the dealer gets blackjack
	public boolean dealerBlackjack()
	{
		if ((dealerCard1.getNum() == 10 && dealerCard2.getNumber().equals("Ace"))
				|| (dealerCard2.getNum() == 10 && dealerCard1.getNumber().equals("Ace"))) {
			System.out.println("BlackJack!");
			return true;
		}
		return false;
	}

	public void winner()
	{
		if (totalNum <= 21 && totalNum > dealerTotal || dealerBusted() || blackjack()) {
			System.out.println("You win!");
		} else if (totalNum == dealerTotal) {
			System.out.println("Even");
		} else {
			System.out.println("Dealer wins!");
		}
	}

	// how to decide the value of ace
	public boolean aceValue()
	{
		if (totalNum > 13 && card1.getNumber().equals("Ace")) {
			card1.setNum(1);
			totalNum = addCards() + card3.getNum() + placeholder;
			return true;
		} else if (totalNum > 13 && card2.getNumber().equals("Ace")) {
			card2.setNum(1);
			totalNum = addCards() + card3.getNum() + placeholder;
			placeholder += card3.getNum();
			return true;

		} else if (totalNum > 13 && card3.getNumber().equals("Ace")) {
			card3.setNum(1);
			return true;
		} else if (dealerTotal > 13 && dealerCard1.getNumber().equals("Ace")) {
			dealerCard1.setNum(1);
			dealerTotal = dealerTotal() + placeholder;
			return true;
		} else if (dealerTotal > 13 && dealerCard2.getNumber().equals("Ace")) {
			dealerCard2.setNum(1);
			dealerTotal = dealerTotal() + placeholder;
			return true;
		} else if (dealerTotal > 13 && dealerCard3.getNumber().equals("Ace")) {
			dealerCard3.setNum(1);
			return true;

		}
		return false;
	}
}
