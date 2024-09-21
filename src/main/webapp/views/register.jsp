<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
    <form action="/loginweb/register" method="post">
        <c:if test="${alert != null}">
            <h3>${alert}</h3>
        </c:if>

        <div>
            <label for="username"><b>Username</b></label><br>
            <input type="text" placeholder="Enter Username" name="username" required><br><br>

            <label for="password"><b>Password</b></label><br>
            <input type="password" placeholder="Enter Password" name="password" required><br><br>

            <label for="fullname"><b>Full Name</b></label><br>
            <input type="text" placeholder="Enter Full Name" name="fullname" required><br><br>

            <label for="email"><b>Email</b></label><br>
            <input type="email" placeholder="Enter Email" name="email" required><br><br>

            <label for="roleid"><b>Role ID</b></label><br>
            <input type="number" placeholder="Enter Role ID" name="roleid" required><br><br>

            <button type="submit">Register</button>
        </div>
    </form>
</body>
</html>
