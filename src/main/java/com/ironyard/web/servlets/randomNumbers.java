package com.ironyard.web.servlets;

import com.ironyard.web.data.randCalc;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by rohanayub on 1/18/17.
 */
@WebServlet(name = "randomNumbers", urlPatterns = "/generateNumbers")
public class randomNumbers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        randCalc numbers = new randCalc();
        ArrayList<randCalc> lotteryNumbers =  (ArrayList<randCalc>)request.getSession().getAttribute("lottList");

        if(lotteryNumbers == null){
            lotteryNumbers = new ArrayList<randCalc>();
            request.getSession().setAttribute("lottList" , lotteryNumbers);
        }
        lotteryNumbers.add(numbers);

        // forward to next jsp
        String nextJSP = "/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
