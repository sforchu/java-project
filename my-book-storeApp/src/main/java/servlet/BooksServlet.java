package servlet;

import model.Books;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/book")
public class BooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            // use connection object to write a query to add things to the database

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstoredb", "root", "AWSjob123#");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from books");

            ResultSet rows = preparedStatement.executeQuery();

            List<Books> books = new ArrayList<>();

            while (rows.next()) {
                Books newBook = new Books();
                newBook.setISBN(rows.getString("ISBN"));
                newBook.setTitle(rows.getString("Title"));
                newBook.setAuthor(rows.getString("Author"));
                newBook.setEdition(rows.getString("Edition"));

                books.add(newBook);
            }

            req.setAttribute("books", books);


        } catch (SQLException ex) {
            req.setAttribute("errorMsg", "Database error: " + ex.getMessage());
//            req.getRequestDispatcher("/book.jsp").forward(req, resp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("/book.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ISBN= req.getParameter("ISBN");
        String Title=req.getParameter("Title");
        String Author=req.getParameter("Author");
        String Edition=req.getParameter("Edition");

        if (ISBN == null || Title == null || Author == null || Edition == null ||
                ISBN.isEmpty() || Title.isEmpty() || Author.isEmpty() || Edition.isEmpty()) {
//            HttpSession session = req.getSession();
//            session.setAttribute("id", full_name);
            req.setAttribute("errorMsg", "All fields are required!");
            req.getRequestDispatcher("/book.jsp").forward(req, resp);
            return;
        }


        try {
            // use connection object to write a query to add things to the database

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstoredb", "root", "AWSjob123#");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into books (ISBN, Title, Author, Edition) values (?, ?, ?, ?)");
            preparedStatement.setString(1, ISBN);
            preparedStatement.setString(2, Title);
            preparedStatement.setString(3, Author);
            preparedStatement.setString(4, Edition);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                resp.sendRedirect(req.getContextPath() + "/book");
            }else {
                req.setAttribute("errorMsg", "Failed to create user.");
                req.setAttribute("books", new ArrayList<>());
                req.getRequestDispatcher("/book.jsp");
            }
        } catch (SQLException ex) {
            req.setAttribute("errorMsg", "Database error: " + ex.getMessage());
            req.setAttribute("books", new ArrayList<>());
            req.getRequestDispatcher("/book.jsp").forward(req, resp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
