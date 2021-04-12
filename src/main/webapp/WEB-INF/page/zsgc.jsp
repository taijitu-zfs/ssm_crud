<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isErrorPage="true" %>
<html>
<head>
    <title>增删改查</title>
</head>
<body>

<a href="book/2">查询图书</a><br/>
<%--<a href="book/1">增加图书</a><br/>--%>
<%--<a href="book/3">删除图书</a><br/>--%>
<%--<a href="book/4">更新图书</a><br/>--%>
<form action="book" method="post">
    <input type="submit" value="增加图书"/>
</form><br/>
<form action="book/3" method="post">
    <input name="_method" value="delete"/>
    <input type="submit" value="删除图书"/>
</form><br/>
<form action="book/4" method="post">
    <input name="_method" value="put"/>
    <input type="submit" value="更新图书"/>
</form>
<form action="bookshops" method="post">
    书名：<input type="text" name="bookName"/><br/>
    作者：<input type="text" name="author"/><br/>
    价格：<input type="text" name="price"/><br/>
    库存：<input type="text" name="stock"/><br/>
    销量：<input type="text" name="sales"/><br/>
    <hr/>
    <input type="submit" value="提交"/>
</form><br/>

</body>
</html>
