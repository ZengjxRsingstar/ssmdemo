<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="account/findAll">查询</a>

<hr>
<form action="account/save" method="post">
    姓名：<input type="text"  name="name" />
    金额：<input type="text" name="money">
   <input type="submit" value="保存"><br>

</form>


</body>
</html>
