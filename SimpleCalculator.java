import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame {
    private JTextField num1Field, num2Field;
    private JLabel resultLabel;

    public SimpleCalculator() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Simple Calculator");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create the components
        JPanel panel = new JPanel();
        JLabel num1Label = new JLabel("Number 1:");
        num1Field = new JTextField(10);
        JLabel num2Label = new JLabel("Number 2:");
        num2Field = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("");

        // add the components to the panel
        panel.add(num1Label);
        panel.add(num1Field);
        panel.add(num2Label);
        panel.add(num2Field);
        panel.add(calculateButton);
        panel.add(resultLabel);

        // add action listener to the button
        calculateButton.addActionListener(new CalculateButtonListener());

        // add the panel to the frame
        add(panel);

        setVisible(true);
    }

    private class CalculateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // get the numbers entered by the user
            String num1Text = num1Field.getText();
            String num2Text = num2Field.getText();

            // validate the numbers entered by the user
            try {
                double num1 = Double.parseDouble(num1Text);
                double num2 = Double.parseDouble(num2Text);

                // calculate the sum of the numbers and display the result
                double result = num1 + num2;
                resultLabel.setText("The sum of " + num1 + " and " + num2 + " is " + result + ".");
            } catch (NumberFormatException ex) {
                // handle the exception if the user enters invalid numbers
                resultLabel.setText("Invalid input. Please enter valid numbers.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimpleCalculator().setVisible(true);
        });
    }
}