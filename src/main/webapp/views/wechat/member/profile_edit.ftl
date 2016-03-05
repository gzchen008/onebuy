<@override name="header"/>
<@override name="content">
<div style="background-color: #f7f7f7;zoom:1;">
    <div class="sub_nav">
        <div class="link-wrapper">
            <a href="edit_name.html">
                <b>昵称</b>
                <i class="am-icon-angle-right am-icon-sm"></i>
                <span class="fr" id="edit_name">janna62</span>
            </a>
        </div>
        <div class="link-wrapper">
            <a id="selectSex">
                <b>性别</b>
                <i class="am-icon-angle-right am-icon-sm"></i>
                <span class="fr">女</span>
                <select id="selSex" class="sex fr" style="display: block"><!--获取select的option的值 -->
                    <option value="1" selected="selected">女</option>
                    <option value="2">男</option>
                    <option value="3">保密</option>
                </select>
            </a>
            <a>
                <b>生日</b>
                <i class="am-icon-angle-right am-icon-sm"></i>
                <span class="fr" id="birth_span">1994-09-21</span>
                <input id="dateBirth" type="date" value="1992-10-23" min="1951-01-01"  max="2011-02-20" class="date fr" style="display:block">
            </a>
            <a href="edit_phone.html">
                <b>电话</b>
                <i class="am-icon-angle-right am-icon-sm"></i>
                <span class="fr">12345678</span>
            </a>
        </div>
        <div class="link-wrapper">
            <a href="edit_select.html">
                <b>现居地</b>
                <i class="am-icon-angle-right am-icon-sm"></i>
                <span class="fr">广州</span>
            </a>
            <a href="edit_select.html">
                <b>家乡</b>
                <i class="am-icon-angle-right am-icon-sm"></i>
                <span class="fr">广州</span>
            </a>
        </div>
        <div class="link-wrapper">
            <a href="edit_qianming.html" class="underwrite">
                <b>个性签名</b>
                <i class="am-icon-angle-right am-icon-sm"></i>
                <span class="fr">呀呀呀呀呀呀</span>
            </a>
        </div>
    </div>
 </@override>
 <@override name="nav_profile">active</@override>
 <@extends name="../common/base.ftl"/>