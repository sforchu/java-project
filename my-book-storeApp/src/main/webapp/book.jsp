<html>
    <body>
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

                    </tbody>
                </table>
___________________________________________________________________________________________________________________________


        <fieldset style="margin-left: 30px; width: 15%">
         <legend>Add New Book</legend>
         <div style="color:red"> <%=request.getAttribute("errorMsg")!=null? request.getAttribute("errorMsg"): ""%> </div>
               <form method="POST" action="/my-book-storeApp/book">
                   <input type="text" Name="ISBN" placeholder="Enter ISBN" /> <br/> <br/>
                   <input type="text" Name="Title" placeholder="Enter Title" /> <br/> <br/>
                   <input type="text" name="Author" placeholder="Enter Author" /> <br/> <br/>
                   <input type="text" name="Edition" placeholder="Enter Book Edition" /> <br/> <br/>
                   <input type="submit" value="Create" style="color: white; background-color: skyblue"/> <br/> <br/>
               </form>
        </fieldset>

    </body>
</html>

