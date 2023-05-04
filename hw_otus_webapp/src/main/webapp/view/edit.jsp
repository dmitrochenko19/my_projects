<%--
  Created by IntelliJ IDEA.
  User: dmitr
  Date: 24.04.2023
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h2>Установите новые значения полей</h2>
<form class="border_block" method="post" >
    <p>
        <label for="name" >Имя студента: </label>
        <input type="text" id="name" name = "name" style="margin-left: 85px">
    </p>
    <p>
        <label for="date">Дата рождения: </label>
        <input type="date" id="date" name = "date" style="margin-left: 75px">
    </p>
    <p>
        <label for="sex">Пол:</label>
        <select id="sex" name="sex" style="margin-left: 150px">
            <option>мужчина</option>
            <option>женщина</option>
        </select>
    </p>
    <p>
        <button type="submit">Редактировать</button>
    </p>
</form>
</body>
</html>
