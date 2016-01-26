<#macro init curPage totalPage showPage=10 url="">
<#if showPage gte totalPage>
	<!--如果显示页数大于总页数，则显示总页数即可-->
	<#local showPage = totalPage/>
</#if>	
<div class="btn-group">
	<a type="button" class="btn btn-white" href="goodsto?page=1">
		<i class="fa fa-chevron-left"></i>
	</a>
	<#local half=(showPage/2)/>
	<#if curPage lte half>
		<@show start=1 end=showPage curPage=curPage/>
	<#elseif (curPage+showPage) gt totalPage >
		<@show start=(totalPage-showPage+1) end=totalPage curPage=curPage/>
	<#elseif curPage gt half>
		<@show start=(curPage-half) end=(curPage+half) curPage=curPage/>
	</#if>
	
	<a type="button" class="btn btn-white" href="goodsto?page=${totalPage}">
		<i class="fa fa-chevron-right"></i>
	</a>

</div>
	
</#macro>

<#macro show start end curPage>
	<#list start..end as num> 
		<#if curPage !=num> 
		<a href="goodsto?page=${num}" class="btn btn-white">${num} </a> 
		<#else> 
		<a class="btn btn-default active">${num}</a> 
		</#if> 
	</#list>
</#macro>