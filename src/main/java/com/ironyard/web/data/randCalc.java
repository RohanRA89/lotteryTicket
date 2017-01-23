package com.ironyard.web.data;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by rohanayub on 1/18/17.
 */
public class randCalc {

    private final static int MIN = 1;
    private final static int MAX = 53;

    private ArrayList<Integer> lotteryNumbers = new ArrayList<Integer>();

public randCalc() {
    for (int i = 0; i < 6; i++) {
        int tmp = 0;
        do {
            tmp = generateRandomTicketNumber();
            System.out.println("i=" + String.valueOf(i) + ", tmp=" + String.valueOf(tmp));
        } while (lotteryNumbers.contains(tmp));
        lotteryNumbers.add(tmp);
    }
}

        private int generateRandomTicketNumber() {
            Random r = new Random();
            int got = r.nextInt((randCalc.MAX - randCalc.MIN) + 1) + randCalc.MIN;
            return got;
        }

        public String toString() {
            String display = "<strong>";
            for (int i = 0; i < lotteryNumbers.size(); i++) {
                display = display + String.format("%02d", lotteryNumbers.get(i)) + "  ";
            }
            display = display + "</strong>";
            return display;
        }



}


/*for(int i = 0;  i < 6; i++){
            System.out.println(getRandomNumberInRange(1, 53));
        }
        */


    /*private static int getRandomNumberInRange(int i, int i1) {
        if (i >= i1 && i != i1) {
            throw new IllegalArgumentException("numbers cannot be equal");
        }
        return (int)(Math.random()) * ((i1 - i)+1) + i;
    }*/