<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="model.LendHistory" %>
<html>
    <body>
        <a href="/my-book-storeApp/logout">Logout</a> | <a href="/my-book-storeApp/book">Back</a>
        <h2>All Books</h2>
        <table border="1" style="width: 50%; margin-left: 30px;">
            <thead>
                <tr>
                    <th>SN</th>
                    <th>ISBN</th>
                    <th>Customer</th>
                    <th>Borrow Date</th>
                    <th>Return Date</th>
                </tr>
            </thead>
            <tbody>
                <%
                // Null check for lends list
                List<LendHistory> lends = (List<LendHistory>) request.getAttribute("lends");

                int cnt = 1;
                for(LendHistory ld : lends){
                    out.println("<tr>");
                    out.println("<td>"+ cnt++ +"</td>");
                    out.println("<td>" + ld.getISBN() + "</td>");  // Include ISBN
                    out.println("<td>" + ld.getCustomer() + "</td>");
                    out.println("<td>" + ld.getBorrow_date() + "</td>");
                    out.println("<td>" + ld.getReturn_date() + "</td>");
                    out.println("</tr>");
                }
                %>
            </tbody>
        </table>

=========================================================================================================================================================

        <fieldset style="margin-left: 30px; width: 15%;">
            <legend>Lend This Book</legend>
            <div style="color:red;">
                <%= request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "" %>
            </div>
            <form method="POST" action="/my-book-storeApp/lend">
                <input type="hidden" name="ISBN" value='<%= request.getAttribute("isbn")%>' /> <br/><br/>
                <label for="Customer">Customer: </label>
                <input type="text" name="Customer" placeholder="Enter Full Name" required /> <br/><br/>
                <label for="borrow_date">Borrow Date: </label>
                <input type="date" name="borrow_date" required /> <br/><br/>
                <label for="return_date">Return Date: </label>
                <input type="date" name="return_date" required /> <br/><br/>
                <input type="submit" value="Submit" style="color: white; background-color: skyblue" /> <br/><br/>
            </form>
        </fieldset>
    </body>
</html>
