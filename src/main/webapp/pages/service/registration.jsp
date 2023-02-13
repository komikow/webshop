<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 22.01.2023
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new user</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>firstname</th>
        <th>second name</th>
        <th>age</th>
        <th>login</th>
        <th>password</th>
    </tr>
    </thead>
    <tbody>
    <form action="/user/create" method="post">
        <tr>
            <td><input type="text" name="firstName" placeholder="put your firstname"></td>
            <td><input type="text" name="secondName" placeholder="put your second name"></td>
            <td><input type="text" name="age" placeholder="put your age"></td>
            <td><input type="text" name="login" placeholder="put your login"></td>
            <td><input type="text" name="password" placeholder="put your password"></td>
            <td><input type="submit" value="CREATE"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
