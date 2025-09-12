import Laba_1.Laba1Panel;

import javax.swing.*;
import java.awt.*;

public class CourseworkMainFrame extends JFrame
{
    private JPanel contentPanel;

    public CourseworkMainFrame()
    {
        super("Coursework App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Выбираем задание
        JPanel topPanel = new JPanel();
        String[] labs = {"Laba 1", "Laba 2", "Laba 3", "Laba 4"};
        JComboBox<String> labSelector = new JComboBox<>(labs);
        topPanel.add(new JLabel("Select Lab:"));
        topPanel.add(labSelector);
        add(topPanel, BorderLayout.NORTH);

        // Панель, в которую вставляется UI выбранного задания
        contentPanel = new JPanel(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);

        labSelector.addActionListener(e ->
        {
            String selected = (String) labSelector.getSelectedItem();
            loadLab(selected);
        });

        // Загружаем по умолчанию задание 1
        loadLab(labs[0]);
    }

    private void loadLab(String lab)
    {
        contentPanel.removeAll();

        switch (lab)
        {
            case "Laba 1":
                contentPanel.add(new Laba1Panel(), BorderLayout.CENTER);
                break;
            case "Laba 2":
                contentPanel.add(new JLabel("Laba 2 - late"), BorderLayout.CENTER);
                break;
            case "Laba 3":
                contentPanel.add(new JLabel("Laba 3 - late"), BorderLayout.CENTER);
                break;
            case "Laba 4":
                contentPanel.add(new JLabel("Laba 4 - late"), BorderLayout.CENTER);
                break;
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            CourseworkMainFrame frame = new CourseworkMainFrame();
            frame.setVisible(true);
        });
    }
}