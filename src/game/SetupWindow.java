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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
/**
 * This window is where the user selects several variables about the game through buttons, text boxes and sliders.
 *
 * @author Jerome Grubb, Edwin Dixon
 * @version 16/05/19
 */
public class SetupWindow {

	private JFrame frmGame;
	private JTextField shipNametxtField;
	private JTextField mem1txtField;
	private JTextField mem3txtField;
	private JTextField mem2txtField;
	private JTextField mem4txtField;
	private JToggleButton confirmCrewMemButt = new JToggleButton("Confirm Crew Members");
	private JToggleButton confirmNumOfCrewMemLockInButt = new JToggleButton("Confirm");
	private String[] types = {"Type 1", "Type 2", "Type 3", "Type 4", "Type 5", "Type 6"}; 
	private JComboBox typeCombo1 = new JComboBox(types);
	private JComboBox typeCombo2 = new JComboBox(types);
	private JComboBox typeCombo3 = new JComboBox(types);
	private JComboBox typeCombo4 = new JComboBox(types);
	private GameEnvironment game;
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
	 * Class constructor.
	 * @param newGame				The new game environment. 
	 */
	public SetupWindow(GameEnvironment newGame) {
		game = newGame;
		initialize();
		frmGame.setVisible(true);
	}
	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frmGame.dispose();
	}
	/**
	 * Closes the window.
	 */
	public void finishedWindow() {
		game.closeSetupScreen(this);
	}
	/**
	 * Returns a boolean to whether or not two confirmation buttons have been selected.
	 * @return			A boolean has to whether the setup is finished
	 */
	public boolean gameReady() {
		if (confirmCrewMemButt.isSelected() && confirmNumOfCrewMemLockInButt.isSelected()) {
			return true;
		}else {
			return false;
		}
			
	}
	/**
	 * Creates a crew member of a type chosen by the user.
	 * @param type			A string of that is has a crew member type.
	 * @return			A crew member
	 */
	public CrewMember createCrewMember(String type) {
		if (type == "Type 1") {
			Type1 newMember = new Type1("", 40, 2, 10);
			return newMember;}
		if (type == "Type 2") {
			Type2 newMember = new Type2("", 10, 1, 25);
			return newMember;}
		if (type == "Type 3") {
			Type3 newMember = new Type3("", 25, 4, 40);
			return newMember;}
		if (type == "Type 4") {
			Type4 newMember = new Type4("", 25, 1, 25);
			return newMember;}
		if (type == "Type 5") {
			Type5 newMember = new Type5("", 25, 2, 40);
			return newMember;}
		else {
			Type6 newMember = new Type6("", 40, 2, 25);
			return newMember;}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGame = new JFrame();
		frmGame.setTitle("Space Explorer");
		frmGame.setBounds(100, 100, 800, 600);
		frmGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGame.getContentPane().setLayout(null);
		
		String[] types = {"Type 1", "Type 2", "Type 3", "Type 4", "Type 5", "Type 6"}; 
		JComboBox[] comboBoxes = {typeCombo1, typeCombo2, typeCombo3, typeCombo4}; 
		TypeStatsFrame stats = new TypeStatsFrame();

		
		JLabel dayLabel = new JLabel("How many days would you like to play?");
		dayLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		dayLabel.setBounds(12, 133, 352, 35);
		frmGame.getContentPane().add(dayLabel);
		
		JLabel crewMemLabel = new JLabel("How many crew Members would you like?");
		crewMemLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		crewMemLabel.setBounds(12, 204, 378, 27);
		frmGame.getContentPane().add(crewMemLabel);
		
		JLabel shipLabel = new JLabel("What would you like to name your Spaceship?");
		shipLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		shipLabel.setBounds(12, 71, 352, 27);
		frmGame.getContentPane().add(shipLabel);
		
		JSlider numOfCrewMemSlider = new JSlider();
		numOfCrewMemSlider.setPaintTicks(true);
		numOfCrewMemSlider.setFont(new Font("Dialog", Font.PLAIN, 15));
		numOfCrewMemSlider.setPaintLabels(true);
		numOfCrewMemSlider.setSnapToTicks(true);
		numOfCrewMemSlider.setValue(2);
		numOfCrewMemSlider.setMajorTickSpacing(1);
		numOfCrewMemSlider.setMaximum(4);
		numOfCrewMemSlider.setMinimum(2);
		numOfCrewMemSlider.setBounds(467, 204, 249, 56);
		frmGame.getContentPane().add(numOfCrewMemSlider);
		
		JSlider NumOfDaysSlider = new JSlider();
		NumOfDaysSlider.setBorder(null);
		NumOfDaysSlider.setPaintTicks(true);
		NumOfDaysSlider.setPaintLabels(true);
		NumOfDaysSlider.setSnapToTicks(true);
		NumOfDaysSlider.setFont(new Font("Dialog", Font.PLAIN, 15));
		NumOfDaysSlider.setMajorTickSpacing(1);
		NumOfDaysSlider.setMinimum(3);
		NumOfDaysSlider.setMaximum(10);
		NumOfDaysSlider.setValue(3);
		NumOfDaysSlider.setBounds(467, 133, 249, 56);
		frmGame.getContentPane().add(NumOfDaysSlider);
		
		JLabel titleLabel = new JLabel("Space Explorer");
		titleLabel.setBounds(30, 12, 305, 33);
		frmGame.getContentPane().add(titleLabel);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 27));
		
		JButton startGameButt = new JButton("Start Game!");
		startGameButt.setFont(new Font("Dialog", Font.BOLD, 18));
		startGameButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<CrewMember> crewMemberList = new ArrayList<CrewMember>();
				for (int i = 0; i < numOfCrewMemSlider.getValue(); i++) {
					String type = (String) comboBoxes[i].getSelectedItem();		// iterates through the combo boxes and gets the inputs.
					CrewMember member = createCrewMember(type);					// createCrewMember(type) is a method which creates the type based on combobox input.
					crewMemberList.add(member);
				}
				crewMemberList.get(0).setName(mem1txtField.getText());			// sets names of each crew member
				crewMemberList.get(1).setName(mem2txtField.getText());
				if (numOfCrewMemSlider.getValue() == 3) {
					crewMemberList.get(2).setName(mem3txtField.getText());
				}
				if (numOfCrewMemSlider.getValue() == 4) {
					crewMemberList.get(2).setName(mem3txtField.getText());
					crewMemberList.get(3).setName(mem4txtField.getText());
				}
				game.getCrew1().setCrewMemberList(crewMemberList);
				stats.dispose();
				finishedWindow();
			}
		});
		startGameButt.setEnabled(false);
		startGameButt.setBounds(201, 494, 323, 56);
		frmGame.getContentPane().add(startGameButt);
		
		shipNametxtField = new JTextField();
		shipNametxtField.setFont(new Font("Dialog", Font.PLAIN, 15));
		shipNametxtField.setText("Ship");
		shipNametxtField.setBounds(482, 72, 234, 35);
		frmGame.getContentPane().add(shipNametxtField);
		shipNametxtField.setColumns(10);
		

		mem1txtField = new JTextField();
		mem1txtField.setFont(new Font("Dialog", Font.PLAIN, 15));
		mem1txtField.setText("Member 1");
		mem1txtField.setBounds(30, 338, 171, 23);
		frmGame.getContentPane().add(mem1txtField);
		mem1txtField.setColumns(10);
		
		JLabel lblCrewMembers = new JLabel("Enter crew members' names and select their types");
		lblCrewMembers.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCrewMembers.setBounds(157, 290, 462, 36);
		frmGame.getContentPane().add(lblCrewMembers);
		
		mem3txtField = new JTextField();
		mem3txtField.setFont(new Font("Dialog", Font.PLAIN, 15));
		mem3txtField.setText("Member 3");
		mem3txtField.setColumns(10);
		mem3txtField.setVisible(false);
		mem3txtField.setBounds(30, 379, 171, 23);;
		frmGame.getContentPane().add(mem3txtField);
		
		mem2txtField = new JTextField();
		mem2txtField.setFont(new Font("Dialog", Font.PLAIN, 15));
		mem2txtField.setText("Member 2");
		mem2txtField.setColumns(10);
		mem2txtField.setBounds(372, 338, 171, 23);
		frmGame.getContentPane().add(mem2txtField);
		
		mem4txtField = new JTextField();
		mem4txtField.setFont(new Font("Dialog", Font.PLAIN, 15));
		mem4txtField.setText("Member 4");
		mem4txtField.setColumns(10);
		mem4txtField.setVisible(false);
		mem4txtField.setBounds(372, 379, 171, 23);
		frmGame.getContentPane().add(mem4txtField);
		

		typeCombo1.setFont(new Font("Dialog", Font.PLAIN, 15));
		typeCombo1.setBounds(240, 338, 95, 23);
		frmGame.getContentPane().add(typeCombo1);
		
		typeCombo3.setFont(new Font("Dialog", Font.PLAIN, 15));
		typeCombo3.setBounds(240, 379, 95, 23);
		typeCombo3.setVisible(false);
		frmGame.getContentPane().add(typeCombo3);
		
		typeCombo2.setFont(new Font("Dialog", Font.PLAIN, 15));
		typeCombo2.setBounds(582, 338, 95, 23);
		frmGame.getContentPane().add(typeCombo2);
		
		typeCombo4.setFont(new Font("Dialog", Font.PLAIN, 15));
		typeCombo4.setBounds(582, 379, 95, 23);
		typeCombo4.setVisible(false);
		frmGame.getContentPane().add(typeCombo4);
		confirmCrewMemButt.setFont(new Font("Dialog", Font.BOLD, 16));
		
		confirmCrewMemButt.setVisible(false);
		confirmCrewMemButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGameButt.setEnabled(gameReady());						// start game button enabled
				if (!confirmCrewMemButt.isSelected()) {
					mem1txtField.setEnabled(true);							// if button is not selected enables all name text boxes and combo boxes
					mem2txtField.setEnabled(true);
					mem3txtField.setEnabled(true);
					mem4txtField.setEnabled(true);
					typeCombo1.setEnabled(true);
					typeCombo2.setEnabled(true);
					typeCombo3.setEnabled(true);
					typeCombo4.setEnabled(true);
				}else {
					mem1txtField.setEnabled(false);							// if button is selected disables all name text boxes and combo boxes
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
		confirmCrewMemButt.setBounds(240, 430, 273, 35);
		frmGame.getContentPane().add(confirmCrewMemButt);
		confirmNumOfCrewMemLockInButt.setFont(new Font("Dialog", Font.BOLD, 15));
		
		
		confirmNumOfCrewMemLockInButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					startGameButt.setEnabled(gameReady());
					if (!confirmNumOfCrewMemLockInButt.isSelected()) {		// if button is not selected
						confirmCrewMemButt.setVisible(false);				// confirmCrewMemButt is not shown
						numOfCrewMemSlider.setEnabled(true);				// both sliders and ship textbox are enabled
						shipNametxtField.setEnabled(true);
						NumOfDaysSlider.setEnabled(true);
						
					}else {														
						shipNametxtField.setEnabled(false);						//disables sliders and ship textbox
						NumOfDaysSlider.setEnabled(false);
						numOfCrewMemSlider.setEnabled(false);					
						
						game.getShip().setShipName(shipNametxtField.getText());				 // gets the inputs from sliders and ship text box and sets them.
						game.setDays(NumOfDaysSlider.getValue());
						game.getCrew1().setRequiredPieces((NumOfDaysSlider.getValue() *2)/3);
						
						confirmCrewMemButt.setVisible(true);			// shows the confirm crew member button and hides extra member combo boxes and text boxes
						mem3txtField.setVisible(false);
						mem4txtField.setVisible(false);
						typeCombo3.setVisible(false);
						typeCombo4.setVisible(false);
					}
					if (numOfCrewMemSlider.getValue() == 3) {			//shows 3 textboxes and comboboxes for members
						mem3txtField.setVisible(true);
						typeCombo3.setVisible(true);
					}
					if (numOfCrewMemSlider.getValue() == 4) {			//shows 3 textboxes and comboboxes for members
						mem3txtField.setVisible(true);
						typeCombo3.setVisible(true);
						mem4txtField.setVisible(true);
						typeCombo4.setVisible(true);
					}
			}
		});
		confirmNumOfCrewMemLockInButt.setBounds(301, 253, 121, 35);
		frmGame.getContentPane().add(confirmNumOfCrewMemLockInButt);
		
		JButton viewTypeStatsButt = new JButton("View Type Stats");
		viewTypeStatsButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				stats.setVisible(true);
				stats.setDefaultCloseOperation(stats.DISPOSE_ON_CLOSE);
			}
		});
		viewTypeStatsButt.setFont(new Font("Dialog", Font.BOLD, 15));
		viewTypeStatsButt.setBounds(30, 431, 177, 35);
		frmGame.getContentPane().add(viewTypeStatsButt);
		
	}	

}
