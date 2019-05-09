package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class WinnerWindow extends JFrame {

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public WinnerWindow(GameEnvironment game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 450);
		getContentPane().setLayout(null);
		
		JLabel lblCongratulations = new JLabel("Congratulations ");
		lblCongratulations.setBounds(10, 11, 817, 100);
		getContentPane().add(lblCongratulations);
	}

}
