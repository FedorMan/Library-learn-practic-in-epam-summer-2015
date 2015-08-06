<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>

    <title>Add Comment</title>
    <meta charset=utf-8">
</head>
<body>

<form:form method="post" action="/addComment/" commandName="comment">

    <table>
        <tr>
            <td><form:label path="author">Author</form:label></td>
            <td><form:input path="author"/></td>
        </tr>
        <td><form:label path="text">Comment</form:label></td>
        <td><form:input path="text"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add"/></td>

        </tr>

    </table>
</form:form>

</body>
</html>
