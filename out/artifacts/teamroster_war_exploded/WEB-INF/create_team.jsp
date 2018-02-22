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

    <h1>Create a new Team</h1>
    <form action="/rosters/teams" method="POST">
        Team Name: <input type="text" name="team_name">
        <input type="submit" value="Create">
    </form>
</body>
</html>
