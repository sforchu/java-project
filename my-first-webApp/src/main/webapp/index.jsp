<html>
    <body>
        <fieldset style="margin-left: 30px; width: 15%">
         <legend>Login</legend>
         <div style="color:red"> <%=request.getAttribute("errorMsg")!=null? request.getAttribute("errorMsg"): ""%> </div>
               <form method="POST" action="/my-first-webApp/login">
                   <input type="text" name="username" placeholder="Enter username" /> <br/> <br/>
                   <input type="password" name="password" placeholder="Enter password" /> <br/> <br/>
                   <input type="submit" value="login" style="color: white; background-color: skyblue"/> <br/> <br/>
               </form>
        </fieldset>

    </body>
</html>