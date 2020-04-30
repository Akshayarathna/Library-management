import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UOP extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UOP frame = new UOP("");
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
	static String ss="";
	public UOP(String s) {
		initComponents();
		ss=s;
	}
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1103, 673);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("activeCaption"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("WELCOME "+ss+" WHAT TO DO?");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		JLabel lblBorrowBook = new JLabel("BORROW BOOK");
		lblBorrowBook.setHorizontalAlignment(SwingConstants.LEFT);
		lblBorrowBook.setForeground(SystemColor.info);
		lblBorrowBook.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		
		JLabel lblReturnBook = new JLabel("RETURN BOOK");
		lblReturnBook.setHorizontalAlignment(SwingConstants.LEFT);
		lblReturnBook.setForeground(SystemColor.info);
		lblReturnBook.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		
		JLabel lblPayFees = new JLabel("RENEW");
		lblPayFees.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayFees.setForeground(SystemColor.info);
		lblPayFees.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		
		JLabel lblPayFine = new JLabel("MEMBERSHIP FEES");
		lblPayFine.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayFine.setForeground(SystemColor.info);
		lblPayFine.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		
		JButton button = new JButton("CLICK HERE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bor b=new bor(ss);
				b.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBackground(SystemColor.activeCaption);
		
		JButton button_1 = new JButton("CLICK HERE");
		button_1.setForeground(Color.BLUE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_1.setBackground(SystemColor.activeCaption);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnbook b=new returnbook(ss);
				b.setVisible(true);
				dispose();
			}
		});
		JButton button_2 = new JButton("CLICK HERE");
		button_2.setForeground(Color.BLUE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_2.setBackground(SystemColor.activeCaption);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkfine b=new checkfine(ss);
				b.setVisible(true);
				dispose();
			}
		});
		JButton button_3 = new JButton("CLICK HERE");
		button_3.setForeground(Color.BLUE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_3.setBackground(SystemColor.activeCaption);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fees b=new fees(ss);
				b.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(350)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(306)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblReturnBook, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblBorrowBook, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_1))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(64)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
												.addComponent(button, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))))
								.addComponent(lblPayFees, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPayFine, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(282, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(85)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBorrowBook, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblReturnBook, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addComponent(lblPayFees, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(68)
							.addComponent(lblPayFine, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(208, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
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
	}

}
