package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberSelection extends JFrame {
	public MemberSelection() {
	}

	private JPanel contentPane;
	private CrewMember crewMember;
	private GameEnvironment game;
	private JFrame frame;;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEnvironment game = new GameEnvironment();
					MemberSelection window = new MemberSelection(game);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the 
	 */
	public CrewMember getCrewMember(GameEnvironment game) {
		MemberSelection frame = new MemberSelection(game);
		frame.setVisible(true);
		return crewMember;
	}
	public MemberSelection(GameEnvironment game) {
		this.game = game;
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 703, 564);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton(game.getCrew1().getCrewMemberList().get(0).getName());
		btnNewButton.setBounds(21, 338, 147, 58);
		frame.getContentPane().add(btnNewButton);


		

		
		JLabel label = new JLabel("<html>i<br>i<br>i<br>i<br>i<br>i<br>i<br>");
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		label.setBounds(21, 140, 158, 142);
		frame.getContentPane().add(label);
		if (game.getCrew1().getCrewMemberList().size() >= 1) {
			CrewMember member1 = game.getCrew1().getCrewMemberList().get(0);
			label.setText(game.convertToMultiline(game.getCrew1().getCrewMemberList().get(0).viewStatus()));
		}
		
		JLabel label_1 = new JLabel("<html>i<br>i<br>i<br>i<br>i<br>i<br>i<br>");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_1.setBounds(188, 140, 155, 142);
		frame.getContentPane().add(label_1);
		if (game.getCrew1().getCrewMemberList().size() >= 2) {
			CrewMember member2 = game.getCrew1().getCrewMemberList().get(1);
			label_1.setText(game.convertToMultiline(member2.viewStatus()));
			JButton btnMember = new JButton(member2.getName());
			btnMember.setBounds(188, 338, 147, 58);
			frame.getContentPane().add(btnMember);

		}
		
		JLabel label_2 = new JLabel("<html>i<br>i<br>i<br>i<br>i<br>i<br>i<br>");
		label_2.setBackground(Color.WHITE);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_2.setBounds(353, 140, 155, 142);
		frame.getContentPane().add(label_2);
		if (game.getCrew1().getCrewMemberList().size() >= 3) {
			CrewMember member3 = game.getCrew1().getCrewMemberList().get(2);
			label_2.setText(game.convertToMultiline(member3.viewStatus()));
			JButton btnMember_1 = new JButton(member3.getName());
			btnMember_1.setBounds(353, 338, 147, 58);
			frame.getContentPane().add(btnMember_1);
		}
		
		JLabel label_3 = new JLabel("<html>i<br>i<br>i<br>i<br>i<br>i<br>i<br>");
		label_3.setForeground(Color.BLACK);
		label_3.setBackground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 15));
		label_3.setBounds(500, 140, 158, 142);
		frame.getContentPane().add(label_3);
		if (game.getCrew1().getCrewMemberList().size() >= 4) {
			CrewMember member4 = game.getCrew1().getCrewMemberList().get(3);
			label_3.setText(game.convertToMultiline(member4.viewStatus()));
			JButton btnMember_2 = new JButton(member4.getName());
			btnMember_2.setBounds(510, 338, 147, 58);
			frame.getContentPane().add(btnMember_2);
		}

			
			
		JLabel lblPickACrew = new JLabel("Pick a Crew Member to do this action");
		lblPickACrew.setBounds(80, 11, 503, 86);
		frame.getContentPane().add(lblPickACrew);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goBack();
			}
		});
		btnGoBack.setBounds(456, 445, 190, 69);
		frame.getContentPane().add(btnGoBack);
		

		
		
	

	}
	private void goBack() {
		game.closeMemberSelection(this);
		game.launchMainScreen();
	}

	public void closeWindow() {
		dispose();
	}
}
	