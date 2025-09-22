package Laba_3.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.List;

public class Laba3Panel extends JPanel 
{
    private JTextArea outputArea;
    private JTextArea inputTextArea;
    private JTextField dictionaryPathField;
    private TranslatorService translator;

    public Laba3Panel() 
    {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout(5,5));
        dictionaryPathField = new JTextField();
        dictionaryPathField.setEditable(false);
        JButton chooseDictButton = new JButton("Choose Dictionary");
        topPanel.add(dictionaryPathField, BorderLayout.CENTER);
        topPanel.add(chooseDictButton, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(2,1,5,5));
        inputTextArea = new JTextArea(5, 40);
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);

        outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        centerPanel.add(new JScrollPane(inputTextArea));
        centerPanel.add(new JScrollPane(outputArea));
        add(centerPanel, BorderLayout.CENTER);

        JButton translateButton = new JButton("Translate");
        add(translateButton, BorderLayout.SOUTH);

        chooseDictButton.addActionListener(e -> chooseDictionary());
        translateButton.addActionListener(e -> translateText());
    }

    private void chooseDictionary() 
    {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION)
        {
            File file = chooser.getSelectedFile();
            dictionaryPathField.setText(file.getAbsolutePath());
            loadDictionary(file.getAbsolutePath());
        }
    }

    private void loadDictionary(String path) 
    {
        DictionaryRepository repo = new DictionaryRepository();

        try 
        {
            List<DictionaryEntry> dict = repo.loadDictionary(path);
            translator = new TranslatorService(dict);
            appendOutput("Dictionary loaded successfully.");
        } 
        catch (Exception e) 
        {
            appendOutput("Error loading dictionary: " + e.getMessage());
        }
    }

    private void translateText() 
    {
        if (translator == null) 
        {
            appendOutput("Please load a dictionary first.");
            return;
        }

        String input = inputTextArea.getText();

        if (input.trim().isEmpty()) 
        {
            appendOutput("Input text is empty.");
            return;
        }

        String result = translator.translate(input);
        appendOutput("Translation result:\n" + result);
    }

    private void appendOutput(String text) 
    {
        outputArea.append(text + "\n");
    }
}