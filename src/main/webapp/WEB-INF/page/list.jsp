<%--
  Created by IntelliJ IDEA.
  User: lovefifi
  Date: 2021/4/3
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh-CN">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <title>员工列表页面</title>
    
    <%
        pageContext.setAttribute("App_PATH",request.getContextPath());
    %>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
<head>
    <title>员工列表页面</title>
</head>
<body>
<%--<h1>成功来到员工列表页面</h1><br/>--%>
<%--页面大小:${pageInfo.pageSize}<br/>--%>
<%--页面数：${pageInfo.pageNum}--%>
<div class="container">
<%--    标题--%>
    <div class="row">
        <div class="col-md-12">
            <h1>欢迎来到CRUD</h1>
        </div>
    </div>
<%--    按钮 --%>
    <div class="col-md-4 col-md-offset-8">
        <a href="${App_PATH}/emps/toInsert" methods="get">
        <button type="button" class="btn btn-primary">新增员工</button>
        </a>
    </div>
<%--    表格内容--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="emp">
                    <tr>
                        <th>${emp.empId}</th>
                        <th>${emp.empName}</th>
                        <th>${emp.gender}</th>
                        <th>${emp.email}</th>
                        <th>${emp.department.deptName}</th>
                        <th>
                            <a href="${App_PATH}/emps/${emp.empId}" methods="get">
                                <button type="submit" class="btn btn-primary btn-sm">
                                    <span class="glyphicon glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                    更新
                                </button>
                            </a>
                            <form action="${App_PATH}/emps/${emp.empId}" method="post">
                                <input type="hidden" name="_method" value="delete">
                                <button type="submit" class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon glyphicon-trash" aria-hidden="true"></span>
                                删除
                                </button>
                            </form>
<%--                            <form action="book/3" method="post">--%>
<%--                                <input name="_method" value="delete"/>--%>
<%--                                <input type="submit" value="删除图书"/>--%>
<%--                            </form--%>
                        </th>
                    </tr>
                </c:forEach>

            </table>

        </div>
    </div>
<%--    底部分页操作--%>
    <div class="row">
        <div class="col-md-6">
            当前第<a class="text-primary">${pageInfo.pageNum}</a>页 总共:<a class="text-primary">${pageInfo.pages}</a>页 总记录数：<a class="text-danger">${pageInfo.total}</a>
        </div>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${App_PATH}/emps?pn=1">首页</a> </li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${App_PATH}/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                        <c:if test="${page_Num == pageInfo.pageNum}">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>
                        <c:if test="${page_Num != pageInfo.pageNum}">
                            <li><a href="${App_PATH}/emps?pn=${page_Num}">${page_Num}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${App_PATH}/emps?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="${App_PATH}/emps?pn=${pageInfo.pages}">尾页</a> </li>
                </ul>
            </nav>
        </div>
    </div>

</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
