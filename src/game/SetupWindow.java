package game;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetupWindow extends GameEnvironment{

	private JFrame frmGame;
	private JTextField shipNametxtField;
	private JTextField mem1txtField;
	private JTextField mem3txtField;
	private JTextField mem2txtField;
	private JTextField mem4txtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupWindow window = new SetupWindow();
					window.frmGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGame = new JFrame();
		frmGame.setTitle("game");
		frmGame.setBounds(100, 100, 800, 600);
		frmGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGame.getContentPane().setLayout(null);
		
		JToggleButton shipNameButt = new JToggleButton("Lock In");
		JToggleButton confirmCrewMemButt = new JToggleButton("Confirm Crew Members");
		JToggleButton dayLockInButt = new JToggleButton("Lock In");
		JToggleButton numOfCrewMemLockInButt = new JToggleButton("Lock In");
		
		JLabel dayLabel = new JLabel("How many days would you like to play?");
		dayLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dayLabel.setBounds(12, 53, 275, 35);
		frmGame.getContentPane().add(dayLabel);
		
		JLabel crewMemLabel = new JLabel("How many crew Members would you like?");
		crewMemLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		crewMemLabel.setBounds(12, 99, 291, 27);
		frmGame.getContentPane().add(crewMemLabel);
		
		JLabel shipLabel = new JLabel("What would you like to name your Spaceship?");
		shipLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		shipLabel.setBounds(12, 158, 323, 27);
		frmGame.getContentPane().add(shipLabel);
		
		JSlider numOfCrewMemSlider = new JSlider();
		numOfCrewMemSlider.setFont(new Font("Tahoma", Font.PLAIN, 13));
		numOfCrewMemSlider.setPaintLabels(true);
		numOfCrewMemSlider.setSnapToTicks(true);
		numOfCrewMemSlider.setValue(3);
		numOfCrewMemSlider.setMajorTickSpacing(1);
		numOfCrewMemSlider.setMaximum(4);
		numOfCrewMemSlider.setMinimum(2);
		numOfCrewMemSlider.setBounds(353, 96, 200, 51);
		frmGame.getContentPane().add(numOfCrewMemSlider);
		
		JSlider NumOfDaysSlider = new JSlider();
		NumOfDaysSlider.setFont(new Font("Tahoma", Font.PLAIN, 13));
		NumOfDaysSlider.setMajorTickSpacing(1);
		NumOfDaysSlider.setSnapToTicks(true);
		NumOfDaysSlider.setPaintLabels(true);
		NumOfDaysSlider.setMinimum(3);
		NumOfDaysSlider.setMaximum(10);
		NumOfDaysSlider.setValue(7);
		NumOfDaysSlider.setBounds(353, 53, 200, 45);
		frmGame.getContentPane().add(NumOfDaysSlider);
		
		JLabel titleLabel = new JLabel("Game Title");
		titleLabel.setBounds(34, 12, 522, 33);
		frmGame.getContentPane().add(titleLabel);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 27));
		
		JButton startGameButt = new JButton("Start Game!");
		startGameButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Will create the crew members by getting values from the comboboxes and textfield for type and name of each.
				// will then close this window and open maingame window
				
			}
		});
		startGameButt.setEnabled(false);
		startGameButt.setBounds(201, 494, 323, 56);
		frmGame.getContentPane().add(startGameButt);
		
		JLabel errorLabel = new JLabel("You must select crew member names and types before you can start the game!");
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		errorLabel.setBounds(78, 417, 635, 76);
		frmGame.getContentPane().add(errorLabel);
		
		shipNametxtField = new JTextField();
		shipNametxtField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		shipNametxtField.setText("Ship");
		shipNametxtField.setBounds(363, 160, 190, 23);
		frmGame.getContentPane().add(shipNametxtField);
		shipNametxtField.setColumns(10);
		
		mem1txtField = new JTextField();
		mem1txtField.setText("Member 1");
		mem1txtField.setBounds(34, 223, 171, 23);
		frmGame.getContentPane().add(mem1txtField);
		mem1txtField.setColumns(10);
		
		JLabel lblCrewMembers = new JLabel("Enter crew members' names and select their types");
		lblCrewMembers.setBounds(156, 196, 336, 15);
		frmGame.getContentPane().add(lblCrewMembers);
		
		mem3txtField = new JTextField();
		mem3txtField.setText("Member 3");
		mem3txtField.setColumns(10);
		mem3txtField.setVisible(false);
		mem3txtField.setBounds(34, 250, 171, 23);;
		frmGame.getContentPane().add(mem3txtField);
		
		mem2txtField = new JTextField();
		mem2txtField.setText("Member 2");
		mem2txtField.setColumns(10);
		mem2txtField.setBounds(382, 223, 171, 23);
		frmGame.getContentPane().add(mem2txtField);
		
		mem4txtField = new JTextField();
		mem4txtField.setText("Member 4");
		mem4txtField.setColumns(10);
		mem4txtField.setVisible(false);
		mem4txtField.setBounds(382, 251, 171, 23);
		frmGame.getContentPane().add(mem4txtField);
		
		String[] types = {"Type 1", "Type 2", "Type 3", "Type 4", "Type 5", "Type 6"}; 
		JComboBox typeCombo1 = new JComboBox(types);
		typeCombo1.setFont(new Font("Courier New", Font.PLAIN, 13));
		typeCombo1.setBounds(240, 223, 95, 23);
		frmGame.getContentPane().add(typeCombo1);
		
		JComboBox typeCombo3 = new JComboBox(types);
		typeCombo3.setFont(new Font("Courier New", Font.PLAIN, 13));
		typeCombo3.setBounds(240, 251, 95, 23);
		typeCombo3.setVisible(false);
		frmGame.getContentPane().add(typeCombo3);
		
		JComboBox typeCombo2 = new JComboBox(types);
		typeCombo2.setFont(new Font("Courier New", Font.PLAIN, 13));
		typeCombo2.setBounds(582, 223, 95, 23);
		frmGame.getContentPane().add(typeCombo2);
		
		JComboBox typeCombo4 = new JComboBox(types);
		typeCombo4.setFont(new Font("Courier New", Font.PLAIN, 13));
		typeCombo4.setBounds(582, 249, 95, 23);
		typeCombo4.setVisible(false);
		frmGame.getContentPane().add(typeCombo4);
		
		
		confirmCrewMemButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!confirmCrewMemButt.isSelected()) {
					mem1txtField.setEnabled(true);
					mem2txtField.setEnabled(true);
					mem3txtField.setEnabled(true);
					mem4txtField.setEnabled(true);
					typeCombo1.setEnabled(true);
					typeCombo2.setEnabled(true);
					typeCombo3.setEnabled(true);
					typeCombo4.setEnabled(true);
				}else {
					mem1txtField.setEnabled(false);
					mem2txtField.setEnabled(false);
					mem3txtField.setEnabled(false);
					mem4txtField.setEnabled(false);
					typeCombo1.setEnabled(false);
					typeCombo2.setEnabled(false);
					typeCombo3.setEnabled(false);
					typeCombo4.setEnabled(false);
				}	
				}
		});
		confirmCrewMemButt.setBounds(251, 301, 210, 35);
		frmGame.getContentPane().add(confirmCrewMemButt);
		
		
		dayLockInButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!dayLockInButt.isSelected()) {
					NumOfDaysSlider.setEnabled(true);
				}else {
					NumOfDaysSlider.setEnabled(false);
					GameEnvironment.setDays(NumOfDaysSlider.getValue());
				}
			}
		});
		dayLockInButt.setBounds(592, 60, 121, 23);
		frmGame.getContentPane().add(dayLockInButt);
		
		
		numOfCrewMemLockInButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (!numOfCrewMemLockInButt.isSelected()) {
						numOfCrewMemSlider.setEnabled(true);
					}else {
						numOfCrewMemSlider.setEnabled(false);
						mem3txtField.setVisible(false);
						mem4txtField.setVisible(false);
						typeCombo3.setVisible(false);
						typeCombo4.setVisible(false);
					}
					if (numOfCrewMemSlider.getValue() == 3) {
						mem3txtField.setVisible(true);
						typeCombo3.setVisible(true);
					}
					if (numOfCrewMemSlider.getValue() == 4) {
						mem3txtField.setVisible(true);
						typeCombo3.setVisible(true);
						mem4txtField.setVisible(true);
						typeCombo4.setVisible(true);
					}
			}
		});
		numOfCrewMemLockInButt.setBounds(592, 108, 121, 23);
		frmGame.getContentPane().add(numOfCrewMemLockInButt);
		
		
		
		shipNameButt.setBounds(592, 160, 121, 23);
		frmGame.getContentPane().add(shipNameButt);
		shipNameButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (!shipNameButt.isSelected()) {
						shipNametxtField.setEnabled(true);
					}else {
						shipNametxtField.setEnabled(false);
						ship.setShipName(shipNametxtField.getText());
			}}
		});
		
		JButton viewTypeStatsButt = new JButton("View Type Stats");
		viewTypeStatsButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TypeStatsWindow();		// doesnt work
			}
			
		});
		viewTypeStatsButt.setBounds(28, 301, 135, 35);
		frmGame.getContentPane().add(viewTypeStatsButt);
		
	}	

}
