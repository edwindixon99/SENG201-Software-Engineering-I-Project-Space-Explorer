package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class ItemsForSale extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemsForSale frame = new ItemsForSale();
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
	public ItemsForSale(GameEnvironment game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JButton button_1 = new JButton("1");
		button_1.setBounds(46, 91, 179, 135);
		getContentPane().add(button_1);
		
		JButton button_5 = new JButton("1");
		button_5.setBounds(546, 91, 179, 135);
		getContentPane().add(button_5);
		
		JButton button_7 = new JButton("1");
		button_7.setBounds(546, 250, 179, 135);
		getContentPane().add(button_7);
		
		JButton button_8 = new JButton("1");
		button_8.setBounds(546, 415, 179, 135);
		getContentPane().add(button_8);
		
		JButton button = new JButton("1");
		button.setBounds(298, 250, 179, 135);
		getContentPane().add(button);
		
		JButton button_2 = new JButton("1");
		button_2.setBounds(298, 91, 179, 135);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("1");
		button_3.setBounds(298, 415, 179, 135);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("1");
		button_4.setBounds(46, 250, 179, 135);
		getContentPane().add(button_4);
		
		JButton button_6 = new JButton("1");
		button_6.setBounds(46, 415, 179, 135);
		getContentPane().add(button_6);
		
		JLabel lblNewLabel = new JLabel("Pick an item that you want to buy. You have $ " + game.getCrew1().getMoney() + " to spend");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(46, 11, 613, 64);
		getContentPane().add(lblNewLabel);
		
		JButton btnExitOutpostStore = new JButton("Exit Outpost Store");
		btnExitOutpostStore.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExitOutpostStore.setBounds(546, 11, 211, 64);
		getContentPane().add(btnExitOutpostStore);

	}

}


	if (num == 7) {
			MedicalItem med = new MedicalItem("SmallHealing", false, 10, 5);
			crew1.buy(foodList, medicalList, med);
		}
		if (num == 8) {
			MedicalItem med = new MedicalItem("Big Healing", false, 40, 20);
			crew1.buy(foodList, medicalList, med);
		}
		if (num == 9) {
			MedicalItem med = new MedicalItem("Space plague cure", true, 0, 15);
			crew1.buy(foodList, medicalList, med);
		}
		if (num == 6) {
			Food food = new Food("Biscut", 10, 5);
			crew1.buy(foodList, medicalList, food);
		}
		if (num == 1) {
			Food food = new Food("Apple", 15, 7);
			crew1.buy(foodList, medicalList, food);

		}
		if (num == 2) {
			Food food = new Food("Sandwich", 25, 12);
			crew1.buy(foodList, medicalList, food);
		}
		if (num == 3) {
			Food food = new Food("Pie", 30, 15);
			crew1.buy(foodList, medicalList, food);
		}
		if (num == 4) {
			Food food = new Food("Burger", 40, 20);
			crew1.buy(foodList, medicalList, food);
		}
		if (num == 5) {
			Food food = new Food("Pizza", 50, 25);
			crew1.buy(foodList, medicalList, food);
