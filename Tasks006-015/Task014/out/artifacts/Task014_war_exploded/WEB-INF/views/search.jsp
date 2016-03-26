<%--
  Created by IntelliJ IDEA.
  User: Adel
  Date: 18.03.2016
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Поиск</title>
</head>
<body>

${name}
<form action='${action}' method='GET'>
    <input type='text' name='${parameter}'/>
    <input type='submit' value='search'/>
</form>

</body>
</html>
