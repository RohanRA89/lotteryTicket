package com.ironyard.web.servlets;

import org.apache.commons.collections.CollectionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rohanayub on 1/19/17.
 */
@WebServlet(name = "winningNumbers" , urlPatterns = "/checkNumbers")
public class winningNumbers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         ArrayList<Integer>generatedPicks = (ArrayList<Integer>) request.getSession().getAttribute("lottList");
         List<Integer>genPicks = new ArrayList<Integer>(generatedPicks);

        //int generatedPicks = (int) request.getSession().getAttribute("lottList");
        //ArrayList<Integer> yourGeneratedPicks = new ArrayList<Integer>(generatedPicks);

        //request.getSession().setAttribute("listOfPicks" , generatedPicks);


        /*String generatedNumbers = String.valueOf(request.getParameterValues("${numbers}"));
        List<Integer> pickList = new ArrayList<Integer>(Integer.parseInt(generatedNumbers));
        System.out.println(generatedNumbers);
        request.setAttribute("listOfPicks" , pickList);*/

        ArrayList<Integer> winningNumbers = new ArrayList<Integer>(Arrays.asList(new Integer[]{11, 48, 23, 43, 7, 52}));

        List<Integer> winList = new ArrayList<Integer>(winningNumbers);
        //List<Integer> randomList = new ArrayList<randCal>(lotteryNumbers);
        request.setAttribute("lotteryWin" , winList);

        ArrayList<Integer> commonNumbers = (ArrayList) CollectionUtils.retainAll(winList , genPicks);
        System.out.println(commonNumbers);
        List<Integer> matching = commonNumbers;
        request.setAttribute("matchNumb", matching);

        //ArrayList<Integer> numbersThatMatch = CollectionsUtils.retainAll(winList , yourGeneratedPicks );
        //String results = null;


        String nextJSP = "/checkAgainstWinningNumbers.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
