import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;

public class returnbook extends JFrame {

	static String namee="";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnbook frame = new returnbook(namee);
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
	public returnbook(String ss)
			{
		namee=ss;
		try{
			initComponents();
		}
		catch(Exception e) {}
			}
	public void initComponents()throws Exception {
		getContentPane().setLayout(null);
		
		JLabel lblReturnBook = new JLabel("RETURN BOOK");
		lblReturnBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturnBook.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblReturnBook.setBounds(228, 13, 446, 35);
		getContentPane().add(lblReturnBook);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 685);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel l2=new JLabel("BOOK NAME  AND BORROWED DATE");
		l2.setBounds(127, 20, 212, 30);
		contentPane.add(l2);
		JLabel l1[] = new JLabel[100];
		JButton bt1[] = new JButton[100];
		//JLabel l2[] = new JLabel[100];
		//JButton bt2 []= new JButton[100];
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wtech","root","");
		 Statement st=con.createStatement();
		 ResultSet rr=st.executeQuery("select * from USER");
		 int i=0;
		 while(rr.next())
			{
			String str1=rr.getString("name");
			if(str1.equals(namee)) {
				String str;
				if(str1.equals(namee)) {
				if(rr.getString("book1").equals("")) {
				}
				else {
					str=rr.getString("book1")+"("+rr.getString("d1")+")";
					l1[i]= new JLabel(str);
					l1[i].setBounds(127, 100+i*100, 212, 30);
					contentPane.add(l1[i]);
				
		bt1[i] = new JButton("CLICK HERE");
				bt1[i].setBounds(351, 100+i*100, 144, 32);
				contentPane.add(bt1[i]);
				bt1[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//bt1[i].setVisible(false);
						//l1[i].setVisible(false);
						//String ss=textField.getText();
						
						try {
							String sr="update user set book1='',d1=null where name='"+namee+"'";
							st.executeUpdate(sr);
							JFrame jft=new JFrame();
							JOptionPane.showMessageDialog(jft,"DONE");	
				}
						catch(Exception ee) {}
					}});
				i++;}
				if(rr.getString("book2").equals("")) {}
				else {
					str=rr.getString("book2")+"("+rr.getString("d2")+")";
					l1[i]= new JLabel(str);
					//lbel_1[i].setBackground(UIManager.getColor("Tree.textForeground"));
					
					l1[i].setBounds(127, 100+i*100, 212, 30);
					contentPane.add(l1[i]);			
					bt1[i] = new JButton("CLICK HERE");
					bt1[i].setBounds(351, 100+i*100, 144, 32);
					contentPane.add(bt1[i]);
				
					bt1[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							//String ss=textField.getText();
							try {
								String sr="update user set book2='',d2=null where name='"+namee+"'";
								st.executeUpdate(sr);
								JFrame jft=new JFrame();
								JOptionPane.showMessageDialog(jft,"DONE");	
					}
							catch(Exception ee) {}
						}});
					i++;}
				if(rr.getString("book3").equals("")) {}
				
				else {
					str=rr.getString("book3")+"("+rr.getString("d3")+")";
					l1[i]= new JLabel(str);
					//lbel_1[i].setBackground(UIManager.getColor("Tree.textForeground"));
					
					l1[i].setBounds(127, 100+i*100, 212, 30);
					contentPane.add(l1[i]);
				
		bt1[i] = new JButton("CLICK HERE");
				bt1[i].setBounds(351, 100+i*100, 144, 32);
				contentPane.add(bt1[i]);
				bt1[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//String ss=textField.getText();
						try {
							String sr="update user set book3='',d3=null where name='"+namee+"'";
							st.executeUpdate(sr);
							JFrame jft=new JFrame();
							JOptionPane.showMessageDialog(jft,"DONE");	
				}
						catch(Exception ee) {}
					}});
				i++;}
				if(rr.getString("book4").equals("")) {}
				else {
					str=rr.getString("book4")+"("+rr.getString("d4")+")";
					l1[i]= new JLabel(str);
					//lbel_1[i].setBackground(UIManager.getColor("Tree.textForeground"));
					
					l1[i].setBounds(127, 100+i*100, 212, 30);
					contentPane.add(l1[i]);
				
		bt1[i] = new JButton("CLICK HERE");
				bt1[i].setBounds(351, 100+i*100, 144, 32);
				contentPane.add(bt1[i]);
				bt1[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//String ss=textField.getText();
						try {
							String sr="update user set book4='',d4=null where name='"+namee+"'";
							st.executeUpdate(sr);
							JFrame jft=new JFrame();
							JOptionPane.showMessageDialog(jft,"DONE");		
				}
						catch(Exception ee) {}
					}});
				i++;}
			}}}
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
				

	}

}
