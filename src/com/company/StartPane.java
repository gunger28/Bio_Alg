package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class StartPane extends JFrame {


   static JLabel textNameSerial = new JLabel("Введите серию и номер:");
    public static JTextField textSerial = new JTextField();
    JButton buttonAccept = new JButton("Принять");

    SpringLayout layout = new SpringLayout();

    int centerX = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2.5);
    int centerY = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3);

    JPanel globalPane = new JPanel();

    public StartPane() {

        // Начало Ввода с главным контейнером
        super("Начало работы");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(globalPane);
        globalPane.setLayout(layout);


        //Использование элементов
        textSerial.setPreferredSize(new Dimension(150, 30));
        buttonAccept.setPreferredSize(new Dimension(100, 40));
        textNameSerial.setPreferredSize(new Dimension(160, 20));

        textNameSerial.setLayout(new FlowLayout(FlowLayout.CENTER));
        textNameSerial.setHorizontalAlignment(JLabel.CENTER);
        buttonAccept.setFocusable(true);
        globalPane.add(textNameSerial);
        globalPane.add(textSerial);
        globalPane.add(buttonAccept);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textNameSerial, 0,
                SpringLayout.HORIZONTAL_CENTER, globalPane);
        layout.putConstraint(SpringLayout.NORTH, textNameSerial, 10,
                SpringLayout.NORTH, globalPane);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textSerial, 0,
                SpringLayout.HORIZONTAL_CENTER, globalPane);
        layout.putConstraint(SpringLayout.NORTH, textSerial, 30,
                SpringLayout.NORTH, globalPane);


        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonAccept, 0,
                SpringLayout.HORIZONTAL_CENTER, globalPane);
        layout.putConstraint(SpringLayout.NORTH, buttonAccept, 65,
                SpringLayout.NORTH, globalPane);


        buttonAccept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tick!");
                switch (CheckUp()) {
                    case 1:
                        Main.LoadPane();
                        textNameSerial.setText("Введите серию и номер:");
                        setVisible(false);
                        dispose();
                        break;

                    case 2:
                        Main.LoadPane();
                        textNameSerial.setText("Введите серию и номер:");
                        setVisible(false);
                        dispose();
                        break;

                    case 3:
                        textNameSerial.setText("Вы неправильно ввели серию");
                        System.out.println("eto ze 3");
                        Repain();
                        break;

                    //Добавить Админа и в проверку тоже
                }


            }
        });

        // Вывод окна на экран
        setLocation(centerX, centerY);
        setSize(400, 150);
        setVisible(true);
    }

    int CheckUp() {
        int Value = 0;
        System.out.println(textSerial.getText());
        StringBuilder text = new StringBuilder();
        char[] textCheck = textSerial.getText().toCharArray();
        for (int i = 0; i < 4; i++) {
            text.append(textCheck[i]);

        }
        // 1я серия проверка
        if (text.toString().equals("1234"))
            Value = 1;

        Repain();

        // 2я серия проверка
        if (text.toString().equals("4321"))
            Value = 2;

        Repain();

// 3я серия проверка
        if (!text.toString().equals("4321") && !text.toString().equals("1234"))
            Value = 3;

        System.out.println(text);

        return Value;
    }


    void Repain() {
        textNameSerial.setForeground(Color.RED);
        revalidate();
        repaint();


    }

}