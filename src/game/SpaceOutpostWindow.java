package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpaceOutpostWindow {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public SpaceOutpostWindow(GameEnvironment gameEnvironment) {
		game = gameEnvironment;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSpaceoutpost = new JLabel("Welcome to the space outpost, please choose what you would like to do");
		lblSpaceoutpost.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSpaceoutpost.setBounds(76, 11, 610, 51);
		frame.getContentPane().add(lblSpaceoutpost);
		
		JButton bttnViewOwned = new JButton("View owned items");
		bttnViewOwned.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String foods = game.viewOwnedFood();
				game.setMessage(game.convertToMultiline(foods));
				String medicalItems = game.viewOwnedMedicalItems();
				game.setsecondMessage(game.convertToMultiline(medicalItems));
				ViewOwnedItems items = new ViewOwnedItems(game);
				items.setVisible(true);
				items.setDefaultCloseOperation(items.DISPOSE_ON_CLOSE);
			}
		});
		
		bttnViewOwned.setBounds(92, 307, 123, 51);
		frame.getContentPane().add(bttnViewOwned);
		
		JButton btnViewForSale = new JButton("View Items for sale");
		btnViewForSale.setBounds(330, 307, 123, 51);
		frame.getContentPane().add(btnViewForSale);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
		btnGoBack.setBounds(597, 307, 123, 51);
		frame.getContentPane().add(btnGoBack);
	}
	private void goBack() {
		game.closeSpaceOutpost(this);
		game.launchMainScreen();
	}

	public void closeWindow() {
		frame.dispose();
		
	}
}
