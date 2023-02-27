package auth;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserForm implements ActionListener {
	JFrame jframe;
	JTextField textfName;
	JTextField textlName;
	JTextField textAddress;
	JTextField textContact;
	JTextField textProgram;
	JTextField textRollNo;
	JTextField textJavaMarks;
	JTextField textEngMarks;
	JTextField textMathMarks;
	JTextField textEcoMarks;
	JTextField textGender;
	
	User editUser = null;
	
	JRadioButton maleRadio;
	JRadioButton femaleRadio;
	
	JButton addUser;
	JButton cancel;
	
	JComboBox<String> comboProgram;
	
	UserForm(User user) {
		this();
		this.editUser = user;
		jframe.setTitle("User Registration / Edit");
		addUser.setText("Update User");
		cancel.setText("Delete User");
		cancel.setForeground(new Color(255, 0, 0));
		
		textfName.setText(editUser.getfName());
		textlName.setText(editUser.getlName());
		textAddress.setText(editUser.getAddress());
		textContact.setText(editUser.getContact());
		textProgram.setText(editUser.getProgram());
		textRollNo.setText(editUser.getRollNo() + "");
		textJavaMarks.setText(editUser.getMarks()[0] + "");
		textEngMarks.setText(editUser.getMarks()[1] + "");
		textMathMarks.setText(editUser.getMarks()[2] + "");
		textEcoMarks.setText(editUser.getMarks()[3] + "");
		
		if(editUser.getGender() == "Male") {
			maleRadio.setSelected(true);
		}else {
			femaleRadio.setSelected(true);
		}
		
		comboProgram.setSelectedItem(editUser.getProgram());
	}
	
	UserForm() {
		jframe = new JFrame(this.editUser != null ? "User Registration / Edit": "User Registration" );
		jframe.setSize(395, 550);
		
		JPanel jp = new JPanel();
		
		GridLayout gl = new GridLayout(12,2, 10, 10);
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 10, 10);
		
		
		JLabel lblUser = new JLabel("First Name: ");
		JLabel lblPassword = new JLabel("Last Name: ");
		JLabel lblAddress = new JLabel("Address: ");
		JLabel lblContact = new JLabel("Contact: ");
		JLabel lblProgram = new JLabel("Program: ");
		JLabel lblRollNo = new JLabel("Roll Number: ");
		JLabel lblJavaMarks = new JLabel("Java: ");
		JLabel lblEngMarks = new JLabel("English: ");
		JLabel lblMathMarks = new JLabel("Math: ");
		JLabel lblEcoMarks = new JLabel("Macro. Eco: ");
		
		JLabel lblGender = new JLabel("Gender: ");
		
		
//		Radio Buttons
		maleRadio = new JRadioButton("Male");
		femaleRadio = new JRadioButton("Female");
		
		ButtonGroup rg = new ButtonGroup();
		rg.add(maleRadio);
		
		JPanel radioPanel = new JPanel();
		radioPanel.add(maleRadio);
		radioPanel.add(femaleRadio);
		radioPanel.setLayout(fl);
		rg.add(femaleRadio);
	
//		ComboBox
		comboProgram = new JComboBox<String>();
		comboProgram.addItem("Grit/Garnet");
		comboProgram.addItem("Fourier");
		comboProgram.addItem("Fusion");
		
		addUser = new JButton();
		cancel = new JButton();
		
		addUser.setText("Add User");
		addUser.setBounds(10, 330, 180, 30);
		
		cancel.setText("Cancel");
		cancel.setBounds(200, 330, 180, 30);
		
		
		textfName = new JTextField();
		textlName = new JTextField();
		textAddress = new JTextField();
		textContact = new JTextField();
		textProgram = new JTextField();
		textRollNo = new JTextField();
		textJavaMarks = new JTextField();
		textEngMarks = new JTextField();
		textMathMarks = new JTextField();
		textEcoMarks = new JTextField();
		textGender = new JTextField();
		
		
		addUser.addActionListener(this);
		cancel.addActionListener(this);
		
		textfName.setSize(180, 30);
		textlName.setSize(180, 30);
		textAddress.setSize(180, 30);
		textContact.setSize(180, 30);
		textProgram.setSize(180, 30);
		textRollNo.setSize(180, 30);
		textJavaMarks.setSize(180, 30);
		textEngMarks.setSize(180, 30);
		textMathMarks.setSize(180, 30);
		textEcoMarks.setSize(180, 30);
		textGender.setSize(180, 30);
		
		lblUser.setSize(180, 30);
		lblPassword.setSize(180, 30);
		lblAddress.setSize(180, 30);
		lblContact.setSize(180, 30);
		lblProgram.setSize(180, 30);
		lblRollNo.setSize(180, 30);
		lblJavaMarks.setSize(180, 30);
		lblEngMarks.setSize(180, 30);
		lblMathMarks.setSize(180, 30);
		lblEcoMarks.setSize(180, 30);
		lblGender.setSize(180, 30);
		
		jp.add(lblUser);
		jp.add(textfName);
		
		jp.add(lblPassword);
		jp.add(textlName);
		
		jp.add(lblAddress);
		jp.add(textAddress);
		
		
		jp.add(lblContact);
		jp.add(textContact);
		
		jp.add(lblProgram);
		jp.add(comboProgram);
		
		jp.add(lblRollNo);
		jp.add(textRollNo);
		
		jp.add(lblGender);
		jp.add(radioPanel);
		
		jp.add(lblJavaMarks);
		jp.add(textJavaMarks);
		
		jp.add(lblEngMarks);
		jp.add(textEngMarks);
		
		jp.add(lblMathMarks);
		jp.add(textMathMarks);
		
		jp.add(lblEcoMarks);
		jp.add(textEcoMarks);
				
		jp.add(addUser);
		jp.add(cancel);
		
		jp.setBorder(new EmptyBorder(10, 10, 10, 15));	
		
		jframe.setContentPane(jp);
		jframe.setLayout(gl);
		jframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		new UserForm();		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addUser) {
			String fName = textfName.getText().toString();
			String lName = textlName.getText().toString();
			String address = textAddress.getText().toString();
			String contact = textContact.getText().toString();
			String program = (String) comboProgram.getSelectedItem();
			int rollNo = Integer.parseInt(textRollNo.getText().toString());

			String gender;
			if(maleRadio.isSelected()) {
				gender = "Male";
			}else {
				gender = "Female";
			}
			
			int javaMarks = Integer.parseInt(textJavaMarks.getText().toString());
			int engMarks = Integer.parseInt(textEngMarks.getText().toString());
			int mathMarks = Integer.parseInt(textMathMarks.getText().toString());
			int ecoMarks = Integer.parseInt(textEcoMarks.getText().toString());
			
			int[] marks = {javaMarks, engMarks, mathMarks, ecoMarks};
			
			try {
				User user = new User(fName, lName, address, contact, program, rollNo, marks, gender);
				
				FileOperation fo = new FileOperation();
				
				if(editUser != null) {
					fo.replaceFile(user, editUser);
				}else {
					fo.writeFile(user);
				}
				
				
				textfName.setText("");
				textlName.setText("");
				textAddress.setText("");
				textContact.setText("");
				textJavaMarks.setText("");
				textEngMarks.setText("");
				textMathMarks.setText("");
				textEcoMarks.setText("");
				textRollNo.setText("");
				
				JOptionPane.showMessageDialog(null, "User has been registered!", "User Registration", JOptionPane.INFORMATION_MESSAGE);
			}catch(Exception err) {
				err.printStackTrace();
			}
			jframe.dispose();
			
		}else if(e.getSource() == cancel) {
			if(editUser != null) {
				FileOperation fo = new FileOperation();
				fo.removeFile(editUser);
				jframe.dispose();
				JOptionPane.showMessageDialog(null,  "User has been deleted.", "User Form", JOptionPane.INFORMATION_MESSAGE);
			}else {
				jframe.dispose();
			}
		}
	}
}
