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

public class SalePopup extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
 
	}
	private GameEnvironment game;
	private ItemsForSale itemsForSale;


	/**
	 * Create the frame.
	 * @param game			The game environment in which is being played.
	 * @param itemsForSale		the items for sale Window in use.
	 */
	public SalePopup(GameEnvironment game, ItemsForSale itemsForSale) {
		setTitle("Space Explorer");
		this.game = game;
		this.itemsForSale = itemsForSale;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 200);
		getContentPane().setLayout(null);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent e) {
		    	close();
            }
        });
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnClose.setBounds(203, 109, 119, 41);
		getContentPane().add(btnClose);
		
		JLabel messageLabel = new JLabel("");
		messageLabel.setText(game.getMessage());
		messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		messageLabel.setBounds(10, 11, 564, 83);
		getContentPane().add(messageLabel);
	}
	/**
	 * Closes the window.
	 */
	private void close() {
		dispose();
		game.closeItemsForSale(itemsForSale);
		game.launchItemsForSale();
	}

}
