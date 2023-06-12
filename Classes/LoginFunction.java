package Classes;

import Interfaces.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class LoginFunction implements ILoginPerforme {
    String username;
    String password;
	String uType;
	boolean isAuthenticated = false;
	boolean isAdmin = false;
	boolean isCustomerN = false;
	boolean isCustomerP = false;

    LoginFunction(String username, String password, String uType) {
        this.username = username;
        this.password = password;
		this.uType= uType;

    }

    public void matchAdmin(String username, String password, String uType) {
        String fileName = (".\\appData\\registration.txt");

	  try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		 String line;
		 while ((line = br.readLine()) != null) {
			String[] parts = line.split(",");
			if (username.equals(parts[1]) && password.equals(parts[2])) {
			   if(uType.equals("Admin")){
				   if(parts[3].equals("Admin")){
					   isAuthenticated = true;
					   isAdmin=true;  
				   }
			   }else if(uType.equals("NCustomer")){
				   if(parts[3].equals("NCustomer")){
					   isAuthenticated = true;
					   isCustomerN=true;
				   }
			   }else if(uType.equals("PCustomer")){
				   if(parts[3].equals("PCustomer")){
					   isAuthenticated = true;
					   isCustomerP=true;
				   }
			   }
			   break;
			}
		 }
	  } catch (IOException exp) {
		 exp.printStackTrace();
	  }
    }
}
