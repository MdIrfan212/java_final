package Classes;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.nio.file.StandardCopyOption;
import java.io.File;
import java.nio.file.Files;
import java.util.UUID;
public class AddIndigrents extends JFrame implements ActionListener
{
	JLabel l1, Name, Ingredients, Quantity,Measurement,PricePerUnit ,imageLabel;
	MyTextField NameTextFeild, QuantityTextFeild,MeasurementTextFeild,PricePerUnitTextFeild;
	MyButton saveBtn, exitBtn, backBtn,saveButton;
	JTextArea IngredientsTextFeild;
	JPanel thisPannel;
	MyButton selectImageBtn, saveImageBtn;
	MyTextField imageNameField;
	//JFileChooser fileChooser;
	//File selectedFile;
public AddIndigrents()
{
	super(" Add Indigrents ");
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
	
	l1 = new JLabel(" Add Indigrents ");
	l1.setFont(new Font("Serif", Font.BOLD, 20));
	l1.setForeground(Color.CYAN);
	l1.setBounds(500, 50, 350, 50);
	thisPannel.add(l1);

	Name = new JLabel("Ingredient name");
	Name.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	Name.setForeground(Color.red);
	Name.setBounds(350, 150, 150, 20);
	thisPannel.add(Name);

	NameTextFeild = new MyTextField();
	NameTextFeild.setBounds(500, 150, 200, 30);
	thisPannel.add(NameTextFeild);

	Ingredients = new JLabel("Ingredient description");
	Ingredients.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	Ingredients.setForeground(Color.red);
	Ingredients.setBounds(330, 200, 200, 20);
	thisPannel.add(Ingredients);

	IngredientsTextFeild = new JTextArea();
	IngredientsTextFeild.setForeground(Color.WHITE);
	

	IngredientsTextFeild.setBounds(500, 200, 300, 50);
	thisPannel.add(IngredientsTextFeild);
	
	JScrollPane scrollPane = new JScrollPane(IngredientsTextFeild);
	scrollPane.setBounds(500, 200, 300, 50);
	thisPannel.add(scrollPane);
	
	Quantity = new JLabel("Food Quality");
	Quantity.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	Quantity.setForeground(Color.red);
	Quantity.setBounds(350, 270, 150, 20);
	thisPannel.add(Quantity);

	QuantityTextFeild = new MyTextField();
	QuantityTextFeild.setBounds(500, 270, 200, 30);
	thisPannel.add(QuantityTextFeild);
	
	Measurement = new JLabel("Measurement unit");
	Measurement.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	Measurement.setForeground(Color.red);
	Measurement.setBounds(350, 350, 300, 50);
	thisPannel.add(Measurement);
	
	MeasurementTextFeild = new MyTextField();
	MeasurementTextFeild.setBounds(500, 350, 200, 30);
	thisPannel.add(MeasurementTextFeild);
	
	JScrollPane scrollPane1 = new JScrollPane(MeasurementTextFeild);
	scrollPane1.setBounds(500, 350, 300, 50);
	thisPannel.add(scrollPane1);
	
	PricePerUnit = new JLabel("Price per unit ");
	PricePerUnit.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	PricePerUnit.setForeground(Color.red);
	PricePerUnit.setBounds(350, 450, 150, 20);
	thisPannel.add(PricePerUnit);

	PricePerUnitTextFeild = new MyTextField();
	PricePerUnitTextFeild.setBounds(500, 450, 200, 30);
	thisPannel.add(PricePerUnitTextFeild);
	
	
	saveBtn = new MyButton("Save");
	saveBtn.setContentAreaFilled(false);
	saveBtn.setFocusPainted(false);
	saveBtn.setBorder(null);
	saveBtn.setBounds(520, 600, 120, 30);
	saveBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	saveBtn.addActionListener(this);
	thisPannel.add(saveBtn);
	saveBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
                saveBtn.setBackground(new Color(25, 118, 211));
                saveBtn.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(MouseEvent e) {
                saveBtn.setForeground(new Color(25, 118, 211));
                saveBtn.setBackground(new Color(255, 255, 255));
            }
        });

	exitBtn = new MyButton("");
	exitBtn.setContentAreaFilled(false);
	exitBtn.setFocusPainted(false);
	exitBtn.setBorder(null);
	exitBtn.setIcon(new ImageIcon("imageBG/exit1.png"));
	exitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	exitBtn.setBounds(990, 10, 70, 50);
	exitBtn.addActionListener(e->exitF());
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
	backBtn.addActionListener(e->backBtnFF());
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
	thisPannel.setBackground(background);
	this.add(thisPannel);
	this.setVisible(true);
}

private int getNextId() {
        int maxId = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(".\\appData\\Ingredients.txt"))) {
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
	public void backBtnFF(){
		AdminView reg = new AdminView();
		this.setVisible(false);
		reg.setVisible(true);
	}
	public void exitF(){
		System.exit(0);
	}
public void actionPerformed(ActionEvent e)
	{
	

		if(e.getSource()==saveBtn)
		{
			int id = this.getNextId();
			String name = NameTextFeild.getText();
			String Ingredients = IngredientsTextFeild.getText();
			String Quantity = QuantityTextFeild.getText();
			String Measurement =MeasurementTextFeild.getText();
			String PricePerUnit =PricePerUnitTextFeild.getText();
			
			
				
				JOptionPane.showMessageDialog(this, "Ingredient name: "+name+"\nIngredient description: "+Ingredients+"\nFood Quality: "+Quantity+"\nMeasurement Unit: "+Measurement+"\nPrice Per Unit: "+PricePerUnit);
				
				try {
					FileWriter fw = new FileWriter(".\\appData\\Ingredients.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(id + ",");
					bw.write(NameTextFeild.getText() + ",");
					bw.write(IngredientsTextFeild.getText() + ",");
					
					bw.write(MeasurementTextFeild.getText() + ",");
					bw.write(PricePerUnitTextFeild.getText() + "\n");
					
					
					
					bw.close();
					fw.close();
					
					NameTextFeild.setText("");
					IngredientsTextFeild.setText("");
					QuantityTextFeild.setText("");
					MeasurementTextFeild.setText("");
					PricePerUnitTextFeild.setText("");
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			if(e.getSource()==exitBtn)
			{
				System.exit(0);
			}
			else if(e.getSource()==backBtn)
			{

				AdminView reg = new AdminView();
				this.setVisible(false);
				reg.setVisible(true);
			}
		}
	}	
	
}
	 



