import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class visitret extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visitret frame = new visitret();
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
	public visitret() 
	{
		try
		{
			initComponents();
		}
		catch(Exception e) {}
	}
			public void initComponents()throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 976, 678);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wtech","root","");
		 Statement st=con.createStatement();
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("THANKING YOU FOR THE VISIT");
		lblNewLabel.setBounds(167, 13, 502, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 23));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER YOUR PHONE NUMBER AND DROP A REVIEW");
		lblNewLabel_1.setBounds(196, 81, 456, 16);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PHONE NUMBER");
		lblNewLabel_2.setBounds(233, 150, 165, 28);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(458, 154, 165, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("POINTS OUT OF 10");
		lblNewLabel_3.setBounds(233, 223, 205, 16);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(458, 221, 165, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBounds(364, 312, 97, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try {
				String ph=textField.getText();
				JFrame  jft=new JFrame();
				JOptionPane.showMessageDialog(jft,"DONE");	
				String st=textField_1.getText();
				/*jft=new JFrame();
				JOptionPane.showMessageDialog(jft,st);	
				*/int n=Integer.parseInt(st);
				/*
					*/
				Statement r=con.createStatement();
				ResultSet rr=r.executeQuery("select * from visitor where phno='"+ph+"'");
				rr.next();
				String sss=rr.getString("book");
			//	jft=new JFrame();
				//JOptionPane.showMessageDialog(jft,sss);
				rr=r.executeQuery("select * from books where name='"+sss+"'");
				rr.next();
				String rrrr;
				int rll=rr.getInt("review");
				if(rll==0)
				rrrr="update books set review="+st+" where name='"+sss+"'";
				else
				rrrr="update books set review=(review+"+st+") DIV 2 where name='"+sss+"'";
				r.executeUpdate(rrrr);
				//Statement ro1=con.createStatement();
				//ro1.executeUpdate(str1);
				String str="delete from visitor where phno='"+ph+"'";
				Statement ro=con.createStatement();
				ro.executeUpdate(str);	}
			catch(Exception eh) {}
				
			}
		});
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
		
		JLabel lblWantToJoin = new JLabel("WANT TO JOIN AS A MEMBER?");
		lblWantToJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblWantToJoin.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblWantToJoin.setBounds(66, 405, 502, 40);
		contentPane.add(lblWantToJoin);
		
		JButton btnNewButton_2 = new JButton("CLICK HERE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mem m=new mem();
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(645, 406, 125, 39);
		contentPane.add(btnNewButton_2);
	}

}
