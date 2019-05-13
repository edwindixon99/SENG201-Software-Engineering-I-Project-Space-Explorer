package game;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberSelection extends JFrame {
	public MemberSelection() {
	}

	private JPanel contentPane;
	private CrewMember crewMember;
	private GameEnvironment game;
	private JFrame frame;;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEnvironment game = new GameEnvironment();
					MemberSelection window = new MemberSelection(game);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the 
	 */
	public CrewMember getCrewMember(GameEnvironment game) {
		MemberSelection frame = new MemberSelection(game);
		frame.setVisible(true);
		return crewMember;
	}
	public MemberSelection(GameEnvironment game) {
		this.game = game;
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 703, 564);
		frame.getContentPane().setLayout(null);
		
		
		CrewMember member1 = game.getCrew1().getCrewMemberList().get(0);
		
		JButton btnconfirm = new JButton("Confirm");
		btnconfirm.setEnabled(false);
		JToggleButton btnNewButton = new JToggleButton(member1.getName());
		JToggleButton btnMember20 = new JToggleButton("");
		JToggleButton btnMember_1 = new JToggleButton("");
		JToggleButton btnMember_2 = new JToggleButton("");
		
		JLabel label = new JLabel("");
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		label.setBounds(21, 140, 158, 142);
		frame.getContentPane().add(label);
		label.setText(game.convertToMultiline(member1.viewStatus()));
		btnNewButton.setBounds(21, 338, 147, 58);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!btnNewButton.isSelected()) {
					btnconfirm.setEnabled(false);
				}else {
					btnMember20.setSelected(false);
					btnMember_1.setSelected(false);
					btnMember_2.setSelected(false);
					btnconfirm.setEnabled(true);
					game.setPickedMember(member1);
				}
			}
		});
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_1.setBounds(188, 140, 155, 142);
		frame.getContentPane().add(label_1);
		if (game.getCrew1().getCrewMemberList().size() >= 2) {
			CrewMember member2 = game.getCrew1().getCrewMemberList().get(1);
			label_1.setText(game.convertToMultiline(member2.viewStatus()));
			btnMember20.setText(member2.getName());
			btnMember20.setVisible(true);
			btnMember20.setBounds(188, 338, 147, 58);
			frame.getContentPane().add(btnMember20);
			btnMember20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!btnMember20.isSelected()) {
						btnconfirm.setEnabled(false);
					}else {
						btnNewButton.setSelected(false);
						btnMember_1.setSelected(false);
						btnMember_2.setSelected(false);
						btnconfirm.setEnabled(true);
						game.setPickedMember(member2);
					}
				}
			});
		}
		
		JLabel label_2 = new JLabel("");
		label_2.setBackground(Color.WHITE);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_2.setBounds(353, 140, 155, 142);
		frame.getContentPane().add(label_2);
		if (game.getCrew1().getCrewMemberList().size() >= 3) {
			CrewMember member3 = game.getCrew1().getCrewMemberList().get(2);
			label_2.setText(game.convertToMultiline(member3.viewStatus()));
			btnMember_1.setText(member3.getName());
			btnMember_1.setVisible(true);
			btnMember_1.setBounds(353, 338, 147, 58);
			frame.getContentPane().add(btnMember_1);
			btnMember_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!btnMember_1.isSelected()) {
						btnconfirm.setEnabled(false);
					}else {
						btnNewButton.setSelected(false);
						btnMember20.setSelected(false);
						btnMember_2.setSelected(false);
						btnconfirm.setEnabled(true);
						game.setPickedMember(member3);
				}
			}
			});
		}
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(Color.BLACK);
		label_3.setBackground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_3.setBounds(500, 140, 158, 142);
		frame.getContentPane().add(label_3);
		if (game.getCrew1().getCrewMemberList().size() >= 4) {
			CrewMember member4 = game.getCrew1().getCrewMemberList().get(3);
			label_3.setText(game.convertToMultiline(member4.viewStatus()));
			btnMember_2.setText(member4.getName());
			btnMember_2.setVisible(true);
			btnMember_2.setBounds(510, 338, 147, 58);
			frame.getContentPane().add(btnMember_2);
			btnMember_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!btnMember_2.isSelected()) {
						btnconfirm.setEnabled(false);
					}else {
						btnNewButton.setSelected(false);
						btnMember20.setSelected(false);
						btnMember_1.setSelected(false);
						btnconfirm.setEnabled(true);
						game.setPickedMember(member4);
				}
			}
			});
		}

			
			
		JLabel lblPickACrew = new JLabel("Pick a Crew Member to do this action");
		lblPickACrew.setBounds(80, 11, 503, 86);
		frame.getContentPane().add(lblPickACrew);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goBack();
			}
		});
		btnGoBack.setBounds(456, 445, 190, 69);
		frame.getContentPane().add(btnGoBack);
		
		
		btnconfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (game.getActTaken() == "search") {
					String message = game.searchPlanet(game.getPickedMember());
					game.setMessage(message);
					goSearchWindow();
				}
				if(game.getActTaken() == "Repairship") {
					String message = game.repairShip(game.getPickedMember());
					game.setMessage(message);
					goSearchWindow(); 			// The two windows are same dimensions same layout only difference is the message.
				}
				if(game.getActTaken() == "Pilot") {
					String message = game.flyToNewPlanet(game.getPickedMember());
					if (message == "Fail") {
						message = ("The shield of your ship has depleted, and everyone on the crew has died!");
						
					}
					else {
						game.setMessage(message);
						goPilotWindow();
					}
					
				}
				if(game.getActTaken() == "Eat") {
					String message = game.eat(game.getPickedMember());
					game.setMessage(message);
					if (game.getMessage() == "") {
						goEatWindow(game.getPickedMember());
					}
					else {
						goSearchWindow();
					}
					
				}
				if(game.getActTaken() == "Sleep") {
					String message = game.sleep(game.getPickedMember());
					game.setMessage(message);
					goSearchWindow();
				}
				if(game.getActTaken() == "Heal") {
					String message = game.heal(game.getPickedMember());
					game.setMessage(message);
					if (game.getMessage() == "") {
						goHealWindow(game.getPickedMember());
					}
					else {
						goSearchWindow();
					}
					
				}
			}


		});
		btnconfirm.setBounds(20, 445, 190, 69);
		frame.getContentPane().add(btnconfirm);
	}
	private void goPilotWindow() {
		game.closeMemberSelection(this);
		game.launchFlyToNewPlanetWindow();
		
	}
	private void goGameOverWindow() {
		game.closeMemberSelection(this);
		game.launchGameOverWindow();
		
	}
	private void goEatWindow(CrewMember member) {
		game.closeMemberSelection(this);
		game.launchEatWindow(member);
	}
	private void goHealWindow(CrewMember member) {
		game.closeMemberSelection(this);
		game.launchHealWindow(member);
	}
	private void goSearchWindow() {
		game.closeMemberSelection(this);
		game.launchSearchWindow(); 
	}
	private void goBack() {
		game.closeMemberSelection(this);
		game.launchMainScreen();
	}

	public void closeWindow() {
		frame.dispose();
	}
}
