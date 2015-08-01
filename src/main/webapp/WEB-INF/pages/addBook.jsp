
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head>
    <title>Add Book</title>
</head>
<body>
<form:form method="post" action="addBook" commandName="book">

    <table>
        <tr>
            <td><form:label  path="name">Title</form:label></td>
            <td><form:input  path="name"/></td>
        </tr>
        <tr>
            <td><form:label  path="author">Author</form:label></td>
            <td><form:input  path="author"/></td>
        </tr>
        <tr>
            <td><form:label  path="year">Year</form:label></td>
            <td><form:input  path="year"/></td>
        </tr>
        <tr>
            <td><form:label  path="genre">Genre</form:label></td>
            <td><form:input  path="genre"/></td>
        </tr>
        <tr>
        <tr>
            <td><form:label accept-charset="utf-8" path="about">Description</form:label></td>
            <td><form:input accept-charset="utf-8" path="about"/></td>
        </tr>
        <tr>
            <td><form:label accept-charset="utf-8" path="rating">Rating(от 0 до 10)</form:label></td>
            <td><form:input accept-charset="utf-8" path="rating"/></td>
        </tr>
        <tr>
            <td><form:label accept-charset="utf-8" path="count">Count</form:label></td>
            <td><form:input accept-charset="utf-8" path="count"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add"/></td>

        </tr>

    </table>
    </form:form>
<div><a href="/">Home Page</a></div>
</body>
</html>
