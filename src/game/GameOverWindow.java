package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameOverWindow extends JFrame {
	private JLabel lblScore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the frame.
	 */
	public GameOverWindow(GameEnvironment game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 450);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(game.convertToMultiline("Game Over!\n" + game.getMessage()));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 654, 79);
		getContentPane().add(lblNewLabel);
		
		JLabel lblYourShip = new JLabel("Your Ship: " + game.getShip().getShipName());
		lblYourShip.setBounds(10, 101, 582, 43);
		getContentPane().add(lblYourShip);
		
		JLabel lblNumberOfDays = new JLabel("Number of Days played: " + game.getDaysProgressedThrough());
		lblNumberOfDays.setBounds(10, 155, 582, 61);
		getContentPane().add(lblNumberOfDays);
		
		lblScore = new JLabel("Score: ");
		lblScore.setBounds(10, 227, 582, 69);
		getContentPane().add(lblScore);
		
		
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
