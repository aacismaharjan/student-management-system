package auth;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Dashboard implements ActionListener {
	JFrame jframe;
	DefaultTableModel model = new DefaultTableModel();
	
	JTextField textUser;
	JTextField textPassword;
	JTextField textName;
	JTextField textPhone;
	JTextField txtSearch;
	
	JButton editBtn;
	JButton cancel;
	
	
	Dashboard() {
		jframe = new JFrame("Dashboard");
		jframe.setSize(800, 300);
		
		JPanel jPanel = new JPanel();
		GridLayout gl = new GridLayout(4, 2, 10, 10);
		
		JPanel jOperationPanel = new JPanel();
		GridLayout operationLayout = new GridLayout(1, 2, 10, 10);
		
		JLabel lblGreeting = new JLabel("Welcome, " + this.getUsername() + "!");
		
		JButton displayBtn = new JButton("Display Users");
		JButton addBtn = new JButton("Add User");
		cancel = new JButton("Cancel");
		
		txtSearch = new JTextField();
		editBtn = new JButton("Search User");
		
		textName = new JTextField();
		textPhone = new JTextField();
	
		displayBtn.addActionListener(this);
		addBtn.addActionListener(this);
		editBtn.addActionListener(this);
		cancel.addActionListener(this);
		
		lblGreeting.setBounds(10, 10, 180, 30);
		
		
		jPanel.add(new JLabel("Edit Section: "));
		jPanel.add(new JLabel(""));
		jPanel.add(new JLabel("First Name: "));
		jPanel.add(textName);
		jPanel.add(new JLabel("Phone: "));
		jPanel.add(textPhone);
		jPanel.add(editBtn);
		jPanel.add(cancel);
		jPanel.setBounds(0, 40, 390, 220);
		jPanel.setBorder(new EmptyBorder(10, 10, 10, 15));
		jPanel.setLayout(gl);
		jPanel.setBackground(new Color(225, 225, 225));
		
		JPanel addOrDisplayPanel = new JPanel();
		addOrDisplayPanel.setLayout(new GridLayout(2, 1, 10, 10));
		addOrDisplayPanel.add(addBtn);
		addOrDisplayPanel.add(displayBtn);
		
		jOperationPanel.add(jPanel);
		jOperationPanel.add(addOrDisplayPanel);
		jOperationPanel.setBounds(0, 40, 800, 220);
		jOperationPanel.setLayout(operationLayout);
		jOperationPanel.setBorder(new EmptyBorder(10, 10, 10, 15));
		
		jframe.add(lblGreeting);
		jframe.add(jOperationPanel);
		
		jframe.setLayout(null);
		jframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Dashboard();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Display Users") {
			new Display();
		}else if(e.getActionCommand() == "Add User") {
			UserForm userForm = new UserForm();
		}else if(e.getSource() == editBtn) {
			String firstName = textName.getText().toString();
			String contactNum = textPhone.getText().toString();
			
			ArrayList<User> list=new ArrayList<User>();
			FileOperation fo= new FileOperation();
			int flag=0;
			User matchedUser = null;
			
			list=fo.readFile();
			
			for(User user: list) {
				if(user.getContact().equals(contactNum) && user.getfName().equals(firstName)) {
					System.out.println("MATCHED" + user.toString());
					matchedUser = user;
					flag = 1;
					break;
				}
			}
			
			if(flag == 0) {
				JOptionPane.showMessageDialog(null, "No user found with above first name and contact number. Please try again!", "Edit User", JOptionPane.WARNING_MESSAGE);
			}else if(matchedUser != null && flag == 1) {
				new UserForm(matchedUser);
				
				textName.setText("");
				textPhone.setText("");
			}
		}else if(e.getSource() == cancel) {
			jframe.dispose();
		}
	}
	
	/* Gets user-name from login file */
	public String getUsername() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("./user.txt"));
			String[] text = br.readLine().split(" ");
			br.close();
			
			return text[0];
		}catch(IOException err) {
			err.printStackTrace();
			return "N/A";
		}
	}
	
}


// Grid view for CRUD Operation
//JPanel userListPanel = new JPanel();
//GridLayout userListGrid = new GridLayout(8, 2, 10, 10);
//int[] rangee = {1,2};
//for(int i: rangee) {
//	userListPanel.add(new JLabel("Name: "));
//	userListPanel.add(new JLabel("Aashish Maharjan"));
//	userListPanel.add(new JLabel("Section: "));
//	userListPanel.add(new JLabel("Grit/Garnet"));
//	userListPanel.add(new JLabel("Address: "));
//	userListPanel.add(new JLabel("Bafal Kalimati"));
//	userListPanel.add(new JButton("Edit"));
//	userListPanel.add(new JButton("Delete"));
//}
//userListPanel.setBounds(0, 130, 390, 360);
//userListPanel.setBorder(new EmptyBorder(10, 10, 10, 15));
//userListPanel.setLayout(userListGrid);
//jframe.add(userListPanel);