package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class ViewOwnedItems extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the frame.
	 * @param game			The game environment in which is being played.
	 */
	public ViewOwnedItems(GameEnvironment game) {
		setTitle("Space Explorer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 585);
		getContentPane().setLayout(null);
		
		
		
		
		
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.setBounds(201, 494, 120, 41);
		getContentPane().add(btnOk);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(485, 494, 119, 41);
		getContentPane().add(btnClose);
		
		String foods = game.getMessage();
		JLabel foodsLabel = new JLabel(foods);
		foodsLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		foodsLabel.setBounds(10, 74, 393, 393);
		getContentPane().add(foodsLabel);
		
		String medicalItems = game.getsecondMessage();
		JLabel medicalItemsLabel = new JLabel(medicalItems);
		medicalItemsLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		medicalItemsLabel.setBounds(413, 74, 399, 385);
		getContentPane().add(medicalItemsLabel);
	}


}
