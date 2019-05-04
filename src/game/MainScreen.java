package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class MainScreen extends GameEnvironment{

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param newGameEnvironment 
	 */
	public MainScreen(GameEnvironment gameEnvironment) {
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
		frame.setBounds(100, 100, 1500, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDayX = new JLabel("Day X");
		lblDayX.setBounds(138, 12, 696, 72);
		frame.getContentPane().add(lblDayX);
		
		JLabel lblShipStatus = new JLabel("Ship Status");
		lblShipStatus.setBounds(47, 83, 125, 30);
		frame.getContentPane().add(lblShipStatus);
		
		JButton btnNewButton = new JButton("Clcik this");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CrewMemberStats panel = new CrewMemberStats();
				//panel.setVisible(false);
			}
		});
		btnNewButton.setBounds(33, 602, 300, 97);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(375, 602, 300, 97);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(720, 602, 300, 97);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(1098, 602, 300, 97);
		frame.getContentPane().add(button_2);
		
		JButton btnSearchPlanet = new JButton("Search Planet");
		btnSearchPlanet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchPlanet();
			}
		});
		btnSearchPlanet.setBounds(33, 814, 300, 97);
		frame.getContentPane().add(btnSearchPlanet);
		
		JButton btnRepairship = new JButton("RepairShip");
		btnRepairship.setBounds(375, 814, 300, 97);
		frame.getContentPane().add(btnRepairship);
		
		JButton btnFlytonewplanet = new JButton("FlytoNewPlanet");
		btnFlytonewplanet.setBounds(720, 814, 300, 97);
		frame.getContentPane().add(btnFlytonewplanet);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextDay();
			}
		});
		btnNextDay.setBounds(1098, 814, 300, 97);
		frame.getContentPane().add(btnNextDay);
	}
}
