package Classes;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class ShowRecipeForAdmin extends JFrame {
    private JTable table;
	private JButton backBtn;
    private DefaultTableModel model;
    private JPanel contentPane;
	Panel panel;
    public ShowRecipeForAdmin() {
        setTitle("All Recipe Show");
        this.setBounds(0, 0, 1100, 685);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));
		this.setResizable(false);
		this.setVisible(true);
		panel = new Panel();
		panel.setBackground(new Color(168, 252, 252));
		this.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
        // Read the text file and store the data in a list of arrays
        java.util.List<Object[]> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(".\\appData\\recipe.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                String imagePath = System.getProperty("user.dir") + "/recipeImage/" + fields[7]; // Assuming the image path is in the fourth column
                ImageIcon imageIcon = new ImageIcon(imagePath);
                Object[] row = {fields[0], fields[1], fields[2],fields[3],fields[4],fields[5],fields[6], imageIcon, "Edit", "Delete"};
                data.add(row);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Create a JTable object and specify the column names and data from the list
        String[] columnNames = {"ID", "Name", "Ingediaants","Dish Type","Cooking Time","Quantitty","Level","Image", "Edit", "Delete"};
        model = new DefaultTableModel(data.toArray(new Object[][]{}), columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 7) {
                    return ImageIcon.class; // Use ImageIcon class for the Photo column
                } else if (columnIndex == 8 || columnIndex == 9) {
                    return JButton.class; // Use JButton class for the Edit and Delete buttons
                } else {
                    return Object.class;
                }
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 8 || column == 9; // Make the Edit and Delete buttons editable
            }
        };
        table = new JTable(model);
        table.getColumnModel().getColumn(7).setCellRenderer(new ImageRenderer()); // Set custom cell renderer for Photo column

        // Set custom cell editor for Edit and Delete buttons
        table.getColumnModel().getColumn(8).setCellEditor(new ButtonEditor(new JTextField()));
        table.getColumnModel().getColumn(9).setCellEditor(new ButtonEditor(new JTextField()));

        // Add action listeners to the Edit and Delete buttons
        table.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(9).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(9).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(9).setCellRenderer(new ButtonRenderer());

        // Add the JTable to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the JFrame
        scrollPane.setBounds(115, 120, 850, 400);
		panel.add(scrollPane);
		backBtn = new JButton("");
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.setBorder(null);
		backBtn.setIcon(new ImageIcon("imageBG/back1.png"));
		backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backBtn.setBounds(10, 10, 100, 70);
		panel.add(backBtn);
		backBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		dispose(); 
		new AdminView().setVisible(true);
		}
		});
        this.setVisible(true);

    }
		public void backBtn(){
				AdminView reg = new AdminView();
				this.setVisible(false);
				reg.setVisible(true);
		}
    class ImageRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			JLabel label = new JLabel();
			if (value != null) {
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setIcon((ImageIcon) value);
			}
			return label;
		}
	}
class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {
    private String label;
    protected JButton button;
    private boolean isPushed;
    private int row;
    private int col;

    public ButtonEditor(JTextField textField) {
        super(textField);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(UIManager.getColor("Button.background"));
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        this.row = row;
        this.col = column;
        return button;
    }

    public Object getCellEditorValue() {
        if (isPushed) {
            // Perform edit or delete action depending on which button was pressed
            if (col == 8) {
                // Edit button was pressed
                editRecipe(row);
            } else if (col == 9) {
                // Delete button was pressed
                deleteRecipe(row);
            }
        }
        isPushed = false;
        return label;
    }

    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }

    // Method to perform edit action
private void editRecipe(int row) {
    // Get the current data from the selected row
    String id = (String) model.getValueAt(row, 0);
    String name = (String) model.getValueAt(row, 1);
    String ingredients = (String) model.getValueAt(row, 2);
    String dishType = (String) model.getValueAt(row, 3);
    String cookingTime = (String) model.getValueAt(row, 4);
    String quantity = (String) model.getValueAt(row, 5);
    String level = (String) model.getValueAt(row, 6);

    // Show a dialog box to get new values for the recipe
    JTextField idField = new JTextField(id);
    JTextField nameField = new JTextField(name);
    JTextField ingredientsField = new JTextField(ingredients);
    JTextField dishTypeField = new JTextField(dishType);
    JTextField cookingTimeField = new JTextField(cookingTime);
    JTextField quantityField = new JTextField(quantity);
    JTextField levelField = new JTextField(level);

    Object[] message = {
            "ID:", idField,
            "Name:", nameField,
            "Ingredients:", ingredientsField,
            "Dish Type:", dishTypeField,
            "Cooking Time:", cookingTimeField,
            "Quantity:", quantityField,
            "Level:", levelField
    };

    int option = JOptionPane.showConfirmDialog(null, message, "Edit Recipe", JOptionPane.OK_CANCEL_OPTION);

    if (option == JOptionPane.OK_OPTION) {
        // Update the model with the new data
        model.setValueAt(idField.getText(), row, 0);
        model.setValueAt(nameField.getText(), row, 1);
        model.setValueAt(ingredientsField.getText(), row, 2);
        model.setValueAt(dishTypeField.getText(), row, 3);
        model.setValueAt(cookingTimeField.getText(), row, 4);
        model.setValueAt(quantityField.getText(), row, 5);
        model.setValueAt(levelField.getText(), row, 6);
        
        // Save the updated data to the file
        try (PrintWriter writer = new PrintWriter(new File(".\\appData\\recipe.txt"))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                writer.print(model.getValueAt(i, 0));
                writer.print(",");
                writer.print(model.getValueAt(i, 1));
                writer.print(",");
                writer.print(model.getValueAt(i, 2));
                writer.print(",");
                writer.print(model.getValueAt(i, 3));
                writer.print(",");
                writer.print(model.getValueAt(i, 4));
                writer.print(",");
                writer.print(model.getValueAt(i, 5));
                writer.print(",");
                writer.print(model.getValueAt(i, 6));
				writer.print(",");
                writer.print(model.getValueAt(i, 6));
                writer.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

    // Method to perform delete action
private void deleteRecipe(int rowIndex) {
    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this recipe?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String id = (String) model.getValueAt(rowIndex, 0);
        try {
            // Open the text file for reading
            File inputFile = new File("C:\\Users\\Admin\\Desktop\\Java_simple\\appData\\recipe.txt");
            Scanner scanner = new Scanner(inputFile);
            StringBuilder buffer = new StringBuilder();

            // Read the file line by line and exclude the line that contains the recipe to be deleted
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                if (!fields[0].equals(id)) {
                    buffer.append(line).append("\n");
                }
            }
            scanner.close();

            // Write the updated data to the text file
            FileWriter fileWriter = new FileWriter(inputFile);
            fileWriter.write(buffer.toString());
            fileWriter.close();

            // Remove the row from the JTable
            model.removeRow(rowIndex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error deleting recipe: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

}


}
