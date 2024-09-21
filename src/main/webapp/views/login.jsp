<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="/loginweb/login" method="post">

		<c:if test="${alert !=null}">
			<h3 class="alert alertdanger">${alert}</h3>
		</c:if>


		<c:if test="${not empty param.logoutMessage}">
			<h3>Bạn đã đăng xuất thành công.</h3>
		</c:if>

		<div class="container">
			<label for="uname"><b>Username</b></label><br> <input
				type="text" placeholder="Enter Username" name="uname" required><br>
			<br> <label for="psw"><b>Password</b></label><br> <input
				type="password" placeholder="Enter Password" name="psw" required><br>
			<br>

			<button type="submit">Login</button>
			<label> <input type="checkbox" checked="checked"
				name="remember"> Remember me
			</label>
		</div>

		<div class="container" style="background-color: #f1f1f1">
			<button type="button" class="cancelbtn">Cancel</button>
			<br> <span class="psw">Forgot <a
				href="${pageContext.request.contextPath}/forgotpassword">password?</a></span>
			<span class="psw">Or <a
				href="${pageContext.request.contextPath}/register">Register</a></span>
		</div>
	</form>
</body>
</html>
