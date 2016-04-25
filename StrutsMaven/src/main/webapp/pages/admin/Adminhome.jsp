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
  <s:if test='%{#session.admin.equals("true")}'> 
  <li ><a href="<%=contextPath %>/admin/emailConfigAction">Email Configuration</a></li>
  <li ><a href="<%=contextPath %>/admin/pricingInvAction">Pricing & Inventory</a></li>
  </s:if>
  <li ><a href="<%=contextPath %>/admin/userManageAction">User Management</a></li>
  
    
    
  

</ul>
  
  </div>
  </div>
  
    
    

</div>


</body>
</html>