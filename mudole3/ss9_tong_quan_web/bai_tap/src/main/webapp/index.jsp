<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/19/2022
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="/display-discount">
    <div class="discount">
      <h2>Product Discount Calculator</h2>
      <input type="text" name="description" placeholder="Product Description"/> <br>
      <input type="text" name="price" placeholder="Price"/> <br>
      <input type="text" name="discount" placeholder="Discount Percent (%)"/> <br>
      <input type="submit" name="submit" value="submit">
    </div>
  </form>
  </body>
</html>
