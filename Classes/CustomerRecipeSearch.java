package Classes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.MyTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class CustomerRecipeSearch extends JFrame {
    private static final String RECIPE_FILE = ".\\appData\\recipe.txt";
    private List<Recipe> recipes;
    private JPanel contentPane;
    private MyTextField searchField;
    private JTable searchResultsTable;

    public CustomerRecipeSearch() {
        // Load recipe data from file
        try {
            recipes = loadRecipesFromFile(RECIPE_FILE);
        } catch (IOException e) {
            System.err.println("Error loading recipe file: " + e.getMessage());
            System.exit(1);
        }

        // Set up the main content pane
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Recipe Search");

        // Add a background image to the panel
        try {
            Image backgroundImage = ImageIO.read(getClass().getResource("/Ww.jpg"));
            JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
            contentPane.add(backgroundLabel, BorderLayout.CENTER);
            backgroundLabel.setLayout(new BorderLayout());

            // Add a search panel to the top of the background image
            JPanel searchPanel = new JPanel(new BorderLayout());
            backgroundLabel.add(searchPanel, BorderLayout.NORTH);
            searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Add a search field and a search button to the search panel
            searchField = new MyTextField();
            searchPanel.add(searchField, BorderLayout.CENTER);

            JButton searchButton = new JButton("Search");
            searchButton.addActionListener(e -> searchRecipes());
            searchPanel.add(searchButton, BorderLayout.EAST);

            // Add a table to display the search results
            searchResultsTable = new JTable(new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Name", "Ingediaants","Dish Type","Cooking Time","Quantitty","Level","Image"}));
            JScrollPane scrollPane = new JScrollPane(searchResultsTable);
            backgroundLabel.add(scrollPane, BorderLayout.CENTER);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        } catch (IOException e) {
            System.err.println("Error loading background image: " + e.getMessage());
        }

        // Show the window
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private List<Recipe> loadRecipesFromFile(String filename) throws IOException {
        List<Recipe> recipes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String id = parts[0];
			String Name = parts[1];
			String Ingediaants = parts[2];
			String DishType = parts[3];
			String CookingTime = parts[4];
			String Quantitty = parts[5];
			String Level = parts[6];
			String Image = parts[7];
			
			 
           // List<String> ingredients = new ArrayList<>();
           // for (int i = 1; i < parts.length; i++) {
           //     ingredients.add(parts[i]);
           // }
            Recipe recipe = new Recipe(id, Name ,Ingediaants,DishType,CookingTime,Quantitty,Level, Image);
            recipes.add(recipe);
        }
        reader.close();
        return recipes;
    }

    private void searchRecipes() {
        String query = searchField.getText().toLowerCase();
        List<Recipe> searchResults = recipes.stream()
                .filter(recipe -> recipe.getName().toLowerCase().contains(query)
                        ||recipe.getIngredients().toLowerCase().contains(query))
            .toList();
    DefaultTableModel model = (DefaultTableModel) searchResultsTable.getModel();
    model.setRowCount(0);
    for (Recipe recipe : searchResults) {
        model.addRow(new Object[]{recipe.getName(), String.join(", ", recipe.getIngredients())});
    }
}

public static void main(String[] args) {
    // Set the look and feel to the system look and feel
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
            | UnsupportedLookAndFeelException e) {
        System.err.println("Error setting look and feel: " + e.getMessage());
    }

    // Create and show the GUI
    new CustomerRecipeSearch();
}

}

class Recipe {
private String id;
private String Name ;
private String ingredients ;
private String DishType ;
private String CookingTime ;
private String Quantitty;
private String Level ;
private String Image;
public Recipe(String id,String Name,String ingredients,String DishType,String CookingTime,String Quantitty,String Level,String Image ) {
    this.id = id;
	this.Name = Name;
	this.ingredients = ingredients;
	this.DishType = DishType;
	this.CookingTime = CookingTime;    
	this.Quantitty = Quantitty;
	this.Level = Level;
	this.Image = Image;
}

public String getName() {
    return Name;
}

public String getIngredients() {
    return ingredients;
}
public String getDishType() {
    return DishType;
}
public String getCookingTime() {
    return CookingTime;
}
public String getQuantitty() {
    return Quantitty;
}
public String getLevel() {
    return Level;
}
public String getImage() {
    return Image;
}

//public List<String> getIngredients() {
  //  return ingredients;
//}
}