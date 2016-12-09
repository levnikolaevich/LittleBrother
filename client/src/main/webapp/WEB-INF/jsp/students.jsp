<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="ru.levnikolaevich.littlebrother.model.StudentDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 25-Nov-16
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список студентов</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even){background-color: #f2f2f2}

        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
<%
    List<StudentDTO> stdlist = (List<StudentDTO>) request.getAttribute("stdlist");
%>
<h1>Студенты:</h1>

<c:import url="logout.jsp">
</c:import>

<table>
    <thead>
    <tr>
        <th>
            №
        </th>
        <th>
            ФИО
        </th>
        <th>
            Пол
        </th>
        <th>
            № группы
        </th>
        <th>
            <a href="/addStudent">Добавить</a>
        </th>
    </tr>
    </thead>
    <tbody>
    <%
        int count = 0;
        for (StudentDTO student : stdlist) {
            count++;
    %>
    <tr>
        <td>
            <%= count %>
        </td>
        <td>
            <%= student.getFio() %>
        </td>
        <td>
            <%= student.isSex() %>
        </td>
        <td>
            <%= student.getGroup() %>
        </td>
        <td>
            <a href="/updateStudent/<%= student.getId()%>">Редактировать</a>
            <a href="/deleteStudent/<%= student.getId()%>">Удалить</a>
        </td>
    </tr>
    <% }%>
    </tbody>
</table>
</body>
</html>
