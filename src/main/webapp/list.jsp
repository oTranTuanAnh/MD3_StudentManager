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
        .search-main{
            width: 500px;
            margin: auto;
        }
        .d-grid{
            margin: 10px !important;
        }
        h1{
            text-align: center;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <div class="d-grid gap-2 col-2 mx-auto">
            <button class="btn btn-primary" type="button">
                <a href="/student?action=create" class="btn text-light ms-auto">Create new student</a>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <form class="d-flex ms-auto" role="search" >
                    <input type="hidden" name="action" value="search"/>
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search">
                    <button class="btn btn-outline-dark" type="submit">Search</button>
                </form>
        </div>
    </div>
</nav>
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
            <td>
                <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/student?action=edit&id=${st.getId()}">Edit</a>
                <a class="btn btn-danger" role="button" href="${pageContext.request.contextPath}/student?action=delete&id=${st.getId()}">Delete</a>
            </td>

        </tr>
    </c:forEach>


    </tbody>
</table>


</body>
</html>
