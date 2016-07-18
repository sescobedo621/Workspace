package Bingo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BingoGame extends JFrame {
	private JButton playButton;
	private JButton closeButton;
	private JMenuItem showCalledNumbers;
	private JMenuItem quitGame;
	private JMenuItem showCalledB;
	private JMenuItem showCalledI;
	private JMenuItem showCalledN;
	private JMenuItem showCalledG;
	private JMenuItem showCalledO;
	
	public BingoGame(){
		super("BINGO");
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		addComponents();
		addMenu();
		addHandlers();
		createGameBoard();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
	}
	private void addComponents(){
		playButton = new JButton("PLAY");
		closeButton = new JButton("CLOSE");
		JPanel panel = new JPanel();
		panel.add(playButton);
		panel.add(closeButton);
		this.add(panel, BorderLayout.CENTER);
	}
	
	private void addMenu(){
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		showCalledNumbers = new JMenuItem("Called Balls");
		showCalledB = new JMenuItem("Called \"B\" Balls");
		showCalledI = new JMenuItem("Called \"I\" Balls");
		showCalledN = new JMenuItem("Called \"N\" Balls");
		showCalledG = new JMenuItem("Called \"G\" Balls");
		showCalledO = new JMenuItem("Called \"O\" Balls");
		quitGame = new JMenuItem("Quit");
		
		gameMenu.add(showCalledNumbers);
		gameMenu.add(showCalledB);
		gameMenu.add(showCalledI);
		gameMenu.add(showCalledN);
		gameMenu.add(showCalledG);
		gameMenu.add(showCalledO);
		gameMenu.add(quitGame);
		gameMenu.insertSeparator(6);
		menuBar.add(gameMenu);
		
		setJMenuBar(menuBar);
		
	}
	
	private void addHandlers(){
		class PlayListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Bingo bingo = new Bingo();
				createGameBoard();
			}
		}
		ActionListener playListener = new PlayListener();
		playButton.addActionListener(playListener);
		class CloseListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();				
			}
		}
		ActionListener closeListener = new CloseListener();
		closeButton.addActionListener(closeListener);
		quitGame.addActionListener(closeListener);
	}
	
	private void createGameBoard(){
		String[] bingo = {"B","I","N","G","O"};
		JTable gameBoard = new JTable(new Integer [5][5], bingo);

		gameBoard.setShowGrid(true);
	}
}
