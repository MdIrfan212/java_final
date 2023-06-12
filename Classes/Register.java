package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Register extends JFrame implements ActionListener
{
    JLabel l1, Name, Email, Age, Gender, Country,CusType, DOB;
    MyTextField NameTextFeild, EmailTextFeild, AgeTextFeild;
    MyButton registerBtn, exitBtn, backBtn;
    JPanel thisPannel;
    JRadioButton maleRadioButton, femaleRadioButton;
    JRadioButton NcusRadioButton, PcusRadioButton;
    JComboBox<String> countryComboBox, dayComboBox, monthComboBox, yearComboBox;
    MyPasswordField jthisPannel, jp2;

    public Register()
    {
        super(" CREATE YOUR ACCOUNT ");
        this.setBounds(0, 0, 1100, 685);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));
		this.setResizable(false);
		this.setVisible(true);

        thisPannel = new JPanel();
        thisPannel.setSize(new Dimension(1200, 720));
		Color background = new Color(255, 255, 255);
        thisPannel.setLayout(null);

		/*ImageIcon img = new ImageIcon("imageBG/admin2.jpg");
		JLabel backgroundLabel = new JLabel("", img, JLabel.CENTER);
		thisPannel.add(backgroundLabel);
		backgroundLabel.setBounds(0, 0, 1200, 700);

       ImageIcon img = new ImageIcon("imageBG/Ww.jpg");
        JLabel background = new JLabel(img);
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        Dimension size = background.getPreferredSize();
        Image scaledImg = img.getImage().getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
        background.setIcon(new ImageIcon(scaledImg));
		*/

       // thisPannel.add().add(background); // Add the background JLabel to the content pane of the JFrame
		
       /*l1 = new JLabel("CREATE YOUR ACCOUNT");
        l1.setFont(new Font("Monospace", Font.BOLD, 20));
        l1.setForeground(Color.CYAN);
        l1.setBounds(400, 50, 350, 50);
        thisPannel.add(l1);
		*/
	Name = new JLabel("Name");
	Name.setFont(new Font("Monospace", Font.PLAIN, 15));
	Name.setForeground(Color.red);
	Name.setBounds(480, 150, 150, 20);
	thisPannel.add(Name);

	NameTextFeild = new MyTextField();
	NameTextFeild.setBounds(550, 150, 150, 25);
	thisPannel.add(NameTextFeild);

	Email = new JLabel("Email");
	Email.setFont(new Font("Monospace", Font.PLAIN, 15));
	Email.setForeground(Color.red);
	Email.setBounds(480, 200, 150, 20);
	thisPannel.add(Email);

	EmailTextFeild = new MyTextField();
	EmailTextFeild.setBounds(550, 200, 150, 25);
	thisPannel.add(EmailTextFeild);

	DOB = new JLabel("DOB");
	DOB.setFont(new Font("Monospace", Font.PLAIN, 15));
	DOB.setForeground(Color.red);
	DOB.setBounds(480, 250, 150, 20);
	thisPannel.add(DOB);

	String[] days = new String[31];
	for (int i = 0; i < 31; i++) {
		days[i] = Integer.toString(i + 1);
	}
	dayComboBox = new JComboBox<>(days);
	dayComboBox.setBounds(550, 250, 50, 25);
	thisPannel.add(dayComboBox);

	String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	monthComboBox = new JComboBox<>(months);
	monthComboBox.setBounds(600, 250, 100, 25);
	thisPannel.add(monthComboBox);

	String[] years = new String[100];
	for (int i = 0; i < 100; i++) {
		years[i] = Integer.toString(1970 + i);
	}
	yearComboBox = new JComboBox<>(years);
	yearComboBox.setBounds(700, 250, 80, 25);
	thisPannel.add(yearComboBox);

	Age = new JLabel("Age");
	Age.setFont(new Font("Monospace", Font.PLAIN, 15));
	Age.setForeground(Color.red);
	Age.setBounds(480, 300, 150, 20);
	thisPannel.add(Age);

	AgeTextFeild = new MyTextField();
	AgeTextFeild.setBounds(550, 300, 150, 25);
	thisPannel.add(AgeTextFeild);
	
	jthisPannel = new MyPasswordField();
	jthisPannel.setBounds(550, 400, 150, 25);
	thisPannel.add(jthisPannel);

	jp2 = new MyPasswordField();
	jp2.setBounds(550, 450, 150, 25);
	thisPannel.add(jp2);

	JLabel passwordLabel = new JLabel("Password");
	passwordLabel.setFont(new Font("Monospace", Font.PLAIN, 15));
	passwordLabel.setForeground(Color.RED);
	passwordLabel.setBounds(480, 400, 150, 20);
	thisPannel.add(passwordLabel);

	JLabel retypePasswordLabel = new JLabel("Retype Password");
	retypePasswordLabel.setFont(new Font("Monospace", Font.PLAIN, 15));
	retypePasswordLabel.setForeground(Color.RED);
	retypePasswordLabel.setBounds(420, 450, 150, 20);
	thisPannel.add(retypePasswordLabel);


	Gender = new JLabel("Gender");
	Gender.setFont(new Font("Monospace", Font.PLAIN, 15));
	Gender.setForeground(Color.red);
	Gender.setBounds(480, 500, 150, 20);
	thisPannel.add(Gender);

	maleRadioButton = new JRadioButton("Male");
	maleRadioButton.setBounds(550, 500, 80, 20);
	//maleRadioButton.setBackground(Color.CYAN);
	thisPannel.add(maleRadioButton);

	femaleRadioButton = new JRadioButton("Female");
	femaleRadioButton.setBounds(660, 500, 80, 20);
	//femaleRadioButton.setBackground(Color.CYAN);
	thisPannel.add(femaleRadioButton);

	ButtonGroup genderGroup = new ButtonGroup();
	genderGroup.add(maleRadioButton);
	genderGroup.add(femaleRadioButton);

	CusType = new JLabel("Customer Type");
	CusType.setFont(new Font("Monospace", Font.PLAIN, 15));
	CusType.setForeground(Color.red);
	CusType.setBounds(430, 550, 150, 20);
	thisPannel.add(CusType);

	NcusRadioButton = new JRadioButton("Free");
	NcusRadioButton.setBounds(550, 550, 80, 20);
	//NcusRadioButton.setBackground(Color.CYAN);
	thisPannel.add(NcusRadioButton);

	PcusRadioButton = new JRadioButton("Paid");
	PcusRadioButton.setBounds(650, 550, 80, 20);
	//PcusRadioButton.setBackground(Color.CYAN);
	thisPannel.add(PcusRadioButton);

	ButtonGroup typegroup = new ButtonGroup();
	typegroup.add(NcusRadioButton);
	typegroup.add(PcusRadioButton);
	
	
	Country = new JLabel("Country");
	Country.setFont(new Font("Monospace", Font.PLAIN, 15));
	Country.setForeground(Color.red);
	Country.setBounds(480, 350, 150, 20);
	thisPannel.add(Country);

	String[] countries = {"USA", "UK", "India", "China", "Australia", "Canada", "France", "Germany", "Italy", "Japan", "Russia"};
	countryComboBox = new JComboBox<>(countries);
	countryComboBox.setBounds(550, 350, 100, 25);
	thisPannel.add(countryComboBox);

	registerBtn = new MyButton("REGISTER");
	registerBtn.setBounds(530, 600, 120, 30);
	registerBtn.setFont(new Font("Monospace",Font.PLAIN,15));
	registerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	registerBtn.setForeground(new Color(255, 55, 39));
	registerBtn.addActionListener(this);
	registerBtn.setRadius(10);
	thisPannel.add(registerBtn);
	registerBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
                registerBtn.setBackground(new Color(25, 118, 211));
                registerBtn.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                registerBtn.setForeground(new Color(25, 118, 211));
                registerBtn.setBackground(new Color(255, 255, 255));
            }
	  });
	exitBtn = new MyButton("");
	exitBtn.setContentAreaFilled(false);
	exitBtn.setFocusPainted(false);
	exitBtn.setBorder(null);
	exitBtn.setIcon(new ImageIcon("imageBG/exit1.png"));
	exitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	exitBtn.setBounds(990, 10, 70, 50);
	exitBtn.addActionListener(this);
	exitBtn.setRadius(10);
	thisPannel.add(exitBtn);
	exitBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
                exitBtn.setBackground(new Color(25, 118, 211));
                exitBtn.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                exitBtn.setForeground(new Color(25, 118, 211));
                exitBtn.setBackground(new Color(255, 255, 255));
            }
        });
		

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
	
	//thisPannel.add(background);
		thisPannel.setBackground(background);
		//thisPannel.add(backgroundLabel);
		this.add(thisPannel);
		this.setVisible(true);
}
private int getNextId() {
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
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==registerBtn)
	{
		int id = this.getNextId();
		String name = NameTextFeild.getText();
		String password = new String(jthisPannel.getPassword());
		String confirm_password = new String(jp2.getPassword());
		String email = EmailTextFeild.getText();
		String dob = (String) dayComboBox.getSelectedItem() + " " + (String) monthComboBox.getSelectedItem() + " " + (String) yearComboBox.getSelectedItem();
		String gender = "";
		String customerType = "";
		String age=AgeTextFeild.getText();
		String country = (String)countryComboBox.getSelectedItem();
		
		if(maleRadioButton.isSelected())
		{
			gender = "Male";
		}
		else if(femaleRadioButton.isSelected())
		{
			gender = "Female";
		}
		
		if(NcusRadioButton.isSelected())
		{
			customerType = "NCustomer";
		}
		else if(PcusRadioButton.isSelected())
		{
			customerType = "PCustomer";
		}
		if((password.equals(confirm_password)) &&  !(password.isEmpty()) && !(confirm_password.isEmpty()) && !(name.isEmpty()) && !(dob.isEmpty()) ){
			//String country = (String) countryComboBox.getSelectedItem(); //type casting
			if(customerType=="PCustomer"){
			Payment reg = new Payment();
			this.setVisible(false);
			reg.setVisible(true);
			RegistrationFunction rgc = new RegistrationFunction(name, password, confirm_password, email,dob,gender,customerType,country,age);
			rgc.register(name, password, confirm_password, email,dob,gender,customerType,country,age);
			JOptionPane.showMessageDialog(this, "Name: "+name+"\nEmail: "+email+"\nDOB: "+dob+"\nGender: "+gender+"\nCountry: "+country);
			}else{
			RegistrationFunction rgc = new RegistrationFunction(name, password, confirm_password, email,dob,gender,customerType,country,age);
			rgc.register(name, password, confirm_password, email,dob,gender,customerType,country,age);
			JOptionPane.showMessageDialog(this, "Name: "+name+"\nEmail: "+email+"\nDOB: "+dob+"\nGender: "+gender+"\nCountry: "+country);
			Login lg = new Login();
			this.setVisible(false);
			lg.setVisible(true);
			}
				
				NameTextFeild.setText("");
				EmailTextFeild.setText("");
				AgeTextFeild.setText("");
				jthisPannel.setText("");
				jp2.setText("");

		}
		else{
			JOptionPane.showMessageDialog(null, "Error: Invalid input. Please Give Entry Properly.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	else if(e.getSource()==exitBtn)
	{
		System.exit(0);
	}
	else if(e.getSource()==backBtn)
	{

		Welcome reg = new Welcome();
		this.setVisible(false);
		reg.setVisible(true);
	}
}

}