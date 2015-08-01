<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comments</title>
</head>
<body>
<div>
    <h1>Comments</h1>
    <c:if test="${!empty comments}">
        <table>
            <tr>
                <td>Author</td>
                <td>Text</td>
            </tr>
            <c:forEach items="${comments}" var="comment">
                <tr>

                    <td>${comment.author}</td>
                    <td>${comment.text}</td>
                    <td><a href="/deleteComment/${comment.iD}">Delete</a>
                    <td>

                </tr>

            </c:forEach>
        </table>
    </c:if>

</div>
<div><a href="addComment">Add Comment</a></div>
<div><a href="/">Home Page</a></div>

</body>
</html>
