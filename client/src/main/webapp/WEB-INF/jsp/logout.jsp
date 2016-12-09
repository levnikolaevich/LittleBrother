<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${param.sectionName == 'HEAD'}">
        head section here [without the <HEAD> tags !]
    </c:when>
    <c:otherwise>
        <div class="row">
            <div class="col-md-8">
                <ul>
                    <li><a href="/home">На главную</a></li>
                    <li><a href="/students">Список студентов</a></li>
                    <li><a href="/lectures">Список лекций</a></li>
                    <li><a href="/statistic">Посещаемость</a></li>
                </ul>
            </div>
            <div class="col-md-4">
                <p><a href="<%=request.getContextPath()%>/j_spring_security_logout">Выход</a></p>
            </div>
        </div>
    </c:otherwise>
</c:choose>