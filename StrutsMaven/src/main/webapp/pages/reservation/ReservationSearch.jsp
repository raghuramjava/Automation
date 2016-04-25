<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <!DOCTYPE html>
<html>
<head>
<%
String contextPath = request.getContextPath();

%>
<style type="text/css">

.row {

margin-bottom: 10px;

}




</style>

</head>
<body>
<script type="text/javascript">
$(document).ready(function() {
	$(function () {
        $('#datetimepicker5').datepicker({
        format:"dd-mm-yyyy",
        autoclose:true,	
        
        	
        });
    });
});
</script>



<div class="container">


   


 <ul class="breadcrumb">

        <li><a href="<%=contextPath %>/reservation/defaultaction">Reservation</a></li>
        

      <li class="active">New Reservation</li>

        

    </ul>

<div class="panel panel-default">
  <div class="panel-body">
  <form  id="searchForm" name="searchReservationForm" method="post" action="searchReservationtiAction">
  
  
   <div class="row">
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Company Name :</label>
                    <input type="text"  class="form-control input-sm" name="companyName" id="companyName" />
                    
                </div>
            </div>
        </div>
        
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Contact Person :</label>
                    <input type="text"  class="form-control input-sm" name="contactPerson" id="contactPerson" />
                  
                </div>
            </div>
        </div>
        
        
        
         </div>
         
         
   
         
        <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Reservation Date :</label>
                    <div class='input-group date' id='datetimepicker5'>
                    <input type='text' class="form-control input-sm" name="reservationDate" id="reservationDate"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
                  
                </div>
            </div>
        </div>
        
       
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            
            <label class="control-label" > Reservation Id :</label>
                    <input type="number"  class="form-control input-sm" name="reservationId" id="reservationId"  />
                 
                </div>
            </div>
        </div>
        
       
           
        
    
    
   
    </div>
   
  
  
  
 <button type="submit" class="btn btn-success" style="margin-left: 30px;margin-top: 10px;margin-bottom: 25px;">Search Reservation</button>
   
   
   </form>
  </div>
  
  </div>

</div>
 




</body>

</html>