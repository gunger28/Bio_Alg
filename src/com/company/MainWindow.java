package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainWindow extends JFrame {

    int centerX = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 5);
    int centerY = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 10);
    GridLayout GridVertical = new GridLayout(1, 0, 20, 0);
    Font FontText = new Font("Sedge UI", Font.PLAIN, 17);
    Font FontTable = new Font("Sedge UI", Font.PLAIN, 17);
    // Данные для таблиц



    String[] values = new String[30];



    Image img1 = ImageIO.read(LoadPane.file);

    public Image img = img1.getScaledInstance(790,400,1);



    JButton buttonRestart = new JButton("Загрузить новый образец");
    JButton buttonSave = new JButton("Сохранить образец");
    JButton buttonExit = new JButton("Выйти из программы");
    JPanel panelBtnColor = new JPanel(GridVertical);


    JPanel paneLeft = new JPanel();
    JPanel paneTop = new JPanel();
    JPanel paneIMG = new JPanel();
    JPanel paneRight = new JPanel();
    JPanel paneResult = new JPanel();

    BufferedImage ico = ImageIO.read(new File("C:\\Users\\Pyth\\Desktop\\Bio_Alg\\src\\com\\company\\Ico.png"));
    ImageIcon icon = new ImageIcon(ico);


    JPanel globalPane = new JPanel();

    public MainWindow() throws IOException {
        super("Считывание точек");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(icon.getImage());

        RandimGeneration RG = new RandimGeneration();
        GoodTable(RG.Sres);

         Object[][] array = new String[][]{{"1я точка", values[0], values[1], values[2], values[3], values[4]},
                {"2я точка", values[5],  values[6], values[7], values[8], values[9]},
                {"3я точка", values[10], values[11], values[12], values[13], values[14]},
                {"4я точка", values[15], values[16], values[17], values[18], values[19]},
                {"5я точка", values[20], values[21], values[22], values[23], values[24]},
                {"6я точка", values[25], values[26], values[27], values[28], values[29]}};
        // Заголовки столбцов
         Object[] columnsHeader = new String[]{"№ точки", "1й гребень",
                "2й гребень", "3й гребень", "4й гребень", "5й гребень"};

        //  добавлять в зависимости от серии
        JTable table1 = new JTable(array, columnsHeader);
        JScrollPane tbSc = new JScrollPane(table1);



        buttonExit.setFont(FontText);
        buttonSave.setFont(FontText);
        buttonRestart.setFont(FontText);
        panelBtnColor.setBackground(Color.DARK_GRAY);

        paneTop.setLayout(GridVertical);
        paneTop.add(buttonRestart);
        paneTop.add(panelBtnColor);
        panelBtnColor.add(buttonSave);
        paneTop.add(buttonExit);

// Настройка размера и шрифта таблицы

        Box contents = new Box(BoxLayout.Y_AXIS);
        table1.setFont(FontTable);
        table1.setRowHeight(50);
        table1.setGridColor(Color.LIGHT_GRAY);

        contents.add(tbSc);

        tbSc.setPreferredSize(new Dimension(780, 328));
        paneResult.setPreferredSize(new Dimension(790, 350));

        paneLeft.setBackground(Color.DARK_GRAY);
        paneRight.setBackground(Color.BLUE);
        paneTop.setBackground(Color.DARK_GRAY);

        paneResult.add(contents);


        buttonExit.setBackground(Color.RED);
        buttonSave.setBackground(Color.RED);
        buttonRestart.setBackground(Color.RED);

        paneLeft.setPreferredSize(new Dimension(800, 850));
        paneRight.setPreferredSize(new Dimension(370, 800));
        paneTop.setPreferredSize(new Dimension(790, 80));
        paneIMG.setPreferredSize(new Dimension(790, 400));


        globalPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(globalPane);
        paneLeft.setLayout(new FlowLayout(FlowLayout.CENTER));
        globalPane.add(paneLeft);

        paneLeft.add(paneTop);
        paneLeft.add(paneIMG);
        paneLeft.add(paneResult);

        globalPane.add(paneRight);




        JLabel l = new JLabel(new ImageIcon(img));
        l.setBounds(0, 0, 50, 50);
        l.setVisible(true);

        paneIMG.setLayout(new FlowLayout(FlowLayout.CENTER));
        paneIMG.add(l);


        setLocation(centerX, centerY);
        setSize(1200, 900);
        setVisible(true);


        buttonRestart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StartPane SP = new StartPane();

                setVisible(false);
                dispose();
            }
        });


        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Main.WarningPane();

            }
        });


        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();

            }
        });
    }


    public void GoodTable(String call[]) {
        for (int i = 0; i < 30; i++)
            values[i] = String.valueOf(call[i]);
            //values[i] = String.valueOf(call[i]);
        values[4] = StartPane.textSerial.getText();
    }
}
