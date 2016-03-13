<#macro showUser stages> 
<#list stages as stage>
<tr>
<td><span class="label label-primary"><a href="${rootPath}/admin/stages/detail/${stage.id}">第 ${stage.num}期</a></span></td>
<td>${(stage.luckyUser.name)!("匿名")}</td>
<td>${(stage.luckyCode)!("无")}</td>
<td>${(stage.announceTime)!("未揭晓")}</td>
<td><#if stage.ifDelivery??>
	 <#if (stage.ifDelivery)?c='true'>已发货
	 <#else>
	 未发货
	</#if> 
</#if></td>
</tr>
</#list> 
</#macro>
