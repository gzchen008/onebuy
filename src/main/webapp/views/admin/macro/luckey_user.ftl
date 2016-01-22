<#macro showUser stages> 
<#list stages as stage>
<tr>
<td><span class="label label-primary">第 ${stage.num} 期</span></td>
<td>${(stage.luckyUser.name)!("匿名")}</td>
<td>${(stage.luckyCode)!("无")}</td>
<td>${(stage.announceTime)!("未揭晓")}</td>
<td><#if stage.ifDelivery??> 未发货
	 <#if stage.ifDelivery=1> 已发货
	</#if> 
</#if></td>
</tr>
</#list> 
</#macro>
