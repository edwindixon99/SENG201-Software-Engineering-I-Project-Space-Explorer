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
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.awt.event.ActionEvent;

public class Eat extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEnvironment game = new GameEnvironment();
					CrewMember member = new CrewMember();
					Eat frame = new Eat(game, member);
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
	public Eat(GameEnvironment game, CrewMember member) {
		Set<String> foodSet = new LinkedHashSet<>();
		ArrayList<Food> foodArray = new ArrayList<>();
		ArrayList<String> stringFoodArray = new ArrayList<>();
		for (Food foodList1: game.getCrew1().getFoodItems()) {
			if (foodSet.contains(foodList1.getName())) {}
			else {
				foodArray.add(foodList1);
			}
			foodSet.add(foodList1.getName());
			stringFoodArray.add(foodList1.getName());
		}
		getContentPane().setLayout(null);
		JButton button = new JButton((String) null);
		button.setBounds(10, 101, 176, 45);
		getContentPane().add(button);
		button.setVisible(false);
		if (foodArray.size() >= 1) {
			button.setVisible(true);
			button.setText(foodArray.get(0).getName() + ("(" + (Collections.frequency(stringFoodArray, foodArray.get(0).getName())) + ")"));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.eat_food(member, foodArray.get(0), 0);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		JButton button_1 = new JButton((String) null);
		button_1.setBounds(10, 176, 176, 45);
		getContentPane().add(button_1);
		button_1.setVisible(false);
		if (foodArray.size() >= 2) {
			button_1.setVisible(true);
			button_1.setText(foodArray.get(1).getName() + ("(" + (Collections.frequency(stringFoodArray, foodArray.get(1).getName())) + ")"));
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.eat_food(member, foodArray.get(1), 1);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		JButton button_2 = new JButton((String) null);
		button_2.setBounds(10, 244, 176, 45);
		getContentPane().add(button_2);
		button_2.setVisible(false);
		if (foodArray.size() >= 3) {
			button_2.setVisible(true);
			button_2.setText(foodArray.get(2).getName() + ("(" + (Collections.frequency(stringFoodArray, foodArray.get(2).getName())) + ")"));
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.eat_food(member, foodArray.get(2), 2);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		
		JButton button_3 = new JButton((String) null);
		button_3.setBounds(10, 310, 176, 45);
		getContentPane().add(button_3);
		button_3.setVisible(false);
		if (foodArray.size() >= 4) {
			button_3.setVisible(true);
			button_3.setText(foodArray.get(3).getName() + ("(" + (Collections.frequency(stringFoodArray, foodArray.get(3).getName())) + ")"));
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.eat_food(member, foodArray.get(3), 3);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		JButton button_4 = new JButton((String) null);
		button_4.setBounds(10, 373, 176, 45);
		getContentPane().add(button_4);
		button_4.setVisible(false);
		if (foodArray.size() >= 5) {
			button_4.setVisible(true);
			button_4.setText(foodArray.get(4).getName() + ("(" + (Collections.frequency(stringFoodArray, foodArray.get(4).getName())) + ")"));
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.eat_food(member, foodArray.get(4), 4);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		JButton button_5 = new JButton((String) null);
		button_5.setBounds(10, 438, 176, 45);
		getContentPane().add(button_5);
		button_5.setVisible(false);
		if (foodArray.size() >= 6) {
			button_5.setVisible(true);
			button_5.setText(foodArray.get(5).getName() + ("(" + (Collections.frequency(stringFoodArray, foodArray.get(5).getName())) + ")"));
			button_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.eat_food(member, foodArray.get(5), 5);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		
		this.game = game;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 664);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pick what food item you want to eat");
		lblNewLabel.setBounds(10, 11, 176, 61);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.setBounds(10, 494, 176, 45);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});

		
	}

	
	public void closeWindow() {
		dispose();
	}
	private void goBack() {
		game.closeEat(this);
		game.launchMainScreen(); 
	}
	private void goSearchWindow() {
		game.closeEat(this);
		game.launchSearchWindow(); 
	}
}
