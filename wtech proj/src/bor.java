import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class bor extends JFrame {
	static String namee="";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bor frame = new bor("");
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
	public bor(String s) {
		namee=s;
		try {
		initComponents();
	}
		catch (Exception e) {}
	}
	public void initComponents()throws Exception{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1266, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
			
			l1[i].setBounds(127, 61+i*100, 212, 30);
			contentPane.add(l1[i]);
		
bt1[i] = new JButton("CLICK HERE");
		bt1[i].setBounds(351, 59+i*100, 144, 32);
		contentPane.add(bt1[i]);
		bt1[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					//JFrame jt=new JFrame();
			//JOptionPane.showMessageDialog(jt,s);	
			/* ResultSet rs=st.executeQuery("select * from books");
			 while(rs.next()) {if(rs.);*/
			
					
				System.out.println(n);
			if(n>0)
			{
				Statement ro=con.createStatement();
						ro.executeUpdate("update books set count=count-1 where name='"+s+"';");	
		
				ResultSet rr=st.executeQuery("select * from user");String str,str1;
				while(rr.next())
				{
					str1=rr.getString("name");
			
					if(str1.equals(namee)) {
					if(rr.getString("book1").equals("")) {
						
						str="update user set book1='"+s+"',d1=current_date() where name='"+namee+"'";
						Statement rt=con.createStatement();
						rt.executeUpdate(str);	
						JFrame jf=new JFrame();
						JOptionPane.showMessageDialog(jf,"DONE");
					}
					else if(rr.getString("book2").equals("")) {
						str="update user set book2='"+s+"',d2=current_date() where name='"+namee+"'";
						Statement rt=con.createStatement();
						rt.executeUpdate(str);
						JFrame jf=new JFrame();
						JOptionPane.showMessageDialog(jf,"DONE");
					}
					else if(rr.getString("book3").equals("")) {
					//	JFrame jl=new JFrame();
						//JOptionPane.showMessageDialog(jl,s);
						str="update user set book3='"+s+"' where name='"+namee+"'";
						String sf="update user set d3=current_date()";
						Statement rt=con.createStatement();
						rt.executeUpdate(str);
						rt.executeUpdate(sf);
						JFrame jf=new JFrame();
						JOptionPane.showMessageDialog(jf,"DONE");
				//	jl=new JFrame();
					//	JOptionPane.showMessageDialog(jl,s);
					}
					else if(rr.getString("book4").equals("")) {
						str="update user set book4='"+s+"',d4=current_date() where name='"+namee+"'";
						Statement rt=con.createStatement();
						rt.executeUpdate(str);
						JFrame jf=new JFrame();
						JOptionPane.showMessageDialog(jf,"DONE");
						
					}
					else
					{
						JFrame jf=new JFrame();
						JOptionPane.showMessageDialog(jf,"ONLY FOUR BOOKS CAN BE BORROWED AT A TIME");	
					}}}}
			else
			{
			JFrame jf=new JFrame();
			JOptionPane.showMessageDialog(jf,"THIS BOOK IS CURRENTLY UNAVAILABLE");	
			}}
				catch(Exception e) {}
			}});
		if(rs.next()) {
		//rs.next();
		String 	s2=rs.getString("name");
		String	s3=rs.getString("author");
		int n1=rs.getInt("count");
		l2[j]= new JLabel(s2+" , "+s3);
			l2[j].setBounds(618, 61+i*100, 262, 30);
		contentPane.add(l2[j]);
		
 bt2[j] = new JButton("CLICK HERE");
		bt2[j].setBounds(884, 61+i*100, 144, 28);
		contentPane.add(bt2[j]);
		bt2[j].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				//	JFrame jt=new JFrame();
					//JOptionPane.showMessageDialog(jt,n1);	
			if(n1>0)
			{
				
				
				Statement ro=con.createStatement();
						ro.executeUpdate("update books set count=count-1 where name='"+s2+"';");	
		
				ResultSet rr=st.executeQuery("select * from user");String str,str1;
				while(rr.next())
				{
					str1=rr.getString("name");
					if(str1.equals(namee)) {
					if(rr.getString("book1").equals("")) {
						
						str="update user set book1='"+s2+"',d1=current_date() where name='"+namee+"'";
						Statement rt=con.createStatement();
						rt.executeUpdate(str);	JFrame jf=new JFrame();
						JOptionPane.showMessageDialog(jf,"DONE");
					}
					else if(rr.getString("book2").equals("")) {
						str="update user set book2='"+s2+"',d2=current_date() where name='"+namee+"'";
						Statement rt=con.createStatement();
						rt.executeUpdate(str);JFrame jf=new JFrame();
						JOptionPane.showMessageDialog(jf,"DONE");
					}
					else if(rr.getString("book3").equals(null)) {
						str="update user set book3='"+s2+"',d3=current_date() where name='"+namee+"'";
						Statement rt=con.createStatement();
						rt.executeUpdate(str);JFrame jf=new JFrame();
						JOptionPane.showMessageDialog(jf,"DONE");
					}
					else if(rr.getString("book4").equals("")) {
						str="update user set book4='"+s2+"',d4=current_date() where name='"+namee+"'";
						Statement rt=con.createStatement();
						rt.executeUpdate(str);JFrame jf=new JFrame();
						JOptionPane.showMessageDialog(jf,"DONE");
					}
					else
					{
						JFrame jf=new JFrame();
						JOptionPane.showMessageDialog(jf,"ONLY FOUR BOOKS CAN BE BORROWED AT A TIME");	
					}}}}
			else
			{
			JFrame jf=new JFrame();
			JOptionPane.showMessageDialog(jf,"THIS BOOK IS CURRENTLY UNAVAILABLE");	
			}}
				catch(Exception e) {}
			}});	
		i++;j++;
	}}
		 String n=namee;
		 JButton btnNewButton_1 = new JButton("<--GO BACK");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UOP m=new UOP(namee);
					m.setVisible(true);
					dispose();
				}
			});
			btnNewButton_1.setBounds(469, 513, 150, 25);
			contentPane.add(btnNewButton_1);

	}}
