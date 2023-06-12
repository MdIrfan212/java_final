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
public class AddRecipe extends JFrame implements ActionListener
{
	JLabel l1, Name, Ingredients, Quantity, Gender, category,diffLevel, CookingTime,imageLabel;
	MyTextField NameTextFeild, QuantityTextFeild;
	MyButton saveBtn, exitBtn, backBtn,saveButton;
	JTextArea IngredientsTextFeild;
	JPanel thisPannel;
	JRadioButton maleRadioButton, femaleRadioButton;
	JRadioButton EasyRadioButton, MediumRadioButton,HardRadioButton;
	JComboBox<String> categoryComboBox;
	JComboBox<String> CookingTimeComboBox;
	BufferedImage selectedImage;
	MyButton selectImageBtn, saveImageBtn;
	MyTextField imageNameField;
	JFileChooser fileChooser;
	File selectedFile;
public AddRecipe()
{
	super(" Add Recipe ");
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
	
	ImageIcon img = new ImageIcon("imageBG/Wk.jpg");
	JLabel background = new JLabel("", img, JLabel.CENTER);
	background.setBounds(0, 0, 1200, 700);
	thisPannel.add(background);
	
	l1 = new JLabel(" Add Recipe ");
	l1.setFont(new Font("Serif", Font.BOLD, 20));
	l1.setForeground(Color.CYAN);
	l1.setBounds(300, 50, 350, 50);
	background.add(l1);

	Name = new JLabel("Name");
	Name.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	Name.setForeground(Color.red);
	Name.setBounds(160, 150, 150, 20);
	background.add(Name);

	NameTextFeild = new MyTextField();
	NameTextFeild.setBounds(250, 150, 200, 30);
	background.add(NameTextFeild);

	Ingredients = new JLabel("Ingredients");
	Ingredients.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	Ingredients.setForeground(Color.red);
	Ingredients.setBounds(160, 200, 150, 20);
	background.add(Ingredients);

	IngredientsTextFeild = new JTextArea();
	IngredientsTextFeild.setBounds(250, 200, 300, 50);
	background.add(IngredientsTextFeild);
	
	JScrollPane scrollPane = new JScrollPane(IngredientsTextFeild);
	scrollPane.setBounds(250, 200, 300, 50);
	background.add(scrollPane);
	CookingTime = new JLabel("CookingTime");
	CookingTime.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	CookingTime.setForeground(Color.red);
	CookingTime.setBounds(160, 250, 150, 20);
	background.add(CookingTime);

	String[] Minute = new String[60];
	for (int i = 0; i < 60; i++) {
		Minute[i] = Integer.toString(i + 1);
	}
	CookingTimeComboBox = new JComboBox<>(Minute);
	CookingTimeComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
	CookingTimeComboBox.setBounds(250, 250, 50, 25);
	background.add(CookingTimeComboBox);

	Quantity = new JLabel("Quantity");
	Quantity.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	Quantity.setForeground(Color.red);
	Quantity.setBounds(160, 300, 150, 20);
	background.add(Quantity);

	QuantityTextFeild = new MyTextField();
	QuantityTextFeild.setBounds(250, 300, 150, 25);
	background.add(QuantityTextFeild);
	
	

	diffLevel = new JLabel("Difficultty Level");
	diffLevel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	diffLevel.setForeground(Color.red);
	diffLevel.setBounds(130, 400, 150, 20);
	background.add(diffLevel);

	EasyRadioButton = new JRadioButton("Easy");
	EasyRadioButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	EasyRadioButton.setBounds(250, 400, 80, 20);
	//EasyRadioButton.setBackground(Color.CYAN);
	background.add(EasyRadioButton);

	MediumRadioButton = new JRadioButton("Medium");
	MediumRadioButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	MediumRadioButton.setBounds(330, 400, 80, 20);
	//MediumRadioButton.setBackground(Color.CYAN);
	background.add(MediumRadioButton);

	HardRadioButton = new JRadioButton("Hard");
	HardRadioButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	HardRadioButton.setBounds(410, 400, 80, 20);
	
	//HardRadioButton.setBackground(Color.CYAN);
	background.add(HardRadioButton);
	
	ButtonGroup typegroup = new ButtonGroup();
	typegroup.add(EasyRadioButton);
	typegroup.add(HardRadioButton);
	typegroup.add(MediumRadioButton);
	
	category = new JLabel("category");
	category.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
	category.setForeground(Color.red);
	category.setBounds(160, 350, 150, 20);
	background.add(category);

	String[] catCombo = {"Appetizer", "Main dish", "Dessert"};
	categoryComboBox = new JComboBox<>(catCombo);
	categoryComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
	categoryComboBox.setBounds(250, 350, 100, 25);
	background.add(categoryComboBox);
/*
	// create GUI components
	selectImageBtn = new MyButton("Select Image");
	imageNameField = new MyTextField(20);

	// create file chooser with image file filter
	fileChooser = new JFileChooser();
	fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif"));
	int result = fileChooser.showOpenDialog(null);

	// add action listeners to buttons
	selectImageBtn.addActionListener(this);

	// add components to GUI
	background.add(selectImageBtn);
	background.add(saveImageBtn);
	background.add(imageNameField);
	*/
	
		// Create a JLabel to display the image
	imageLabel = new JLabel();
	imageLabel.setBounds(600, 250, 400, 400);
	background.add(imageLabel);

	// Create a MyButton to select an image file
	selectImageBtn = new MyButton("Select Image");
	selectImageBtn.setBounds(250, 450, 120, 30);
	selectImageBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	selectImageBtn.addActionListener(this);
	background.add(selectImageBtn);
	
	saveBtn = new MyButton("Save");
	saveBtn.setBackground(Color.GREEN);
	saveBtn.setForeground(Color.BLACK);
	saveBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	saveBtn.setBounds(160, 600, 120, 30);
	saveBtn.addActionListener(this);
	background.add(saveBtn);

	exitBtn = new MyButton("EXIT");
	exitBtn.setBackground(Color.RED);
	exitBtn.setForeground(Color.BLACK);
	exitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	exitBtn.setBounds(350, 600, 120, 30);
	exitBtn.addActionListener(this);
	background.add(exitBtn);

	backBtn = new MyButton("");
	backBtn.setContentAreaFilled(false);
	backBtn.setFocusPainted(false);
	backBtn.setBorder(null);
	backBtn.setIcon(new ImageIcon("imageBG/back1.png"));
	backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	backBtn.setBounds(5, 10, 60, 50);
	thisPannel.add(backBtn);
	backBtn.addActionListener(this);
	background.add(backBtn);
	//thisPannel.add(background);
	this.add(thisPannel);
	this.setVisible(true);
}

private int getNextId() {
        int maxId = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(".\\appData\\recipe.txt"))) {
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
	 if (e.getSource() == selectImageBtn) {
		// open file chooser dialog and get selected file

		JFileChooser chooser = new JFileChooser();
			int returnVal = chooser.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
			  selectedFile = chooser.getSelectedFile();
			  File file = chooser.getSelectedFile();
			  try {
				selectedImage = ImageIO.read(file);
				
				Image scaledImage = selectedImage.getScaledInstance(
				imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
				imageLabel.setIcon(new ImageIcon(scaledImage));
			  } catch (IOException ex) {
				ex.printStackTrace();
			  }
	}
 }
	if(e.getSource()==saveBtn)
	{
		int id = this.getNextId();
		String name = NameTextFeild.getText();
		String Quantity = QuantityTextFeild.getText();
		String Ingredients = IngredientsTextFeild.getText();
		//String CookingTime =  categoryComboBox.getSelectedItem() + "/" + (String) CookingTime.getSelectedItem();
		//String CookingTime = categoryComboBox.getSelectedItem() + " " + (String) (CookingTimeComboBox).getSelectedItem();
		String category = (String) categoryComboBox.getSelectedItem();
		String CookingTime = (String) CookingTimeComboBox.getSelectedItem();
		String customerType = "";
		
		
		if(EasyRadioButton.isSelected())
		{
			customerType = "Easy";
		}
		else if(MediumRadioButton.isSelected())
		{
			customerType = "Medium";
		}
		else if(HardRadioButton.isSelected())
		{
			customerType = "Hard";
		}
		
		if(!(Ingredients.isEmpty())  && !(name.isEmpty()) && !(CookingTime.isEmpty()) ){
			//String category = (String) categoryComboBox.getSelectedItem();
	
		
		String selectedCategory = (String) categoryComboBox.getSelectedItem();

			//JOptionPane.showMessQuantityDialog(this, "Name: "+name+"\nIngredients: "+Ingredients+"\nCookingTime: "+CookingTime+"\nCatagory"+category);
			JOptionPane.showMessageDialog(this, "Name: "+name+"\nIngredients: "+Ingredients+"\nCookingTime: "+CookingTime+"\nCategory: "+category+"\nQuantity: "+Quantity);

			try {
				FileWriter fw = new FileWriter(".\\appData\\recipe.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(id + ",");
				bw.write(NameTextFeild.getText() + ",");
				bw.write(IngredientsTextFeild.getText() + ",");
				bw.write( (String)categoryComboBox.getSelectedItem() +",");
				bw.write((String) (CookingTimeComboBox).getSelectedItem() +"," );
				
				bw.write(QuantityTextFeild.getText() + ",");
				//bw.write(jthisPannel.getText() + ",");
				if(EasyRadioButton.isSelected()) {
				    bw.write("Easy,");
				} else if(MediumRadioButton.isSelected()) {
				    bw.write("Medium,");
				}
				else if(HardRadioButton.isSelected())
				{	bw.write("Hard,");
				
				}
				
				if (selectedFile != null) {
                    // save selected image to project location
                    String destPath = System.getProperty("user.dir") + "/recipeImage/" + selectedFile.getName();
                    File destFile = new File(destPath);
                    Files.copy(selectedFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                    // save image name to text file
                    bw.write(selectedFile.getName() + "\n");
                    bw.close();
                    // reset GUI components
                    selectedFile = null;
                    imageLabel.setText("");
                    JOptionPane.showMessageDialog(this, "Image saved successfully.");
				} else {
					JOptionPane.showMessageDialog(this, "Please select an image to save.");
				}
				
				bw.close();
				fw.close();
				
				NameTextFeild.setText("");
				IngredientsTextFeild.setText("");
				QuantityTextFeild.setText("");
				//jthisPannel.setText("");
				//jp2.setText("");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/*	if (e.getSource() == selectImageBtn) {
			
			JFileChooser chooser = new JFileChooser();
			int returnVal = chooser.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
			  
			  File file = chooser.getSelectedFile();
			  try {
				selectedImage = ImageIO.read(file);
				
				Image scaledImage = selectedImage.getScaledInstance(
				imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
				imageLabel.setIcon(new ImageIcon(scaledImage));
			  } catch (IOException ex) {
				ex.printStackTrace();
			  }
			}
	}*/
	else if(e.getSource()==exitBtn)
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
