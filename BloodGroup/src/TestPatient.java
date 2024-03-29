import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPatient {

    public static void main(String[] args) {
        //title, layout, and size
        JFrame frame = new JFrame("Plz give us a 100");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 75);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // ID number input
        JLabel idLabel = new JLabel("ID number:");
        JTextField idField = new JTextField(10);

        // age number input
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(10);

        // blood info input
        JLabel bloodLabel = new JLabel("Blood Type:");
        JTextField bloodField = new JTextField(10);

        // button
        JButton enterButton = new JButton("Submit");

        // add frames
        frame.add(idLabel);
        frame.add(idField);
        frame.add(ageLabel);
        frame.add(ageField);
        frame.add(bloodLabel);
        frame.add(bloodField);
        frame.add(enterButton);

        //button pressed
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // tries everything
                    try {
                        String inputId = "0";
                        String inputAge = "0";
                        String inputBloodTypeInfo = "O";
                        String inputRhFactorInfo = "POS";

                        //creates patient object
                        Patient defaultPatient = new Patient();

                        //gets the input id, age, and blood type
                        inputId = idField.getText();
                        inputAge = ageField.getText();
                        String userCombinedBloodType = bloodField.getText();

                        //splits the blood info
                        inputBloodTypeInfo = userCombinedBloodType.substring(0, userCombinedBloodType.length() - 1);
                        inputRhFactorInfo = userCombinedBloodType.substring(userCombinedBloodType.length() - 1);

                        //turns input into usable with enum
                        if (inputRhFactorInfo.equals("+")) {
                            inputRhFactorInfo = "POS";
                        } else {
                            inputRhFactorInfo = "NEG";
                        }

                        //creates objects user patient (all user info used) and basic patient (only use id and age, use basic for blood stuff)
                        Patient userPatient = new Patient(inputId, inputAge, inputBloodTypeInfo, inputRhFactorInfo);
                        Patient userBasicPatient = new Patient(inputId, inputAge, "O", "POS");

                        //shows info (basically toString)
                        JOptionPane.showMessageDialog(frame, "Default Patient Data:\n" + defaultPatient + "\n\n\nUser Patient:\n" + userPatient + "\n\n\nBasic User Patient:\n" + userBasicPatient);
                    }
                    //catches errors and prints error message
                    catch(IllegalArgumentException ex){
                    JOptionPane.showMessageDialog(frame, "Invalid blood type was input", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // make it visible
        frame.setVisible(true);
    }}