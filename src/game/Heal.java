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
	 * 
	 * @param game			The game environment in which is being played.
	 * @param member				The member that is getting healed.
	 */
	public Heal(GameEnvironment game, CrewMember member) {
		setTitle("Space Explorer");
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
		JButton buttonMedicalItem1 = new JButton((String) null);
		buttonMedicalItem1.setBounds(10, 101, 292, 45);
		getContentPane().add(buttonMedicalItem1);
		buttonMedicalItem1.setVisible(false);
		if (healArray.size() >= 1) {
			buttonMedicalItem1.setVisible(true);
			buttonMedicalItem1.setText(healArray.get(0).getName() + ("(" + (Collections.frequency(stringHealArray, healArray.get(0).getName())) + ")"));
			buttonMedicalItem1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.healMethod(member, healArray.get(0), 0);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		JButton buttonMedicalItem2 = new JButton((String) null);
		buttonMedicalItem2.setBounds(10, 176, 292, 45);
		getContentPane().add(buttonMedicalItem2);
		buttonMedicalItem2.setVisible(false);
		if (healArray.size() >= 2) {
			buttonMedicalItem2.setVisible(true);
			buttonMedicalItem2.setText(healArray.get(1).getName() + ("(" + (Collections.frequency(stringHealArray, healArray.get(1).getName())) + ")"));
			buttonMedicalItem2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.healMethod(member, healArray.get(1), 1);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
		JButton buttonMedicalItem3 = new JButton((String) null);
		buttonMedicalItem3.setBounds(10, 244, 292, 45);
		getContentPane().add(buttonMedicalItem3);
		buttonMedicalItem3.setVisible(false);
		if (healArray.size() >= 3) {
			buttonMedicalItem3.setVisible(true);
			buttonMedicalItem3.setText(healArray.get(2).getName() + ("(" + (Collections.frequency(stringHealArray, healArray.get(2).getName())) + ")"));
			buttonMedicalItem3.addActionListener(new ActionListener() {
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
		
		JLabel titleLabel = new JLabel("Pick what healing item you wnat to use");
		titleLabel.setBounds(10, 11, 212, 61);
		getContentPane().add(titleLabel);
		
		JButton goBackButton = new JButton("Go Back");
		goBackButton.setBounds(10, 494, 176, 45);
		getContentPane().add(goBackButton);
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});

		
	}

	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		dispose();
	}
	/**
	 * Closes the window and opens the main window.
	 */
	private void goBack() {
		game.closeHeal(this);
		game.launchMainScreen(); 
	}
	/**
	 * Closes the window and opens a new window.
	 */
	private void goSearchWindow() {
		game.closeHeal(this);
		game.launchSearchWindow(); 
	}
}
