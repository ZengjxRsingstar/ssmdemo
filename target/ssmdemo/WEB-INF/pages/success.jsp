<%--
  Created by IntelliJ IDEA.
  User: zengjx
  Date: 2019/10/2
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>访问成功</title>
</head>
<body>
 <c:forEach items="${list}" var="account">
   ${account.id}--
   ${account.name} ---
   ${account.money}---


 </c:forEach>


</body>
</html>
