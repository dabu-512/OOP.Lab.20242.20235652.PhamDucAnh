package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2, 5, 5));

        cp.add(new JLabel("Enter an Integer: "));
        tfInput = new JTextField(10);
        cp.add(tfInput);

        cp.add(new JLabel("The Accumulated Sum is: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        tfInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int number = Integer.parseInt(tfInput.getText());
                sum += number;
                tfInput.setText("");
                tfOutput.setText(sum + "");
            }
        });

        setTitle("Swing Accumulator");
        setSize(350, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }
}