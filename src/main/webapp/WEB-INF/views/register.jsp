<%-- 
    Document   : register
    Created on : nov 21, 2019, 5:55:46 p.m.
    Author     : LeaRC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- Bootstrap 3.3.7-->
  <link rel="stylesheet" href="resources/css/bootstrap.css">
  <link rel="stylesheet" href="resources/css/style.css">
  <link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<div id="page-content">  
    <c:if test="${not empty error}">
        <div class="error" style="color:red">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
    </c:if>
    <c:if test="${not empty username}">
        <script type="text/javascript">
           window.onload = function() {
                document.getElementById("usrname").value = "${username}";
            };
        </script>
    </c:if>    
    <div style="width: 50%; padding-left: 30px">  
        <form role="form" action="<c:url value='/register' />" method='POST'>

            <div class="form-group">
              <label for="usrname" style="color:whitesmoke"><span class="glyphicon glyphicon-user"></span> Username</label>
              <input type="text" name='username' class="form-control" id="usrname" placeholder="Enter email">
            </div>
            <div class="form-group">
              <label for="psw" style="color:whitesmoke"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="password" name='password' class="form-control" id="psw" placeholder="Enter password">
            </div>
            <div class="form-group">
              <label for="psw" style="color:whitesmoke"><span class="glyphicon glyphicon-eye-open"></span>Confirm Password</label>
              <input type="password" name='password2' class="form-control" id="psw2" placeholder="Enter password">
            </div>
            
            <button type="submit" class="btn btn-success btn-block" onclick=" return verifyPass()"><span class="glyphicon glyphicon-off"></span> Login</button>

              <input type="hidden" name="${_csrf.parameterName}"
                value="${_csrf.token}" />

        </form>                
            
    </div>
                
</div>