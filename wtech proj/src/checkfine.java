import java.awt.BorderLayout;
import java.util.concurrent.TimeUnit;
import java.text.*;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.font.*;
public class checkfine extends JFrame {

	static String namee="";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkfine frame = new checkfine("");
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
	public checkfine(String ss) {
			namee=ss;
			try {
				initComponents();
			}
			catch(Exception e) {}
	}
	public void initComponents()throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		long fine=0;
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wtech","root","");
		 Statement st=con.createStatement();
		 ResultSet rr=st.executeQuery("select * from USER");
		 JLabel l1[] = new JLabel[100];
		int i=0;
		 while(rr.next())
			{
			String str1=rr.getString("name");
			if(str1.equals(namee)) {
				String str;
				if(str1.equals(namee)) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					if(rr.getDate("d1")!=null) {
					Date d1=rr.getDate("d1");
					Date d2=Calendar. getInstance(). getTime();
					long diff=Math.abs(d2.getTime() - d1.getTime());
					long x = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
					/*JFrame jft=new JFrame();
					JOptionPane.showMessageDialog(jft,x);	
					*/if(x<15)
						fine=fine+0;
					else {
						fine=fine+(x-15)*2;
						str="You have returned "+rr.getString("book1")+" "+(x-15)+"days late.Fine applicable:"+(x-15)*2;
						l1[i]= new JLabel(str);
						l1[i].setBounds(127, 100+i*100, 21200, 30);
						contentPane.add(l1[i]);
						i++;
					}
					}
					if(rr.getDate("d2")!=null) {
						Date d1=rr.getDate("d2");
						Date d2=Calendar. getInstance(). getTime();
						long diff=Math.abs(d2.getTime() - d1.getTime());
						long x = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	//					JFrame jft=new JFrame();
		//				JOptionPane.showMessageDialog(jft,x);	
						if(x<15)
							fine=fine+0;
						else {
							fine=fine+(x-15)*2;
							str="You have returned "+rr.getString("book2")+" "+(x-15)+"days late.Fine applicable:"+(x-15)*2;
							l1[i]= new JLabel(str);
							l1[i].setBounds(127, 100+i*100, 21200, 30);
							contentPane.add(l1[i]);
							i++;
						}
						}
					if(rr.getDate("d3")!=null) {
						Date d1=rr.getDate("d3");
						Date d2=Calendar. getInstance(). getTime();
						long diff=Math.abs(d2.getTime() - d1.getTime());
						long x = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
						if(x<15)
							fine=fine+0;
						else {
							fine=fine+(x-15)*2;
							str="You have returned "+rr.getString("book3")+" "+(x-15)+"days late.Fine applicable:"+(x-15)*2;
							l1[i]= new JLabel(str);
							l1[i].setBounds(127, 100+i*100, 21200, 30);
							contentPane.add(l1[i]);
							i++;
						}
						}
					if(rr.getDate("d4")!=null) {
						Date d1=rr.getDate("d4");
						Date d2=Calendar. getInstance(). getTime();
						long diff=Math.abs(d2.getTime() - d1.getTime());
						long x = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
						if(x<15)
							fine=fine+0;
						else {
							fine=fine+(x-15)*2;
							str="You have returned "+rr.getString("book4")+" "+(x-15)+"days late.Fine applicable:"+(x-15)*2;
							l1[i]= new JLabel(str);
							l1[i].setBounds(127, 100+i*100, 21200, 30);
							contentPane.add(l1[i]);
							i++;
						}
						}
				}}}
		  String str="Your current fine amount is "+fine;
			l1[i]= new JLabel(str);
	//		l1[i].setFont(new Font("Arial Black",Font.BOLD,17));
			l1[i].setBounds(400, 100+i*100, 21200, 30);
			contentPane.add(l1[i]);
			i++;
			JButton button = new JButton("PAY FINE");
			button.setBounds(443, 516, 97, 25);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {try {
					String ss="update user set d1=current_date,d2=current_date,d3=current_date,d4=current_date where name='"+namee+"'";
					Statement st=con.createStatement();
					st.executeUpdate(ss);
					UOP a=new UOP(namee);
					a.setVisible(true);
					dispose();
					}
				catch(Exception ee) {}
				}
			});
			contentPane.setLayout(null);
			contentPane.add(button);
			 JButton btnNewButton_1 = new JButton("<--GO BACK");
			 btnNewButton_1.setBounds(400, 700, 150, 25);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						UOP m=new UOP(namee);
						m.setVisible(true);
						dispose();
					}
				});
				contentPane.add(btnNewButton_1);
		
	}

}
