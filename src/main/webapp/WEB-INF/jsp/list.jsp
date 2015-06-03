<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>success file</title>
</head>
<body>
<table>
    <tr>
        <th>序号</th>
        <th>用户名称</th>
    </tr>
    <c:if test="${fn:length(users) lt 0}">
        <c:forEach items="${users}" var="item" varStatus="i">
            <tr>
                <td>${i.count}</td>
                <td>${item.name}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>
