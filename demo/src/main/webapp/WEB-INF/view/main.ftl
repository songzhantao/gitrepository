
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script  type="text/javascript"  src="${base.contextPath}/static/js/jquery-3.1.0.min.js"></script>


<body>

		<table border="1">
			<tr>
			
				<th>任务ID</th>
				<th>任务名称</th>
				<th>任务创建的时间</th>
				<th>任务的办理人</th>
				<th>流程实例ID</th>
				<th>执行对象ID</th>
				<th>流程定义ID</th>
				
			</tr>	
			<#list  tasks as task>
			<tr>
				
				<td >${task['id']}</td>
				<td>${task['name']}</td>
				<td>${task['createTime']?string('yyyy-MM-dd')}</td>
				<td>${task['assignee']}</td>
				<td>${task['processInstanceId']}</td>
				<td>${task['executionId']}</td>
				<td>${task['processDefinitionId']}</td>
			</tr>	
			</#list>
		
		</table>
	
</body>

</head>
</html>