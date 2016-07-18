package Bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {
	private List<Integer> Bnumbers;
	private List<Integer> Inumbers;
	private List<Integer> Nnumbers;
	private List<Integer> Gnumbers;
	private List<Integer> Onumbers;
	private String[] letters;
	private int[][] board;

	public Card(int num)
	{
		letters = new String[num];
		board = new int[num][num];
		setNumbers();
		setBoard();
	}

	public String[] getLetters()
	{
		return letters;
	}

	public void setLetters(String[] letters)
	{
		this.letters = letters;
	}

	public int[][] getBoard()
	{
		return board;
	}

	public void setBoard(int[][] board)
	{
		this.board = board;
	}
	//the numbers in the arraylist
	private void setNumbers()
	{
		Bnumbers = new ArrayList<>();
		Inumbers = new ArrayList<>();
		Nnumbers = new ArrayList<>();
		Gnumbers = new ArrayList<>();
		Onumbers = new ArrayList<>();
		for (int i = 1; i <= 15; i++) {
			Bnumbers.add(i);
			Inumbers.add(i + 15);
			Nnumbers.add(i + 30);
			Gnumbers.add(i + 45);
			Onumbers.add(i + 60);
		}
	}
	//set up the board number wise
	private void setBoard()
	{
		Collections.shuffle(Bnumbers);
		Collections.shuffle(Inumbers);
		Collections.shuffle(Nnumbers);
		Collections.shuffle(Gnumbers);
		Collections.shuffle(Onumbers);
		for (int i = 0; i < board.length; i++) {
			letters[i] = name(i);
			board[i][0] = Bnumbers.remove(0);
			board[i][1] = Inumbers.remove(0);
			board[i][2] = Nnumbers.remove(0);
			board[i][3] = Gnumbers.remove(0);
			board[i][4] = Onumbers.remove(0);
		}
	}
	private String name(int val)
	{
		String name;
		if (val == 0) {
			name = "B";
		} else if (val == 1) {
			name = "I";
		} else if (val == 2) {
			name = "N";
		} else if (val == 3) {
			name = "G";
		} else {
			name = "O";
		}
		return name;
	}
	// print out the board in a certain way
	public void printBoard()
	{
		for (String letter : letters) {
			System.out.print(letter + "\t");
		}
		System.out.println();
		for (int[] is : board) {
			for (int i : is) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}
}
