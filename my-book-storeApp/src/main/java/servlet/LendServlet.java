package servlet;

import model.Books;
import model.LendHistory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebServlet("/lend")
public class LendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ISBN = req.getParameter("isbn");

        List<LendHistory> lends = new ArrayList<>(); // Initialize the list

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstoredb", "root", "AWSjob123#");
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM lendinghistory WHERE ISBN = ?")) {

                preparedStatement.setString(1, ISBN);

                try (ResultSet rows = preparedStatement.executeQuery()) {
                    while (rows.next()) {

                        LendHistory newLend = new LendHistory();
                        newLend.setISBN(rows.getString("ISBN"));
                        newLend.setCustomer(rows.getString("Customer"));
                        newLend.setBorrow_date(rows.getString("borrow_date"));
                        newLend.setReturn_date(rows.getString("return_date"));

                        lends.add(newLend);
                    }
                }
            }


            req.setAttribute("lends", lends);
            req.setAttribute("isbn", ISBN);
            req.getRequestDispatcher("lend.jsp").forward(req, resp);

        } catch (SQLException ex) {
            req.setAttribute("errorMsg", "Database error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            req.setAttribute("errorMsg", "Driver error: " + ex.getMessage());
        }


        req.getRequestDispatcher("lend.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ISBN = req.getParameter("ISBN");
        String Customer = req.getParameter("Customer");
        String borrow_date = req.getParameter("borrow_date");
        String return_date = req.getParameter("return_date");

        if (ISBN == null || Customer ==null || borrow_date == null || return_date == null) {
            req.setAttribute("errorMsg", "All fields are required!");
            req.getRequestDispatcher("/lend.jsp").forward(req, resp);
            return;
        }

        try {
            // use connection object to write a query to add things to the database

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstoredb", "root", "AWSjob123#");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into lendinghistory (ISBN, Customer, borrow_date, return_date) values (?, ?, ?, ?)");
            preparedStatement.setString(1, ISBN);
            preparedStatement.setString(2, Customer);
            preparedStatement.setString(3, borrow_date);
            preparedStatement.setString(4, return_date);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resp.sendRedirect(req.getContextPath() + "/lend?isbn=" + ISBN);
            }else {
                req.setAttribute("errorMsg", "Failed to create user.");
                req.getRequestDispatcher("/lend.jsp");
            }
        } catch (SQLException ex) {
            req.setAttribute("errorMsg", "Database error: " + ex.getMessage());
            req.getRequestDispatcher("/lend.jsp").forward(req, resp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
