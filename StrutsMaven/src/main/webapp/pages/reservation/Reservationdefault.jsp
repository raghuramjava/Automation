 <!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    
<html>
<head>

</head>

<body>
<%
String contextPath = request.getContextPath();

%>
<div class="container">

     <!--  <ul class="breadcrumb">

        <li class="active">Home</li>

    </ul>-->
    <div class="panel panel-default">
  <div class="panel-body">
  <ul class="nav nav-pills nav-stacked">
    
    <li ><a href="<%=contextPath %>/reservation/newReservationAction">New Reservation</a></li>
    <li ><a href="<%=contextPath %>/reservation/searchReservationFormAction">Search Reservation</a></li>
   

</ul>
  
  </div>
  </div>
  
    
    

</div>


</body>
</html>