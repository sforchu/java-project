package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static db.FakeDB.USER_DB;

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
        String fakePwd = USER_DB.get(username);
        if(password.equals(fakePwd)){

            HttpSession session = req.getSession();
            session.setAttribute("id", username);
            session.setMaxInactiveInterval(15);

            resp.sendRedirect(req.getContextPath() + "/check");
            //req.getRequestDispatcher("home.jsp").forward(req, resp);
            // resp.getWriter().print("Success");
        }else {
            String error = "wrong username or password";
            req.setAttribute("errorMsg", error);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }
}
