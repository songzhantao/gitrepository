<#macro lanqiaopage  url  page  nowPage >     
    
    
		<div>
				<ul>
						<li><a href="${url}?page=1">首页</a></li>
						<li><a href="${url}?page=${nowPage -1}">上一页</a></li>
						<li><a href="${url}?page=${nowPage +1}">下一页</a></li>
						<li><a href="${url}?page=${page}">尾巴</a></li>
				
				</ul>
		
		</div>
      
</#macro>  