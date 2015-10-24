<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!doctype html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>新增地址</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/comment.css">
    <link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/add-address.css">
    <script type="text/javascript" src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
</head>
<body>
<form action="${rootPath}/address/save" method="post">
    <div class="header">
        <span class="backspace"></span>

        <h3>新增地址</h3>
        <input type="submit" class="save" value="保存"/>
    </div>
    <label class="name" for="name">姓名</label>
    <input type="text" name="userName" id="name" placeholder="请填写真是姓名"/>
    <em>*</em>

    <div class="divider"></div>
    <label class="phone" for="phone">手机号</label>
    <input type="text" name="phoneNum" id="phone" placeholder="请填写您的手机号"/>
    <em>*</em>

    <div class="divider"></div>

    <label>城市</label>
    <span class="city">广州</span>

    <div class="divider"></div>

    <label for="county">区县</label>
    <select id="county" name="area">
        <option value="tip">请选择区</option>
        <c:forEach items="${lsAb }" var="area">
        <option cid="${area.abid }" value="${area.name }">${area.name }</option>
        </c:forEach>
    </select>
    <i></i>

    <div class="divider"></div>

    <label for="community" >社区</label>
    <select id="community" name="liveArea">
        <option value="tip">请选择社区</option>
    </select>
    <i></i>
    <input id="liveAreaId" type="hidden" name="liveAreaId" value="">
    <div class="divider"></div>

    <label for="cabinet">柜号</label>
    <select id="cabinet" name="cabinet">
        <option value="tip">请选择柜号</option>
    </select>
    <i></i>


    <div class="divider"></div>
</form>
<script src="${rootPath }/resources/js/add-address.js"></script>
</body>
</html>