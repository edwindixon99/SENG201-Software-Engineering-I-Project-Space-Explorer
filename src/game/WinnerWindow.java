package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JLabel lblCongratulations = new JLabel("Congratulations you found all the spaceship pieces.");
		lblCongratulations.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCongratulations.setBounds(10, 0, 817, 69);
		getContentPane().add(lblCongratulations);
		
		JLabel lblYourShip = new JLabel("Your Ship: " + game.getShip().getShipName());
		lblYourShip.setBounds(10, 80, 582, 43);
		getContentPane().add(lblYourShip);
		
		JLabel lblNumberOfDays = new JLabel("Number of Days taken: " +  + game.getDaysProgressedThrough());
		lblNumberOfDays.setBounds(10, 121, 582, 61);
		getContentPane().add(lblNumberOfDays);
		
		JLabel lblNewLabel = new JLabel("Score: ");
		lblNewLabel.setBounds(10, 195, 582, 69);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Quit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(678, 350, 149, 50);
		getContentPane().add(btnNewButton);
	}
}
