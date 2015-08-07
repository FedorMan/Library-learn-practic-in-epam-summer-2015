<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html" ; charset="cp1251"/>
<head>

    <title>Library</title>

</head>
<body>

<div>
    <h1>Library</h1>
    <c:if test="${!empty books}">
        <table>
            <tr>
                <td>Title</td>
                <td>Author</td>
                <td>Year</td>
                <td>Genre</td>
                <td></td>
                <td>Description</td>
                <td></td>
                <td>Rating</td>
                <td>Count</td>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>

                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.year}</td>
                    <td>
                            ${book.genre}
                    <td>
                    <td>
                            ${book.about}
                    <td>
                    <td>${book.rating}</td>
                    <td>${book.count}</td>
                    <td><a href="/deleteBook/${book.iD}">Delete</a>
                    <td>
                    <td><a href="/correctBook/${book.iD}/${book.name}/${book.author}/${book.year}/${book.genre}/${book.about}/${book.count}/${book.rating}">Correct</a>
                    <td>
                    <td><a href="/viewComments/${book.iD}">View comments</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </c:if>

</div>
<a href="addBook">Add</a>
</body>
</html>
