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
		setTitle("Space Explorer");
		this.game = game;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		ArrayList<Food> foodList = game.getCrew1().getFoodItems();
		ArrayList<MedicalItem> medicalList = game.getCrew1().getMedicalItems();
		
		
		Food apple = new Food("Apple", 15, 7);
		JButton button_1 = new JButton("Buy " + apple.getName());
		button_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, apple));
				itemBought();
			}
		});
		button_1.setBounds(46, 182, 179, 44);
		getContentPane().add(button_1);
		
		Food sandwich = new Food("Sandwich", 25, 12);
		JButton button_5 = new JButton("Buy " + sandwich.getName());
		button_5.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, sandwich));
				itemBought();
			}
		});
		button_5.setBounds(546, 182, 179, 44);
		getContentPane().add(button_5);
		
		Food biscuit = new Food("Biscut", 10, 5);
		JButton button_7 = new JButton("Buy " + biscuit.getName());
		button_7.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, biscuit));
				itemBought();
			}
		});
		button_7.setBounds(546, 341, 179, 44);
		getContentPane().add(button_7);
		
		Food pie = new Food("Pie", 30, 15);
		JButton button_8 = new JButton("Buy " + pie.getName());
		button_8.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, pie));
				itemBought();
			}
		});
		button_8.setBounds(298, 341, 179, 44);
		getContentPane().add(button_8);
		
		MedicalItem spc = new MedicalItem("Space plague cure", true, 0, 15);
		JButton button = new JButton("Buy " + spc.getName());
		button.setFont(new Font("Dialog", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, spc));
				itemBought();
			}
		});
		button.setBounds(546, 506, 179, 44);
		getContentPane().add(button);
		
		Food burger = new Food("Burger", 40, 20);
		JButton button_2 = new JButton("Buy " + burger.getName());
		button_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, burger));
				itemBought();
			}
		});
		button_2.setBounds(298, 182, 179, 44);
		getContentPane().add(button_2);
		
		MedicalItem bHealing = new MedicalItem("Big Healing", false, 40, 20);
		JButton button_3 = new JButton("Buy " + bHealing.getName());
		button_3.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, bHealing));
				itemBought();
			}
		});
		button_3.setBounds(298, 506, 179, 44);
		getContentPane().add(button_3);
		
		MedicalItem sHealing = new MedicalItem("SmallHealing", false, 10, 5);
		JButton button_4 = new JButton("Buy " + sHealing.getName());
		button_4.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, sHealing));
				itemBought();
			}
		});
		button_4.setBounds(46, 506, 179, 44);
		getContentPane().add(button_4);
		
		Food pizza = new Food("Pizza", 50, 25);
		JButton button_6 = new JButton("Buy " + pizza.getName());
		button_6.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, pizza));
				itemBought();
			}
		});
		button_6.setBounds(46, 341, 179, 44);
		getContentPane().add(button_6);
		
		JLabel lblNewLabel = new JLabel(game.convertToMultiline("Pick an item that you want to buy. You have $ " + game.getCrew1().getMoney() + " to spend.\nYou can find money by searching planets."));
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, -9, 649, 104);
		getContentPane().add(lblNewLabel);
		
		JButton btnExitOutpostStore = new JButton("Exit Outpost Store");
		btnExitOutpostStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
		btnExitOutpostStore.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnExitOutpostStore.setBounds(546, 11, 211, 64);
		getContentPane().add(btnExitOutpostStore);
		
		JLabel applelabel = new JLabel(game.convertToMultiline(apple.toString()));
		applelabel.setBounds(46, 86, 179, 93);
		getContentPane().add(applelabel);
		
		JLabel burgerlabel = new JLabel(game.convertToMultiline(burger.toString()));
		burgerlabel.setBounds(298, 86, 179, 93);
		getContentPane().add(burgerlabel);
		
		JLabel sandwichlabel = new JLabel(game.convertToMultiline(sandwich.toString()));
		sandwichlabel.setBounds(546, 86, 179, 93);
		getContentPane().add(sandwichlabel);
		
		JLabel biscuitlabel = new JLabel(game.convertToMultiline(biscuit.toString()));
		biscuitlabel.setBounds(546, 237, 179, 93);
		getContentPane().add(biscuitlabel);
		
		JLabel pielabel = new JLabel(game.convertToMultiline(pie.toString()));
		pielabel.setBounds(298, 237, 179, 93);
		getContentPane().add(pielabel);
		
		JLabel pizzalabel = new JLabel(game.convertToMultiline(pizza.toString()));
		pizzalabel.setBounds(46, 237, 179, 93);
		getContentPane().add(pizzalabel);
		
		JLabel shealinglabel = new JLabel(game.convertToMultiline(sHealing.toString()));
		shealinglabel.setBounds(46, 396, 179, 93);
		getContentPane().add(shealinglabel);
		
		JLabel bhealinglabel = new JLabel(game.convertToMultiline(bHealing.toString()));
		bhealinglabel.setBounds(298, 396, 179, 93);
		getContentPane().add(bhealinglabel);
		
		JLabel spclabel = new JLabel(game.convertToMultiline(spc.toString()));
		spclabel.setBounds(546, 396, 179, 93);
		getContentPane().add(spclabel);

	}
	private void goBack() {
		if (popup != null) {
			popup.dispose();
		}
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

	