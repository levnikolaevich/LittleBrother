<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: berezhnoy
  Date: 28.11.2016
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить студента</title>
</head>
<body>
<h1>Добавление студента:</h1>
<c:import url="logout.jsp">
</c:import>

<form  action="/addStudent"  method="post">

<p style="color: #106b6c; margin-bottom: 0px;">ФИО</p>
<input required autocomplete="off" name="fio" type="text" placeholder="Введите ФИО" title="Введите ФИО"/>

<br/>
<p style="color: #106b6c; margin-bottom: 0px;">Пол</p>
<p><input name="sex" type="radio" title="Женщина" value="false"/>Женский</p>
    <p><input name="sex" type="radio" title="Мужчина" value="true"/>Мужской</p>

<br/>
<p style="color: #106b6c; margin-bottom: 0px;">Номер группы</p>
<input required autocomplete="off" name="group" type="number"
       placeholder="Введите номер группы" title="Введите номер группы"/>


<br/><br/>
<button type="submit" class="btn btn-primary">Добавить</button>
</form>
</body>
</html>
