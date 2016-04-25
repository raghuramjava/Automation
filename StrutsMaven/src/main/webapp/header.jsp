<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<%
String contextPath = request.getContextPath();

%>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <link rel="shortcut icon" href="<%=contextPath %>/img/bike.ico" />
    
    <!-- Bootstrap -->
    <link href="<%=contextPath %>/css/bootstrap.min.css" rel="stylesheet">
     <link href="<%=contextPath %>/css/font-awesome.min.css" rel="stylesheet" />
    
      <link href="<%=contextPath %>/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
       <link href="<%=contextPath %>/css/bootstrap-datepicker.min.css" rel="stylesheet">
       <link href="<%=contextPath %>/css/common.css" rel="stylesheet">
       
     <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<%--      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> --%>
    <script src="<%=contextPath %>/jquery/jquery-1.11.3.min.js"></script>
     <!-- Include all compiled plugins (below), or include individual files as needed -->
     
    
 <script src="<%=contextPath %>/jquery/jquery-1.11.3.min.js"></script>
 <script src="<%=contextPath %>/js/moment.js"></script>
  <script src="<%=contextPath %>/js/transition.js"></script>
<script src="<%=contextPath %>/js/collapse.js"></script>

<script src="<%=contextPath %>/js/bootstrap/bootstrap.min.js"></script>
<script src="<%=contextPath %>/js/bootstrap-datepicker.min.js"></script>

 <script src="<%=contextPath %>/js/respond.min.js"></script>
<script src="<%=contextPath %>/js/html5shiv.min.js"></script>

<style type="text/css">

.breadcrumb {
    background-color: #ffffff;
     margin:10px;
    }
label {
	font-weight: normal;
}
</style>



</head>
<body>

	
<div class="container">



<!-- Modal -->
<div id="changePasswordModal" class="modal fade" role="dialog">

<script type="text/javascript">


var response;
$(document).ready(function() {
$("#changePwd").on("click",function(){
	
	var loginId  = '<s:property value="#session.loginId" />';

	var  oldPwd = $("#currentPassword").val();

	var   newPwd = $("#newPassword").val();
	
	var   renPwd  = $("#renPassword").val();
	
	if(oldPwd == ""){
		alert("Please Enter Current Password");
		return false;
	}else if(newPwd==""){
		alert("Please Enter New  Password");
		return false;
	}else if(renPwd==""){
		alert("Please Re type new  Password");
		return false;
	}else if(newPwd != renPwd){
	alert("New Passwords not matching");
	return false;
	}
	$.ajax({
        type: "POST",
        url:'<%=contextPath %>/changePasswordAction.action',
        data: { 
        "loginId": loginId, 
        "newPwd": newPwd, 
        "oldPwd": oldPwd
    },
        success: function(response){

            if(response == "success"){
            	alert("Paasword Changed Successfully");
            	$('#changePasswordModal').modal('hide');
            }else if(response =="CurrentPwdMismtch)"){
            	alert("Current Password is wrong");
            }else {
            	alert("Operation failed");
            }
           
           

        },

        error: function(e){

            alert('Error: ' + e.name+'  '+ e.message);

        }

    });
     
}); 



$('#changePasswordModal').on('hidden.bs.modal', function (e) {
	  $(this)
	    .find("input,textarea,select")
	       .val('')
	       .end()
	    .find("input[type=checkbox], input[type=radio]")
	       .prop("checked", "")
	       .end();
	})
}); 

                     

</script>
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Change Password</h4>
      </div>
      <div class="modal-body">
       
  
   <div class="row">
        
        <div class='col-sm-12'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Current Password :</label>
                    <input type="password"  class="form-control input-sm" name="currentPassword" id="currentPassword" required="required" />
                  
                </div>
            </div>
        </div>
        </div>
        
        <div class="row" style="margin-top: 10px;">
        
        <div class='col-sm-12'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > New Password :</label>
                    <input type="password"  class="form-control input-sm" name="newPassword" id="newPassword" required="required" />
                  
                </div>
            </div>
        </div>
        </div>
        
        <div class="row"  style="margin-top: 10px;">
        
        <div class='col-sm-12'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Retype New Password :</label>
                    <input type="password"  class="form-control input-sm" name="renPassword" id="renPassword" required="required" />
                  
                </div>
            </div>
        </div>
        </div>
        
        
        
        
        
       
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success"  id="changePwd">Change Password</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
         
      </div>
    </div>

  </div>
</div>
<!-- Modal -->
    <div class="well"  >
    <table style="width:100%">
  
  <tr>
    <th rowspan="2"><img  src="<%=contextPath %>/img/logoblueocean.png" class="img-rounded" alt="Cinque Terre" width="203" height="120"></th>
<%--     <td>Welcome : <s:property value="#session.userFname" /> &nbsp; <s:property value="#session.userLname" /> </td>  --%>
 <td>
<div class="dropdown">
  <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" style="border:0px;background-color: #f5f5f5;color: #337ab7;">Welcome : <s:property value="#session.userFname" /> &nbsp; <s:property value="#session.userLname" /> 
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
     <li><a data-toggle="modal" href="#changePasswordModal" class="button">Change Password</a></li>
     <li><a href="<%=contextPath %>/logoutAction">Log out</a></li>
   
    
  </ul>
</div>


</td>
  </tr>
  <tr>
    <td></td>
  </tr>
</table>
    
    </div>
    
     
    <ul class="nav nav-pills">
    <!--class="active"  -->
    <li  style="background-color:#6fc7eb;width:24.8%;" <s:if test="tabIndex.equals('home')">class="active"</s:if>><a  href="<%=contextPath %>/homeAction" >HOME</a></li>
    <li style="background-color:#6fc7eb;width:24.8%;" <s:if test="tabIndex.equals('reservation')">class="active"</s:if>  ><a href="<%=contextPath %>/reservation/defaultaction" >RESERVATION</a></li>
    <li style="background-color:#6fc7eb;width:24.8%;"><a href="#" >REPORTS</a></li>
    <li style="background-color:#6fc7eb;width:24.8%;" <s:if test="tabIndex.equals('Admin')">class="active"</s:if>><a href="<%=contextPath %>/admin/defaultaction"  >ADMIN</a></li>
  </ul>
</div>
    
 
</body>
</html>