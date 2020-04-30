import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fees extends JFrame {
	static String namee="";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fees frame = new fees(namee);
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
	public fees(String ss) {
		namee=ss;
		try {
			initComponents();
		}
		catch(Exception e) {}
}
public void initComponents() throws Exception{
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 637);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInOrderTo = new JLabel("IN ORDER TO MAINTAIN MEMBERSHIP THE ENTRY FEE(500) SHOULD BE PAID REGULARY");
		lblInOrderTo.setBounds(12, 13, 958, 27);
		lblInOrderTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInOrderTo.setBackground(new Color(211, 211, 211));
		lblInOrderTo.setFont(new Font("Arial", Font.PLAIN, 17));
		contentPane.add(lblInOrderTo);
		
		JButton btnNewButton = new JButton("PAY FEES");
		btnNewButton.setBounds(423, 497, 97, 25);
		contentPane.add(btnNewButton);
		
		
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wtech","root","");
		 Statement st=con.createStatement();
		 ResultSet rr=st.executeQuery("select * from USER");
		 JLabel l1[] = new JLabel[100];
		//int i=0;
		 while(rr.next())
			{
			String str1=rr.getString("name");
			if(str1.equals(namee)) 
			{
				String str;
				Date d1=rr.getDate("feedate");
				Date d2=Calendar. getInstance(). getTime();
				long diff=Math.abs(d2.getTime() - d1.getTime());
				long x = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			if(x>=365)
			{
				JLabel label = new JLabel("DEAR "+namee+", YOUR MEMBERSHIP VALIDITY HAS BEEN EXPIRED.PAY TO CONTINUE SERIVICES.");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Arial", Font.PLAIN, 17));
				label.setBounds(94, 185, 811, 27);
				contentPane.add(label);	
			}
			else
			{
				JLabel label = new JLabel("DEAR "+namee+", YOUR MEMBERSHIP VALIDITY LASTS FOR "+(x)+" MORE DAYS");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Arial", Font.PLAIN, 17));
				label.setBounds(94, 185, 811, 27);
				contentPane.add(label);	
			}
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String str="update user set feedate=DATE_ADD(current_date, INTERVAL 1 year)";
						Statement sp=con.createStatement();
						sp.executeUpdate(str);
						}
					catch(Exception eee) {}
					}
				});
			
			}
			}
		 String n=namee;
		 JButton btnNewButton_1 = new JButton("<--GO BACK");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UOP m=new UOP(namee);
					m.setVisible(true);
					dispose();
				}
			});
			btnNewButton_1.setBounds(400, 700, 150, 25);
			contentPane.add(btnNewButton_1);
		
	}

}
