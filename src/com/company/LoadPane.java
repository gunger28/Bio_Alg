package com.company;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LoadPane extends JFrame {

    // Задание директории где беруться фотки плат
String directory = "C:\\Users\\Pyth\\Desktop\\Алгоритмы Биологи\\src\\com\\company";

    static File file;

    int centerX = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2.5);
    int centerY = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3);

    JFileChooser fileopen = new JFileChooser(directory);

    SpringLayout layout = new SpringLayout();


    JPanel globalPane = new JPanel();
    JButton button = new JButton("Выберите фото платы");
    JLabel label = new JLabel();

    public LoadPane() {
        super("Выбор фото");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(globalPane);
        JLabel textNameSerial = new JLabel("Ваша серия: " + StartPane.textSerial.getText());

        globalPane.setLayout(layout);


        globalPane.add(textNameSerial);
        globalPane.add(button);
        globalPane.add(label);


        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textNameSerial, 0,
                SpringLayout.HORIZONTAL_CENTER, globalPane);
        layout.putConstraint(SpringLayout.NORTH, textNameSerial, 10,
                SpringLayout.NORTH, globalPane);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, button, 0,
                SpringLayout.HORIZONTAL_CENTER, globalPane);
        layout.putConstraint(SpringLayout.NORTH, button, 30,
                SpringLayout.NORTH, globalPane);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0,
                SpringLayout.HORIZONTAL_CENTER, globalPane);
        layout.putConstraint(SpringLayout.NORTH, label, 65,
                SpringLayout.NORTH, globalPane);


//    Открытие директории и выбор файла из нее

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    file = fileopen.getSelectedFile();
                    label.setText(file.getName());

                    // Проверка на файл и открытие основного окна

                    if (file.getName() != null) {

                        try {
                            setVisible(false);
                            dispose();
                            Main.WorkPane();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }


                    }

                }
            }
        });


        setLocation(centerX, centerY);
        setSize(400, 150);
        setVisible(true);
    }

}
