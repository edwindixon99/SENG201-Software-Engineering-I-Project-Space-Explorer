

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class TypeStatsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TypeStatsFrame frame = new TypeStatsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TypeStatsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Types of Crew Members");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setBounds(192, 11, 381, 91);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Type 1:<br>Hunger degrade: high<br>Health degrade: medium<br>Tiredness Degrade: low<br>Special ability: None<br>");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(23, 129, 215, 168);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("<html>Type 2:<br>Hunger degrade: low<br>Health degrade: high<br>Tiredness Degrade: medium<br>Special ability: None<br>");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(299, 129, 210, 168);
		add(label);
		
		JLabel label_1 = new JLabel("<html>Type 3:<br>Hunger degrade: medium<br>Health degrade: low<br>Tiredness Degrade: high<br>Special ability: None<br>");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(540, 129, 210, 168);
		add(label_1);
		
		JLabel label_2 = new JLabel("<html>Type 4:<br>Hunger degrade: medium<br>Health degrade: high<br>Tiredness Degrade: medium<br>Special ability: Able to pilot the ship to a new planet by themselves<br>");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(23, 323, 215, 168);
		add(label_2);
		
		JLabel label_3 = new JLabel("<html>Type 5:<br>Hunger degrade: medium<br>Health degrade: medium<br>Tiredness Degrade: high<br>Special ability: Higher chance of finding a spaceship piece when searching a planet<br>");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(299, 323, 210, 168);
		add(label_3);
		
		JLabel label_4 = new JLabel("<html>Type 6:<br>Hunger degrade: high<br>Health degrade: medium<br>Tiredness Degrade: medium<br>Special ability: Fully repair the ships shield<br>");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(540, 323, 210, 168);
		add(label_4);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.setBounds(217, 509, 120, 41);
		add(btnOk);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(390, 509, 119, 41);
		add(btnClose);
	}
}
