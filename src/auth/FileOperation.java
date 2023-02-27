package auth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileOperation {
	void writeFile(User user) {
		/* take out all users, append user to the list and write all at once again */
		try {
			ArrayList<User> users = this.readFile();
			users.add(user);
			
			FileOutputStream f = new FileOutputStream(new File("./users.dat"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.reset();
			for(User userOne: users) {
				o.writeObject(userOne);
			}
			o.close();
			f.close();
		}catch(Exception err) {
			System.out.println("Unable to write to a file.");
		}
	}
	
	void replaceFile(User user, User oldUser) {
		/* Take out users from db file, compare it with oldUser, if match, replace it with user object and
		 * write it again to the file if not, do not replace. */
		try {
			ArrayList<User> users = this.readFile();
			int flag = 0;
			
			FileOutputStream f = new FileOutputStream(new File("./users.dat"), false);
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.reset();
			
			for(User userOne: users) {
				if(userOne.getContact().equals(oldUser.getContact()) && flag == 0) {
					o.writeObject(user);
					flag=1;
					continue;
				}
				o.writeObject(userOne);
			}
			
			o.close();
			f.close();
		}catch(Exception err) {
			err.printStackTrace();
			System.out.println("Unable to write to a file.");
		}
	}
	
	ArrayList<User> readFile() {
		ArrayList<User> list = new ArrayList<User>();
		
		/* Read all users from db file until there is no data left, and add it to users list */
		try {
			FileInputStream fi = new FileInputStream(new File("./users.dat"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			while(fi.available() > 0) {
				User user = (User) oi.readObject();
				list.add(user);
			}
			
		}catch(Exception er) {
			System.out.println("No Records found!");
			return list;
		}
		return list;
	}
	
	void removeFile(User removeUser) {
		/* Take out users from db file, then write all objects except removeUser object */
		try {
			ArrayList<User> users = this.readFile();
			int flag = 0;
			
			FileOutputStream f = new FileOutputStream(new File("./users.dat"), false);
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.reset();
			
			for(User userOne: users) {
				if(userOne.getContact().equals(removeUser.getContact()) && flag == 0) {
					flag = 1;
					continue;
				}
				o.writeObject(userOne);
				
			}
			
			if(flag == 1) {
				System.out.println("File has been deleted.");
			}else {
				System.out.println("Unable to delete a file.");
			}
			
			o.close();
			f.close();
		}catch(Exception err) {
			err.printStackTrace();
			System.out.println("Unable to write to a file.");
		}
	}
}
