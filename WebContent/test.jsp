<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
    <title>SELECT 操作</title>
</head>
<body>

<sql:setDataSource var="abc" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/TEST?serverTimezone=UTC"
                   user="root"  password="123456"/>

<sql:query dataSource="${abc}" var="result">
    SELECT * from accounts;
</sql:query>

<table border="1" width="100%">
    <tr>
        <th>ID</th>
        <th>AccountU</th>
        <th>Password</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.account}"/></td>
            <td><c:out value="${row.password}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>