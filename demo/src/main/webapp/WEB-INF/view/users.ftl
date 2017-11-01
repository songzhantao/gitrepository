
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script  type="text/javascript"  src="${base.contextPath}/static/js/jquery-3.1.0.min.js"></script>
<script>
		$(document).ready(function(){
			$("#del").click(function(){
				document.forms['myform'].submit();
				
					
			});
		});
		

</script>

<body>
<button typ="button" id="del">删除</button>
<input type="hidden"  id="root" value="${base.contextPath}" />

<form  action="${base.contextPath}/user/search"  method="post">
	<table border="1">
			<tr>
				<th>编号</th>
				<td>
					<input type="text" name="id"  value="${vo.id}"/>
				</td>
				<th>用户</th>
				<td>
					<input type="text" name="uname" value="${vo.uname}"/>
				</td>
				<th>搜索</th>
				
			</tr>	
				
			<tr>
				<th>邮箱</th>
				<td>
					<input type="text" name="email" value="${vo.email}"/>
				</td>
				<th>部门</th>
				<td>
					<select name="deptId" >
							<option value="">请选择</option>
							<option value="1">教学部</option>
							<option value="2">教学部</option>
					
					<select>
					 <span>排序</span>
					<select name="order" >
							<option value="">请选择</option>
							<option value="asc">升序</option>
							<option value="desc">降序</option>
					
					<select>
					
						<select name="column" >
							<option value="">请选择</option>
							<option value="id">id</option>
							<option value="email">email</option>
							<option value="uname">uname</option>
					
					<select>
				</td>
					<td>
						<input type="submit"  value="搜索"/>
					</td>
			</tr>	
		
		
		</table>
		
</form>
		<br/>
		<br/>
		<br/>
		
		<form  id="myform"  name="myform" action="${base.contextPath}/user/delete" >
		<table border="1">
			<tr>
				<th>
					<input type="checkbox"/>
				</th>
				<th>编号</th>
				<th>用户</th>
				<th>密码</th>
				<th>邮箱</th>
				<th>部门</th>
			</tr>	
			<#list  list as user>
			<tr>
				<td><input type="checkbox" name="ids" value="${user['id']}"/></td>
				<td >${user['id']}</td>
				<td>${user['uname']}</td>
				<td>${user['upass']}</td>
				<td>${user['email']}</td>
				<td>${user['deptname']}</td>
			</tr>	
			</#list>
		
		</table>
		</form>
</body>

</head>
</html>