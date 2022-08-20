<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/17/2022
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Bai 2</title>
    <style>
      .login
      {
        height: 180px;
        width: 230px;
        margin: 0;
        padding: 10px;
        border: 1px solid #CCC;
      }
      .login
      {
        padding: 5px;
        margin: 5px;
      }
    </style>
  </head>
  <body>
  <form  method="post" action="/login">
    <div class="login">
      <h2>Login</h2>
      <input type="text" name="username" size="30" placeholder="username"/>
      <input type="password" name="password" size="30" placeholder="password"/>
      <input type="submit" value="Sign in"/>
    </div>
  </form>
  </body>
</html>
