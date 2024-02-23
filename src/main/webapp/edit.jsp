<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/23/2024
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <title>Edit student</title>
    <style>
        h1{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container" >
    <h1> Edit Student Information</h1>
    <form method="post">
        <div class="mb-3">
            <label for="exampleInputName" class="form-label">Name</label>
            <input type="text" class="form-control" id="exampleInputName" name="name" value="<c:out value="${students.getName()}"></c:out>">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="<c:out value="${students.getEmail()}"></c:out>">
        </div>
        <div class="mb-3">
            <label for="exampleInputDOB" class="form-label">Date of birth</label>
            <input name="dateOfBirth" type="text" class="form-control" id="exampleInputDOB" value="<c:out value="${students.getDateOfBirth()}"></c:out>">
        </div>
        <div class="mb-3">
            <label for="exampleInputAdd" class="form-label">Address</label>
            <input name="address" type="text" class="form-control" id="exampleInputAdd" value="<c:out value="${students.getAddress()}"></c:out>">
        </div>
        <div class="mb-3">
            <label for="exampleInputPhone" class="form-label">Phone number</label>
            <input name="phone" type="text" class="form-control" id="exampleInputPhone" value="<c:out value="${students.getPhone()}"></c:out>">
        </div>
        <div class="mb-3">
            <label class="form-label">Class </label>
            <select name="classroom" id="classroom" >
                <c:forEach items="${classroom}" var="cl">
                    <option value="${cl.id}" selected>${cl.name}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Edit</button>
    </form>

</div>









<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>


</body>
</html>
