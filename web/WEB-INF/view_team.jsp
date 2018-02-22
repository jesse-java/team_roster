<%--
  Created by IntelliJ IDEA.
  User: jesse
  Date: 2/21/18
  Time: 11:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Team: ${vTeam.getTeam_name()}</h1>
    <a href="<c:url value="/rosters/home"/>">Back to Home</a>
    <a href="<c:url value="/rosters/players?id=${team_id}"/>">Add Player</a>

    <table>
        <thead>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>Actions</th>
        </thead>
        <tbody>
            <c:forEach items="${vPlayers}" var="player" varStatus="loop">
                <tr>
                    <td><c:out value="${player.getFirst_name()}"/></td>
                    <td><c:out value="${player.getLast_name()}"/></td>
                    <td><c:out value="${player.getAge()}"/></td>
                    <td>
                        <form action="/rosters/players" method="POST">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="team_id" value="${team_id}">
                            <input type="hidden" name="player_id" value="${loop.index}">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</body>
</html>
