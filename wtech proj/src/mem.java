import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class mem extends JFrame {
static int co=0;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mem frame = new mem();
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
	public mem() {
		try {
		initComponents();
	}
		catch(Exception e){}
	}
	public void initComponents() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wtech","root","");
		 Statement st=con.createStatement();
		 //ResultSet rs=st.executeQuery("select * from user");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1074, 758);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblW = new JLabel("WELCOME");
		lblW.setHorizontalAlignment(SwingConstants.CENTER);
		lblW.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblW.setBounds(259, 13, 502, 40);
		contentPane.add(lblW);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(259, 151, 182, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 17));
		lblPassword.setBounds(259, 223, 182, 29);
		contentPane.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("RE-ENTER PASSWORD");
		lblReenterPassword.setFont(new Font("Arial", Font.PLAIN, 17));
		lblReenterPassword.setBounds(259, 295, 182, 29);
		contentPane.add(lblReenterPassword);
		
		textField = new JTextField();
		textField.setBounds(503, 155, 167, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(503, 227, 167, 22);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(503, 299, 167, 22);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try {
				ResultSet rs=st.executeQuery("select * from user");
				co=0;
				while(rs.next())
					co++;
				String s=textField.getText();
				String s1=passwordField.getText();
				//JFrame jf=new JFrame();
				//JOptionPane.showMessageDialog(jf,s+s1);	
				//date d=
				String sql="insert into user values("+co+",'"+s+"','"+s1+"','','','','',null,null,null,null,DATE_ADD(current_date, INTERVAL 1 year))";
				st.executeUpdate(sql);
				JFrame jft=new JFrame();
				JOptionPane.showMessageDialog(jft,"DONE");
			}
			catch(Exception ehh) {}}
		});
		btnNewButton.setBounds(458, 386, 97, 25);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("<--GO BACK");
		btnNewButton_1.setBounds(364, 518, 150, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainpage m=new mainpage();
				m.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
	}

}
