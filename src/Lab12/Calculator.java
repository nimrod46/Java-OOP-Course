package Lab12;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Calculator extends JFrame {

    private JTextField firstNumberInput;
    private JTextField secondNumberInput;
    private JTextField resultOutput;
    private JButton add;
    private JButton clear;
    private JButton exitButton;

    public Calculator() {
        this.getContentPane().setLayout(new BorderLayout());
        calculatorForm();

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(200, 20));
        add(northPanel, BorderLayout.NORTH);

        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(20, 100));
        add(westPanel, BorderLayout.WEST);

        JPanel southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(200, 50));
        add(southPanel, BorderLayout.SOUTH);
        exitButton = new JButton("Exit");
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 50,20));
        southPanel.add(exitButton, BorderLayout.EAST);

        JPanel eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(20, 100));
        add(eastPanel, BorderLayout.EAST);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        repaint();
    }

    private void calculatorForm() {
        JPanel jPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(4, 2);
        gridLayout.setVgap(5);
        gridLayout.setHgap(5);
        jPanel.setLayout(gridLayout);
        jPanel.setPreferredSize(new Dimension(350,180));
        jPanel.setMaximumSize(new Dimension(350,180));
        jPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.red, 5), // outer border
                BorderFactory.createEmptyBorder(5,5,5,5)));

        formInput(jPanel);
        formInteraction(jPanel);
    }

    private void formInput(JPanel jPanel) {
        Border inputBorder = BorderFactory.createLineBorder(Color.blue, 1);
        Label firstNumber = new Label("First number:");
        Label secondNumber = new Label("Second number:");
        Label result = new Label("First number:");

        firstNumberInput = new JTextField();
        firstNumberInput.setBorder(inputBorder);

        secondNumberInput = new JTextField();
        secondNumberInput.setBorder(inputBorder);

        resultOutput = new JTextField();
        resultOutput.setBorder(inputBorder);

        jPanel.add(firstNumber);
        jPanel.add(firstNumberInput);
        jPanel.add(secondNumber);
        jPanel.add(secondNumberInput);
        jPanel.add(result);
        jPanel.add(resultOutput);
        add(jPanel, BorderLayout.CENTER);
    }

    private void formInteraction(JPanel jPanel) {
        JPanel addClearPanel = new JPanel();
        add = new JButton("Add");
        clear = new JButton("Clear");
        addClearPanel.add(add);
        addClearPanel.add(clear);
        jPanel.add(new JPanel());
        jPanel.add(addClearPanel);
    }
}
