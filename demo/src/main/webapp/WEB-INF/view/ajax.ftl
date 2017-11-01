
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script  type="text/javascript"  src="${base.contextPath}/static/js/jquery-3.1.0.min.js"></script>

<script  type="text/javascript"  src="http://10.10.10.10/static/js/jquery-3.1.0.min.js"></script>

<script>
		$(document).ready(function(){
			$("#cors").click(function(){
				$.ajax({
						url:"http://127.0.0.1:8080/demo/ajax/cors",
						type:"get",
						dataType:"text",
						success:function(data){
							alert(data);
						}
						
						
				});
				
				
				
					
			});
			
			
				$("#jsonp").click(function(){
				$.ajax({
						url:"http://127.0.0.1:8080/demo/ajax/jsonp",
						type:"get",
						dataType:"jsonp",
						jsonp:'jsonpcallback',
						success:function(data){
							alert(data.msg);
						}
						
						
				});
				
				
				
					
			});
		});
		

</script>


  <button id="cors">ajax</button>
   <button id="jsonp">jsonp</button>
</head>
</html>