<%--
  Created by IntelliJ IDEA.
  User: Adel
  Date: 18.03.2016
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action='/process' method='POST'>
    <p><textarea name='text' rows='10' cols='50'>Text</textarea></p>
    Count the number of:
    <p><select name='value'>
        <option value='symbols'>symbols</option>
        <option value='words'>words</option>
        <option value='sentences'>sentences</option>
        <option value='paragraphs'>paragraphs</option>
    </select></p>
    <p><input type='submit' value='Process'/></p>
</form>

</body>
</html>
