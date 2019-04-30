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

public class SetupWindow {

	private JFrame frmGame;
	private JTextField textField;
	private JTextField txtEnterName;
	private JTextField txtMember2;
	private JTextField txtMember;
	private JTextField txtMember_1;

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
		
		JLabel lblNumberOfDays = new JLabel("How many days would you like to play?");
		lblNumberOfDays.setBounds(12, 72, 275, 35);
		frmGame.getContentPane().add(lblNumberOfDays);
		
		JLabel lblNewLabel = new JLabel("How many crew Members would you like?");
		lblNewLabel.setBounds(12, 119, 291, 27);
		frmGame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("What would you like to name your Spaceship?");
		lblNewLabel_1.setBounds(12, 158, 323, 27);
		frmGame.getContentPane().add(lblNewLabel_1);
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setValue(3);
		slider.setMajorTickSpacing(1);
		slider.setMaximum(4);
		slider.setMinimum(2);
		slider.setBounds(353, 97, 200, 56);
		frmGame.getContentPane().add(slider);
		
		JSlider slider_1 = new JSlider();
		slider_1.setMajorTickSpacing(1);
		slider_1.setSnapToTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMinimum(3);
		slider_1.setMaximum(10);
		slider_1.setValue(7);
		slider_1.setBounds(353, 60, 200, 45);
		frmGame.getContentPane().add(slider_1);
		
		JLabel lbTitle = new JLabel("Game Title");
		lbTitle.setBounds(34, 12, 522, 33);
		frmGame.getContentPane().add(lbTitle);
		lbTitle.setFont(new Font("Dialog", Font.BOLD, 27));
		
		JButton btnNewButton_1 = new JButton("Start Game!");
		btnNewButton_1.setBounds(201, 494, 323, 56);
		frmGame.getContentPane().add(btnNewButton_1);
		
		JLabel lblYouMustSelect = new JLabel("You must select crew member names and types before you can start the game!");
		lblYouMustSelect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblYouMustSelect.setBounds(78, 417, 635, 76);
		frmGame.getContentPane().add(lblYouMustSelect);
		
		JLabel label = new JLabel("");
		label.setBounds(51, 257, 66, 15);
		frmGame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(345, 160, 203, 23);
		frmGame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtEnterName = new JTextField();
		txtEnterName.setText("Member 1");
		txtEnterName.setBounds(34, 223, 171, 23);
		frmGame.getContentPane().add(txtEnterName);
		txtEnterName.setColumns(10);
		
		JLabel lblCrewMembers = new JLabel("Enter crew members' names and select their types");
		lblCrewMembers.setBounds(156, 196, 241, 15);
		frmGame.getContentPane().add(lblCrewMembers);
		
		txtMember2 = new JTextField();
		txtMember2.setText("Member 3");
		txtMember2.setColumns(10);
		txtMember2.setBounds(34, 250, 171, 23);
		txtMember2.setEnabled(false);;
		frmGame.getContentPane().add(txtMember2);
		
		txtMember = new JTextField();
		txtMember.setText("Member 2");
		txtMember.setColumns(10);
		txtMember.setBounds(382, 223, 171, 23);
		frmGame.getContentPane().add(txtMember);
		
		txtMember_1 = new JTextField();
		txtMember_1.setText("Member 4");
		txtMember_1.setColumns(10);
		txtMember_1.setBounds(382, 251, 171, 23);
		frmGame.getContentPane().add(txtMember_1);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setBounds(240, 223, 95, 23);
		frmGame.getContentPane().add(comboBox1);
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(240, 251, 95, 23);
		frmGame.getContentPane().add(comboBox2);
		
		JComboBox comboBox3 = new JComboBox();
		comboBox3.setBounds(582, 223, 95, 23);
		frmGame.getContentPane().add(comboBox3);
		
		JComboBox comboBox4 = new JComboBox();
		comboBox4.setBounds(582, 249, 95, 23);
		frmGame.getContentPane().add(comboBox4);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Confirm Crew Members");
		tglbtnNewToggleButton.setBounds(251, 301, 210, 35);
		frmGame.getContentPane().add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("New toggle button");
		tglbtnNewToggleButton_1.setBounds(592, 60, 121, 23);
		frmGame.getContentPane().add(tglbtnNewToggleButton_1);
		
		JToggleButton toggleButton = new JToggleButton("New toggle button");
		toggleButton.setBounds(592, 108, 121, 23);
		frmGame.getContentPane().add(toggleButton);
		
		
		JToggleButton toggleButton_1 = new JToggleButton("New toggle button");
		toggleButton_1.setBounds(592, 160, 121, 23);
		frmGame.getContentPane().add(toggleButton_1);
		
	}
}
