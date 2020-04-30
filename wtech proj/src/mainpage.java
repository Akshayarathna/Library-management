import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainpage frame = new mainpage();
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
	public mainpage() {
		initComponents();
	}
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1109, 683);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(8, 8, 8, 8));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setBounds(338, 52, 287, 35);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		
		JLabel lblAlreadyAnUser = new JLabel("ALREADY AN USER?");
		lblAlreadyAnUser.setBounds(301, 311, 173, 26);
		lblAlreadyAnUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlreadyAnUser.setForeground(SystemColor.info);
		lblAlreadyAnUser.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		
		JLabel lblLoginAsAdmin = new JLabel("LOGIN AS ADMIN?");
		lblLoginAsAdmin.setBounds(301, 391, 173, 26);
		lblLoginAsAdmin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoginAsAdmin.setForeground(SystemColor.info);
		lblLoginAsAdmin.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("CLICK HERE");
		btnNewButton.setBounds(509, 251, 130, 17);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				visitor u=new visitor();
				//.setVisible(false);
				u.setVisible(true);
				dispose();
			}
		});
		JButton button = new JButton("CLICK HERE");
		button.setBounds(509, 316, 130, 17);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				USER u=new USER();
				//.setVisible(false);
				u.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBackground(SystemColor.activeCaption);
		
		JButton button_1 = new JButton("CLICK HERE");
		button_1.setBounds(509, 396, 130, 17);
		button_1.setForeground(Color.BLUE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_1.setBackground(SystemColor.activeCaption);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admin u=new admin();
				u.setVisible(true);
				dispose();
				}
		});
		JLabel lblNewUser = new JLabel("NEW USER?");
		lblNewUser.setBounds(301, 246, 173, 26);
		lblNewUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewUser.setForeground(SystemColor.info);
		lblNewUser.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		contentPane.setLayout(null);
		contentPane.add(lblAlreadyAnUser);
		contentPane.add(lblLoginAsAdmin);
		contentPane.add(lblNewUser);
		contentPane.add(btnNewButton);
		contentPane.add(button_1);
		contentPane.add(button);
		contentPane.add(lblNewLabel);
	}
}
