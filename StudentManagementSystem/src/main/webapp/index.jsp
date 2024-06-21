<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href = "assets/css/login.css">
<link rel="icon" href="images/title-image.png" type="image/png" sizes="16x16">
<style>
	h4{
		 text-align: center;
		 font-weight: 400;
	}
</style>
</head>
<body>
	<div class="login">
	<h1>S<span style ="color:#5d98d9; margin-left:5px; margin-right:5px;">M</span>S</h1>
	<h4><span style="color:#ffd100">${invalidCredential}</span></h4>
    <form action ="Login" method="post">
    	<input type="email" name="name" placeholder="Username" required="required" />
        <input type="password" name="pass" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Login</button>
        
    </form>
    <h4 style = "color:#ffd100">Are you sells? <a href = "#" style = "color:#5d98d9; text-decoration: none;">Login Here</a></h4>
</div>
</body>
</html>