<%--
  Created by IntelliJ IDEA.
  User: jesse
  Date: 2/21/18
  Time: 11:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.naldojesse.web.models.*" import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Prototype Roster</h1>

    <a href=" <c:url value="/rosters/teams"/>">Create Team</a>
    
    <table>
        <thead>
            <th>Team</th>
            <th>Players</th>
            <th>Action</th>
        </thead>
        <c:forEach items="${cTeams}" var="team" varStatus="loop">
            <tr>
                <td><c:out value="${team.getTeam_name()}"/></td>
                <td><p>4</p></td>
                <td>
                    <a href="<c:url value="/rosters/teams?id=${loop.index}"/>">Details</a>
                    <a href="<c:url value="/rosters/teams?delete=${loop.index}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>


    </table>
</body>
</html>