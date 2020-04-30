import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.SystemColor;

public class aop1 extends JFrame {

private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aop1 frame = new aop1();
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
	public aop1() {
		try {
		initComponents();
	}
		catch(Exception e) {}
	}
			
			
			
	public void initComponents()throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 976, 691);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel l1[]=new JLabel[100];
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblWelcome.setBounds(12, 13, 916, 27);
		contentPane.add(lblWelcome);
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wtech","root","");
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("select * from books");
		 int i=0,j=0;
		 l1[i]= new JLabel("BOOK:"+"         "+"AUTHOR:"+"        "+"COUNT:"+"REVIEW:");
			l1[i].setFont(new Font("Arial Black", Font.PLAIN, 16));
			//lbel_1[i].setBackground(UIManager.getColor("Tree.textForeground"));
			
			l1[i].setBounds(127, 100+i*100, 450, 30);
			contentPane.add(l1[i]);
			i++;
		 while(rs.next())
			{
				String s=rs.getString("name");
				String s1=rs.getString("author");
			int n=rs.getInt("count");
			String s2=rs.getString("review");
			l1[i]= new JLabel(s+"         "+s1+"        "+n+"              "+s2);
			if(n==0) {
				JFrame jf=new JFrame();
			JOptionPane.showMessageDialog(jf,"Alert!"+s+" is out of stock");	
			}
			l1[i].setFont(new Font("Arial", Font.PLAIN, 16));
			//lbel_1[i].setBackground(UIManager.getColor("Tree.textForeground"));
			
			l1[i].setBounds(127, 100+i*100, 450, 30);
			contentPane.add(l1[i]);
		/*
bt1[i] = new JButton("CLICK HERE");
		bt1[i].setBounds(351, 100+i*100, 144, 32);
		contentPane.add(bt1[i]);
		bt1[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ss=textField.getText();
				try {
					JFrame jt=new JFrame();
			JOptionPane.showMessageDialog(jt,ss);	
			if(n>0)
			{
				
				String str="insert into visitor values(5,'"+ss+"','"+s+"')";
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
				catch(Exception e) {}
			}});*/
		/*if(rs.next()) {
		//rs.next();
		String 	s2=rs.getString("name");
		String	s3=rs.getString("author");
		int n1=rs.getInt("count");
		l2[j]= new JLabel(s2+" , "+s3+" "+n1);
			l2[j].setBounds(200, 100+i*100, 262, 30);
		contentPane.add(l2[j]);
		/*
 bt2[j] = new JButton("CLICK HERE");
		bt2[j].setBounds(884, 100+i*100, 144, 28);
		contentPane.add(bt2[j]);
		bt2[j].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ss=textField.getText();
				try {
					JFrame jt=new JFrame();
					JOptionPane.showMessageDialog(jt,n1);	
			if(n1>0)
			{
			//	String ss=textField.getText();
				String str="insert into visitor values(1,"+ss+","+s2+")";
		Statement ro=con.createStatement();
		ro.executeUpdate(str);	
				
				JFrame jf=new JFrame();
				JOptionPane.showMesgeDialog(jf,"DONE");	
			}
				else
				{
				JFrame jf=new JFrame();
				JOptionPane.showMessageDialog(jf,"THIS BOOK IS CURRENTLY UNAVAILABLE");	
				}}
					catch(Exception e) {}
				}});	
	*/		i++;j++;
		}

	JButton btnNewButton = new JButton("ADD BOOK");
	btnNewButton.setBounds(319, 100+i*100, 127, 35);
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
	contentPane.add(btnNewButton);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			addbook a=new addbook();
			a.setVisible(true);
			dispose();
		}});
	JButton btnRemoveBook = new JButton("REMOVE BOOK");
	btnRemoveBook.setBounds(524, 100+i*100, 163, 35);
	btnRemoveBook.setFont(new Font("Tahoma", Font.PLAIN, 15));
	contentPane.add(btnRemoveBook);
	btnRemoveBook.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			removebook a=new removebook();
			a.setVisible(true);
			dispose();
		}});
	JButton btnNewButton_1 = new JButton("<--GO BACK");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mainpage m=new mainpage();
			m.setVisible(true);
			dispose();
		}
	});
	btnNewButton_1.setBounds(469, 850, 150, 25);
	contentPane.add(btnNewButton_1);
	
	}}


