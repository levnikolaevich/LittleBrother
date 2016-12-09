<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.levnikolaevich.littlebrother.model.LectureDTO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
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
    <title>Список лекций</title>
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

        tr:nth-child(even) {
            background-color: #f2f2f2
        }

        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
<%
    List<LectureDTO> lectureList = (List<LectureDTO>) request.getAttribute("lectureList");
%>
<h1>Список лекций:</h1>
<c:import url="logout.jsp">
</c:import>
<div style="align-content: center;">
    <table width="800px;">
        <thead>
        <tr>
            <th width="60px">
                №
            </th>
            <th width="340px">
                Тема
            </th>
            <th width="200px">
                Дата
            </th>
            <th width="200px">
                <a href="/addLecture">Добавить</a>
            </th>
        </tr>
        </thead>
        <tbody>
        <%
            int count = 0;
            for (LectureDTO lecture : lectureList) {
                count++;
        %>
        <tr>
            <td>
                <%= count %>
            </td>
            <td>
                <%= lecture.getTheme() %>
            </td>
            <td>
                <%
                    Calendar startDate = lecture.getDateStart();
                    SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
                    fmt.setCalendar(startDate);
                    String dateFormatted = fmt.format(startDate.getTime());
                %>
                <%= dateFormatted %>
            </td>
            <td>
                <a href="/updateLecture/<%= lecture.getId()%>">Редактировать</a>
                <a href="/deleteLecture/<%= lecture.getId()%>">Удалить</a>
            </td>
        </tr>
        <% }%>
        </tbody>
    </table>
</div>
</body>
</html>
