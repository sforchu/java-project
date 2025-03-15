<html>
    <body>
        <a href="/my-book-storeApp/login">Back</a>
        <fieldset style="margin-left: 30px; width: 15%">
         <legend>Create User account</legend>
         <div style="color:red"> <%=request.getAttribute("errorMsg")!=null? request.getAttribute("errorMsg"): ""%> </div>
               <form method="POST" action="/my-book-storeApp/register">
                   <input type="text" Name="full_name" placeholder="Enter Full name" required /> <br/> <br/>
                   <input type="text" Name="username" placeholder="Enter username" required /> <br/> <br/>
                   <input type="password" name="password" placeholder="create password" required /> <br/> <br/>
                   <input type="submit" value="Create" style="color: white; background-color: skyblue"/> <br/> <br/>
               </form>
        </fieldset>

    </body>
</html>
