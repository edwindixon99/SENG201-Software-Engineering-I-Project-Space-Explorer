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
import java.util.ArrayList;

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
	 * 
	 * @param game			The game environment in which is being played.
	 */
	public GameOverWindow(GameEnvironment game) {
		setTitle("Space Explorer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 450);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(game.convertToMultiline("Game Over!\n" + game.getMessage()));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 817, 116);
		getContentPane().add(lblNewLabel);
		
		JLabel lblYourShip = new JLabel("Your Ship: " + game.getShip().getShipName());
		lblYourShip.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblYourShip.setBounds(10, 139, 582, 61);
		getContentPane().add(lblYourShip);
		
		JLabel lblNumberOfDays = new JLabel("Number of Days played: " + game.getDaysProgressedThrough());
		lblNumberOfDays.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNumberOfDays.setBounds(10, 198, 582, 61);
		getContentPane().add(lblNumberOfDays);
		
		int score =  500*(game.getScore()/game.getDaysProgressedThrough());
		if (game.getCrew1().getCrewMemberList().size() > 0) {
			score += 10 * game.getCrewMemberScores();
		}
		lblScore = new JLabel("Score: " + Integer.toString(score));
		lblScore.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblScore.setBounds(10, 254, 582, 69);
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
