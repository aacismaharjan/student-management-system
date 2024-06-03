package auth;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Display {
	JFrame jframe;
	DefaultTableModel model = new DefaultTableModel();
	
	Display() {
		jframe = new JFrame("Users");
		jframe.setSize(1200, 500);
		
		/* This adds table header */
		model.addColumn("First Name");
		model.addColumn("Last Name");
		model.addColumn("Gender");
		model.addColumn("Address");
		model.addColumn("Contact");
		model.addColumn("Roll no");
		model.addColumn("Program");
		model.addColumn("Java");
		model.addColumn("Math");
		model.addColumn("English");
		model.addColumn("Macro Economics");
		
		
		JButton viewButton = new JButton("View Profile");
		viewButton.setBounds(0, 0, 100, 30);
		
		JTable table=new JTable(model);
		ArrayList<User> list=new ArrayList<User>();
		
		FileOperation fo= new FileOperation();
		list=fo.readFile();
		
		
		/* This adds table body */
		for(User user: list) {
			model.addRow(new Object[]{ user.getfName(),
				user.getlName(),
				user.getGender(),
				user.getAddress(),
				user.getContact(),
				user.getRollNo(),
				user.getProgram(),
				user.getMarks()[0],
				user.getMarks()[1],
				user.getMarks()[2],
				user.getMarks()[3],
				});
		}
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.setBounds(30, 40, 600, 600);
		
		JScrollPane sp = new JScrollPane(table);
		jframe.add(sp);
		jframe.setVisible(true);
		
	}
	
	/* This is for testing purpose only */
//	public static void main(String[] args) {
//		Display d = new Display();
//	}
}
