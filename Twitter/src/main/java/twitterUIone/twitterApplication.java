package twitterUIone;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;

import action.Twitter.follow;
import action.Twitter.reportTweet;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class twitterApplication {

	private JFrame frmTwitterApplication;
	private JTextField userName;
	private JPasswordField password;
	private JTextField urlHttps;
	private JComboBox selectOperation;
	private JTextPane textPaneTrue;
	private JTextPane textPaneFalse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					twitterApplication window = new twitterApplication();
					window.frmTwitterApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public twitterApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTwitterApplication = new JFrame();
		frmTwitterApplication.setTitle("Twitter Application");
		frmTwitterApplication.setResizable(false);
		frmTwitterApplication.getContentPane().setBackground(new Color(30, 144, 255));
		frmTwitterApplication.getContentPane().setForeground(new Color(30, 144, 255));
		frmTwitterApplication.setIconImage(Toolkit.getDefaultToolkit().getImage(twitterApplication.class.getResource("/photo/logogh.png")));
		frmTwitterApplication.setBounds(100, 100, 799, 443);
		frmTwitterApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTwitterApplication.getContentPane().setLayout(null);
		
		userName = new JTextField();
		userName.setBackground(Color.WHITE);
		userName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userName.setBounds(25, 42, 321, 58);
		frmTwitterApplication.getContentPane().add(userName);
		userName.setColumns(10);
		
		password = new JPasswordField();
		password.setBackground(Color.WHITE);
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setBounds(25, 153, 321, 58);
		frmTwitterApplication.getContentPane().add(password);
		
		JTextPane txtpnTwitterUserName = new JTextPane();
		txtpnTwitterUserName.setEditable(false);
		txtpnTwitterUserName.setBackground(new Color(30, 144, 255));
		txtpnTwitterUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnTwitterUserName.setText("Twitter User Name");
		txtpnTwitterUserName.setBounds(25, 11, 288, 20);
		frmTwitterApplication.getContentPane().add(txtpnTwitterUserName);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setEditable(false);
		txtpnPassword.setBackground(new Color(30, 144, 255));
		txtpnPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnPassword.setText("Password");
		txtpnPassword.setBounds(25, 122, 288, 20);
		frmTwitterApplication.getContentPane().add(txtpnPassword);
		
		urlHttps = new JTextField();
		urlHttps.setBackground(Color.WHITE);
		urlHttps.setFont(new Font("Tahoma", Font.PLAIN, 20));
		urlHttps.setBounds(412, 42, 321, 58);
		frmTwitterApplication.getContentPane().add(urlHttps);
		urlHttps.setColumns(10);
		
		selectOperation = new JComboBox();
		selectOperation.setMaximumRowCount(3);
		selectOperation.setBackground(Color.WHITE);
		selectOperation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		selectOperation.setModel(new DefaultComboBoxModel(new String[] {"Select", "Follow", "Report Tweet"}));
		selectOperation.setBounds(412, 153, 321, 58);
		frmTwitterApplication.getContentPane().add(selectOperation);
		
		JTextPane txtpnPleaseEnterA = new JTextPane();
		txtpnPleaseEnterA.setEditable(false);
		txtpnPleaseEnterA.setText("Please Enter a valid Url");
		txtpnPleaseEnterA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnPleaseEnterA.setBackground(new Color(30, 144, 255));
		txtpnPleaseEnterA.setBounds(412, 11, 288, 20);
		frmTwitterApplication.getContentPane().add(txtpnPleaseEnterA);
		
		JTextPane txtpnPleaseSelectAn = new JTextPane();
		txtpnPleaseSelectAn.setEditable(false);
		txtpnPleaseSelectAn.setText("Please select an operation");
		txtpnPleaseSelectAn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnPleaseSelectAn.setBackground(new Color(30, 144, 255));
		txtpnPleaseSelectAn.setBounds(412, 122, 288, 32);
		frmTwitterApplication.getContentPane().add(txtpnPleaseSelectAn);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(269, 266, 241, 58);
		frmTwitterApplication.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(selectOperation.getSelectedItem().equals("Follow")) {
						follow.followMain(urlHttps.getText(),userName.getText(),password.getText());
						textPaneTrue.setText("Item has been Followed Successfully");		
					}
					
					else if(selectOperation.getSelectedItem().equals("Report Tweet")) {
						reportTweet.reportTweetMain(urlHttps.getText(),userName.getText(),password.getText());
						textPaneTrue.setText("Item has been Loved Successfully");		
					}
					
				
					else
						textPaneFalse.setText("Please select an operation");
					
				}
			});
		
		textPaneFalse = new JTextPane();
		textPaneFalse.setBackground(new Color(30, 144, 255));
		textPaneFalse.setForeground(Color.RED);
		textPaneFalse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPaneFalse.setBounds(186, 346, 413, 25);
		frmTwitterApplication.getContentPane().add(textPaneFalse);
		
		textPaneTrue = new JTextPane();
		textPaneTrue.setForeground(new Color(0, 255, 0));
		textPaneTrue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPaneTrue.setBackground(new Color(30, 144, 255));
		textPaneTrue.setBounds(186, 346, 413, 25);
		frmTwitterApplication.getContentPane().add(textPaneTrue);
	}
}
