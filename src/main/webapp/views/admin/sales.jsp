<%--
  Created by IntelliJ IDEA.
  User: yangtk
  Date: 2015/11/29
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh-cn">
    <jsp:include page="head.jsp">
        <jsp:param value="鲜出没门店管理中心" name="title"/>
    </jsp:include>
    <body id="orderManage" class="comment">
    <jsp:include page="menu.jsp">
        <jsp:param value="${session.admin.account}" name="username"/>
    </jsp:include>
    <div class="content">
        <div class="main-content">
            <div class="manage-type">
                <ul>
                    <li><a href="#">增加门店</a></li>
                    <li><a href="#" class="hover-line">产品日销量统计</a></li>
                    <li><a href="#">交易营业额统计</a></li>
                </ul>
            </div>
            <div class="inline-div">
                <span class="shop-icon"></span>
                <h3 class="inline-div-header">门店管理</h3>
                <h4>产品日销量统计</h4>
            </div>
            <div class="trade-time top-margin-2x bottom-margin-2x">
                <span>统计时间:</span>
                <input class="form-control time" type="date"/>
                <span>到</span>
                <input class="form-control time" type="date"/>
                <button class="btn btn-primary btn-border-none pull-right">点此查询</button>
            </div>
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th>店铺</th>
                    <th>类别</th>
                    <th>规格</th>
                    <th>销售量10：30</th>
                    <th>销售量17：30</th>
                    <th>备注</th>
                    <!--其下对应开始处理-->
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td id="normal-orders"><span id="normal-icon"></span>店铺A</td>
                    <td>哈哈</td>
                    <td>500</td>
                    <td>30</td>
                    <td>35</td>
                    <td>无</td>
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
    <%@include file="script.jsp" %>
    </body>
</html>