package Laba_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Laba1Panel extends JPanel
{
    private JTextArea outputArea;
    private JTextField fromField;
    private JTextField toField;
    private JComboBox<String> strategyBox;
    private Hero hero;

    public Laba1Panel()
    {
        hero = new Hero("Artem");
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.add(new JLabel("From:"));
        fromField = new JTextField();
        inputPanel.add(fromField);

        inputPanel.add(new JLabel("To:"));
        toField = new JTextField();
        inputPanel.add(toField);

        inputPanel.add(new JLabel("Strategy:"));
        strategyBox = new JComboBox<>(new String[]{"Walk", "Horse", "Fly"});
        inputPanel.add(strategyBox);

        add(inputPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JButton moveButton = new JButton("Move Hero");

        moveButton.addActionListener(e -> 
        {
            String from = fromField.getText().trim();
            String to = toField.getText().trim();

            if (from.isEmpty() || to.isEmpty())
            {
                appendOutput("From and To fields cannot be empty!");
                return;
            }

            String strategy = (String) strategyBox.getSelectedItem();

            switch (strategy)
            {
                case "Walk":
                    hero.setStrategy(new Walk());
                    break;
                case "Horse":
                    hero.setStrategy(new Horse());
                    break;
                case "Fly":
                    hero.setStrategy(new Fly());
                    break;
                default:
                    appendOutput("Unknown strategy!");
                    break;
            }

            hero.move(from, to, this::appendOutput);
        });

        add(moveButton, BorderLayout.SOUTH);
    }

    private void onMove()
    {
        String from = fromField.getText().trim();
        String to = toField.getText().trim();

        if (from.isEmpty() || to.isEmpty())
        {
            appendOutput("Departure or destination cannot be empty!");
            return;
        }

        switch ((String) strategyBox.getSelectedItem())
        {
            case "Walk":
                hero.setStrategy(new Walk());
                break;
            case "Horse":
                hero.setStrategy(new Horse());
                break;
            case "Fly":
                hero.setStrategy(new Fly());
                break;
        }

        hero.move(from, to, this::appendOutput);
    }

    private void appendOutput(String text)
    {
        outputArea.append(text + "\n");
    }
}