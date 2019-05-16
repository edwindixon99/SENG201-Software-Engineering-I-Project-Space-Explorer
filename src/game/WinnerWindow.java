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
/**
 * This window displays an final message when game is won.
 *
 * @author Jerome Grubb, Edwin Dixon
 * @version 16/05/19
 */
public class WinnerWindow extends JFrame {

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * @param game			The game environment in which is being played.
	 */
	public WinnerWindow(GameEnvironment game) {
		setTitle("Space Explorer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 450);
		getContentPane().setLayout(null);
		
		JLabel lblCongratulations = new JLabel("Congratulations you found all the spaceship pieces.");
		lblCongratulations.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCongratulations.setBounds(10, 0, 817, 69);
		getContentPane().add(lblCongratulations);
		
		JLabel lblYourShip = new JLabel("Your Ship: " + game.getShip().getShipName());
		lblYourShip.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblYourShip.setBounds(10, 80, 595, 61);
		getContentPane().add(lblYourShip);
		
		JLabel lblNumberOfDays = new JLabel("Number of Days taken: " +  + game.getDaysProgressedThrough());
		lblNumberOfDays.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNumberOfDays.setBounds(10, 153, 582, 61);
		getContentPane().add(lblNumberOfDays);
		
		JLabel scoreLabel = new JLabel("Score: " + Integer.toString(1000*(game.getScore()/game.getDaysProgressedThrough())));
		scoreLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		scoreLabel.setBounds(10, 225, 582, 69);
		getContentPane().add(scoreLabel);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		quitButton.setBounds(678, 350, 149, 50);
		getContentPane().add(quitButton);
	}
}
