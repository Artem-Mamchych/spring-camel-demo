<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>

<tag:pageWrapper sectionName="Main">
    <p>Greetings</p>
    <table>
    <thead>
        <tr>
            <th>Message</th>
            <th>Age</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${greetings}" var="greeting">
        <tr>
            <td>${greeting.message}</td>
            <td>${greeting.count}</td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
</tag:pageWrapper>