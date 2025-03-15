<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.List,java.sql.*,java.time.LocalDateTime,java.time.format.DateTimeFormatter,java.lang.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="model.Books" %>
<html>
    <body>
    <a href="/my-book-storeApp/logout">Logout</a> | <a href="/my-book-storeApp/lend">Lend this book</a>
        <h2>All Books</h2>
                <table border="1" style="width: 50%; margin-left: 30px;">
                    <thead>
                        <tr>
                            <th>SN</th>
                            <th>ISBN</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Edition</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        int cnt = 1;
                        List<Books> books = (List<Books>) request.getAttribute("books");
                        for(Books bk: books){
                            out.println("<tr>");
                                out.println("<td>"+ cnt++ +"</td>");
                                out.println("<td><a href='/my-book-storeApp/lend?isbn="+bk.getISBN()+"'>"+ bk.getISBN() +"</a></td>");
                                out.println("<td>"+ bk.getTitle() +"</td>");
                                out.println("<td>"+ bk.getAuthor() +"</td>");
                                out.println("<td>"+ bk.getEdition() +"</td>");
                            out.println("</tr>");
                        }
                        %>

                    </tbody>
                </table>
___________________________________________________________________________________________________________________________


        <fieldset style="margin-left: 30px; width: 15%">
         <legend>Add New Book</legend>
         <div style="color:red"> <%=request.getAttribute("errorMsg")!=null? request.getAttribute("errorMsg"): ""%> </div>
               <form method="POST" action="/my-book-storeApp/book">
                   <input type="text" Name="ISBN" placeholder="Enter ISBN" required /> <br/> <br/>
                   <input type="text" Name="Title" placeholder="Enter Title" required /> <br/> <br/>
                   <input type="text" name="Author" placeholder="Enter Author" required /> <br/> <br/>
                   <input type="text" name="Edition" placeholder="Enter Book Edition" required /> <br/> <br/>
                   <input type="submit" value="Create" style="color: white; background-color: skyblue"/> <br/> <br/>
               </form>
        </fieldset>

    </body>
</html>

