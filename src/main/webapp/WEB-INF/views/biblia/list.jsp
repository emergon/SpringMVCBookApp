<%-- 
    Document   : bookList
    Created on : Nov 17, 2020, 12:00:22 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="myjsp" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Books</h1>
        <section>
            <a href="${pageContext.request.contextPath}/book/create">Create</a>
            <form action="${pageContext.request.contextPath}/book/search" method="post">
                Search: <input type="text" name="searchValue"/>
                <input type="submit" value="FIND"/>
            </form>
            <table border="1">
                <tr>
                    <th>ISBN</th>
                    <th>TITLE</th>
                    <th>PRICE</th>
                    <th>CATEGORY</th>
                    <th>AUTHOR</th>
                </tr>
                <myjsp:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.isbn}</td>
                        <td>${book.title}</td>
                        <td>${book.price}</td>
                        <td>${book.category.name}</td>
                        <td>${book.author.lname}</td>
                    </tr>
                </myjsp:forEach>
            </table>
        </section>
    </body>
</html>
