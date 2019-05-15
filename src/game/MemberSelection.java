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
	 * Create the frame and the user picks which crew member to perform an action.
	 * 
	 * @param game			The game environment in which is being played.
	 * @return				The crew member that gets selected.
	 */
	public CrewMember getCrewMember(GameEnvironment game) {
		MemberSelection frame = new MemberSelection(game);
		frame.setVisible(true);
		return crewMember;
	}
	/**
	 * The constructor for the class.
	 * 
	 * @param game			The game environment in which is being played.
	 */
	public MemberSelection(GameEnvironment game) {
		this.game = game;
		initialize();
		frame.setVisible(true);
	}
	/**
	 * The Window initializer.
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Space Explorer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 703, 564);
		frame.getContentPane().setLayout(null);
		
		
		CrewMember member1 = game.getCrew1().getCrewMemberList().get(0);
		
		JButton btnconfirm = new JButton("Confirm");
		btnconfirm.setEnabled(false);
		JToggleButton member1Button = new JToggleButton(member1.getName());
		JToggleButton member2Button = new JToggleButton("");
		JToggleButton member3Button = new JToggleButton("");
		JToggleButton member4Button = new JToggleButton("");
		
		JLabel member1Label = new JLabel("");
		member1Label.setForeground(Color.BLACK);
		member1Label.setBackground(Color.WHITE);
		member1Label.setFont(new Font("Dialog", Font.PLAIN, 15));
		member1Label.setBounds(21, 140, 158, 142);
		frame.getContentPane().add(member1Label);
		member1Label.setText(game.convertToMultiline(member1.viewStatus()));
		member1Button.setBounds(21, 338, 147, 58);
		frame.getContentPane().add(member1Button);
		member1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!member1Button.isSelected()) {
					btnconfirm.setEnabled(false);
				}else {
					member2Button.setSelected(false);
					member3Button.setSelected(false);
					member4Button.setSelected(false);
					btnconfirm.setEnabled(true);
					game.setPickedMember(member1);
				}
			}
		});
		
		JLabel member2Label = new JLabel("");
		member2Label.setFont(new Font("Dialog", Font.PLAIN, 15));
		member2Label.setBounds(188, 140, 155, 142);
		frame.getContentPane().add(member2Label);
		if (game.getCrew1().getCrewMemberList().size() >= 2) {
			CrewMember member2 = game.getCrew1().getCrewMemberList().get(1);
			member2Label.setText(game.convertToMultiline(member2.viewStatus()));
			member2Button.setText(member2.getName());
			member2Button.setVisible(true);
			member2Button.setBounds(188, 338, 147, 58);
			frame.getContentPane().add(member2Button);
			member2Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!member2Button.isSelected()) {
						btnconfirm.setEnabled(false);
					}else {
						member1Button.setSelected(false);
						member3Button.setSelected(false);
						member4Button.setSelected(false);
						btnconfirm.setEnabled(true);
						game.setPickedMember(member2);
					}
				}
			});
		}
		
		JLabel member3Label = new JLabel("");
		member3Label.setBackground(Color.WHITE);
		member3Label.setFont(new Font("Dialog", Font.PLAIN, 15));
		member3Label.setBounds(353, 140, 155, 142);
		frame.getContentPane().add(member3Label);
		if (game.getCrew1().getCrewMemberList().size() >= 3) {
			CrewMember member3 = game.getCrew1().getCrewMemberList().get(2);
			member3Label.setText(game.convertToMultiline(member3.viewStatus()));
			member3Button.setText(member3.getName());
			member3Button.setVisible(true);
			member3Button.setBounds(353, 338, 147, 58);
			frame.getContentPane().add(member3Button);
			member3Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!member3Button.isSelected()) {
						btnconfirm.setEnabled(false);
					}else {
						member1Button.setSelected(false);
						member2Button.setSelected(false);
						member4Button.setSelected(false);
						btnconfirm.setEnabled(true);
						game.setPickedMember(member3);
				}
			}
			});
		}
		
		JLabel member4Label = new JLabel("");
		member4Label.setForeground(Color.BLACK);
		member4Label.setBackground(Color.WHITE);
		member4Label.setFont(new Font("Dialog", Font.PLAIN, 15));
		member4Label.setBounds(500, 140, 158, 142);
		frame.getContentPane().add(member4Label);
		if (game.getCrew1().getCrewMemberList().size() >= 4) {
			CrewMember member4 = game.getCrew1().getCrewMemberList().get(3);
			member4Label.setText(game.convertToMultiline(member4.viewStatus()));
			member4Button.setText(member4.getName());
			member4Button.setVisible(true);
			member4Button.setBounds(510, 338, 147, 58);
			frame.getContentPane().add(member4Button);
			member4Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!member4Button.isSelected()) {
						btnconfirm.setEnabled(false);
					}else {
						member1Button.setSelected(false);
						member2Button.setSelected(false);
						member3Button.setSelected(false);
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
	/**
	 * Launches the pilot window.
	 */
	private void goPilotWindow() {
		game.closeMemberSelection(this);
		game.launchFlyToNewPlanetWindow();
		
	}
	/**
	 * Launches the game over window.
	 */
	private void goGameOverWindow() {
		game.closeMemberSelection(this);
		game.launchGameOverWindow();
		
	}
	/**
	 * Launches the eat window.
	 */
	private void goEatWindow(CrewMember member) {
		game.closeMemberSelection(this);
		game.launchEatWindow(member);
	}
	/**
	 * Launches the heal window.
	 */
	private void goHealWindow(CrewMember member) {
		game.closeMemberSelection(this);
		game.launchHealWindow(member);
	}
	/**
	 * Launches the search window.
	 */
	private void goSearchWindow() {
		game.closeMemberSelection(this);
		game.launchSearchWindow(); 
	}
	/**
	 * Closes the window and opens the main window.
	 */
	private void goBack() {
		game.closeMemberSelection(this);
		game.launchMainScreen();
	}
	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frame.dispose();
	}
}
