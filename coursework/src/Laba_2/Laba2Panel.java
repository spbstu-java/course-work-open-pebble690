package Laba_2;

import javax.swing.*;
import java.awt.*;

public class Laba2Panel extends JPanel
{
    private JTextArea outputArea;

    public Laba2Panel()
    {
        setLayout(new BorderLayout());

        JButton runButton = new JButton("Execute methods with the @Repeat annotation");
        runButton.addActionListener(e -> runInvoker());

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(runButton, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    private void runInvoker()
    {
        outputArea.setText("");
        Invoker invoker = new Invoker();
        Methods obj = new Methods(this::appendOutput);

        invoker.invokeAnnotatedMethods(obj, this::appendOutput);
    }

    private void appendOutput(String text)
    {
        outputArea.append(text + "\n");
    }
}