<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html> 
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<title>Login Page For First spring app</title>
</head>
<body>
<div class="container">
<h1>LOGIN PAGE-Janarthan T</h1>
<pre>${errormessage }</pre>
<div>

<form method="POST">
Name:<input type="text" name="username"/>
Password:<input type="password" name="password"/>
<input type="submit">
 </form>

</div>
</div>

<script src="webjars/bootstrap/3.3.6/bootstrap.min.js"></script>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
</body>

</html>