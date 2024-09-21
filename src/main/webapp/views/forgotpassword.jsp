<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/forgotpassword" method="post">
        <c:if test="${not empty alert}">
            <h3 class="alert alert-danger">${alert}</h3>
        </c:if>

        <label for="email"><b>Email</b></label>
        <input type="email" placeholder="Enter your email" name="email" required>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
