<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>success file</title>
</head>
<body>
<table id="testtable">
    <tr>
        <th>序号</th>
        <th>用户名称</th>
    </tr>

    <c:if test="${fn:length(users) gt 0}">
        <c:forEach items="${users}" var="item" varStatus="i">
            <tr>
                <td>${i.count}</td>
                <td>${item.name}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<input type="button" value="新增用户" id="add"/>
<script src="${request.contextPath}/static/js/common/jquery-2.1.4.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $.ajax({
       url:"${request.contextPath}/user/save",
        data:{'name':"test","password":"123456"},
        type:"post",
        dataType:"json",
        success:function(data){
            console.log(data);
        }
    });
</script>
</body>
</html>
