<#macro judge status>
	<#switch status>
		<#case 0>
		<span class="label label-primary">未开始</span><#break>
		<#case 1>
		<span class="label label-primary">未购满未揭晓 </span><#break> 
		<#case 2>
		<span class="label label-primary">已购满待揭晓</span><#break> 
		<#case 3>
		<span class="label label-primary">已揭晓 </span><#break>
		<#default>
		<span class="label label-primary">结束 </span>
		</#switch>
</#macro>