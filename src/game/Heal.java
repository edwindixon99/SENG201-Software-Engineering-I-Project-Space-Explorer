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

public class Heal extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEnvironment game = new GameEnvironment();
					CrewMember member = new CrewMember();
					Heal frame = new Heal(game, member);
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
	public Heal(GameEnvironment game, CrewMember member) {
		Set<String> healSet = new LinkedHashSet<>();
		ArrayList<MedicalItem> healArray = new ArrayList<>();
		ArrayList<String> stringHealArray = new ArrayList<>();
		for (MedicalItem healList1: game.getCrew1().getMedicalItems()) {
			if (healSet.contains(healList1.getName())) {}
			else {
				healArray.add(healList1);
			}
			healSet.add(healList1.getName());
			stringHealArray.add(healList1.getName());
		}
		getContentPane().setLayout(null);
		JButton button = new JButton((String) null);
		button.setBounds(10, 101, 292, 45);
		getContentPane().add(button);
		button.setVisible(false);
		if (healArray.size() >= 1) {
			button.setVisible(true);
			button.setText(healArray.get(0).getName() + ("(" + (Collections.frequency(stringHealArray, healArray.get(0).getName())) + ")"));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.healMethod(member, healArray.get(0), 0);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		JButton button_1 = new JButton((String) null);
		button_1.setBounds(10, 176, 292, 45);
		getContentPane().add(button_1);
		button_1.setVisible(false);
		if (healArray.size() >= 2) {
			button_1.setVisible(true);
			button_1.setText(healArray.get(1).getName() + ("(" + (Collections.frequency(stringHealArray, healArray.get(1).getName())) + ")"));
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.healMethod(member, healArray.get(1), 1);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		JButton button_2 = new JButton((String) null);
		button_2.setBounds(10, 244, 292, 45);
		getContentPane().add(button_2);
		button_2.setVisible(false);
		if (healArray.size() >= 3) {
			button_2.setVisible(true);
			button_2.setText(healArray.get(2).getName() + ("(" + (Collections.frequency(stringHealArray, healArray.get(2).getName())) + ")"));
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.healMethod(member, healArray.get(2), 2);
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
		
		JLabel lblNewLabel = new JLabel("Pick what healing item you wnat to use");
		lblNewLabel.setBounds(10, 11, 212, 61);
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
		game.closeHeal(this);
		game.launchMainScreen(); 
	}
	private void goSearchWindow() {
		game.closeHeal(this);
		game.launchSearchWindow(); 
	}
}
