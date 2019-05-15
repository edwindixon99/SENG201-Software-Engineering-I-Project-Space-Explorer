package game;



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
		setTitle("Space Explorer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Types of Crew Members");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		titleLabel.setBounds(192, 11, 381, 91);
		add(titleLabel);
		
		JLabel type1Label = new JLabel("<html>Type 1:<br>Hunger degrade: high<br>Health degrade: medium<br>Tiredness Degrade: low<br>Special ability: None<br>");
		type1Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		type1Label.setBounds(23, 129, 215, 168);
		add(type1Label);
		
		JLabel type2Label = new JLabel("<html>Type 2:<br>Hunger degrade: low<br>Health degrade: high<br>Tiredness Degrade: medium<br>Special ability: None<br>");
		type2Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		type2Label.setBounds(299, 129, 210, 168);
		add(type2Label);
		
		JLabel type3Label = new JLabel("<html>Type 3:<br>Hunger degrade: medium<br>Health degrade: low<br>Tiredness Degrade: high<br>Special ability: None<br>");
		type3Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		type3Label.setBounds(540, 129, 210, 168);
		add(type3Label);
		
		JLabel type4Label = new JLabel("<html>Type 4:<br>Hunger degrade: medium<br>Health degrade: high<br>Tiredness Degrade: medium<br>Special ability: Able to pilot the ship to a new planet by themselves<br>");
		type4Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		type4Label.setBounds(23, 323, 215, 168);
		add(type4Label);
		
		JLabel type5Label = new JLabel("<html>Type 5:<br>Hunger degrade: medium<br>Health degrade: medium<br>Tiredness Degrade: high<br>Special ability: Higher chance of finding a spaceship piece when searching a planet<br>");
		type5Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		type5Label.setBounds(299, 323, 210, 168);
		add(type5Label);
		
		JLabel type6Label = new JLabel("<html>Type 6:<br>Hunger degrade: high<br>Health degrade: medium<br>Tiredness Degrade: medium<br>Special ability: Fully repair the ships shield<br>");
		type6Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		type6Label.setBounds(540, 323, 210, 168);
		add(type6Label);
		
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
