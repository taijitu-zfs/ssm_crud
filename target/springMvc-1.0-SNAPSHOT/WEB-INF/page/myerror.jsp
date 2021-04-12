<%--
  Created by IntelliJ IDEA.
  User: lovefifi
  Date: 2021/3/31
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="alert alert-warning" role="alert">出现错误！</div>

<div class="alert alert-danger" role="alert">
    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
    <span class="sr-only">异常信息：</span>
    ${ex}
</div>

</body>
</html>
