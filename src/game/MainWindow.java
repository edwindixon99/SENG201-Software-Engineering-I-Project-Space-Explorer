package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

/**
 * This is the main window containing buttons to each action. This window acts as the center of the whole game.
 *
 * @author Jerome Grubb, Edwin Dixon
 * @version 16/05/19
 */
public class MainWindow {
	private JFrame frame;
	private GameEnvironment game;
	private NextDayPopup popup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEnvironment game = new GameEnvironment();
					MainWindow window = new MainWindow(game);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param gameEnvironment			The game environment in which is being played.
	 */

	public MainWindow(GameEnvironment gameEnvironment) { 
	game = gameEnvironment;
	initialize();
	frame.setVisible(true);
	}
	/**
	 * Closes window.
	 */
	public void closeWindow() {
		frame.dispose();
	}
	/**
	 * Closes window.
	 */
	public void finishedWindow() {
		game.closeMainScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Space Explorer");
		frame.setBounds(100, 100, 703, 564);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWhatDoYou = new JLabel("What would you like your crew member(s) to do?");
		lblWhatDoYou.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblWhatDoYou.setBounds(10, 11, 411, 27);
		frame.getContentPane().add(lblWhatDoYou);
		
		JButton btnEat = new JButton("Eat");
		btnEat.setFont(new Font("Dialog", Font.BOLD, 15));
		btnEat.setBounds(224, 49, 177, 35);
		frame.getContentPane().add(btnEat);
		btnEat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.setActTaken("Eat");
				chooseMember();
			}
		});
		
		JButton btnHeal = new JButton("Heal");
		btnHeal.setFont(new Font("Dialog", Font.BOLD, 15));
		btnHeal.setBounds(20, 49, 177, 35);
		frame.getContentPane().add(btnHeal);
		btnHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.setActTaken("Heal");
				chooseMember();
			}
		});
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.setFont(new Font("Dialog", Font.BOLD, 15));
		btnSleep.setBounds(433, 49, 177, 35);
		frame.getContentPane().add(btnSleep);
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setActTaken("Sleep");
				chooseMember();
			}
		});
		
		JButton SearchPlanetbtn = new JButton("Search Planet");
		SearchPlanetbtn.setFont(new Font("Dialog", Font.BOLD, 15));
		SearchPlanetbtn.setBounds(433, 95, 177, 35);
		frame.getContentPane().add(SearchPlanetbtn);
		SearchPlanetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.setActTaken("search");
				chooseMember();
			}
		});
		
		JButton btnPilotShip = new JButton("Pilot ship");
		btnPilotShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.setActTaken("Pilot");
				chooseMember();
			}
		});
		btnPilotShip.setFont(new Font("Dialog", Font.BOLD, 15));
		btnPilotShip.setBounds(224, 95, 177, 35);
		frame.getContentPane().add(btnPilotShip);
		
		JButton btnVisitOutpost = new JButton("Visit Outpost");
		btnVisitOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchSpaceOutpost();
			}
		});
		btnVisitOutpost.setFont(new Font("Dialog", Font.BOLD, 15));
		btnVisitOutpost.setBounds(20, 141, 177, 35);
		frame.getContentPane().add(btnVisitOutpost);
		
		JButton btnRepairShip = new JButton("Repair Ship");
		btnRepairShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setActTaken("Repairship");
				chooseMember();
			}
		});
		btnRepairShip.setFont(new Font("Dialog", Font.BOLD, 15));
		btnRepairShip.setBounds(20, 95, 177, 35);
		frame.getContentPane().add(btnRepairShip);

	
		JLabel lblDaysLeft = new JLabel("Day: " + game.getCrew1().getDays());
		lblDaysLeft.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDaysLeft.setBounds(20, 204, 107, 27);
		frame.getContentPane().add(lblDaysLeft);
		
		JLabel lblRemainingPieces = new JLabel("Remaining pieces left to find: " + game.getCrew1().getRequiredPieces());
		lblRemainingPieces.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblRemainingPieces.setBounds(20, 242, 361, 35);
		frame.getContentPane().add(lblRemainingPieces);
		
		JLabel crewMember1Label = new JLabel("");
		crewMember1Label.setForeground(Color.BLACK);
		crewMember1Label.setBackground(Color.WHITE);
		crewMember1Label.setFont(new Font("Dialog", Font.PLAIN, 15));
		crewMember1Label.setBounds(20, 288, 158, 142);
		frame.getContentPane().add(crewMember1Label);
		if (game.getCrew1().getCrewMemberList().size() >= 1) {
			crewMember1Label.setText(game.convertToMultiline(game.getCrew1().getCrewMemberList().get(0).viewStatus()));
		}
		
		JLabel crewMember2Label = new JLabel("");
		crewMember2Label.setFont(new Font("Dialog", Font.PLAIN, 15));
		crewMember2Label.setBounds(188, 288, 155, 142);
		frame.getContentPane().add(crewMember2Label);
		if (game.getCrew1().getCrewMemberList().size() >= 2) {
			crewMember2Label.setText(game.convertToMultiline(game.getCrew1().getCrewMemberList().get(1).viewStatus()));
		}
		
		JLabel crewMember3Label = new JLabel("");
		crewMember3Label.setBackground(Color.WHITE);
		crewMember3Label.setFont(new Font("Dialog", Font.PLAIN, 15));
		crewMember3Label.setBounds(353, 288, 155, 142);
		frame.getContentPane().add(crewMember3Label);
		if (game.getCrew1().getCrewMemberList().size() >= 3) {
			crewMember3Label.setText(game.convertToMultiline(game.getCrew1().getCrewMemberList().get(2).viewStatus()));
		}
		
		JLabel crewMember4Label = new JLabel("");
		crewMember4Label.setForeground(Color.BLACK);
		crewMember4Label.setBackground(Color.WHITE);
		crewMember4Label.setFont(new Font("Dialog", Font.PLAIN, 15));
		crewMember4Label.setBounds(500, 288, 158, 142);
		frame.getContentPane().add(crewMember4Label);
		if (game.getCrew1().getCrewMemberList().size() >= 4) {
			crewMember4Label.setText(game.convertToMultiline(game.getCrew1().getCrewMemberList().get(3).viewStatus()));
		}
		
		JLabel shipStatusLabel = new JLabel(game.convertToMultiline(game.getShip().checkShipShield()));
		shipStatusLabel.setForeground(Color.BLACK);
		shipStatusLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		shipStatusLabel.setBackground(Color.WHITE);
		shipStatusLabel.setBounds(20, 406, 158, 87);
		frame.getContentPane().add(shipStatusLabel);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNextDay.setBounds(433, 458, 177, 35);
		frame.getContentPane().add(btnNextDay);
		
		JLabel lblMoney = new JLabel("Crew Money: $ " + Double.toString(game.getCrew1().getMoney()));
		lblMoney.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMoney.setBounds(433, 11, 244, 27);
		frame.getContentPane().add(lblMoney);
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.setMessage(game.nextDay());
				if(game.isGameIsOver()) {
					game.setDaysProgressedThrough(game.getDaysProgressedThrough()-1);
					goGameOverScreen();
				}else {
					launchNextDayPopup();
				}
			}
		});
	}
	/**
	 * Closes this window and opens the game over window.
	 */
	private void goGameOverScreen() {
		game.closeMainScreen(this);
		game.launchGameOverWindow();
		if (popup != null) {
			popup.dispose();
		}
		
	}
	/**
	 * Closes window and opens the space outpost window.
	 */
	private void launchSpaceOutpost() {
		game.closeMainScreen(this);
		game.launchSpaceOutpost();
		
	}
	/**
	 * Closes this window and opens the crew member selection window.
	 */
	private void chooseMember() {
		game.closeMainScreen(this);
		game.launchMemberSelection();
	}
 	
	/**
	 * opens the next day popup.
	 */
	private void launchNextDayPopup() {
		if (popup == null) {
			popup = new NextDayPopup(game, this);
		}
		popup.dispose();
		popup = new NextDayPopup(game, this);
		popup.setVisible(true);
		popup.setDefaultCloseOperation(popup.DISPOSE_ON_CLOSE);
 	}
}
