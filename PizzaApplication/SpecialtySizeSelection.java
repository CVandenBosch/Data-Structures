import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialtySizeSelection extends JFrame {
    private final PizzaSelection pizzaSelection; //Reference to main PizzaSelection class

    public SpecialtySizeSelection(String pizzaName, PizzaSelection pizzaSelection) {
        this.pizzaSelection = pizzaSelection;
        setTitle("Select Pizza Size");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Create panel with border layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        // Creates a window with name based on the selected pizza
        JLabel titleLabel = new JLabel("Select Size for " + pizzaName);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Creates new one column panel for sizes
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 10));
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Creates size buttons for each size
        String[] sizes = {"Small ($5)", "Medium ($10)", "Large ($15)", "Super ($20)"};
        for (String size : sizes) {
            JButton sizeButton = new JButton(size);
            sizeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Turns the price string into the price as a double
                    String priceString = size.split("\\$")[1];
                    double price = Double.parseDouble((priceString.replaceAll("[^\\d.]", "")));
                    // Add pizza to cart
                    pizzaSelection.addToCart(pizzaName, price, size);
                    // Close the size selection gui
                    dispose();
                }
            });
            buttonPanel.add(sizeButton);
        }
    }

    // Main function
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SpecialtySizeSelection("BBQ Chicken Pizza", null).setVisible(true);
            }
        });
    }
}