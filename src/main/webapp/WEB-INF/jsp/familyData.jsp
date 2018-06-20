<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<br>
<h2>Search Family by LastName: </h2>
<form action="/family/list/search">
    <table>
        <tr>
            <td>Search Family : <input name="searchFamily" type="text" value=""></td>
        </tr>
        <tr>
        <tr>
            <td><input type="submit" value="Search LastName"></td>
        </tr>
    </table>
</form>
<table>
    <tr>
        <td>ID</td><td>FirstName</td><td>LastName</td><td>Pesel</td><td>birthday</td>
    </tr>
    <c:forEach items="${fatherDataList}" var="personalData">
        <tr>
            <td>${personalData.id}</td>
            <td>${personalData.firstName}</td>
            <td>${personalData.lastName}</td>
            <td>${personalData.pesel}</td>
            <td>${personalData.dateOfBirth}</td>
        </tr>
    </c:forEach>

    <c:forEach items="${childDataList}" var="childData">
        <tr>
            <td>${childData.id}</td>
            <td>${childData.firstName}</td>
            <td>${childData.lastName}</td>
            <td>${childData.pesel}</td>
            <td>${childData.dateOfBirth}</td>
            <td>${childData.type}</td>
        </tr>
    </c:forEach>
</table>
</br>
<a href="/father/new">Dodaj Rodzica</a>
<a href="/child/new">Dodaj Dziecko</a>
</body>
</html>
