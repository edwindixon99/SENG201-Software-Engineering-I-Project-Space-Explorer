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
		for (MedicalItem healList1: game.getCrew1().getMedicalItems()) {
			healSet.add(healList1.getName());
		}
		ArrayList healArray = new ArrayList<>(healSet);
		String string0 = heal_string(game, game.getCrew1().getMedicalItems().get(0));
		getContentPane().setLayout(null);
		JButton button = new JButton((String) null);
		button.setBounds(10, 101, 176, 45);
		getContentPane().add(button);
		button.setVisible(false);
		if (healSet.size() >= 1) {
			button.setVisible(true);
			button.setText(healArray.get(0) + string0);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.healMethod(member, game.getCrew1().getMedicalItems().get(0), 0);
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
		if (healSet.size() >= 2) {
			String string1 = heal_string(game, game.getCrew1().getMedicalItems().get(1));
			button_1.setVisible(true);
			button_1.setText(healArray.get(1) + string1);
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.healMethod(member, game.getCrew1().getMedicalItems().get(1), 1);
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
		if (healSet.size() >= 3) {
			String string2 = heal_string(game, game.getCrew1().getMedicalItems().get(2));
			button_2.setVisible(true);
			button_2.setText(healArray.get(2) + string2);
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String message = game.healMethod(member, game.getCrew1().getMedicalItems().get(2), 2);
					game.setMessage(message);
					dispose();
					goSearchWindow();
				}
			});
		}
				
		this.game = game;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 505);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pick what healing item you want to use");
		lblNewLabel.setBounds(10, 11, 221, 61);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.setBounds(10, 314, 176, 45);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
		

		
	}
	public String heal_string(GameEnvironment game, MedicalItem med) {
			ArrayList<String> stringHealList2;
			ArrayList<MedicalItem> finalHealList;
			ArrayList<String> finalHealList2;
			stringHealList2 = new ArrayList<String>();
			finalHealList = new ArrayList<MedicalItem>();
			finalHealList2 = new ArrayList<String>();
			for (MedicalItem med1: game.getCrew1().getMedicalItems()) {
				stringHealList2.add(med1.getName());
			}
			Set<MedicalItem> s = new LinkedHashSet<>(game.getCrew1().getMedicalItems());
			for (MedicalItem set: s) {
				if (finalHealList2.contains(set.getName())) {}
				else {
					finalHealList.add(set);
					finalHealList2.add(set.getName());
				}
			}
			return ("(" + (Collections.frequency(stringHealList2, med.getName())) + ")");
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
