<%-- 
    Document   : create
    Created on : Nov 17, 2020, 1:01:34 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
    </head>
    <body>
        <h1>Create Book</h1>
        <form:form action="${pageContext.request.contextPath}/book/add" 
                   method="post"
                   modelAttribute="biblio">
            ISBN: <form:input path="isbn"/>
            <br/>
            Title: <form:input path="title"/>
            <br/>
            Price: <form:input type="number" path="price"/>
            <br/>
            Category: <form:input path="category.name"/>
            <br/>
            Author: <form:input path="author.lname"/>
            <br/>
            <input type="submit" value="Save Book"/>
        </form:form>
    </body>
</html>
