import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaSelection extends JFrame {
    private JLabel totalPriceLabel;
    private double totalPrice;
    public static String listOfPizzas = "";

    public PizzaSelection() {
        setTitle("Big Y Pizza Online Ordering");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        // Create inner panel with BoxLayout
        JPanel pizzaOptionsPanel = new JPanel();
        pizzaOptionsPanel.setLayout(new BoxLayout(pizzaOptionsPanel, BoxLayout.Y_AXIS));

        // Specialty pizzas
        // Title
        JLabel specialtyLabel = new JLabel("Specialty Pizzas:");
        specialtyLabel.setFont(new Font("Arial", Font.BOLD, 20));
        specialtyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialtyLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        pizzaOptionsPanel.add(specialtyLabel);

        // #1
        JButton specialtyPizza1Button = new JButton("BBQ Chicken Pizza");
        specialtyPizza1Button.setPreferredSize(new Dimension(150, 50));
        specialtyPizza1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // open PizzaSizeSelection class for this specific pizza
                new SpecialtySizeSelection("BBQ Chicken Pizza", PizzaSelection.this).setVisible(true);
            }
        });
        pizzaOptionsPanel.add(specialtyPizza1Button);

        // #2
        JButton specialtyPizza2Button = new JButton("Buffalo Chicken Pizza");
        specialtyPizza2Button.setPreferredSize(new Dimension(150, 50));
        specialtyPizza2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SpecialtySizeSelection("Buffalo Chicken Pizza", PizzaSelection.this).setVisible(true);
            }
        });
        pizzaOptionsPanel.add(specialtyPizza2Button);

        // #3
        JButton specialtyPizza3Button = new JButton("Meat Lovers Pizza");
        specialtyPizza3Button.setPreferredSize(new Dimension(150, 50));
        specialtyPizza3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SpecialtySizeSelection("Meat Lovers Pizza", PizzaSelection.this).setVisible(true);
            }
        });
        pizzaOptionsPanel.add(specialtyPizza3Button);

        // #4
        JButton specialtyPizza4Button = new JButton("Veggie Pizza");
        specialtyPizza4Button.setPreferredSize(new Dimension(150, 50));
        specialtyPizza4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SpecialtySizeSelection("Veggie Pizza", PizzaSelection.this).setVisible(true);
            }
        });
        pizzaOptionsPanel.add(specialtyPizza4Button);

        // #5
        JButton specialtyPizza5Button = new JButton("Hawaiian Pizza");
        specialtyPizza5Button.setPreferredSize(new Dimension(150, 50));
        specialtyPizza5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SpecialtySizeSelection("Hawaiian Pizza", PizzaSelection.this).setVisible(true);
            }
        });
        pizzaOptionsPanel.add(specialtyPizza5Button);

        // #6
        JButton specialtyPizza6Button = new JButton("Margarita Pizza");
        specialtyPizza6Button.setPreferredSize(new Dimension(150, 50));
        specialtyPizza6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SpecialtySizeSelection("Margarita Pizza", PizzaSelection.this).setVisible(true);
            }
        });
        pizzaOptionsPanel.add(specialtyPizza6Button);

        // Space between specialty pizzas and build your own button
        pizzaOptionsPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Build your own pizza
        JButton buildYourOwnButton = new JButton("Build Your Own Pizza");
        buildYourOwnButton.setPreferredSize(new Dimension(200, 75));
        buildYourOwnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open BYOPizzaSize class
                new BYOSizeSelection(PizzaSelection.this).setVisible(true);
            }
        });
        pizzaOptionsPanel.add(buildYourOwnButton);

        mainPanel.add(pizzaOptionsPanel, BorderLayout.CENTER);

        // Panel for total price and checkout
        JPanel totalPricePanel = new JPanel(new FlowLayout());
        totalPriceLabel = new JLabel("Total Price: $0.00");
        totalPricePanel.add(totalPriceLabel);

        // Checkout button
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckoutSummary(listOfPizzas).setVisible(true);
            }
        });
        totalPricePanel.add(checkoutButton);
        mainPanel.add(totalPricePanel, BorderLayout.SOUTH);
    }

    public void addToCart(String pizzaName, double price, String size) {
        // Update total price variable
        totalPrice += price;
        // Separates size into the size and the price (cuz size variable has ($XX) after it)
        String[] updatedSize = size.split(" ");
        // Add pizza to list of pizzas to be used later in checkout window (? is used for replace later)
        listOfPizzas += updatedSize[0] + " " + pizzaName + " ($" + price + ")" + "?";
        // Update total price label in gui
        updateTotalPriceLabel();
    }

    private void updateTotalPriceLabel() {
        // Updates total price label
        totalPriceLabel.setText(String.format("Total Price: $%.2f", totalPrice));
    }

    // Main function
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PizzaSelection().setVisible(true);
            }
        });
    }
}