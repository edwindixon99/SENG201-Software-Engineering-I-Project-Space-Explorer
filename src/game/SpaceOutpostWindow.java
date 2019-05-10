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
		frame.setBounds(100, 100, 800, 279);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSpaceoutpost = new JLabel("Welcome to the space outpost, please choose what you would like to do");
		lblSpaceoutpost.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblSpaceoutpost.setBounds(32, 11, 707, 51);
		frame.getContentPane().add(lblSpaceoutpost);
		
		JButton bttnViewOwned = new JButton("View owned items");
		bttnViewOwned.setFont(new Font("Dialog", Font.PLAIN, 15));
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
		
		bttnViewOwned.setBounds(32, 89, 177, 88);
		frame.getContentPane().add(bttnViewOwned);
		
		JButton btnViewForSale = new JButton("View Items for sale");
		btnViewForSale.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnViewForSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchViewItemsForSale();
			}
		});
		btnViewForSale.setBounds(288, 89, 199, 88);
		frame.getContentPane().add(btnViewForSale);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
		btnGoBack.setBounds(562, 89, 177, 88);
		frame.getContentPane().add(btnGoBack);
	}
	private void launchViewItemsForSale() {
		game.closeSpaceOutpost(this);
		game.launchItemsForSale();
		
		
	}

	private void goBack() {
		game.closeSpaceOutpost(this);
		game.launchMainScreen();
	}

	public void closeWindow() {
		frame.dispose();
		
	}
}
