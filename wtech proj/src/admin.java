import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;
public class admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	public admin()
	{
		initComponents();
	}
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 982, 699);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO ADMIN PORTAL LOGIN TO ENJOY YOUR SERVICES");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.windowText);
		lblNewLabel.setBounds(107, 30, 731, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USER ID");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(177, 166, 181, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 17));
		lblPassword.setBounds(177, 237, 181, 27);
		contentPane.add(lblPassword);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER");
		lblPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 17));
		lblPhoneNumber.setBounds(177, 301, 181, 27);
		contentPane.add(lblPhoneNumber);
		
		textField = new JTextField();
		textField.setBounds(354, 169, 202, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(354, 304, 202, 22);
		contentPane.add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(354, 240, 203, 22);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wtech","root","");
					 Statement st=con.createStatement();
					 ResultSet rs=st.executeQuery("select * from admin");
					 String s=(String)textField.getText();
						String s1=passwordField.getText( );
						String s2=textField_1.getText();
					//	String options=jComboBox1.getSelectedItem().
					JFrame jf=new JFrame();
						if(s=="" && s1=="")
							JOptionPane.showMessageDialog(jf,"some fields are empty");
						
						while(rs.next())
						{
							String s3=(String)rs.getString("name");
							String s4=rs.getString("password");
							String s5=rs.getString("phno");
							if(s3.equals(s))
							{
								JOptionPane.showMessageDialog(jf,s1);
								if(s4.equals(s1))
								{
									if(s2.equals(s5)) {
									aop1 u=new aop1();
									u.setVisible(true);
									dispose();
									}
									else
									{
										JOptionPane.showMessageDialog(jf,"INVALID PHONENUMBER");
									}
								}
								else
								{
									JOptionPane.showMessageDialog(jf,"INVALID PASSWORD");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(jf,"INVALID USER NAME"+s+s3);
							}
						}}
						catch(Exception ekk) {}
					
				}
		});
		btnNewButton.setBounds(304, 411, 132, 27);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("<--GO BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainpage m=new mainpage();
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(300, 513, 140, 25);
		contentPane.add(btnNewButton_1);
	}
}
