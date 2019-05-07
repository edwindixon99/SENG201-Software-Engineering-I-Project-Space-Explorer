package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ItemsForSale extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEnvironment game = new GameEnvironment();
					ItemsForSale frame = new ItemsForSale(game);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private GameEnvironment game;
	private SalePopup popup;

	/**
	 * Create the frame.
	 */
	public ItemsForSale(GameEnvironment game) {
		this.game = game;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		ArrayList<Food> foodList = game.getCrew1().getFoodItems();
		ArrayList<MedicalItem> medicalList = game.getCrew1().getMedicalItems();
		
		
		Food apple = new Food("Apple", 15, 7);
		JButton button_1 = new JButton(game.convertToMultiline(apple.toString()));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, apple));
				itemBought();
			}
		});
		button_1.setBounds(46, 91, 179, 135);
		getContentPane().add(button_1);
		
		Food sandwich = new Food("Sandwich", 25, 12);
		JButton button_5 = new JButton(game.convertToMultiline(sandwich.toString()));
		button_5.setBounds(546, 91, 179, 135);
		getContentPane().add(button_5);
		
		Food biscuit = new Food("Biscut", 10, 5);
		JButton button_7 = new JButton(game.convertToMultiline(biscuit.toString()));
		button_7.setBounds(546, 250, 179, 135);
		getContentPane().add(button_7);
		
		Food pie = new Food("Pie", 30, 15);
		JButton button_8 = new JButton(game.convertToMultiline(pie.toString()));
		button_8.setBounds(298, 250, 179, 135);
		getContentPane().add(button_8);
		
		MedicalItem spc = new MedicalItem("Space plague cure", true, 0, 15);
		JButton button = new JButton(game.convertToMultiline(spc.toString()));
		button.setBounds(546, 415, 179, 135);
		getContentPane().add(button);
		
		Food burger = new Food("Burger", 40, 20);
		JButton button_2 = new JButton(game.convertToMultiline(burger.toString()));
		button_2.setBounds(298, 91, 179, 135);
		getContentPane().add(button_2);
		
		MedicalItem bHealing = new MedicalItem("Big Healing", false, 40, 20);
		JButton button_3 = new JButton(game.convertToMultiline(bHealing.toString()));
		button_3.setBounds(298, 415, 179, 135);
		getContentPane().add(button_3);
		
		MedicalItem sHealing = new MedicalItem("SmallHealing", false, 10, 5);
		JButton button_4 = new JButton(game.convertToMultiline(sHealing.toString()));
		button_4.setBounds(46, 415, 179, 135);
		getContentPane().add(button_4);
		
		Food pizza = new Food("Pizza", 50, 25);
		JButton button_6 = new JButton(game.convertToMultiline(pizza.toString()));
		button_6.setBounds(46, 250, 179, 135);
		getContentPane().add(button_6);
		
		JLabel lblNewLabel = new JLabel("Pick an item that you want to buy. You have $ " + game.getCrew1().getMoney() + " to spend");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(46, 11, 613, 64);
		getContentPane().add(lblNewLabel);
		
		JButton btnExitOutpostStore = new JButton("Exit Outpost Store");
		btnExitOutpostStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
		btnExitOutpostStore.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExitOutpostStore.setBounds(546, 11, 211, 64);
		getContentPane().add(btnExitOutpostStore);

	}
	private void goBack() {
		closeWindow();
		game.launchSpaceOutpost();
		
	}
	private void itemBought() {
		if (popup == null) {
			popup = new SalePopup(game, this);
		}
		popup.dispose();
		popup = new SalePopup(game, this);
		popup.setVisible(true);
		popup.setDefaultCloseOperation(popup.DISPOSE_ON_CLOSE);
//		game.closeItemsForSale(this);
//		game.launchItemsForSale();
		
	}
	public void closeWindow() {
		dispose();
	}

}
/*
 * if (num == 7) {
 * 
 * 
 * } if (num == 8) {
 * 
 * crew1.buy(foodList, medicalList, med); } if (num == 9) {
 * 
 * crew1.buy(foodList, medicalList, med); } if (num == 6) {
 * 
 * crew1.buy(foodList, medicalList, food); } if (num == 1) { crew1.buy(foodList,
 * medicalList, food);
 * 
 * } if (num == 2) { crew1.buy(foodList, medicalList, food); } if (num == 3) {
 * 
 * crew1.buy(foodList, medicalList, food); } if (num == 4) {
 * 
 * crew1.buy(foodList, medicalList, food); } if (num == 5) {
 * 
 * crew1.buy(foodList, medicalList, food); }
 */

	