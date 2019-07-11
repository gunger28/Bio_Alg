package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Warning extends JDialog {
    int centerX = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2.5);
    int centerY = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3);

    Font FontText = new Font("Sedge UI", Font.PLAIN, 12);

    JPanel globalPane = new JPanel();
    JPanel paneTop = new JPanel();
    JPanel paneReport = new JPanel();
    JPanel paneHelp = new JPanel();
    JPanel paneBot = new JPanel();


    JTextArea textHalper = new JTextArea("Текст помошник шо делать тут");
    JTextArea textField = new JTextArea("Проверка");
    JButton buttonContinue = new JButton("Продолжить");
    JButton buttonReport = new JButton("Сохранить ошибку");

    public Warning(JFrame MainWindow) {

        super(MainWindow, "Ошибка выполнения", true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        add(globalPane);
        globalPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        paneTop.setLayout(new FlowLayout(FlowLayout.CENTER));
        paneTop.setPreferredSize(new Dimension(350, 210));
        paneBot.setPreferredSize(new Dimension(350, 30));

        globalPane.add(paneTop);
        globalPane.add(paneBot);

        textHalper.setBackground(Color.GRAY);
        textField.setLineWrap(true);
        textField.setFont(FontText);
        textHalper.setFont(FontText);
        textField.setPreferredSize(new Dimension(340, 130));
        textHalper.setPreferredSize(new Dimension(340, 70));


        paneTop.add(paneReport);
        paneReport.add(textField);
        paneTop.add(paneHelp);

        paneHelp.add(textHalper);

        paneBot.setLayout(new FlowLayout(FlowLayout.RIGHT));

        paneBot.add(buttonContinue);
        paneBot.add(buttonReport);


        setLocation(centerX, centerY);
        setSize(400, 300);
        setVisible(true);



        buttonContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Warning.this.setVisible(false);
                Warning.this.dispatchEvent(new WindowEvent(Warning.this, WindowEvent.WINDOW_CLOSING));

            }
        });


    }


}