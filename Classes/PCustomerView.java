package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PCustomerView extends JFrame implements ActionListener
{
	
	
	JLabel accountLable;
	MyButton exitBtn,LogoutBtn,ShowRecipeBtn,AddRecipeBtn,AdminCreate,CustomerCreate,FRecipeBtn;
	JPanel thisPannel;
	MyTextField AddTextFeild,CatagoryTextFeild,IngredientTextFeild,RecipeNameTextFeild;
	public PCustomerView()
	{
		super(" Customer page - Paid ");
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
		
		ImageIcon img = new ImageIcon("imageBG/welcome.jpg");
        JLabel background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1200, 700);
        thisPannel.add(background);

		accountLable = new JLabel("Customer Page - Paid");
		accountLable.setFont(new Font("Serif",Font.BOLD,20));
		accountLable.setForeground(Color.BLUE);
		accountLable.setBounds(460,50,350,50);
		background.add(accountLable);
		
		
		AddRecipeBtn = new MyButton("Add Recipe");
		AddRecipeBtn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		AddRecipeBtn.setForeground(Color.white);
		AddRecipeBtn.setBackground(Color.green);
		AddRecipeBtn.setBounds(470,200,150,30);
		AddRecipeBtn.addActionListener(this);
		background.add(AddRecipeBtn);
		
		
		FRecipeBtn = new MyButton("Find a Recipe ");
		FRecipeBtn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		FRecipeBtn.setForeground(Color.white);
		FRecipeBtn.setBackground(Color.green);
		FRecipeBtn.setBounds(650,150,180,30);
		FRecipeBtn.addActionListener(this);
		thisPannel.add(FRecipeBtn);
		
		LogoutBtn = new MyButton("Logout");
		LogoutBtn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		LogoutBtn.setForeground(Color.white);
		LogoutBtn.setBackground(Color.green);
		LogoutBtn.setBounds(470,500,100,30);
		LogoutBtn.addActionListener(this);
		background.add(LogoutBtn);
		
		
		ShowRecipeBtn = new MyButton("Show Recipe");
		ShowRecipeBtn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		ShowRecipeBtn.setForeground(Color.white);
		ShowRecipeBtn.setBackground(Color.green);
		ShowRecipeBtn.setBounds(470,250,150,30);
		ShowRecipeBtn.addActionListener(this);
		background.add(ShowRecipeBtn);
		
		
		exitBtn = new MyButton("Exit");
		exitBtn.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		exitBtn.setForeground(Color.white);
		exitBtn.setBackground(Color.green);
		exitBtn.setBounds(600,500,80,30);
		exitBtn.addActionListener(this);
		background.add(exitBtn);
		

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
			/*if(e.getSource()==ShowRecipeBtn)
			{
				ShowRecipeForAdmin Sr = new ShowRecipeForAdmin();
				this.setVisible(false);
				Sr.setVisible(true);
			}*/
			if(e.getSource()==FRecipeBtn)
			{
				RecipeSearch fr = new RecipeSearch();
				this.setVisible(false);
				fr.setVisible(true);
			}
			if(e.getSource()==ShowRecipeBtn)
			{
				ShowRecipeForPCustomer CC = new ShowRecipeForPCustomer();
				this.setVisible(false);
				CC.setVisible(true);
			}
			/*if(e.getSource()==AdminCreate)
			{
				AdminCreate Ac = new AdminCreate();
				this.setVisible(false);
				Ac.setVisible(true);
			}*/
			
			if(e.getSource()==AddRecipeBtn)
			{
				AddRecipeCustomer ar = new AddRecipeCustomer();
				this.setVisible(false);
				ar.setVisible(true);
			}
		}
}