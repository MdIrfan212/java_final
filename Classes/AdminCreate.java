package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class AdminCreate extends JFrame implements ActionListener
{
	JLabel l1, Name, Email, Age, Gender, Country,CusType, DOB;
	MyTextField NameTextFeild, EmailTextFeild, AgeTextFeild;
	MyButton registerBtn, exitBtn, backBtn;
	JPanel thisPannel;
	JRadioButton maleRadioButton, femaleRadioButton;
	JRadioButton NcusRadioButton, PcusRadioButton;
	JComboBox<String> countryComboBox, dayComboBox, monthComboBox, yearComboBox;
	MyPasswordField jthisPannel, jp2;

public AdminCreate()
{
	super(" Admin Create ");
	this.setBounds(0, 0, 1100, 685);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(new BorderLayout(0, 0));
	this.setResizable(false);
	this.setVisible(true);

	thisPannel = new JPanel();
	thisPannel.setSize(new Dimension(1200, 720));
	//thisPannel.setBackground((Color.CYAN));
	thisPannel.setLayout(null);
	
	ImageIcon img = new ImageIcon("imageBG/Ww.jpg");
	JLabel background = new JLabel("", img, JLabel.CENTER);
	background.setBounds(0, 0, 1200, 700);
	//thisPannel.add(background);
	
	l1 = new JLabel("CREATE YOUR ACCOUNT");
	l1.setFont(new Font("Serif", Font.BOLD, 20));
	l1.setForeground(Color.BLUE);
	l1.setBounds(200, 50, 350, 50);
	thisPannel.add(l1);

	Name = new JLabel("Name");
	Name.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	Name.setForeground(Color.red);
	Name.setBounds(180, 150, 150, 20);
	thisPannel.add(Name);

	NameTextFeild = new MyTextField();
	NameTextFeild.setBounds(250, 150, 150, 25);
	thisPannel.add(NameTextFeild);

	Email = new JLabel("Email");
	Email.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	Email.setForeground(Color.red);
	Email.setBounds(180, 200, 150, 20);
	thisPannel.add(Email);

	EmailTextFeild = new MyTextField();
	EmailTextFeild.setBounds(250, 200, 150, 25);
	thisPannel.add(EmailTextFeild);

	DOB = new JLabel("DOB");
	DOB.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	DOB.setForeground(Color.red);
	DOB.setBounds(180, 250, 150, 20);
	thisPannel.add(DOB);

	String[] days = new String[31];
	for (int i = 0; i < 31; i++) {
		days[i] = Integer.toString(i + 1);
	}
	dayComboBox = new JComboBox<>(days);
	dayComboBox.setBounds(250, 250, 50, 25);
	thisPannel.add(dayComboBox);

	String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	monthComboBox = new JComboBox<>(months);
	monthComboBox.setBounds(310, 250, 100, 25);
	thisPannel.add(monthComboBox);

	String[] years = new String[100];
	for (int i = 0; i < 100; i++) {
		years[i] = Integer.toString(1970 + i);
	}
	yearComboBox = new JComboBox<>(years);
	yearComboBox.setBounds(420, 250, 80, 25);
	thisPannel.add(yearComboBox);

	Age = new JLabel("Age");
	Age.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	Age.setForeground(Color.red);
	Age.setBounds(180, 300, 150, 20);
	thisPannel.add(Age);

	AgeTextFeild = new MyTextField();
	AgeTextFeild.setBounds(250, 300, 150, 25);
	thisPannel.add(AgeTextFeild);
	
	jthisPannel = new MyPasswordField();
	jthisPannel.setBounds(250, 400, 150, 25);
	thisPannel.add(jthisPannel);

	jp2 = new MyPasswordField();
	jp2.setBounds(250, 450, 150, 25);
	thisPannel.add(jp2);

	JLabel passwordLabel = new JLabel("Password");
	passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	passwordLabel.setForeground(Color.RED);
	passwordLabel.setBounds(180, 400, 150, 20);
	thisPannel.add(passwordLabel);

	JLabel retypePasswordLabel = new JLabel("Retype Password");
	retypePasswordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	retypePasswordLabel.setForeground(Color.RED);
	retypePasswordLabel.setBounds(120, 450, 150, 20);
	thisPannel.add(retypePasswordLabel);


	Gender = new JLabel("Gender");
	Gender.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	Gender.setForeground(Color.red);
	Gender.setBounds(180, 500, 150, 20);
	thisPannel.add(Gender);

	maleRadioButton = new JRadioButton("Male");
	maleRadioButton.setBounds(250, 500, 80, 20);
	//maleRadioButton.setBackground(Color.CYAN);
	thisPannel.add(maleRadioButton);

	femaleRadioButton = new JRadioButton("Female");
	femaleRadioButton.setBounds(330, 500, 80, 20);
	//femaleRadioButton.setBackground(Color.CYAN);
	thisPannel.add(femaleRadioButton);

	ButtonGroup genderGroup = new ButtonGroup();
	genderGroup.add(maleRadioButton);
	genderGroup.add(femaleRadioButton);

	/*CusType = new JLabel("Customer Type");
	CusType.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	CusType.setForeground(Color.red);
	CusType.setBounds(150, 550, 150, 20);
	thisPannel.add(CusType);

	NcusRadioButton = new JRadioButton("Free");
	NcusRadioButton.setBounds(250, 550, 80, 20);
	NcusRadioButton.setBackground(Color.CYAN);
	thisPannel.add(NcusRadioButton);

	PcusRadioButton = new JRadioButton("Paid");
	PcusRadioButton.setBounds(330, 550, 80, 20);
	PcusRadioButton.setBackground(Color.CYAN);
	thisPannel.add(PcusRadioButton);

	ButtonGroup typegroup = new ButtonGroup();
	typegroup.add(NcusRadioButton);
	typegroup.add(PcusRadioButton);*/
	
	
	Country = new JLabel("Country");
	Country.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	Country.setForeground(Color.red);
	Country.setBounds(180, 350, 150, 20);
	thisPannel.add(Country);

	String[] countries = {"USA", "UK", "India", "China", "Australia", "Canada", "France", "Germany", "Italy", "Japan", "Russia"};
	countryComboBox = new JComboBox<>(countries);
	countryComboBox.setBounds(250, 350, 100, 25);
	thisPannel.add(countryComboBox);

	registerBtn = new MyButton("REGISTER");
	registerBtn.setBackground(Color.GREEN);
	registerBtn.setForeground(Color.BLACK);
	registerBtn.setBounds(180, 600, 120, 30);
	registerBtn.addActionListener(this);
	thisPannel.add(registerBtn);
	
	
	
	exitBtn = new MyButton("EXIT");
	exitBtn.setBackground(Color.RED);
	exitBtn.setForeground(Color.BLACK);
	exitBtn.setBounds(350, 600, 120, 30);
	exitBtn.addActionListener(this);
	thisPannel.add(exitBtn);

	backBtn = new MyButton("BACK");
	backBtn.setBackground(Color.YELLOW);
	backBtn.setForeground(Color.BLACK);
	backBtn.setBounds(500, 600, 120, 30);
	backBtn.addActionListener(this);
	thisPannel.add(backBtn);
	
	thisPannel.add(background);
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
		String confirm_password = new String(jp2.getPassword());//mendatory feild na 
		String email = EmailTextFeild.getText();
		String dob = (String) dayComboBox.getSelectedItem() + " " + (String) monthComboBox.getSelectedItem() + " " + (String) yearComboBox.getSelectedItem();
		String gender = "";
		String customerType = "";
		if(maleRadioButton.isSelected())
		{
			gender = "Male";
		}
		else if(femaleRadioButton.isSelected())
		{
			gender = "Female";
		}
		
		/*if(NcusRadioButton.isSelected())
		{
			customerType = "NCustomer";
		}
		else if(PcusRadioButton.isSelected())
		{
			customerType = "PCustomer";
		}*/
		
		if((password.equals(confirm_password)) &&  !(password.isEmpty()) && !(confirm_password.isEmpty()) && !(name.isEmpty()) && !(dob.isEmpty()) ){
			String country = (String) countryComboBox.getSelectedItem(); //type casting
			JOptionPane.showMessageDialog(this, "Name: "+name+"\nEmail: "+email+"\nDOB: "+dob+"\nGender: "+gender+"\nCountry: "+country);
			AdminView Av = new AdminView();
			this.setVisible(false);
			Av.setVisible(true);
			try {
				FileWriter fw = new FileWriter(".\\appData\\registration.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(id + ",");
				bw.write(NameTextFeild.getText() + ",");
				bw.write(jthisPannel.getText() + ",");			
				bw.write("Admin,");
				bw.write(countryComboBox.getSelectedItem() + ",");
				bw.write(EmailTextFeild.getText() + ",");
				bw.write(dayComboBox.getSelectedItem() + "/" + monthComboBox.getSelectedItem() + "/" + yearComboBox.getSelectedItem() + ",");
				bw.write(AgeTextFeild.getText() + ",");
				
				if(maleRadioButton.isSelected()) {
				    bw.write("Male \n");
				} else if(femaleRadioButton.isSelected()) {
				    bw.write("Female \n");
				}

				/*if(NcusRadioButton.isSelected()) {
				    bw.write("NCustomer,\n");
				} else if(PcusRadioButton.isSelected()) {
				    bw.write("PCustomer,\n");
				}*/
				bw.close();
				fw.close();
				
				NameTextFeild.setText("");
				EmailTextFeild.setText("");
				AgeTextFeild.setText("");
				jthisPannel.setText("");
				jp2.setText("");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
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

		AdminView Av = new AdminView();
		this.setVisible(false);
		Av.setVisible(true);
	}
}

}
