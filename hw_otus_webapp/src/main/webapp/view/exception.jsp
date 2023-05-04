<%--
  Created by IntelliJ IDEA.
  User: dmitr
  Date: 25.04.2023
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Exception</title>
</head>
<body>
<h2>Произошла ошибка</h2>
<p>Проверьте, пожалуйста, следующие пункты</p>
<p>Вы заполнили все поля формы</p>
<p>Вы не ввели пустую строку в поле имя</p>
<p>Вы ввели правильную дату</p>
<a href='<c:url value="/form" />'>Edit</a>
</body>

</html>
