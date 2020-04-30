import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

public class visitor extends JFrame {
	static int co=0;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visitor frame = new visitor();
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
	public visitor() 
			{
		try {
		initComponents();
			}
		catch(Exception ee) {}
			}
	public void initComponents()throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1237, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHOOSE A BOOK(Enter mobile number)");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(59, 29, 476, 35);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		
		textField.setBounds(585, 38, 164, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		JButton btnNewButton = new JButton("RETURN");
		btnNewButton.setBounds(907, 37, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<--GO BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainpage m=new mainpage();
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(469, 513, 150, 25);
		contentPane.add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visitret b=new visitret();
				b.setVisible(true);
				dispose();
			}
		});
		JLabel l1[] = new JLabel[100];
		JButton bt1[] = new JButton[100];
		JLabel l2[] = new JLabel[100];
		JButton bt2 []= new JButton[100];
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wtech","root","");
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("select * from books");
		 int i=0,j=0;
		 while(rs.next())
			{
				String s=rs.getString("name");
				String s1=rs.getString("author");
			int n=rs.getInt("count");
			l1[i]= new JLabel(s+" , "+s1);
			//lbel_1[i].setBackground(UIManager.getColor("Tree.textForeground"));
			
			l1[i].setBounds(127, 100+i*100, 212, 30);
			contentPane.add(l1[i]);
		
bt1[i] = new JButton("CLICK HERE");
		bt1[i].setBounds(351, 100+i*100, 144, 32);
		contentPane.add(bt1[i]);
		bt1[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ss=textField.getText();
				if(ss.equals(""))
				{
					JFrame jt=new JFrame();
					JOptionPane.showMessageDialog(jt,"Enter phone number");
				}
				else {
				try {
				//	JFrame jt=new JFrame();
			//JOptionPane.showMessageDialog(jt,ss);	
			if(n>0)
			{
				co=0;
				ResultSet rrr=st.executeQuery("select * from visitor");
				while(rrr.next())
					co++;
				String str="insert into visitor values("+co+",'"+ss+"','"+s+"')";
		Statement ro=con.createStatement();
		ro.executeUpdate(str);	

				JFrame jft=new JFrame();
				JOptionPane.showMessageDialog(jft,"DONE");	
			}else
				{
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"THIS BOOK IS CURRENTLY UNAVAILABLE");	
				}
			}
				catch(Exception e) {}}
			}});
		if(rs.next()) {
		//rs.next();
		String 	s2=rs.getString("name");
		String	s3=rs.getString("author");
		int n1=rs.getInt("count");
		l2[j]= new JLabel(s2+" , "+s3);
			l2[j].setBounds(618, 100+i*100, 262, 30);
		contentPane.add(l2[j]);
		
 bt2[j] = new JButton("CLICK HERE");
		bt2[j].setBounds(884, 100+i*100, 144, 28);
		contentPane.add(bt2[j]);
		bt2[j].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ss=textField.getText();
				if(ss.equals(""))
				{
					JFrame jt=new JFrame();
					JOptionPane.showMessageDialog(jt,"Enter phone number");
				}
				else {
				try {
				//	JFrame jt=new JFrame();
			//JOptionPane.showMessageDialog(jt,ss);	
			if(n>0)
			{
				co=0;
				ResultSet rrr=st.executeQuery("select * from visitor");
				while(rrr.next())
					co++;
				String str="insert into visitor values("+co+",'"+ss+"','"+s2+"')";
		Statement ro=con.createStatement();
		ro.executeUpdate(str);	

				JFrame jft=new JFrame();
				JOptionPane.showMessageDialog(jft,"DONE");	
			}else
				{
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"THIS BOOK IS CURRENTLY UNAVAILABLE");	
				}
			}
				catch(Exception e) {}}
			}});	i++;j++;
		}}

		}

		
	}

