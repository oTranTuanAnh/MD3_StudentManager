<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/23/2024
  Time: 9:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>List students</title>
    <style>
        .d-grid{
            margin: 10px !important;
        }
        h1{
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Students List</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">DateOfBirth</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Phone</th>
        <th scope="col">ClassRoom</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="st">
        <tr>
            <th scope="row">${st.id}</th>
            <td>${st.getName()}</td>
            <td>${st.getDateOfBirth()}</td>
            <td>${st.getEmail()}</td>
            <td>${st.getAddress()}</td>
            <td>${st.getPhone()}</td>
            <td>${st.getClassName()}</td>
            <td>Edit</td>
            <td>Delete</td>

        </tr>
    </c:forEach>


    </tbody>
</table>
<div class="d-grid gap-2 col-2 mx-auto">
    <button class="btn btn-primary" type="button">
        <a href="/student?action=create" class="btn text-light ms-auto">Create new student</a>
    </button>


</div>
</body>
</html>
