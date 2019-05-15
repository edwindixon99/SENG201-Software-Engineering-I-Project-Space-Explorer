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
	 * 
	 * @param game			The game environment in which is being played.
	 * @param member		The member who eats.
	 */
	public Eat(GameEnvironment game, CrewMember member) {
		setTitle("Space Explorer");
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
		JButton buttonFood1 = new JButton((String) null);
		buttonFood1.setBounds(10, 101, 176, 45);
		getContentPane().add(buttonFood1);
		buttonFood1.setVisible(false);
		if (foodArray.size() >= 1) {
			buttonFood1.setVisible(true);
			buttonFood1.setText(foodArray.get(0).getName() + ("(" + (Collections.frequency(stringFoodArray, foodArray.get(0).getName())) + ")"));
			buttonFood1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.eat_food(member, foodArray.get(0), 0);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		JButton buttonFood2 = new JButton((String) null);
		buttonFood2.setBounds(10, 176, 176, 45);
		getContentPane().add(buttonFood2);
		buttonFood2.setVisible(false);
		if (foodArray.size() >= 2) {
			buttonFood2.setVisible(true);
			buttonFood2.setText(foodArray.get(1).getName() + ("(" + (Collections.frequency(stringFoodArray, foodArray.get(1).getName())) + ")"));
			buttonFood2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.eat_food(member, foodArray.get(1), 1);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		JButton buttonFood3 = new JButton((String) null);
		buttonFood3.setBounds(10, 244, 176, 45);
		getContentPane().add(buttonFood3);
		buttonFood3.setVisible(false);
		if (foodArray.size() >= 3) {
			buttonFood3.setVisible(true);
			buttonFood3.setText(foodArray.get(2).getName() + ("(" + (Collections.frequency(stringFoodArray, foodArray.get(2).getName())) + ")"));
			buttonFood3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.eat_food(member, foodArray.get(2), 2);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		
		JButton buttonFood4 = new JButton((String) null);
		buttonFood4.setBounds(10, 310, 176, 45);
		getContentPane().add(buttonFood4);
		buttonFood4.setVisible(false);
		if (foodArray.size() >= 4) {
			buttonFood4.setVisible(true);
			buttonFood4.setText(foodArray.get(3).getName() + ("(" + (Collections.frequency(stringFoodArray, foodArray.get(3).getName())) + ")"));
			buttonFood4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.eat_food(member, foodArray.get(3), 3);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		JButton buttonFood5 = new JButton((String) null);
		buttonFood5.setBounds(10, 373, 176, 45);
		getContentPane().add(buttonFood5);
		buttonFood5.setVisible(false);
		if (foodArray.size() >= 5) {
			buttonFood5.setVisible(true);
			buttonFood5.setText(foodArray.get(4).getName() + ("(" + (Collections.frequency(stringFoodArray, foodArray.get(4).getName())) + ")"));
			buttonFood5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.eat_food(member, foodArray.get(4), 4);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		JButton buttonFood6 = new JButton((String) null);
		buttonFood6.setBounds(10, 438, 176, 45);
		getContentPane().add(buttonFood6);
		buttonFood6.setVisible(false);
		if (foodArray.size() >= 6) {
			buttonFood6.setVisible(true);
			buttonFood6.setText(foodArray.get(5).getName() + ("(" + (Collections.frequency(stringFoodArray, foodArray.get(5).getName())) + ")"));
			buttonFood6.addActionListener(new ActionListener() {
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
		
		JLabel titleLabel = new JLabel("Pick what food item you want to eat");
		titleLabel.setBounds(10, 11, 176, 61);
		getContentPane().add(titleLabel);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.setBounds(10, 494, 176, 45);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});

		
	}

	/**
	 * Closes window.
	 */
	public void closeWindow() {
		dispose();
	}
	/**
	 * Closes this window and opens main window.
	 */
	private void goBack() {
		game.closeEat(this);
		game.launchMainScreen(); 
	}
	/**
	 * Closes this window and opens new window.
	 */
	private void goSearchWindow() {
		game.closeEat(this);
		game.launchSearchWindow(); 
	}
}
