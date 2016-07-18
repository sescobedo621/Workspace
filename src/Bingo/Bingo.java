package Bingo;

import java.util.*;

public class Bingo {
	private Scanner keyboard = new Scanner(System.in);
	private boolean play;
	Card bingoCard;
	private Caller caller;

	// constructor
	public Bingo()
	{
		caller = new Caller();
		play = true;
		bingoCard = new Card(5);
		bingoGame();
	}

	// displaying the main menu
	private int showMenu()
	{
		System.out.println("1. Call number \t\t2. Show all numbers called");
		System.out.println("3. Quit");
		return keyboard.nextInt();
	}

	// displaying the menu
	private int secondMenu()
	{
		System.out.println("1. Only print B's called \t2. Only print I's called");
		System.out.println("3. Only print N's called \t4. Only print G's called");
		System.out.println("5. Only print O's called \t6. Print whole list");

		return keyboard.nextInt();
	}

	// the second menu when you want to see the what has been called choice
	private void secondMenuChoice()
	{
		int choice = secondMenu();
		switch (choice) {
		case 1:
			caller.printCalledLetter('B');
			menuChoice();
			break;
		case 2:
			caller.printCalledLetter('I');
			menuChoice();
			break;
		case 3:
			caller.printCalledLetter('N');
			menuChoice();
			break;
		case 4:
			caller.printCalledLetter('G');
			menuChoice();
			break;
		case 5:
			caller.printCalledLetter('O');
			menuChoice();
			break;
		case 6:
			caller.printCalledBalls();
			menuChoice();
			break;
		default:
			System.out.println("Wrong action");
		}
	}

	// the main menu choices
	private void menuChoice()
	{
		int choice = showMenu();
		switch (choice) {
		case 1:
			break;
		case 2:
			System.out.println();
			secondMenuChoice();
			break;
		case 3:
			play = false;
			break;
		default:
			System.out.println("Wrong action try again");
		}
	}

	// the actual game
	public void bingoGame()
	{
		while(play) {
			
			caller.printBall();
			fillPiece();
			bingoCard.printBoard();
			if (bingo()){
				
				break;
			}
			menuChoice();
		}
		keyboard.close();
	}

	// if you have the number to fill the piece
	private void fillPiece()
	{
		String name = caller.getBall().getValue().substring(1).trim();
		int number = Integer.parseInt(name);
		for (int i = 0; i < bingoCard.getBoard().length; i++) {
			for (int j = 0; j < bingoCard.getBoard()[i].length; j++) {
				if (number == bingoCard.getBoard()[i][j])
					bingoCard.getBoard()[i][j] = 0;
				else
					continue;
			}
		}
	}

	// if there is bingo
	private boolean bingo()
	{
		// a loop to check for horizontal and vertical
		for (int i = 0; i < bingoCard.getBoard().length; i++) {
			// a very nested if statement to see if there is a win
			if (bingoCard.getBoard()[0][i] == 0 && bingoCard.getBoard()[0][i] == bingoCard.getBoard()[1][i]) {
				if (bingoCard.getBoard()[1][i] == bingoCard.getBoard()[2][i]) {
					if (bingoCard.getBoard()[2][i] == bingoCard.getBoard()[3][i]) {
						if (bingoCard.getBoard()[3][i] == bingoCard.getBoard()[4][i]) {
							System.out.println("BINGO!");
							return true;
						}
					}
				}
			}
			// a very nested if statement to see if there is a win
			else if (bingoCard.getBoard()[i][0] == 0 && bingoCard.getBoard()[i][0] == bingoCard.getBoard()[i][1]) {
				if (bingoCard.getBoard()[i][1] == bingoCard.getBoard()[i][2]) {
					if (bingoCard.getBoard()[i][2] == bingoCard.getBoard()[i][3]) {
						if (bingoCard.getBoard()[i][4] == bingoCard.getBoard()[i][4]) {
							System.out.println("BINGO!");
							return true;
						}
					}
				}
			}
			else if(bingoCard.getBoard()[0][0]== 0 && bingoCard.getBoard()[0][0] == bingoCard.getBoard()[1][1]){
				if(bingoCard.getBoard()[1][1] == bingoCard.getBoard()[2][2]){
					if(bingoCard.getBoard()[2][2] == bingoCard.getBoard()[3][3]){
						if(bingoCard.getBoard()[3][3] == bingoCard.getBoard()[4][4]){
							System.out.println("BINGO!");
							return true;
						}
					}
				}
			}
			else if(bingoCard.getBoard()[0][4] == 0 && bingoCard.getBoard()[0][4] ==bingoCard.getBoard()[1][3]){
				if(bingoCard.getBoard()[1][3] == bingoCard.getBoard()[2][2]){
					if(bingoCard.getBoard()[2][2] == bingoCard.getBoard()[3][1]){
						if(bingoCard.getBoard()[3][1] == bingoCard.getBoard()[4][0]){
							System.out.println("BINGO!");
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		BingoGame bingo = new BingoGame();
//		Bingo bingo = new Bingo();
//		bingo.bingoGame();

	}
}
