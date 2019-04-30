package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class SpaceOutpostWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpaceOutpostWindow window = new SpaceOutpostWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SpaceOutpostWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSpaceoutpost = new JLabel("SpaceOutpost");
		lblSpaceoutpost.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSpaceoutpost.setBounds(149, 11, 417, 51);
		frame.getContentPane().add(lblSpaceoutpost);
		
		JLabel lblNewLabel = new JLabel("Apple");
		lblNewLabel.setBounds(34, 81, 140, 75);
		frame.getContentPane().add(lblNewLabel);
	}
}
