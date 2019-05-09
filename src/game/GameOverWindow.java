package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class GameOverWindow extends JFrame {

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
		setBounds(100, 100, 703, 564);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(game.convertToMultiline("Game Over!\n" + game.getMessage()));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(23, 11, 654, 503);
		getContentPane().add(lblNewLabel);
		
		
	}
}
