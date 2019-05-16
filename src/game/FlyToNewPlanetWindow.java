package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
/**
 * This window displays a message about the crews flying situation.
 *
 * @author Jerome Grubb, Edwin Dixon
 * @version 16/05/19
 */
public class FlyToNewPlanetWindow extends JFrame {

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * 
	 * @param game			The game environment in which is being played.
	 */
	public FlyToNewPlanetWindow(GameEnvironment game) {
		setTitle("Space Explorer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 488);
		getContentPane().setLayout(null);
		
		JLabel messageLabel = new JLabel(game.convertToMultiline(game.getMessage()));
		messageLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		messageLabel.setBounds(65, 27, 665, 288);
		getContentPane().add(messageLabel);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setFont(new Font("Dialog", Font.BOLD, 15));
		btnContinue.setBounds(290, 382, 165, 35);
		getContentPane().add(btnContinue);
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				game.launchMainScreen();
			}
		});
	}
}
