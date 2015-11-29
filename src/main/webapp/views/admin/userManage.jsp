<%--
  Created by IntelliJ IDEA.
  User: yangtk
  Date: 2015/11/29
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
    <html lang="zh-cn">
    <jsp:include page="head.jsp">
        <jsp:param value="鲜出没用户管理中心" name="title"/>
    </jsp:include>
    <body id="orderManage" class="comment">
    <jsp:include page="menu.jsp">
        <jsp:param value="${session.admin.account}" name="username"/>
    </jsp:include>
    <div class="content">
        <div class="main-content">
            <div class="inline-div">
                <span></span>
                <h3 class="inline-div-header">用户管理</h3>
            </div>
            <div class="wrap">
                <span id="search"></span>
                <input class="search form-control" placeholder="请输入搜索内容"/>
                <input type="submit" class="submit btn btn-primary" value="搜索" />
            </div>
            <div class="trade-time top-margin-2x bottom-margin-2x">
                <thead>
                <span>交易时间:</span>
                <input class="form-control time" type="date"/>
                <span>到</span>
                <input class="form-control time" type="date"/>
                <input class="submit btn btn-primary" type="submit" value="点此查询"/>
                </thead>
            </div>

            <div class="all-stores-and-icon">
                <span class="icon"></span>
                <div class="all-stores">
                    <a href="#">门店A</a>
                    <a href="#">门店B</a>
                    <a href="#">门店C</a>
                    <a href="#">门店D</a>
                    <a href="#">门店E</a>
                </div>
            </div>
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th>社区</th>
                    <th>总数量</th>
                    <th>今日新增</th>
                    <th>用户积累</th>
                    <!--其下对应开始处理-->
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>A</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>B</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>C</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>D</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>D</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>D</td>
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

    <%@include file="script.jsp"%>
    </body>
</html>