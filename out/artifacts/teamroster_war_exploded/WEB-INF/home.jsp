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

    <h1>Prototype Roster</h1>

    <a href=" <c:url value="/rosters/teams"/>">Create Team</a>
    
    <table>
        <thead>
            <th>Team</th>
            <th>Players</th>
            <th>Action</th>
        </thead>
        
    </table>
</body>
</html>