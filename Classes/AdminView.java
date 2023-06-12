package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AdminView extends JFrame implements ActionListener
{
	
	
	JLabel accountLable;
	MyButton exitBtn,LogoutBtn,ShowRecipeBtn,AddRecipeBtn,AdminCreateBtn,CustomerCreateBtn,FRecipeBtn,AddIndigrentsBtn;
	JPanel thisPannel;
	MyTextField AddTextFeild,CatagoryTextFeild,IngredientTextFeild,RecipeNameTextFeild;
	public AdminView()
	{
		super(" Admin page ");
		this.setBounds(0, 0, 1100, 685);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));
		this.setResizable(false);
		this.setVisible(true);
		
		thisPannel = new JPanel();
		thisPannel.setSize(new Dimension(1200,700));
		//thisPannel.setBackground((Color.CYAN));
		thisPannel.setLayout(null);
		
		ImageIcon img = new ImageIcon("imageBG/admin2.jpg");
        JLabel background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1200, 700);
        //thisPannel.add(background);

		accountLable = new JLabel("Admin Page");
		accountLable.setFont(new Font("Serif",Font.BOLD,20));
		accountLable.setForeground(Color.BLUE);
		accountLable.setBounds(500,50,350,50);
		background.add(accountLable);
		
		
		AddRecipeBtn = new MyButton("Add Recipe");
		AddRecipeBtn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		AddRecipeBtn.setForeground(Color.white);
		AddRecipeBtn.setBackground(Color.green);
		AddRecipeBtn.setBounds(300,150,150,30);
		AddRecipeBtn.addActionListener(this);
		AddRecipeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(AddRecipeBtn);
		thisPannel.add(AddRecipeBtn);
		
		AdminCreateBtn = new MyButton("Create Admin");
		AdminCreateBtn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		AdminCreateBtn.setForeground(Color.white);
		AdminCreateBtn.setBackground(Color.green);
		AdminCreateBtn.setBounds(300,200,150,30);
		AdminCreateBtn.addActionListener(this);
		AdminCreateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(AdminCreateBtn);
		thisPannel.add(AdminCreateBtn);
		
		CustomerCreateBtn = new MyButton("Create Customer");
		CustomerCreateBtn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		CustomerCreateBtn.setForeground(Color.white);
		CustomerCreateBtn.setBackground(Color.green);
		CustomerCreateBtn.setBounds(300,250,180,30);
		CustomerCreateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		CustomerCreateBtn.addActionListener(this);
		thisPannel.add(CustomerCreateBtn);
		
		FRecipeBtn = new MyButton("Find a Recipe");
		FRecipeBtn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		FRecipeBtn.setForeground(Color.white);
		FRecipeBtn.setBackground(Color.green);
		FRecipeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		FRecipeBtn.setBounds(500,150,150,30);
		FRecipeBtn.addActionListener(this);
		thisPannel.add(FRecipeBtn);
		
		AddIndigrentsBtn = new MyButton("Add IndigrentsBtn ");
		AddIndigrentsBtn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		AddIndigrentsBtn.setForeground(Color.white);
		AddIndigrentsBtn.setBackground(Color.green);
		AddIndigrentsBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		AddIndigrentsBtn.setBounds(500,200,200,30);
		AddIndigrentsBtn.addActionListener(this);
		thisPannel.add(AddIndigrentsBtn);
	
	
	
	
		LogoutBtn = new MyButton("Logout");
		LogoutBtn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		LogoutBtn.setForeground(Color.white);
		LogoutBtn.setBackground(Color.green);
		LogoutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		LogoutBtn.setBounds(470,550,100,30);
		LogoutBtn.addActionListener(this);
		background.add(LogoutBtn);
		thisPannel.add(LogoutBtn);
		
		
		ShowRecipeBtn = new MyButton("Show Recipe");
		ShowRecipeBtn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		ShowRecipeBtn.setForeground(Color.white);
		ShowRecipeBtn.setBackground(Color.green);
		ShowRecipeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ShowRecipeBtn.setBounds(500,250,150,30);
		ShowRecipeBtn.addActionListener(this);
		background.add(ShowRecipeBtn);
		thisPannel.add(ShowRecipeBtn);
		
		
		exitBtn = new MyButton("Exit");
		exitBtn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		exitBtn.setForeground(Color.white);
		exitBtn.setBackground(Color.green);
		exitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitBtn.setBounds(600,550,80,30);
		exitBtn.addActionListener(this);
		background.add(exitBtn);
		thisPannel.add(exitBtn);
		
		thisPannel.add(background);

		this.add(thisPannel);
	}
	
		public void actionPerformed(ActionEvent e)
		{
			
			if(e.getSource()==exitBtn)
			{
				System.exit(0);
			}
			if(e.getSource()==LogoutBtn)
			{
				Login lg = new Login();
				this.setVisible(false);
				lg.setVisible(true);
			}
			if(e.getSource()==FRecipeBtn)
			{
				RecipeSearch fr = new RecipeSearch();
				this.setVisible(false);
				fr.setVisible(true);
			}
			if(e.getSource()==AddIndigrentsBtn)
			{
				AddIndigrents ad = new AddIndigrents();
				this.setVisible(false);
				ad.setVisible(true);
			}
			if(e.getSource()==ShowRecipeBtn)
			{
				ShowRecipeForAdmin Sr = new ShowRecipeForAdmin();
				this.setVisible(false);
				Sr.setVisible(true);
			}
			if(e.getSource()==CustomerCreateBtn)
			{
				CustomerCreate CC = new CustomerCreate();
				this.setVisible(false);
				CC.setVisible(true);
			}if(e.getSource()==AdminCreateBtn)
			{
				AdminCreate Ac = new AdminCreate();
				this.setVisible(false);
				Ac.setVisible(true);
			}
			
			if(e.getSource()==AddRecipeBtn)
			{
				AddRecipe ar = new AddRecipe();
				this.setVisible(false);
				ar.setVisible(true);
			}
		}
}