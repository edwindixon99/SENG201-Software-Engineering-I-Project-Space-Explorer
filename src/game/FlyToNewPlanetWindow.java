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

public class FlyToNewPlanetWindow extends JFrame {

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public FlyToNewPlanetWindow(GameEnvironment game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 488);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(game.convertToMultiline(game.getMessage()));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setBounds(65, 27, 665, 288);
		getContentPane().add(lblNewLabel);
		
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
