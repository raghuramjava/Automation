<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <!DOCTYPE html>
<html>
<head>

<style type="text/css">

.row {

margin-bottom: 10px;

}




</style>

</head>
<body>


<s:if test="hasActionErrors()">
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      
      <div class="modal-body">
        <div class="alert alert-danger">
      <strong> <s:actionerror/></strong>
       </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	$('#myModal').modal('show'); 
});
</script>

</s:if>

<div class="container">


   
<%
String contextPath = request.getContextPath();

%>

 <ul class="breadcrumb">

        <li><a href="<%=contextPath %>/admin/defaultaction">Admin</a></li>
        <li><a href="<%=contextPath %>/admin/defaultaction">User Management</a></li>

      <li class="active">New User</li>

        

    </ul>

<div class="panel panel-default">
  <div class="panel-body">
  <form  id="newUserForm" name="newUserForm" method="post" action="newUserSaveAction">
  
   <div class="row">
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > First name :</label>
                    <input type="text"  class="form-control input-sm" name="fname" id="fname" required="required" />
                  
                </div>
            </div>
        </div>
        
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Last name :</label>
                    <input type="text"  class="form-control input-sm" name="lname" id="lname" required="required" />
                  
                </div>
            </div>
        </div>
        
        
        
         </div>
         
         
       
  
  
  <div class="row">
  
  <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Email address :</label>
                    <input type="text"  class="form-control input-sm" name="email" id="email" required="required"  />
                  
                </div>
            </div>
        </div>
  
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label">User Id :</label>
                    <input type="text" class="form-control input-sm" name="userId"  id="userId"  required="required" />
                 </div>
            </div>
        </div>
       </div>  
       
      
       
      
         
        <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > User  Password :</label>
                    <input type="password"  class="form-control input-sm" name="password" id="password" required="required" />
                  
                </div>
            </div>
        </div>
        
        
        
        
        
        
    </div>
    
    <div class="row">
      
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Admin  User :</label>
              <input type="checkbox" value="true" id="admUser" name="admUser">                    
                  
                </div>
            </div>
        </div>
  
  
  <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Send  Mail :</label>
              <input type="checkbox" value="true" id="chkMail" name="chkMail">                    
                  
                </div>
            </div>
        </div>
        
        
        
     
        
        
    </div>
   
   
   
        
     
        
        
    </div>
   
  
  
  
 <button type="submit" class="btn btn-success" style="margin: 20px;">Save User</button>
   
   
   </form>
  </div>
  
  </div>
</div>


 




</body>

</html>