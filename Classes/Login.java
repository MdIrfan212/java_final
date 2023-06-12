package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import Interfaces.*;


public class Login extends JFrame implements ActionListener {
    JLabel l0, Signin, Name, pass, l4, userT,imagelb,logolb;
    MyTextField t1;
    MyPasswordField PassField;
    MyButton loginBtn, clearBtn, ExitBtn, RegisterBtn,backBtn;
    JPanel thisPannel;
    JCheckBox Showpass;
	//JFrame JFrame;
	//Panel panel;
    JComboBox<String> usertypeCombobox;


    public Login() {
        super("Log In");
		this.setBounds(0, 0, 1100, 685);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));
		this.setResizable(false);
		this.setVisible(true);
		
        thisPannel = new JPanel();
        thisPannel.setSize(new Dimension(1200, 700));
		Color background = new Color(255, 255, 255); // or any other RGB values

        thisPannel.setLayout(null);

       /* ImageIcon img = new ImageIcon("imageBG/Wc.jpg");
        JLabel background = new JLabel(img);
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());*/

        /*Dimension size = background.getPreferredSize();
        Image scaledImg = img.getImage().getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
        background.setIcon(new ImageIcon(scaledImg));*/

        // Sign In Label
		imagelb = new JLabel("");
		imagelb.setBounds(70, 10, 630, 628);
		imagelb.setIcon(new ImageIcon("imageBG/login1.jpg"));
		thisPannel.add(imagelb);
		
		logolb = new JLabel("");
		logolb.setBounds(672, 85, 176, 176);
		logolb.setIcon(new ImageIcon("imageBG/Us.png"));
		thisPannel.add(logolb);
		
       /* Signin = new JLabel("SIGN IN");
        Signin.setFont(new Font("Monospace", Font.BOLD, 30));
        Signin.setForeground(Color.BLUE);
        Signin.setBounds(280, 40, 200, 50);
        thisPannel.add(Signin);*/

        // User Name Label
        Name = new JLabel("Username");
        Name.setFont(new Font("Monospace", Font.PLAIN, 15));
        Name.setForeground(Color.blue);
        Name.setBounds(643, 285, 311, 57);
        thisPannel.add(Name);

        // Password Label
        pass = new JLabel("Password");
        pass.setFont(new Font("Monospace", Font.PLAIN, 15));
        pass.setForeground(Color.blue);
        pass.setBounds(643, 325, 311, 57);
        thisPannel.add(pass);

        // Password Field
        PassField = new MyPasswordField();
        PassField.setBounds(740, 343, 100, 25);
        thisPannel.add(PassField);

        // User Name Field
        t1 = new MyTextField();
        t1.setBounds(740, 303, 100, 25);
        thisPannel.add(t1);

        // User Type Label
        userT = new JLabel("User Type");
        userT.setFont(new Font("Monospace", Font.PLAIN, 15));
        userT.setForeground(Color.blue);
        userT.setBounds(643, 393, 150, 20);
        thisPannel.add(userT);

        // User Type ComboBox
        String[] usertype = { "Admin", "NCustomer", "PCustomer" };
        usertypeCombobox = new JComboBox<>(usertype);
        usertypeCombobox.setBounds(740, 393, 100, 25);
		usertypeCombobox.setCursor(new Cursor(Cursor.HAND_CURSOR));
		usertypeCombobox.setForeground(new Color(56,117,125));
		usertypeCombobox.setBorder(null);
        thisPannel.add(usertypeCombobox);
		usertypeCombobox.addActionListener(this);

        // Show Password CheckBox
		Showpass = new JCheckBox("Show Password");
		Showpass.setBounds(740, 426, 150, 25);
		Showpass.setFont(new Font("Monospace",Font.PLAIN,15));
		Showpass.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Showpass.setForeground(new Color(230, 212, 22));
		Showpass.setBorder(null);
		Showpass.setForeground(Color.blue);
		//Showpass.setForeground(Color.WHITE);
		Showpass.addActionListener(this);
		
		thisPannel.add(Showpass);

		// Login Button
		loginBtn = new MyButton("Log in");
		loginBtn.setFocusPainted(false);
		loginBtn.setBounds(646, 466, 80, 25);
		//loginBtn.addActionListener(this);
		//background.add(loginBtn);
		loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginBtn.setForeground(new Color(255, 55, 39));
		loginBtn.setRadius(10);

		//loginBtn.setBorder(null);;
		
		thisPannel.add(loginBtn);
		loginBtn.addActionListener(this);
		loginBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
                loginBtn.setBackground(new Color(25, 118, 211));
                loginBtn.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                loginBtn.setForeground(new Color(25, 118, 211));
                loginBtn.setBackground(new Color(255, 255, 255));
            }
        });

		// Clear Button
		clearBtn = new MyButton("Clear");
		clearBtn.setBounds(755, 466, 80, 25);
		clearBtn.setFont(new Font("Monospace",Font.PLAIN,15));
		clearBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clearBtn.setForeground(new Color(255, 55, 39));
		clearBtn.setRadius(10);
		clearBtn.addActionListener(this);
				clearBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
                clearBtn.setBackground(new Color(25, 118, 211));
                clearBtn.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                clearBtn.setForeground(new Color(25, 118, 211));
                clearBtn.setBackground(new Color(255, 255, 255));
            }
        });
		
		thisPannel.add(clearBtn);
		
		

		backBtn = new MyButton("");
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.setBorder(null);
		backBtn.setIcon(new ImageIcon("imageBG/back1.png"));
		backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backBtn.setBounds(5, 10, 60, 50);
		thisPannel.add(backBtn);
		backBtn.addActionListener(this);
		backBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
                backBtn.setBackground(new Color(25, 118, 211));
                backBtn.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                backBtn.setForeground(new Color(25, 118, 211));
                backBtn.setBackground(new Color(255, 255, 255));
            }
        });
		
		
		// Register Button
		RegisterBtn = new MyButton("Register");
		RegisterBtn.setBounds(658, 503, 170, 25);
		RegisterBtn.setFont(new Font("Monospace",Font.PLAIN,15));
		RegisterBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		RegisterBtn.setForeground(new Color(255, 55, 39));
		RegisterBtn.addActionListener(this);
		RegisterBtn.setRadius(10);
		thisPannel.add(RegisterBtn);
		RegisterBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
                RegisterBtn.setBackground(new Color(25, 118, 211));
                RegisterBtn.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                RegisterBtn.setForeground(new Color(25, 118, 211));
                RegisterBtn.setBackground(new Color(255, 255, 255));
            }
        });
		// Exit Button
		ExitBtn = new MyButton("");
		ExitBtn.setContentAreaFilled(false);
		ExitBtn.setFocusPainted(false);
		ExitBtn.setBorder(null);
		ExitBtn.setIcon(new ImageIcon("imageBG/exit1.png"));
		ExitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ExitBtn.setBounds(990, 10, 70, 50);
		ExitBtn.addActionListener(this);
		ExitBtn.setRadius(10);
		thisPannel.add(ExitBtn);
		ExitBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
                ExitBtn.setBackground(new Color(25, 118, 211));
                ExitBtn.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                ExitBtn.setForeground(new Color(25, 118, 211));
                ExitBtn.setBackground(new Color(255, 255, 255));
            }
        });
		//thisPannel.add(background);
		thisPannel.setBackground(background);

		this.add(thisPannel);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==loginBtn)
			{	
				String username = t1.getText();
				String password = new String(PassField.getPassword());
				String uType = (String) usertypeCombobox.getSelectedItem();
				//log in function
				if(!(username.isEmpty()) && !(password.isEmpty())){
				//implement interface start
				LoginFunction logC= new LoginFunction(username, password, uType);
				logC.matchAdmin(username, password, uType);
				//implement interface end
				  if (logC.isAuthenticated) {
					  if(logC.isAdmin){
						JOptionPane.showMessageDialog(this,"Admin Login successful");
						AdminView adV = new AdminView();
						this.setVisible(false);
						adV.setVisible(true);
					  }
					  else if(logC.isCustomerN){
						JOptionPane.showMessageDialog(this,"Customer Login successful");
						CustomerView cusV = new CustomerView();
						this.setVisible(false);
						cusV.setVisible(true);
					  }
					else if(logC.isCustomerP){
						JOptionPane.showMessageDialog(this,"Customer Login successful");
						PCustomerView pcusV = new PCustomerView();
						this.setVisible(false);
						pcusV.setVisible(true);
					  }
					 
				  } else {
						JOptionPane.showMessageDialog(this,"Invalid username or password or User Type" ,"Error", JOptionPane.ERROR_MESSAGE);
				  }
				}else{
					JOptionPane.showMessageDialog(this, "Login Failed!");					
				}
			}
			else if(e.getSource()==clearBtn)
			{
				//clear button function
				t1.setText("");
				PassField.setText("");
				
			}
			//show password function
			if (e.getSource() == Showpass) {
				if (Showpass.isSelected()) {
					PassField.setEchoChar((char) 0);
				} else {
					PassField.setEchoChar('*');
				}
			}

		else if(e.getSource()==ExitBtn)
			{
				System.exit(0);
			}

		else if(e.getSource()==RegisterBtn)
			{
				Register reg = new Register();
				this.setVisible(false);
				reg.setVisible(true);
			}
		else if(e.getSource()==backBtn)
			{
				Welcome wg = new Welcome();
				this.setVisible(false);
				wg.setVisible(true);
			}
	
	}

}
