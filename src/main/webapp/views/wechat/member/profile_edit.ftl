<@override name="header"/>
<@override name="content">
<div style="background-color: #f7f7f7;zoom:1;">
    <div class="sub_nav">
        <div class="link-wrapper">
            <a href="edit_name.html">
                <b>昵称</b>
                <i class="am-icon-angle-right am-icon-sm"></i>
                <span class="fr" id="edit_name">${user.username!}</span>
            </a>
        </div>
        <div class="link-wrapper">
            <a id="selectSex">
                <b>性别</b>
                <i class="am-icon-angle-right am-icon-sm"></i>
                <span class="fr">
                	<#if user.sex ??>
                		<#if user.sex == -1>保密
                		<#elseif user.sex == 1 >女
                		<#elseif user.sex == 2 >男
                		</#if>
                	</#if>
                </span>
                <select id="selSex" class="sex fr" style="display: block"><!--获取select的option的值 -->
                    <option value="1"  <#if user.sex == 1 >selected="selected"</#if>>女</option>
                    <option value="2" <#if user.sex == 2 >selected="selected"</#if> >男</option>
                    <option value="-1" <#if user.sex == -1 >selected="selected"</#if> >保密</option>
                </select>
            </a>
            <a>
                <b>生日</b>
                <i class="am-icon-angle-right am-icon-sm"></i>
                <span class="fr" id="birth_span">${user.birthday!}</span>
                <input id="dateBirth" type="date" value="1992-10-23" min="1951-01-01"  max="2011-02-20" class="date fr" style="display:block">
            </a>
            <a href="edit_phone.html">
                <b>电话</b>
                <i class="am-icon-angle-right am-icon-sm"></i>
                <span class="fr">${user.phone!}</span>
            </a>
        </div>
        <div class="link-wrapper">
            <a href="edit_select.html">
                <b>居住地</b>
                <i class="am-icon-angle-right am-icon-sm"></i>
                <span class="fr">${user.residence!}</span>
            </a>
        </div>
        <div class="link-wrapper">
            <a href="edit_qianming.html" class="underwrite">
                <b>个性签名</b>
                <i class="am-icon-angle-right am-icon-sm"></i>
                <span class="fr">${user.userDetail.signature!}</span>
            </a>
        </div>
    </div>
 </@override>
 <@override name="nav_profile">active</@override>
 <@extends name="../common/base.ftl"/>