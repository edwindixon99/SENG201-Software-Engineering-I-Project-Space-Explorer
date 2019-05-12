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
	 * @return 
	 * @return 
	 * @return 
	 */

	public MainWindow(GameEnvironment gameEnvironment) { 
	game = gameEnvironment;
	initialize();
	frame.setVisible(true);
	}

	public void closeWindow() {
		frame.dispose();
	}

	public void finishedWindow() {
		game.closeMainScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 564);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWhatDoYou = new JLabel("What would you like your crew member(s) to do?");
		lblWhatDoYou.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblWhatDoYou.setBounds(10, 11, 352, 27);
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
		
		JLabel label = new JLabel("");
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		label.setBounds(20, 288, 158, 142);
		frame.getContentPane().add(label);
		if (game.getCrew1().getCrewMemberList().size() >= 1) {
			label.setText(game.convertToMultiline(game.getCrew1().getCrewMemberList().get(0).viewStatus()));
		}
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_1.setBounds(188, 288, 155, 142);
		frame.getContentPane().add(label_1);
		if (game.getCrew1().getCrewMemberList().size() >= 2) {
			label_1.setText(game.convertToMultiline(game.getCrew1().getCrewMemberList().get(1).viewStatus()));
		}
		
		JLabel label_2 = new JLabel("");
		label_2.setBackground(Color.WHITE);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_2.setBounds(353, 288, 155, 142);
		frame.getContentPane().add(label_2);
		if (game.getCrew1().getCrewMemberList().size() >= 3) {
			label_2.setText(game.convertToMultiline(game.getCrew1().getCrewMemberList().get(2).viewStatus()));
		}
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(Color.BLACK);
		label_3.setBackground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_3.setBounds(500, 288, 158, 142);
		frame.getContentPane().add(label_3);
		if (game.getCrew1().getCrewMemberList().size() >= 4) {
			label_3.setText(game.convertToMultiline(game.getCrew1().getCrewMemberList().get(3).viewStatus()));
		}
		
		JLabel label_4 = new JLabel(game.convertToMultiline(game.getShip().checkShipShield()));
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(20, 406, 158, 87);
		frame.getContentPane().add(label_4);
		
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
					goGameOverScreen();
				}else {
					launchNextDayPopup();
				}
			}
		});
	}
	
	private void goGameOverScreen() {
		game.closeMainScreen(this);
		game.launchGameOverWindow();
		if (popup != null) {
			popup.dispose();
		}
		
	}

	private void launchSpaceOutpost() {
		game.closeMainScreen(this);
		game.launchSpaceOutpost();
		
	}
	
	private void chooseMember() {
		game.closeMainScreen(this);
		game.launchMemberSelection();
	}
 	
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
