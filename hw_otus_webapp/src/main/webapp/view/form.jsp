<%@ page import="java.util.List" %>
<%@ page import="webapp.entilities.User" %>
<%@ page import="webapp.model.Model" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="webapp.model.ModelDB" %><%--
  Created by IntelliJ IDEA.
  User: dmitr
  Date: 17.04.2023
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Форма</title>
    <link rel = "stylesheet" href = "styles/style.css"/>
</head>
<body>

<% if(request.getAttribute("exception")!=null){ %>
<script>
    alert("Вы ввели неверное имя или дату рождения")
</script>
<% } %>
<h3>Форма добавления информации о студенте</h3>

<form class="border_block" method="post">
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
        <button type="submit">Добавить</button>
    </p>
</form>
<h3>Таблица студентов</h3>
<table id = "studentTable">
    <tbody id = "tbody">
    <tr>
        <td>Имя студента</td><td>Пол</td><td>Дата рождения</td><td>Возраст</td><td>Редактировать</td><td>Удалить</td>
    </tr>
    <c:forEach var="user" items="${users}">
    <tr>
        <td>${user.name}</td>
        <td>${user.sex}</td>
        <td>${user.birthDateString}</td>
        <td>${user.age}</td>
        <td>
            <a href='<c:url value="/edit?old_name=${user.name}&&old_date=${user.birthDateString}&&old_sex=${user.sex}" />'>Edit</a>
        </td>
        <td>
            <form method="post" action='<c:url value="/delete?name=${user.name}&&sex=${user.sex}&&date=${user.birthDateString}"/>'  style="width:40px;height:20px;" >
                <input type="hidden" name="name" value="${user.name}">
                <input type="hidden" name="sex" value="${user.sex}">
                <input type="hidden" name="date" value="${user.birthDateString}">
                <input type="submit" value="Delete"  style="width:60px;height:20px;">
            </form>
        </td>
    </tr>
    </c:forEach>

    <tfoot>
    <tr>
        <td colspan="6" class="blank_row"></td>
    </tr>
    <tr id = "medium_age">
        <td colspan="2">Средний возраст студентов: </td><td id = "result_age"></td>
        <%
            ModelDB modelDB = new ModelDB();
            int mediumAge = 0;
           if(modelDB.getUsers().size()>0);
            mediumAge = modelDB.getMediumAge();
        %>
        <td><%=mediumAge%></td>
        <td></td>
        <td></td>
    </tr>
    </tfoot>
</table>
</body>
</html>
