<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Father to Family</title>
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
</head>

<body>
<h2>Add Child</h2>

<c:if test="${not empty errorMessage}">
    <div>${errorMessage}</div>
</c:if>

<form:form method="POST" modelAttribute="childDataModel" action="/child/save">
    <table>
        <tr>
            <td>First Name</td>
            <td><form:input path="firstName" id="firstName"/></td>
            <td><form:errors path="firstName" id="firstName"/></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><form:input path="lastName" id="lastName"/></td>
            <td><form:errors path="lastName" id="lastName"/></td>
        </tr>
        <tr>
            <td>Pesel</td>
            <td><form:input path="pesel" id="pesel"/></td>
            <td><form:errors path="pesel" id="pesel"/></td>
        </tr>

        <tr>
            <td>Dzien urodzin</td>
            <td><form:input path="dateOfBirth" id="dateOfBirth"/></td>
            <td><form:errors path="dateOfBirth" id="dateOfBirth"/></td>
        </tr>
        <tr>
            <td>Sex Type</td>
            <td><form:select path="type" id="type" items="${childDataType}"/>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update Name"/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Add Name"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <form:hidden path="id" id="id"/>
    </table>
</form:form>
</body>
</html>