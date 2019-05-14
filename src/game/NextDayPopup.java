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

public class NextDayPopup extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
 
	}
	private GameEnvironment game;
	private MainWindow main;

	/**
	 * Create the frame.
	 */
	public NextDayPopup(GameEnvironment game, MainWindow main) {
		setTitle("Space Explorer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.game = game;
		this.main = main;
		setBounds(100, 100, 600, 296);
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
		btnClose.setBounds(206, 205, 119, 41);
		getContentPane().add(btnClose);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setText(game.convertToMultiline(game.getMessage()));
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 564, 183);
		getContentPane().add(lblNewLabel);
	}
	private void close() {
		dispose();
		game.closeMainScreen(main);
		game.launchMainScreen();
	}

}
