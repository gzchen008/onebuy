<%--
  Created by IntelliJ IDEA.
  User: yangtk
  Date: 2015/11/29
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
    <head>
    <meta charset="UTF-8">
    <title>鲜出没中心管理系统</title>
    <link rel="stylesheet" href="../../resources/style/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../resources/style/css/filter-message.css"/>
</head>
    <body>
    <div class="header">
        <h1>中心管理系统</h1>
    </div>
    <div class="step-progress">
        <ul class="progress-list">
            <li class="long-li">
            </li>
            <span class="right-angle"></span>
            <span class="hollow-angle-active"></span>
            <li class="long-li active">请填写门店信息</li>
            <span class="right-angle-active"></span>
            <span class="hollow-angle"></span>
            <li class="long-li"></li>
        </ul>
    </div>
    <div class="container">
        <div class="content">
            <form role="form">
                <div class="item" id="brand-a">
                    <div class="form-group">
                        <label for="type" class="col-sm-4">门店名称:</label>
                        <div class="col-sm-6">
                            <input type="text"  class="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="brand" class="col-sm-4">门店编号:</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="application" class="col-sm-4">门店地址:</label>
                        <div class="col-sm-6">
                            <input type="text"  class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="grade" class="col-sm-4">社区名字:</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="identification" class="col-sm-4">冷柜编号:</label>
                        <div class="col-sm-6">
                            <input type="text"  class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pack" class="col-sm-4">冷柜位置:</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="identification" class="col-sm-4">门店到社区的距离:</label>
                        <div class="col-sm-6">
                            <input type="text"  class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pack" class="col-sm-4">门店到社区的路线:</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pack" class="col-sm-4">特殊路线备注:</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" />
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <button class="btn btn-info btn-middle">提交</button>

    </body>
</html>