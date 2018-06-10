<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ksiązka Telefoniczna by Artur Czajkowski</title>

    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
</head>
<body>
<h2><spring:message code="form.products.header.text"/></h2>
<h2>Search Number: </h2>
<form action="/phonebook/list/search/number">
    <table>
        <tr>
            <td>PhoneNumber : <input name="phoneNumber" type="text" value=""></td>
        </tr>
        <tr>
        <tr>
            <td><input type="submit" value="Search number"></td>
        </tr>
    </table>
</form>
<table>
    <tr>
        <td>ID</td><td>FirstName</td><td>LastName</td><td>Number</td><td>Type</td>
    </tr>
    <c:forEach items="${personalDataList}" var="personalData">
        <tr>
            <td>${personalData.id}</td>
            <td>${personalData.firstName}</td>
            <td>${personalData.lastName}</td>
            <td>${personalData.phoneNumber}</td>
            <td>${personalData.type}</td>
            <td><a href="<c:url value='/phonebook/edit/${personalData.id}' />">Edit lastName</a></td>
            <td><a href="<c:url value='/phonebook/delete/${personalData.id}' />"  data-method="delete">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/phonebook/new">Dodaj nowy wpis</a>
</body>
</html>