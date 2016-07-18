package pigLatin;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatinGUI extends JFrame {
	private JButton translateButton;
	private JLabel messageLabel;
	private JLabel resultLabel;
	private JTextField messageTextField;
	private JTextField resultTextField;
	
	public PigLatinGUI(){
		super("Pig Latin Translater");
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		addComponents();
		addEventHandlers();
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	private void addComponents(){
		translateButton = new JButton("TRANSLATE");
		messageLabel = new JLabel("Message:");
		resultLabel = new JLabel("Translated Message:");
		messageTextField = new JTextField(40);
		resultTextField = new JTextField(40);
		
		JPanel topPanel = new JPanel();
		topPanel.add(messageLabel);
		topPanel.add(messageTextField);
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(resultLabel);
		bottomPanel.add(resultTextField);
		
		add(topPanel, BorderLayout.NORTH);
		add(translateButton, BorderLayout.EAST);
		add(bottomPanel, BorderLayout.SOUTH);
		
	}
	private void addEventHandlers(){
		translateButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String message = messageTextField.getText().toUpperCase();
				PigLatin pigLatin = new PigLatin(message);
				pigLatin.translatePhrase();
				
				resultTextField.setText(pigLatin.toString());
				
			}
		});
	}
	public static void main(String[] args)
	{
		new PigLatinGUI();
	}
}
