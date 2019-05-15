package game;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RepairShip extends JFrame {
	private GameEnvironment game;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEnvironment game = new GameEnvironment();
					RepairShip frame = new RepairShip(game);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param game			The game environment in which is being played.
	 */
	public RepairShip(GameEnvironment game) {
		setTitle("Space Explorer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 219);
		getContentPane().setLayout(null);
		
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setFont(new Font("Dialog", Font.BOLD, 15));
		btnContinue.setBounds(12, 130, 165, 35);
		getContentPane().add(btnContinue);
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				game.launchMainScreen();
		JLabel messageLabel = new JLabel(game.getMessage());
		messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		messageLabel.setBounds(12, 12, 817, 106);
		getContentPane().add(messageLabel);

			}
		});
	}
}