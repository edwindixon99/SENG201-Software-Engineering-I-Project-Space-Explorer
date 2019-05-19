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
 * This window is used for actions as a way to display a message relating to that action.
 *
 * @author Jerome Grubb, Edwin Dixon
 * @version 16/05/19
 */
public class SearchPlanet extends JFrame {
	private GameEnvironment game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEnvironment game = new GameEnvironment();
					SearchPlanet frame = new SearchPlanet(game);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param game			The GameEnvironment object which is being played.
	 */
	public SearchPlanet(GameEnvironment game) {
		setTitle("Space Explorer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 219);
		getContentPane().setLayout(null);
		
		JLabel messageLabel = new JLabel(game.convertToMultiline(game.getMessage()));
		messageLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		messageLabel.setBounds(10, 11, 817, 124);
		getContentPane().add(messageLabel);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setFont(new Font("Dialog", Font.BOLD, 15));
		btnContinue.setBounds(10, 134, 165, 35);
		getContentPane().add(btnContinue);
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (game.isGameIsOver()) {
					dispose();
					game.launchWinnerWindow();
				}
				else {
					dispose();
					game.launchMainScreen();
				}
			}
		});
	}
}
