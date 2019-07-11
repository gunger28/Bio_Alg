package com.company;

import java.util.Random;

public class RandimGeneration {

    String[] Sres = new String[30];

    public RandimGeneration() {
        Random rnd = new Random(0);

        int[] res = new int[30];



        for (int i = 0; i < 30; i++) {
            res[i] = rnd.nextInt(100);
            System.out.println(res[i]);
            if (res[i] < 50)
                Sres[i] = "SoS_<0.5";
            else
                Sres[i] = "KoK_>0.5";

        }
    }



}
