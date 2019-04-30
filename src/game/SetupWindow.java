import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class SetupWindow extends GameEnvironment{

	private JFrame frame;
	private JTextField txtEnterNameHere_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupWindow window = new SetupWindow();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumberOfDays = new JLabel("How many days would you like to play?");
		lblNumberOfDays.setBounds(12, 72, 275, 35);
		frame.getContentPane().add(lblNumberOfDays);
		
		JLabel lblNewLabel = new JLabel("How many crew Members would you like?");
		lblNewLabel.setBounds(12, 119, 291, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("What would you like to name your Spaceship?");
		lblNewLabel_1.setBounds(12, 158, 323, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtEnterNameHere_1 = new JTextField();
		txtEnterNameHere_1.setText("Enter name here");
		txtEnterNameHere_1.setBounds(353, 162, 203, 23);
		frame.getContentPane().add(txtEnterNameHere_1);
		txtEnterNameHere_1.setColumns(10);
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setValue(3);
		slider.setMajorTickSpacing(1);
		slider.setMaximum(4);
		slider.setMinimum(2);
		slider.setBounds(353, 97, 200, 56);
		frame.getContentPane().add(slider);
		
		JSlider slider_1 = new JSlider();
		slider_1.setMajorTickSpacing(1);
		slider_1.setSnapToTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMinimum(3);
		slider_1.setMaximum(10);
		slider_1.setValue(7);
		slider_1.setBounds(353, 60, 200, 45);
		frame.getContentPane().add(slider_1);
		
		JLabel lbTitle = new JLabel("Game Title");
		lbTitle.setBounds(34, 12, 522, 33);
		frame.getContentPane().add(lbTitle);
		lbTitle.setFont(new Font("Dialog", Font.BOLD, 27));
		
		JButton btnNewButton_1 = new JButton("Start Game!");
		btnNewButton_1.setBounds(139, 319, 323, 56);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblYouMustSelect = new JLabel("You must select crew member names and types before you can start the game!");
		lblYouMustSelect.setBounds(47, 284, 556, 23);
		frame.getContentPane().add(lblYouMustSelect);
		
		JButton btnViewTypeStats = new JButton("Create Crew Members");
		btnViewTypeStats.setBounds(175, 197, 244, 63);
		frame.getContentPane().add(btnViewTypeStats);
		
		JLabel label = new JLabel("");
		label.setBounds(51, 257, 66, 15);
		frame.getContentPane().add(label);
	}
}
