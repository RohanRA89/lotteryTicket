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
        ArrayList<Integer> winningNumbers  = new ArrayList<Integer>(Arrays.asList(new Integer[]{11, 48, 23, 43, 7, 52}));

         ArrayList<randCalc>generatedPicks = (ArrayList<randCalc>) request.getSession().getAttribute("lottList");
         //String genNumbs = null;
         // iterating all user generated tickets
         for(randCalc aTicket : generatedPicks){
             System.out.println(aTicket);

              //genNumbs = String.valueOf(aTicket);
             // iteratting all numbers in a single user ticket
              for(int aNumberInATicket: aTicket.getLotteryNumbers()) {

                  String ticketMatch = null;
                  // iterating all winning number
                  for (Integer aWinningNumber : winningNumbers) {
                      // compare this winning number vs the user number

                      if(aWinningNumber == aNumberInATicket){
                          // we have a user gen ticket with a matched number
                          aNumberInATicket++;
                          System.out.println(aNumberInATicket);


                      }

                      int match = Integer.parseInt(ticketMatch);//give me a null result. Number is not looping back around.
                      //int match = aNumberInATicket gives me one value that cycles through and auto assigns a winner of one million.
                      String results = null;
                      if (match ==0){
                          results = "Sorry you did not win. T.T";
                      }
                      else if(match <= 2 && match == 0){
                          results = "You've won a free ticket!";
                      }
                      else if(match == 3){
                          results = "You've won $3!";
                      }
                      else if (match == 4){
                          results = "You've won $5!";
                      }
                      else if (match ==5){
                          results = "You've won $10";
                      }
                      else{
                          results = "Wow! That's a prize of $1,000,000";
                      }
                      request.setAttribute("winMessage" ,results);
                  }

              }

         }


       // ArrayList<Integer> winningNumbers  = new ArrayList<Integer>(Arrays.asList(new Integer[]{11, 48, 23, 43, 7, 52}));
//        String winNumbs = null;
//        for(Integer winNumb : winningNumbers){
//            System.out.println(winNumb);
//            winNumbs = String.valueOf(winNumb);
//        }
        List winList = new ArrayList<Integer>(winningNumbers);


        request.setAttribute("lotteryWin" , winList);


        /*String matchingNumbers = null;
        if(winNumbs !=genNumbs){
            matchingNumbers = "Sorry you did not match any numbers you do not win.";
        }
        else if(winNumbs == genNumbs){
            matchingNumbers = "You've won a million dollars!";
        }*/
        //request.setAttribute("ticketOutcome", ticketResult);


        String nextJSP = "/checkAgainstWinningNumbers.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
