import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class BORROW extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BORROW frame = new BORROW();
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
	public BORROW() throws Exception{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1104, 672);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel= new JLabel("LIST OF BOOKS");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wtech","root","");
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("select * from books");
		 JLabel lblNewLabel_1[]=new JLabel[10];
		 JLabel label[] = new JLabel[10];
		 GroupLayout gl_contentPane[] = new GroupLayout[100];
		 int i=0,j=0,k=0;
		// gl_contentPane[k++]
		 gl_contentPane[k] = new GroupLayout(contentPane);
			gl_contentPane[k].setHorizontalGroup(
				gl_contentPane[k].createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane[k].createSequentialGroup()
						//.addGap(74)
						//.addComponent(lblNewLabel_1[i])
						//.addGap(76)
						//.addComponent(btnNewButton)
						//.addPreferredGap(ComponentPlacement.RELATED, 321, Short.MAX_VALUE)
						//.addComponent(label[j])// GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						//.addGap(75)
					//	.addComponent(button)// GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addGap(206))
					.addGroup(gl_contentPane[k].createSequentialGroup()
						.addGap(420)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(451, Short.MAX_VALUE))
			);
			gl_contentPane[k].setVerticalGroup(
				gl_contentPane[k].createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane[k].createSequentialGroup()
						.addGroup(gl_contentPane[k].createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane[k].createSequentialGroup()
								.addContainerGap().addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							//	.addGap(87+i*100)
								//.addGroup(gl_contentPane[k].createParallelGroup(Alignment.BASELINE)
									//.addComponent(lblNewLabel_1[i],GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									//.addComponent(label[j],GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								//	.addComponent(btnNewButton,GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
							//.addGroup(gl_contentPane[k].createSequentialGroup()
								//.addGap(126+i*100)
							//	.addComponent(button,GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
						//.addContainerGap(456, Short.MAX_VALUE))
			))));
			
		 while(rs.next())
		{
			String s=rs.getString("name");
			String s1=rs.getString("author");
		lblNewLabel_1[i]= new JLabel(s+" , "+s1);
		lblNewLabel_1[i].setBackground(UIManager.getColor("Tree.textForeground"));
		if(rs.next()) {
			s=rs.getString("name");
			s1=rs.getString("author");
		label[j]= new JLabel(s+" , "+s1);
		label[j].setBackground(Color.BLACK);
		}
		JButton btnNewButton = new JButton("CLICK HERE");
		
		JButton button = new JButton("CLICK HERE");
		gl_contentPane[k] = new GroupLayout(contentPane);
		gl_contentPane[k].setHorizontalGroup(
			gl_contentPane[k].createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane[k].createSequentialGroup()
					.addGap(74)
					.addComponent(lblNewLabel_1[i])
					.addGap(76)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 321, Short.MAX_VALUE)
					.addComponent(label[j])// GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addGap(75)
					.addComponent(button)// GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(206))
				.addGroup(gl_contentPane[k].createSequentialGroup()
					.addGap(420)
			//		.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(451, Short.MAX_VALUE))
		);
		gl_contentPane[k].setVerticalGroup(
			gl_contentPane[k].createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane[k].createSequentialGroup()
					.addGroup(gl_contentPane[k].createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane[k].createSequentialGroup()
							.addContainerGap()
							.addGap(87+i*100)
							.addGroup(gl_contentPane[k].createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1[i],GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(label[j],GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton,GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane[k].createSequentialGroup()
							.addGap(126+i*100)
							.addComponent(button,GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(456, Short.MAX_VALUE))
		);
		//JFrame jf=new JFrame();
		//JOptionPane.showMessageDialog(jf,s+s1);
		contentPane.setLayout(gl_contentPane[k]);
		i++;j++;k++;
		}
	}
}
