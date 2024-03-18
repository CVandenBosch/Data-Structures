import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class ToppingsSelection extends JFrame{
    private final PizzaSelection pizzaSelection; // gets the pizza selection
    private String preListOfToppings = "";
    private double totalPrice = 0.00;
    private double toppingPrice = 0.00;
    private int selectedCount = 0; // Counter for # of selected toppings
    private boolean isCheese = false;
    private ArrayList<JCheckBox> checkBoxes = new ArrayList<>(); // List to hold list of toppings

    public ToppingsSelection(PizzaSelection pizzaSelection, double pizzaPrice, String size) {
        this.pizzaSelection = pizzaSelection;
        setTitle("Select Toppings");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Sets panel with border layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        // Creates window
        JLabel titleLabel = new JLabel("Select Toppings (Max 3) ($1.25 for 3, $1.00 for 2, $0.50 for 1)");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Grid layout with one single column
        JPanel checkboxPanel = new JPanel(new GridLayout(0,1));
        mainPanel.add(checkboxPanel, BorderLayout.CENTER);

        // Create checkboxes for toppings
        String[] toppings = {"Pepperoni", "Sausage", "Bacon", "Mushrooms", "Onions", "Olives", "Peppers", "Pineapple", "Spinach", "Extra Cheese"};
        for (String topping : toppings) {
            JCheckBox checkBox = new JCheckBox(topping);
            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (checkBox.isSelected()) {
                        // Check if toppings count is less than 3
                        if (selectedCount < 3) {
                            // add one to toppings count if it is less than 3
                            selectedCount += 1;
                        } else {
                            // Unselect the checkbox if it is more than 3
                            checkBox.setSelected(false);
                        }
                    } else {
                        // subtract one from toppings count if a checkbox is unselected
                        selectedCount-= 1;
                    }
                }
            });
            // Add checkbox to list
            checkBoxes.add(checkBox);
            // Add checkbox to gui panel
            checkboxPanel.add(checkBox);
        }

        // Confirm button
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedToppings = 0;
                // for loop for each topping
                for (Component component : checkboxPanel.getComponents()) {
                    if (component instanceof JCheckBox) {
                        JCheckBox checkBox = (JCheckBox) component;
                        // if topping is selected
                        if (checkBox.isSelected()) {
                            // add one to selected toppings
                            selectedToppings += 1;
                            // get topping name
                            String toppingName = checkBox.getText();
                            // add topping name to list
                            preListOfToppings += toppingName + ", ";
                            // if topping name is Extra Cheese, update isCheese variable to true
                            if (Objects.equals(toppingName, "Extra Cheese")) {
                                isCheese = true;
                            }
                        }
                    }
                }

                // Adjust price based on the number of selected toppings and if there is extra cheese
                if (selectedToppings == 1) {
                    if (isCheese) {
                        toppingPrice += 0.00;
                    } else {
                        toppingPrice += 0.50;
                    }
                }
                if (selectedToppings == 2) {
                    if (isCheese) {
                        toppingPrice += 0.50;
                    } else {
                        toppingPrice += 1.00;
                    }
                }
                if (selectedToppings == 3) {
                    if (isCheese) {
                        toppingPrice += 1.00;
                    } else {
                        toppingPrice += 1.25;
                    }
                }
                // Adds pizza price to topping price
                totalPrice = pizzaPrice + toppingPrice;

                // if they select toppings
                if (selectedToppings > 0) {
                    // remove last comma from list of toppings
                    int lenListOfToppings = preListOfToppings.length();
                    String listOfToppings = preListOfToppings.substring(0, lenListOfToppings - 2);
                    pizzaSelection.addToCart("Custom Pizza with " + listOfToppings, totalPrice, size);

                    // if they don't select any toppings
                } else {
                    pizzaSelection.addToCart("Basic Cheese Pizza", totalPrice, size);
                }
                // Close the toppings selection window
                dispose();
            }
        });
        // Add confirm button to gui at the bottom
        mainPanel.add(confirmButton, BorderLayout.SOUTH);
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToppingsSelection(null, 0.00, "").setVisible(true);
            }
        });
    }
}
