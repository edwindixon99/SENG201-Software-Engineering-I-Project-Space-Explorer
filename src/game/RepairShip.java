import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RepairShip extends JFrame {
	private GameEnvironment game;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEnvironment game = new GameEnvironment();
					RepairShip frame = new RepairShip(game);
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
	public RepairShip(GameEnvironment game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 219);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(game.getRepairMessage());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 12, 817, 106);
		getContentPane().add(lblNewLabel);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setFont(new Font("Dialog", Font.BOLD, 15));
		btnContinue.setBounds(12, 130, 165, 35);
		getContentPane().add(btnContinue);
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				game.launchMainScreen();
			}
		});
	}

}
