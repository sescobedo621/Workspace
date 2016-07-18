package caesarCipher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CipherWindow extends JFrame {
	private JButton encriptButton;
	private JButton decriptButton;
	private JTextField text;
	private JTextField shift;
	private JTextField cipher;
	private JLabel label;
	private JMenuItem exitMenuItem;
	private JMenuItem encriptMenuItem;
	private JMenuItem decriptMenuItem;

	public CipherWindow()
	{
		super("Caesar Cipher");
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		addComponents();
		addMenu();
		pack();
		addEventHandlers();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void addComponents()
	{
		
		encriptButton = new JButton("ENCRIPT");
		decriptButton = new JButton("DECRIPT");
		
		JLabel wordToCript = new JLabel("Message:");
		JLabel numToShift = new JLabel("Shift Amount:");
		addSubcomponents();
		
		JPanel northPanel = new JPanel();
		northPanel.add(wordToCript);
		northPanel.add(text);
		
		JPanel panel = new JPanel();
		panel.add(numToShift);
		panel.add(shift);
		panel.add(encriptButton);
		panel.add(decriptButton);
		
		JPanel southPanel = new JPanel();
		southPanel.add(label);
		southPanel.add(cipher);
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
		this.add(southPanel, BorderLayout.SOUTH	);
	}
	
	private void addSubcomponents(){
		text = new JTextField(40);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setEnabled(true);
		shift = new JTextField(5);
		shift.setHorizontalAlignment(SwingConstants.CENTER);
		cipher = new JTextField(40);
		label = new JLabel("Result:");
	}

	private void addMenu()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		encriptMenuItem = new JMenuItem("Encript");
		decriptMenuItem = new JMenuItem("Decript");
		exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(encriptMenuItem);
		fileMenu.add(decriptMenuItem);
		fileMenu.add(exitMenuItem);
		fileMenu.insertSeparator(2);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
	}

	private void addEventHandlers()
	{
		class EncriptListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String words = text.getText();
				int numberShift = Integer.parseInt(shift.getText());
				char[] letters = words.toUpperCase().toCharArray();
				Cipher encript = new Cipher(letters, numberShift);
				cipher.setText(encript.toString());
			}
		}
		class DecriptListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String words = text.getText();
				int numberShift = Integer.parseInt(shift.getText());
				char[] letters = words.toUpperCase().toCharArray();
				Decript decript = new Decript(letters, numberShift);
				cipher.setText(decript.toString());
			}

		}
		class ExitListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}

		}
		ActionListener encriptListen = new EncriptListener();
		ActionListener decriptListen = new DecriptListener();
		encriptButton.addActionListener(encriptListen);
		encriptMenuItem.addActionListener(encriptListen);
		decriptButton.addActionListener(decriptListen);
		decriptMenuItem.addActionListener(decriptListen);
		exitMenuItem.addActionListener(new ExitListener());
	}

	public static void main(String[] args)
	{
		new CipherWindow();
	}
}
