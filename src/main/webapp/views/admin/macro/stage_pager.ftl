<#macro init curPage totalPage url="" showPage=10>
<#if showPage gte totalPage>
	<!--如果显示页数大于总页数，则显示总页数即可-->
	<#local showPage = totalPage/>
</#if>	
<div class="btn-group">
	<a type="button" class="btn btn-white" onclick="submitForm('1')">
		<i class="fa fa-chevron-left"></i>
	</a>
	<#local half=(showPage/2)/>
	<#if curPage lte half>
		<@show start=1 end=showPage curPage=curPage url=url/>
	<#elseif (curPage+showPage) gt totalPage >
		<@show start=(totalPage-showPage+1) end=totalPage curPage=curPage url=url/>
	<#elseif curPage gt half>
		<@show start=(curPage-half) end=(curPage+half) curPage=curPage url=url/>
	</#if>
	
	<a type="button" class="btn btn-white" onclick="submitForm('${totalPage}')">
		<i class="fa fa-chevron-right"></i>
	</a>

</div>
	
</#macro>

<#macro show start end curPage url>
	<#list start..end as num> 
		<#if curPage !=num> 
		<a onclick="submitForm('${num}')" class="btn btn-white">${num} </a> 
		<#else> 
		<a onclick="submitForm('${num}')" class="btn btn-default active">${num}</a> 
		</#if> 
	</#list>
</#macro>