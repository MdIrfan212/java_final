package Classes;

import Interfaces.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import javax.swing.JOptionPane;
import java.io.IOException;
import static javax.swing.JOptionPane.showMessageDialog;

public class RegistrationFunction implements IRegistrationPerforme {
	int id = this.getNextId();
	String name;
	String password;
	String confirm_password ; 
	String email;
	String dob ;	
	String age ;
	String gender;
	String customerType;
	String country;
    RegistrationFunction(String name, String password, String confirm_password,	String email,String dob,String gender,String customerType,String country,String age) {
        this.name = name;
        this.password = password;
		this.confirm_password= confirm_password;
		this.email= email;
		this.dob= dob;
		this.age= age;
		this.gender= gender;
		this.customerType= customerType;
		this.country= country;
    }

    public void register(String name, String password, String confirm_password,	String email,String dob,String gender,String customerType,String country,String age) {
			try {
				FileWriter fw = new FileWriter(".\\appData\\registration.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(id + ",");
				bw.write(name + ",");
				bw.write(password + ",");
				bw.write(customerType + ",");
				bw.write(email + ",");
				bw.write(dob + ",");
				bw.write(age + ",");
				bw.write(gender + ",");
				bw.write(country + "\n");
				bw.close();
				fw.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
    }
	
	public int getNextId() {
        int maxId = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(".\\appData\\registration.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                if (id > maxId) {
                    maxId = id;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        return maxId + 1;
    }
}
