
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<h1>login</h1>
		<form  action="${base.contextPath}/user/login"  method="post">
				<input  type="text"  name="uname"/>
				<input  type="password" name="upass" />
			<input  type="submit"/>
		</form>
		<h3>
			${loginError}
		
		</h3>
		
		
</body>
</html>