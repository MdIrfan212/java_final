package Classes;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class ShowRecipeForPCustomer extends JFrame {
    private JTable table;
    private DefaultTableModel model;
	private JButton backBtn;
		Panel panel;
    public ShowRecipeForPCustomer() {
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
                Object[] row = {fields[0], fields[1], fields[2],fields[3],fields[4],fields[5],fields[6], imageIcon};
                data.add(row);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Create a JTable object and specify the column names and data from the list
        String[] columnNames = {"ID", "Name", "Ingediaants","Dish Type","Cooking Time","Quantitty","Level","Image"};
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

       
        // Add the JTable to a JScrollPane
        //JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the JFrame
        //getContentPane().add(scrollPane);

        //setVisible(true);
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
			new PCustomerView().setVisible(true);
		}
		});
        this.setVisible(true);
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
        // Add code here to open a new window to edit the selected recipe
    }

    // Method to perform delete action
    private void deleteRecipe(int row) {
        // Add code here to delete the selected recipe from the file and from the JTable
    }
}
}
