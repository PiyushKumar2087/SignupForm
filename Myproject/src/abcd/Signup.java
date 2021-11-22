package abcd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.util.*;
import database.DB;

public class Signup {

	private JFrame frame;
	private JTextField tf2;
	private JPasswordField pass;
	DefaultTableModel model;
	private JTextField tf3;
	private JTextField tf5;
	private JLabel lblNewLabel_1;
	private JLabel image2;
	private JLabel image2_1;
	private JTextField tf4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection con=null;
	
	public Signup() {
		con=DB.dbconnect();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(169, 169, 169));
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1195, 784);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 33));
		lblNewLabel.setBounds(337, 68, 754, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel fn = new JLabel("First Name:");
		fn.setFont(new Font("Tahoma", Font.BOLD, 20));
		fn.setBounds(384, 224, 122, 36);
		frame.getContentPane().add(fn);
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("Tahoma", Font.BOLD, 20));
		password.setBounds(384, 400, 122, 36);
		frame.getContentPane().add(password);
		tf2 = new JTextField();
		tf2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf2.setBounds(532, 221, 216, 47);
		frame.getContentPane().add(tf2);
		tf2.setColumns(10);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pass.setBounds(532, 399, 216, 47);
		frame.getContentPane().add(pass);
		
		tf3 = new JTextField();
		tf3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf3.setColumns(10);
		tf3.setBounds(532, 284, 216, 47);
		frame.getContentPane().add(tf3);
		
		JLabel ln = new JLabel("Last Name:");
		ln.setFont(new Font("Tahoma", Font.BOLD, 20));
		ln.setBounds(384, 285, 122, 36);
		frame.getContentPane().add(ln);
		
		JLabel email = new JLabel("Email ID:");
		email.setFont(new Font("Tahoma", Font.BOLD, 20));
		email.setBounds(384, 465, 122, 36);
		frame.getContentPane().add(email);
		model=new DefaultTableModel();
		Object[] column= {"Fname","Mname","Lname","Password","Email ID"};
		Object[] row=new Object[11];
		model.setColumnIdentifiers(column);
		
		tf5 = new JTextField();
		tf5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf5.setColumns(10);
		tf5.setBounds(532, 464, 216, 47);
		frame.getContentPane().add(tf5);
		
		lblNewLabel_1 = new JLabel("NIT Jalandhar ");
		lblNewLabel_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_1.setBackground(new Color(176, 196, 222));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 37));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(337, -1, 754, 81);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		JLabel un = new JLabel("Username");
		un.setFont(new Font("Tahoma", Font.BOLD, 20));
		un.setBounds(384, 345, 122, 36);
		frame.getContentPane().add(un);
		
		tf4 = new JTextField();
		tf4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tf4.setColumns(10);
		tf4.setBounds(532, 342, 216, 47);
		frame.getContentPane().add(tf4);
		
		JButton submit = new JButton("SignUp");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals("")||tf5.getText().equals("")||pass.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please, fill all the information.");
					}
					else
					{
				     String first=tf2.getText();
				     String last=tf3.getText();
				     String user=tf4.getText();
				     String pwd=pass.getText();
				     String ei=tf5.getText();
				
					PreparedStatement pst=(PreparedStatement) con.prepareStatement("insert into signup(fname,lname,userid,password,email)values(?,?,?,?,?)");
				    pst.setString(1,first);
				    pst.setString(2,last);
				    pst.setString(3,user);
				    pst.setString(4,pwd);
				    pst.setString(5,ei);
				    pst.executeUpdate();
				    JOptionPane.showMessageDialog(null,"Thank you, your form has been submitted.");
				   tf2.setText("");
				   tf3.setText("");
				   tf4.setText("");
				   pass.setText("");
				   tf5.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		submit.setFont(new Font("Tahoma", Font.BOLD, 24));
		submit.setBounds(553, 583, 124, 36);
		frame.getContentPane().add(submit);
		
		

	}
}

