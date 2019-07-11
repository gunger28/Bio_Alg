package com.company;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;


public class Main {

   static LoadPane LP;
    static  StartPane stP;
   static MainWindow MW ;
    static  Warning WP;
    public static void main(String[] args) throws IOException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
StartPane();
       //LoadPane();
//WorkPane();
//WarningPane();

    }

    public static void StartPane() {

         stP = new StartPane();


    }

    public static void WorkPane() throws IOException {

         MW = new MainWindow();

    }

    public static void LoadPane() {
         LP = new LoadPane();


    }

    public static void WarningPane() {
       WP = new Warning(MW);


    }


    public static void WarningPaneClose(int trow) {



    }
}
