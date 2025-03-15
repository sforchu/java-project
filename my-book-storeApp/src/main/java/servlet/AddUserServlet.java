package servlet;

import db.DataBaseConnection;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;



@WebServlet("/register")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String full_name=req.getParameter("full_name");
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        if (full_name == null || username == null || password == null ||
                full_name.isEmpty() || username.isEmpty() || password.isEmpty()) {
//            HttpSession session = req.getSession();
//            session.setAttribute("id", full_name);
            req.setAttribute("errorMsg", "All fields are required!");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }


        try {
            // use connection object to write a query to add things to the database

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstoredb", "root", "AWSjob123#");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into users (full_name, username, password) values (?, ?, ?)");
            preparedStatement.setString(1, full_name);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resp.sendRedirect("success.jsp");
            }else {
                req.setAttribute("errorMsg", "Failed to create user.");
                req.getRequestDispatcher("/register.jsp");
            }
        } catch (SQLException ex) {
            req.setAttribute("errorMsg", "Database error: " + ex.getMessage());
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
