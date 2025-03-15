<html>
    <body>
        <a href="/my-book-storeApp/logout">Logout</a> | <a href="/my-book-storeApp/welcome">Welcome</a>
        <fieldset style="margin-left: 30px; width: 15%">
         <legend>Please Login</legend>
         <div style="color:red"> <%=request.getAttribute("errorMsg")!=null? request.getAttribute("errorMsg"): ""%> </div>
               <form method="POST" action="/my-book-storeApp/login">
                   <input type="text" name="username" placeholder="Enter username" /> <br/> <br/>
                   <input type="password" name="password" placeholder="Enter password" /> <br/> <br/>
                   <input type="submit" value="login" style="color: white; background-color: skyblue"/> <br/> <br/>
               </form>
        </fieldset>


        <a href="/my-book-storeApp/register">Create Account</a>

    </body>
</html>
