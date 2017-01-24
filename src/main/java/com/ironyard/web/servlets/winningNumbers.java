package com.ironyard.web.servlets;

import com.ironyard.web.data.randCalc;
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

         ArrayList<randCalc>generatedPicks = (ArrayList<randCalc>) request.getSession().getAttribute("lottList");
         String genNumbs = null;
         for(randCalc genNumb : generatedPicks){
             System.out.println(genNumb);
              genNumbs = String.valueOf(genNumb);
         }

        // List<randCalc>genPicks = new ArrayList<randCalc>(generatedPicks);

        //int generatedPicks = (int) request.getSession().getAttribute("lottList");
        //ArrayList<Integer> yourGeneratedPicks = new ArrayList<Integer>(generatedPicks);

        //request.getSession().setAttribute("listOfPicks" , generatedPicks);


        /*String generatedNumbers = String.valueOf(request.getParameterValues("${numbers}"));
        List<Integer> pickList = new ArrayList<Integer>(Integer.parseInt(generatedNumbers));
        System.out.println(generatedNumbers);
        request.setAttribute("listOfPicks" , pickList);*/

        ArrayList<Integer> winningNumbers  = new ArrayList<Integer>(Arrays.asList(new Integer[]{11, 48, 23, 43, 7, 52}));
        String winNumbs = null;
        for(Integer winNumb : winningNumbers){
            System.out.println(winNumb);
            winNumbs = String.valueOf(winNumb);
        }
        List winList = new ArrayList<Integer>(winningNumbers);

        
        request.setAttribute("lotteryWin" , winList);


        String matchingNumbers = null;
        if(winNumbs !=genNumbs){
            matchingNumbers = "Sorry you did not match any numbers you do not win.";
        }
        else if(winNumbs == genNumbs){
            matchingNumbers = "You've won a million dollars!";
        }
        request.setAttribute("ticketOutcome", matchingNumbers);


        String nextJSP = "/checkAgainstWinningNumbers.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
