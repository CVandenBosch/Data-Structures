import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BYOSizeSelection extends JFrame{
    private final PizzaSelection pizzaSelection;
    public BYOSizeSelection(PizzaSelection pizzaSelection) {
        this.pizzaSelection = pizzaSelection;
        setTitle("Select Pizza Size");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Creates panel with border layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        // Creates window
        JLabel titleLabel = new JLabel("Select Size for Your Pizza");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Creates one column panel for buttons
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
                    // Open toppings selection class after selecting size
                    new ToppingsSelection(pizzaSelection, price, size).setVisible(true);
                    // Close this gui
                    dispose();
                }
            });
            buttonPanel.add(sizeButton);
        }
    }
    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BYOSizeSelection(null).setVisible(true);
            }
        });
    }
}
