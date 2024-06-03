package auth;
import java.io.Serializable;

 public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	String fName, lName, address, contact, program;
	int rollNo;  
	int[] marks = new int[4]; // [Java, Math, English, Macro. Eco]
	String gender;
	
	/* This helps to create user without parameterized constructor */
	public User() {
		
	}
	
	/* This is parameterized constructor */
	public User(String fName, String lName, String address, String contact, String program, int rollNo, int[] marks,
			String gender) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.contact = contact;
		this.program = program;
		this.rollNo = rollNo;
		this.marks = marks;
		this.gender = gender;
	}
	
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getContact() {
		return contact;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getProgram() {
		return program;
	}
	
	public void setProgram(String program) {
		this.program = program;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public int[] getMarks() {
		return marks;
	}
	
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
}
