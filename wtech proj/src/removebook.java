import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.*;
public class removebook extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					removebook frame = new removebook();
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
	public removebook() {try {
		initComponents();
	}
	catch(Exception e){
	}
}
public void initComponents()throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wtech","root","");
		 Statement st=con.createStatement();
		 
	
		setBackground(new Color(255, 250, 205));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 684);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REMOVE BOOKS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(248, 13, 446, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Arial", Font.PLAIN, 17));
		lblName.setBounds(275, 124, 181, 27);
		contentPane.add(lblName);
		
		JLabel lblNumberOfBooks = new JLabel("NUMBER OF BOOKS");
		lblNumberOfBooks.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNumberOfBooks.setBounds(275, 204, 181, 27);
		contentPane.add(lblNumberOfBooks);
		
		JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(522, 127, 202, 22);
		contentPane.add(textField);
		
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(522, 207, 202, 22);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("DONE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try {
				ResultSet rs=st.executeQuery("select * from books");
				String s=textField.getText();
				int no=Integer.parseInt(textField_1.getText());
				while(rs.next())
				{
					String s1=rs.getString("name"); 
					if(s1.equals(s))
					{
						no=rs.getInt("count")-no;
						String q="update books set count="+no+" where name='"+s+"'";
						Statement u=con.createStatement();
						u.executeUpdate(q);
						JFrame jf=new JFrame();
						JOptionPane.showMessageDialog(jf,"DONE");
					}
				}
			}
			catch(Exception ee) {}
			}
		});
		btnNewButton.setBounds(433, 316, 97, 25);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("<--GO BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				aop1 m=new aop1();
				m.setVisible(true);
				dispose();}
				catch(Exception ef) {}
			}
		});
		btnNewButton_1.setBounds(469, 513, 150, 25);
		contentPane.add(btnNewButton_1);
	}

}
