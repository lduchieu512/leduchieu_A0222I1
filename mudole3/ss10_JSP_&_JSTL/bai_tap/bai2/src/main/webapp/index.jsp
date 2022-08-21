<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/20/2022
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      th{
        text-align: left;
      }
      select{
        width: 100%;
        text-align: center;
      }

    </style>
  </head>

  <body>
  <h1>Simple Calculator</h1>
  <form action="/Calculator" method="post">
      <fieldset>
        <legend>
          Calculator
        </legend>
        <table>
          <tr>
            <th>First operand: </th>
            <th><input type="text" name="First" ></th>
          </tr>
          <tr>
            <th>Operator: </th>
            <th><select name="Operator">
              <option value="+">+</option>
              <option value="-">-</option>
              <option value="*">*</option>
              <option value="/">/</option>
          </select></th>
          </tr>
          <tr>
            <th>Second operand: </th>
            <th><input type="text" name="Second" ></th>
          </tr>
          <tr>
            <th> </th>
            <th><button>calculate </button></th>
          </tr>

        </table>
      </fieldset>
  </form>
  </body>
</html>
