package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	 */
	public SearchPlanet(GameEnvironment game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 564);
		getContentPane().setLayout(null);
		
		
		
		
		JButton goBackBttn = new JButton("Go Back");
		goBackBttn.setFont(new Font("Dialog", Font.BOLD, 15));
		goBackBttn.setBounds(433, 458, 177, 35);
		getContentPane().add(goBackBttn);
	}

}
