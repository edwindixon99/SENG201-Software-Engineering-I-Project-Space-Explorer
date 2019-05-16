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
/**
 * This window displays all the items the space outpost has for sale. The user can use buttons to buy items.
 *
 * @author Jerome Grubb, Edwin Dixon
 * @version 16/05/19
 */
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
	 * 
	 * @param game			The game environment in which is being played.
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
		JButton appleButton = new JButton("Buy " + apple.getName());
		appleButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		appleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, apple));
				itemBought();
			}
		});
		appleButton.setBounds(46, 182, 179, 44);
		getContentPane().add(appleButton);
		
		Food sandwich = new Food("Sandwich", 25, 12);
		JButton sandwichButton = new JButton("Buy " + sandwich.getName());
		sandwichButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		sandwichButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, sandwich));
				itemBought();
			}
		});
		sandwichButton.setBounds(546, 182, 179, 44);
		getContentPane().add(sandwichButton);
		
		Food biscuit = new Food("Biscut", 10, 5);
		JButton biscuitButton = new JButton("Buy " + biscuit.getName());
		biscuitButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		biscuitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, biscuit));
				itemBought();
			}
		});
		biscuitButton.setBounds(546, 341, 179, 44);
		getContentPane().add(biscuitButton);
		
		Food pie = new Food("Pie", 30, 15);
		JButton pieButton = new JButton("Buy " + pie.getName());
		pieButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		pieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, pie));
				itemBought();
			}
		});
		pieButton.setBounds(298, 341, 179, 44);
		getContentPane().add(pieButton);
		
		MedicalItem spacePlagueCure = new MedicalItem("Space plague cure", true, 0, 15);
		JButton spacePlagueCureButton = new JButton("Buy " + spacePlagueCure.getName());
		spacePlagueCureButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		spacePlagueCureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, spacePlagueCure));
				itemBought();
			}
		});
		spacePlagueCureButton.setBounds(546, 506, 179, 44);
		getContentPane().add(spacePlagueCureButton);
		
		Food burger = new Food("Burger", 40, 20);
		JButton burgerButton = new JButton("Buy " + burger.getName());
		burgerButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		burgerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, burger));
				itemBought();
			}
		});
		burgerButton.setBounds(298, 182, 179, 44);
		getContentPane().add(burgerButton);
		
		MedicalItem bigHealing = new MedicalItem("Big Healing", false, 40, 20);
		JButton bigHealingButton = new JButton("Buy " + bigHealing.getName());
		bigHealingButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		bigHealingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, bigHealing));
				itemBought();
			}
		});
		bigHealingButton.setBounds(298, 506, 179, 44);
		getContentPane().add(bigHealingButton);
		
		MedicalItem smallHealing = new MedicalItem("SmallHealing", false, 10, 5);
		JButton smallHealingButton = new JButton("Buy " + smallHealing.getName());
		smallHealingButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		smallHealingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, smallHealing));
				itemBought();
			}
		});
		smallHealingButton.setBounds(46, 506, 179, 44);
		getContentPane().add(smallHealingButton);
		
		Food pizza = new Food("Pizza", 50, 25);
		JButton pizzaButton = new JButton("Buy " + pizza.getName());
		pizzaButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		pizzaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setMessage(game.getCrew1().buy(foodList, medicalList, pizza));
				itemBought();
			}
		});
		pizzaButton.setBounds(46, 341, 179, 44);
		getContentPane().add(pizzaButton);
		
		JLabel label = new JLabel(game.convertToMultiline("Pick an item that you want to buy. You have $ " + game.getCrew1().getMoney() + " to spend.\nYou can find money by searching planets."));
		label.setFont(new Font("Dialog", Font.PLAIN, 17));
		label.setBounds(10, -9, 649, 104);
		getContentPane().add(label);
		
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
		
		JLabel shealinglabel = new JLabel(game.convertToMultiline(smallHealing.toString()));
		shealinglabel.setBounds(46, 396, 179, 93);
		getContentPane().add(shealinglabel);
		
		JLabel bhealinglabel = new JLabel(game.convertToMultiline(bigHealing.toString()));
		bhealinglabel.setBounds(298, 396, 179, 93);
		getContentPane().add(bhealinglabel);
		
		JLabel spclabel = new JLabel(game.convertToMultiline(spacePlagueCure.toString()));
		spclabel.setBounds(546, 396, 179, 93);
		getContentPane().add(spclabel);

	}
	/**
	 * Closes window and opens space outpost window.
	 */
	private void goBack() {
		if (popup != null) {
			popup.dispose();
		}
		closeWindow();
		game.launchSpaceOutpost();
		
		
	}
	/**
	 * Launches a popup confirming or denying purchase.
	 */
	private void itemBought() {
		if (popup == null) {
			popup = new SalePopup(game, this);
		}
		popup.dispose();
		popup = new SalePopup(game, this);
		popup.setVisible(true);
		popup.setDefaultCloseOperation(popup.DISPOSE_ON_CLOSE);
		
	}
	/**
	 * Closes window.
	 */
	public void closeWindow() {
		dispose();
	}

}


	