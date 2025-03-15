package servlet;

import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        try {
            // use connection object to write a query to add things to the database

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstoredb", "root", "AWSjob123#");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password from users where username = ?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

           if (rs.next()) {
               String storedPassword = rs.getString("password");

               if (password.equals(storedPassword)) {

                   HttpSession session = req.getSession();
                   session.setAttribute("id", username);
                   session.setMaxInactiveInterval(300);

                   resp.sendRedirect(req.getContextPath() + "/book");
               } else {
                   req.setAttribute("errorMsg", "Wrong username or password");
                   req.getRequestDispatcher("index.jsp").forward(req, resp);
               }
           } else {
               req.setAttribute("errorMsg", "Wrong username or password");
               req.getRequestDispatcher("index.jsp").forward(req, resp);
           }

        } catch (Exception ex) {
            req.setAttribute("errorMsg", "Database connection error: " + ex.getMessage());
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }
}
