package auth;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Authentication implements ActionListener {
	JFrame jframe;
	JTextField textUser;
	JTextField textPassword;
	JButton login;
	JButton register;
	
	Authentication() {
		jframe = new JFrame("Authentication");
		jframe.setSize(395, 180);
		
		JPanel jPanel = new JPanel();
		GridLayout gridLayout = new GridLayout(3, 2, 10, 10);
		
		JLabel lblUser = new JLabel("Username ");
		JLabel lblPassword = new JLabel("Password ");
		
		login = new JButton();
		register = new JButton();
		
		login.setText("Login");
		login.setSize(180, 30);
		
		register.setText("Register");
		register.setSize(180, 30);
		
		textUser = new JTextField();
		textPassword = new JTextField();
		
		login.addActionListener(this);
		register.addActionListener(this);
		
		textUser.setSize(180, 30);
		textPassword.setSize(180, 30);
		
		lblUser.setSize(180, 30);
		lblPassword.setSize( 180, 30);
		
		jPanel.add(lblUser);
		jPanel.add(textUser);
		
		jPanel.add(lblPassword);
		jPanel.add(textPassword);
		
		jPanel.add(login);
		jPanel.add(register);
		
		
		jPanel.setBorder(new EmptyBorder(10, 10, 10, 15));
		jframe.setContentPane(jPanel);
		jframe.setLayout(gridLayout);
		jframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Authentication();		
	}
	
	public void actionPerformed(ActionEvent e) {
		String username = textUser.getText().toString();
		String password = textPassword.getText().toString();
		
		if(e.getSource() == login) {
			/* When user logins, retrieve user-name and password and compare them with input */
			try {
				BufferedReader br = new BufferedReader(new FileReader("./user.txt"));
				String line = br.readLine();
				String[] text = line.split(" ");
				
				if(username.equals(text[0]) && password.equals(text[1])) {
					new Dashboard();
					JOptionPane.showMessageDialog(null, "Successfully logged in!", "Authentication", JOptionPane.INFORMATION_MESSAGE);
					jframe.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Error logging in!", "Authentication", JOptionPane.ERROR_MESSAGE);
				}
				
				br.close();
			}catch(IOException err) {
				JOptionPane.showMessageDialog(null, "You must register first!", "Error opening file", JOptionPane.ERROR_MESSAGE);
			}
			
		}else if(e.getSource() == register) {
			/* When user registers, take out user-name and password then write it to file */
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("./user.txt", false));
				bw.write(username + ' ' + password);
				bw.flush();
				bw.close();
				JOptionPane.showMessageDialog(null, "Successfully registered!", "Authentication", JOptionPane.INFORMATION_MESSAGE);
			}catch(IOException err) {
				err.printStackTrace();
			}
		}
	}
}
