<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    
     <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
     <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <style type="text/css">
label {
	font-weight: normal;
}


</style>
</head>
<body>

<div class="container" style="width: 579px;margin-top: 30px;">
    
    
    
    <div class="panel panel-default" >
    <div class="panel-heading" style="background-color: #337ab7;color: #fff;text-align: center;">FORGOT  PASSWORD</div>
    <div class="panel-body">
    <form role="form" method="post" action="checkRegMail">
    <div><label>Enter your email address and we will send you a link to reset your password.</label></div>
  <div class="form-group">
     
     <s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
     </s:if>
  
    <input type="email" class="form-control" id="email" name="email" required="required" placeholder="Enter email">
  </div>
  
  
   <div class="form-group" style="margin-top: 10px;">
     <button type="button" class="btn btn-success">Send passwod reset email</button>
  </div>
</form>
    </div>
  </div>
  
</div>

</body>
</html>