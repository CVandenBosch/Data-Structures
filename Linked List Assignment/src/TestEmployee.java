import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestEmployee {
    public static void main(String[] args) {
        //linked list starting info
        Student chris = new Student("chris", 19, "CS", 2025);
        Student john = new Student("john", 20, "DS", 2026);
        Student bill = new Student("bill", 17, "Math", 2027);
        Student mona = new Student("mona", 18, "Physics", 2034);
        Student tom = new Student("tom", 18, "Physics", 2018);
        Student dylan = new Student("dylan", 18, "HackerVibes", 2027);
        Student charlie = new Student("charlie", 19, "Rizz", 207);
        Student oz = new Student("oz", 22, "StudentAdvisor", 2027);
        Student pawan = new Student("pawan", 25, "Rizz", 2004);
        Student nina = new Student("nina", 36, "CS", 2025);
        StudentLinkedList list = new StudentLinkedList();
        list.insertNode(chris);
        list.insertNode(john);
        list.insertNode(bill);
        list.insertNode(mona);
        list.insertNode(tom);
        list.insertNode(dylan);
        list.insertNode(charlie);
        list.insertNode(oz);
        list.insertNode(pawan);
        list.insertNode(nina);

        //title, layout, and size
        JFrame frame = new JFrame("Plz give us a 100");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 500);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
        // print list button
        JButton printListButton = new JButton("Print List");

        // remove after stuff
        JLabel removeAfterText = new JLabel("Remove After Function - Input name of student whom you want to remove next student: ");
        JTextField removeAfter = new JTextField(10);
        JButton removeAfterButton = new JButton("Confirm Remove After");

        // copy stuff
        JLabel copyText = new JLabel("Copy Function - Input any name of student in list: ");
        JTextField copy = new JTextField(10);
        JButton copyButton = new JButton("Confirm Copy");

        // remove duplicate age stuff
        JLabel removeDuplicateAgeText = new JLabel("Age Removal Function - Input age wanting to be removed: ");
        JTextField removeDuplicateAge = new JTextField(10);
        JButton removeDuplicateAgeButton = new JButton("Confirm Remove Age");

        // remove duplicate year stuff
        JLabel removeDuplicateYearText = new JLabel("Year Removal Function - Input year wanting to be removed: ");
        JTextField removeDuplicateYear = new JTextField(10);
        JButton removeDuplicateYearButton = new JButton("Confirm Remove Year");

        // remove duplicate major stuff
        JLabel removeDuplicateMajorText = new JLabel("Major Removal Function - Input major wanting to be removed: ");
        JTextField removeDuplicateMajor = new JTextField(10);
        JButton removeDuplicateMajorButton = new JButton("Confirm Remove Major");

        // max age stuff
        JButton maxAgeButton = new JButton("Find Max Age");

        // max year stuff
        JButton maxYearButton = new JButton("Find Max GradYear");

        // add frames
        frame.add(removeAfterText);
        frame.add(removeAfter);
        frame.add(removeAfterButton);
        frame.add(copyText);
        frame.add(copy);
        frame.add(copyButton);
        frame.add(removeDuplicateAgeText);
        frame.add(removeDuplicateAge);
        frame.add(removeDuplicateAgeButton);
        frame.add(removeDuplicateYearText);
        frame.add(removeDuplicateYear);
        frame.add(removeDuplicateYearButton);
        frame.add(removeDuplicateMajorText);
        frame.add(removeDuplicateMajor);
        frame.add(removeDuplicateMajorButton);
        frame.add(Box.createHorizontalStrut(100));
        frame.add(maxAgeButton);
        frame.add(maxYearButton);
        frame.add(printListButton);

        //print list button pressed
        printListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, list.returnPrintList());
            }
        }
        );

        //remove after button pressed
        removeAfterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                list.removeAfter(removeAfter.getText());
                JOptionPane.showMessageDialog(frame, list.returnPrintList());
            } catch (Exception x) {
                JOptionPane.showMessageDialog(frame, "Invalid Data Type Entered", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            }
        }
        );

        //copy button pressed
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(frame, "Copy Created: " + list.copy(copy.getText().toLowerCase()).returnPrintList());
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(frame, "Invalid Data Type Entered", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //remove age pressed
        removeDuplicateAgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    list.removeDuplicateAge(Integer.valueOf(removeDuplicateAge.getText()), list.getFirst());
                    JOptionPane.showMessageDialog(frame, list.returnPrintList());
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(frame, "Invalid Data Type Entered", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //remove year pressed
        removeDuplicateYearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                list.removeDuplicateYear(Integer.valueOf(removeDuplicateYear.getText()), list.getFirst());
                JOptionPane.showMessageDialog(frame, list.returnPrintList());
            } catch (Exception x) {
                JOptionPane.showMessageDialog(frame, "Invalid Data Type Entered", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            }
        }
        );

        //remove major pressed
        removeDuplicateMajorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                list.removeDuplicateMajor(removeDuplicateMajor.getText().toLowerCase(), list.getFirst());
                JOptionPane.showMessageDialog(frame, list.returnPrintList());
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(frame, "Invalid Data Type Entered", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        );

        //max age button pressed
        maxAgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(frame, "Max age is: " + String.valueOf(list.maxAge(list.getFirst())));
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(frame, "Invalid Data Type Entered", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //max year button pressed
        maxYearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                JOptionPane.showMessageDialog(frame, "Max grad year is: " + String.valueOf(list.maxYear(list.getFirst())));
            } catch (Exception x) {
                    JOptionPane.showMessageDialog(frame, "Invalid Data Type Entered", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                }
            });

        // make it visible
        frame.setVisible(true);
    }
}
