import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutSummary extends JFrame {
    public CheckoutSummary(String items) {
        setTitle("Order Summary");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Makes panel with border layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        // Makes text area
        JTextArea summaryTextArea = new JTextArea();
        summaryTextArea.setEditable(false);
        summaryTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryTextArea.setMargin(new Insets(10, 10, 10, 10));

        // Append each item to the text area (each item has a ? at the end so it splits them all)
        summaryTextArea.append(items.replace("?", "\n"));

        // Adds scroll if window not big enough
        JScrollPane scrollPane = new JScrollPane(summaryTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Adds close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        mainPanel.add(closeButton, BorderLayout.SOUTH);
    }

    // main method
    public static void main(String[] args) {
        String exItems = "ABC";
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CheckoutSummary(exItems).setVisible(true);
            }
        });
    }
}