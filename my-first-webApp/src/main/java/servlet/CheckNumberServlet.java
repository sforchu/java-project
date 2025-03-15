package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/check")

public class CheckNumberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String firstNumber = req.getParameter("first number");
        String secondNumber = req.getParameter("second number");

        // convert to integer
        int first = Integer.parseInt(firstNumber);
        int second = Integer.parseInt(secondNumber);
        String message;
        if(first>second){
            message = firstNumber + " is greater than " + secondNumber;
        }else{
            message = secondNumber + " is greater than " + firstNumber;
        }

        req.setAttribute("msg", message);

        req.getRequestDispatcher("result.jsp").forward(req, resp);

        }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

}
