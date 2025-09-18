package Laba_4;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class Laba4Panel extends JPanel
{
    private JTextArea outputArea;
    private JTextField inputField;
    private JComboBox<String> methodBox;

    public Laba4Panel()
    {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        methodBox = new JComboBox<>(new String[]{ "Average", "Uppercase + Prefix", "Unique Squares", "Sum Even", "List to Map" });
        inputPanel.add(methodBox, BorderLayout.WEST);

        //--------------------------------------------------

        JPanel labelPanel = new JPanel(new GridLayout(2,1));
        JLabel inputLabel = new JLabel("Enter data:");
        JLabel exampleLabel = new JLabel("Example: numbers - 1,2,3, words - apple, phone, csgo");
        exampleLabel.setFont(exampleLabel.getFont().deriveFont(Font.ITALIC, 11f));
        exampleLabel.setForeground(Color.GRAY);
        labelPanel.add(inputLabel);
        labelPanel.add(exampleLabel);

        inputPanel.add(labelPanel, BorderLayout.NORTH);

        //--------------------------------------------------

        inputField = new JTextField();
        inputPanel.add(inputField, BorderLayout.CENTER);

        JButton executeButton = new JButton("Execute");
        executeButton.addActionListener(e -> onExecute());
        inputPanel.add(executeButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.NORTH);

        outputArea = new JTextArea(15, 40);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    private void onExecute()
    {
        String method = (String) methodBox.getSelectedItem();
        String input = inputField.getText().trim();

        outputArea.append("Method: " + method + "\n");

        try
        {
            switch (method)
            {
                case "Average":
                    java.util.List<Integer> numbers = parseIntegerList(input);
                    double avg = StreamTasks.getAverage(numbers);
                    outputArea.append("Average: " + avg + "\n");
                    break;

                case "Uppercase + Prefix":
                    java.util.List<String> strings = parseStringList(input);
                    java.util.List<String> transformed = StreamTasks.addPrefixAndUpperCase(strings);
                    outputArea.append("Result: " + transformed + "\n");
                    break;

                case "Unique Squares":
                    java.util.List<Integer> nums = parseIntegerList(input);
                    java.util.List<Integer> squares = StreamTasks.getUniqueSquares(nums);
                    outputArea.append("Unique squares: " + squares + "\n");
                    break;

                case "Sum Even":
                    int[] arr = parseIntegerArray(input);
                    int sum = StreamTasks.sumEvenNumbers(arr);
                    outputArea.append("Sum of even numbers: " + sum + "\n");
                    break;

                case "List to Map":
                    java.util.List<String> list = parseStringList(input);
                    Map<Character, String> map = StreamTasks.listToMap(list);
                    outputArea.append("Map: " + map + "\n");
                    break;
            }
        }
        catch (Exception ex)
        {
            outputArea.append("Error: " + ex.getMessage() + "\n");
        }

        outputArea.append("\n");
    }

    private java.util.List<Integer> parseIntegerList(String input)
    {
        if (input.isEmpty()) return new ArrayList<>();
        return Arrays.stream(input.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
    }

    private int[] parseIntegerArray(String input)
    {
        return parseIntegerList(input).stream().mapToInt(i -> i).toArray();
    }

    private java.util.List<String> parseStringList(String input)
    {
        if (input.isEmpty()) return new ArrayList<>();
        return Arrays.stream(input.split(",")).map(String::trim).collect(Collectors.toList());
    }
}