
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<h1>请假审批</h1>
		
		<a href="${base.contextPath}/process/leave/deply">首先部署流程</a>
		
		<form   method="post"  action="${base.contextPath}/process/leave/start">
		
		<table border ="1">
				<tr>
					<th>标题</th>
						<td>
							<input  type="text"  name="title"/>
						</td>
				
				</tr>
				<tr>
					<th>内容</th>
						<td>
							<input  type="text"  name="content"/>
						</td>
				
				</tr>
				
					<tr>
					<th>天数</th>
						<td>
							<input  type="text"  name="day"/>
					</td>
				
				</tr>
		
			<tr>
					<th>提交审批</th>
						<td>
							<input  type="submit"  name="提交"/>
					</td>
				
				</tr>
		
		
		</table>
		
		
		</form>
		
		
</body>
</html>