package Blackjack;

import java.util.Scanner;

public class Blackjack {
	private Scanner keyboard = new Scanner(System.in);
	private String answer;
	private int bet;
	private int bank;
	Deck deck = new Deck();

	// getters and setters
	public String getAnswer()
	{
		return answer;
	}

	public void setAnswer(String answer)
	{
		this.answer = answer;
	}

	public int getBet()
	{
		return bet;
	}

	public void setBet(int bet)
	{
		this.bet = bet;
	}

	public int getBank()
	{
		return bank;
	}

	public void setBank()
	{
		System.out.println("How much money do you want to put in the bank");
		bank = keyboard.nextInt();
		
	}

	// you can place a bet
	public void placeBets()
	{
		System.out.println("Place your bet.");
		bet += keyboard.nextInt();
	}

	// so people can play again
	public boolean playAgain()
	{
		System.out.println("Do you want to play again?");
		answer = keyboard.next();
		if (answer.equalsIgnoreCase("yes")) {
			return true;
		}
		return false;
	}
//winning money
	public int earnings(){
		if (deck.blackjack()){
			bank += (bet * 2);
		}
		else if(!(deck.playerBusted()) && deck.getTotalNum() > deck.getDealerTotal() || deck.dealerBusted()){
			bank += bet;
		}
		else{
			bank -= bet;
		}
		return bank;
		
	}
	
	public static void main(String[] args)
	{
		Blackjack game = new Blackjack();
		//setting up your bank
		game.setBank();
		do {
			game.placeBets();
			game.deck.createCards();
			game.deck.shuffleCards();
			game.deck.dealCards();
			if (game.deck.blackjack()) {
				game.deck.winner();
				game.bank = game.earnings();
				System.out.println(game.bank);
				continue;
			}
			game.deck.playGame();
			game.placeBets();
			if(game.deck.dealerBlackjack()){
				game.deck.winner();
				game.bank = game.earnings();
				System.out.println(game.bank);
				continue;
			}
			game.deck.dealerPlays();
			game.deck.winner();
			game.bank = game.earnings();
			System.out.println(game.bank);
			// game.playAgain();
		} while (game.playAgain());
		game.keyboard.close();
	}
}
