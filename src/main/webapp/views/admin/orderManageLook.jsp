<%--
  Created by IntelliJ IDEA.
  User: yangtk
  Date: 2015/11/29
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh-cn">
    <jsp:include page="head.jsp">
        <jsp:param value="鲜出没订单管理中心" name="title"/>
    </jsp:include>
    <body id="orderManage" class="comment">
    <div class="header"><h1>鲜出没中心管理系统</h1></div>
    <jsp:include page="menu.jsp">
        <jsp:param value="${session.admin.account}" name="username"/>
    </jsp:include>
    <div class="content">
        <div class="main-content">
            <div class="inline-div">
                <span></span>
                <h3 class="inline-div-header">订单管理</h3>
                <button class="btn btn-primary btn-border-none pull-right left-margin-1x right-margin-3x " href="#">操作模式</button>
                <button class="btn btn-primary btn-border-none pull-right left-margin-1x disabled" href="#">查看模式</button>
            </div>
            <div class="wrap">
                <span id="search"></span>
                <input class="form-control" placeholder="请输入搜索内容"/>
            </div>
            <button class="btn btn-primary btn-border-none pull-right left-margin-1x right-margin-3x " href="#" data-toggle="modal" data-target="#delet-btn">删除</button>
            <button class="btn btn-primary btn-border-none pull-right left-margin-1x" href="#">修改</button>
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th>订单管理</th>
                    <th><input type="checkbox"/>序号</th>
                    <th>下单时间</th>
                    <th>收货人</th>
                    <th>收货地址</th>
                    <th>产品信息</th>
                    <th>产品评价</th>
                    <th>合计</th>
                    <th>订单状态</th>
                    <!--其下对应开始处理-->
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td id="danger-orders" class="align-left"><span id="danger-icon"></span>高危订单 <span class="badge">12</span></td>
                    <td><input type="checkbox"/>01</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td id="normal-orders" class="align-left"><span id="normal-icon"></span>店铺A</td>
                    <td><input type="checkbox"/>01</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </tbody>
            </table>

            <div class="page-divider btn-group" role="group" aria-label="page-divide">
                <a href="#" class="btn btn-default disabled">上一页</a>
                <a href="#" class="btn btn-default active">1</a>
                <a href="#" class="btn btn-default">2</a>
                <a href="#" class="btn btn-default">3</a>
                <a href="#" class="btn btn-default disabled">...</a>
                <a href="#" class="btn btn-default">10</a>
                <a href="#" class="btn btn-default">11</a>
                <a href="#" class="btn btn-default">12</a>
                <a href="#" class="btn btn-default">下一页</a>
            </div>
        </div>
    </div>


    <!-- //删除确认 -->
    <div class="modal fade" id="delet-btn" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">警告</h4>
                </div>
                <div class="modal-body">
                    你确定要删除吗？
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
                    <button type="button" class="btn btn-primary">取消</button>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="../../resources/js/jquery-1.11.2.js"></script>
    <script type="text/javascript" src="../../resources/js/bootstrap.min.js"></script>
</body>
</html>