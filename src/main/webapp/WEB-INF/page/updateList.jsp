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

    <title>员工更新页面</title>
    
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
    <title>员工更新页面</title>
</head>
<body>
<%--<h1>成功来到员工列表页面</h1><br/>--%>
<%--页面大小:${pageInfo.pageSize}<br/>--%>
<%--页面数：${pageInfo.pageNum}--%>
<div class="container">
<%--    标题--%>
    <div class="row">
        <div class="col-md-12">
            <h1>欢迎来到员工更新页面</h1>
        </div>
    </div>

<%--    表格内容--%>
    <form action="${App_PATH}/emps/${empInfo.empId}" method="post">
        <input type="hidden" name="_method" value="put">
        <div class="form-group">
            <label>empId</label>
            <input type="text" class="form-control" name="empId" placeholder="id尽量不要修改：${empInfo.empId}">
        </div>

        <div class="form-group">
            <label>empName</label>
            <input type="text" class="form-control" name="empName" placeholder="${empInfo.empName}">
        </div>

        <div class="form-group">
            <label>gender</label>
            <input type="text" class="form-control" name="gender" placeholder="${empInfo.gender}">
        </div>

        <div class="form-group">
            <label>email</label>
            <input type="email" class="form-control" name="email" placeholder="${empInfo.email}">
        </div>

        <div class="form-group">
            <label>dId</label>
            <input type="text" class="form-control" name="dId" placeholder="${empInfo.dId}">
        </div>

        <button type="reset" class="btn btn-default">reset</button>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>

    </div>

</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
