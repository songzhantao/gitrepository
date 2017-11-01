<#import "page.ftl" as page>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>${loginUser}</h1>	
		<@page.lanqiaopage  url="/user/list" page=100 nowPage=1/>
		
		
</body>
</html>