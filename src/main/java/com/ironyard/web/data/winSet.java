package com.ironyard.web.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by rohanayub on 1/19/17.
 */
public class winSet {
    private ArrayList<Integer> winNumbers = new ArrayList<Integer>();
//private ArrayList<Integer> genNumbers = (ArrayList<randCalc>) session.getAttribute("lottList");


    public winSet(){
        ArrayList<Integer> winNumbers = new ArrayList<Integer>(Arrays.asList(new Integer[]{11, 48, 23, 43, 7, 52}));
        winNumbers.addAll(winNumbers);
        System.out.println(winNumbers);

    }





}
