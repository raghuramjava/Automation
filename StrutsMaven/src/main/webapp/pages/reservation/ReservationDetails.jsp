<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
   
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
$("#noOfPerson").change(function(){

	var rDate = $('#reservationDate').val();
	
		 $.ajaxSetup({
	         
	         beforeSend: function () {
	            $(".modal").show();
	         },
	         complete: function () {
	             $(".modal").hide();
	         }
	     });
		 
		 $.ajax({
		        type: "POST",
		        url:'<%=contextPath %>/reservation/getInventoryAction.action',
		        data: { 
		        "rDate": rDate 
		          },
		          
		         
		         
		        success: function(responseJson){
	             var messagge = '';
	             var reservedSeats  ='';
	             var totalSeats = '';
		        	$.each(responseJson, function(key, value) { 
		        		if(key =='message'){
		        			messagge = value;
		        		}else if(key =='totalSeats'){
		        			totalSeats = value;
		        		}else if(key =='reservedSeats'){
		        			reservedSeats =value;
		        		
		        		}
		        		
		        		
		        		
		        		
		        	});
		        
		        	if(messagge=='success'){
		        		var noOfSeatsResClaimed  = "<s:property value='reservation.noOfPesons'/>";
		        		
		        		var other= reservedSeats-noOfSeatsResClaimed;
		        		
		        		var modifiedSeat =  $('#noOfPerson').val();
		        		
		        		if((Number(other)+Number(modifiedSeat))>Number(totalSeats)){
		        			alert("You are trying to reserve seats more than available seats");
		        			$('#noOfPerson').val(noOfSeatsResClaimed);
		        		}
		        		
		        		
		        		
		        		
		        	}else{
		        		
		        		
		        	}
		           

		        },

		       

		    });
	
 	
   });
	 
	 
});



</script>



<div class="container">


<s:if test="hasActionMessages()">
<!-- Modal -->
<div id="reservationSuceeModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      
      <div class="modal-body">
        <div class="alert alert-success">
      <strong> <s:actionmessage escape="true"/></strong>
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
	
	$('#reservationSuceeModal').modal('show'); 
});
</script>

</s:if>


   


 <ul class="breadcrumb">

        <li><a href="<%=contextPath %>/reservation/defaultaction">Reservation</a></li>
        

      <li class="active">New Reservation</li>

        

    </ul>

<div class="panel panel-default">
  <div class="panel-body">
  
  
  <div class="modal" style="display: none;position:absolute;margin-left: -241px;margin-top: 190px;">
        <div class="center">
         <img alt="" src="<%=contextPath %>/img/loader.gif" />
        </div>
        </div>
  
  <s:set name="cancelRes"  var="cancelRes" value="C"></s:set>
  <form  id="reservationForm" name="reservationForm" method="post" action="updateReservation">
  
  <s:if test='%{reservation.status=="C"}'> <div class="alert alert-danger">
  <strong> This is a Cancelled Reservation</strong> 
</div></s:if>
 
<%--      <s:if test="#reservation.status.equals(cancelRes)"><div class="row">This is a Cancelled Reservation</div></s:if> --%>
  <div class="row">
    <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Reservation  Id :</label>
                    <input type="text"  class="form-control input-sm" name="resId" id="resId" readonly="readonly" value="<s:property value='reservation.resId'/>"/>
                    
                </div>
            </div>
        </div>
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Created by :</label>
                    <input type="text"  class="form-control input-sm" name="createdBy" id="createdBy" readonly="readonly" value=" <s:property value='reservation.createdBy'/>" />
                    
                </div>
            </div>
        </div>
  
  
  </div>
  
  
   <div class="row">
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Company Name :</label>
                    <input type="text"  class="form-control input-sm" name="companyName" id="companyName" value=" <s:property value='reservation.companyName'/>" />
                    
                </div>
            </div>
        </div>
        
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Contact Person :</label>
                    <input type="text"  class="form-control input-sm" name="contactPerson" id="contactPerson" value=" <s:property value='reservation.contact_person'/>"  />
                  
                </div>
            </div>
        </div>
        
        
        
         </div>
         
         
       
  
  
  <div class="row">
  
  <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Phone No</label>
                    <input type="text"  class="form-control input-sm" name="phoneNo" id="phoneNo"  value=" <s:property value='reservation.phoneNo'/>"  />
                  
                </div>
            </div>
        </div>
  
        <div class='col-sm-6'>
                       
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Email address :</label>
                    <input type="text"  class="form-control input-sm" name="email" id="email" value=" <s:property value='reservation.email'/>"   />
                  
                </div>
            </div>
        </div>
       </div>  
       
      
       
      
         
        <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Reservation Date :</label>
                    <input type='text' class="form-control input-sm" name="reservationDate" id="reservationDate" readonly="readonly" value="<s:date name='reservation.reservation_date' format='dd-MM-yyyy' />" />
                </div>
            </div>
        </div>
        
         <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            
            <label class="control-label" > No of Guests :</label>
                    <input type="number"  class="form-control input-sm" name="noOfPerson" id="noOfPerson" required="required" value="<s:property value='reservation.noOfPesons'/>" />
                 
                </div>
            </div>
        </div>
        
   
     
       
           
        
    </div>
    
    
    <div class="row">
             
         <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            
            <label class="control-label" > Advance amount :</label>
                    <input type="number"  class="form-control input-sm" name="adavanceAmount" id="adavanceAmount" required="required" value="<s:property value='reservation.advanceAmount'/>" />
                 
                </div>
            </div>
        </div>
        
       
           
        
    </div>
    
    
    
    
    
    
    <div class="row">
      
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > User Input :</label>
             <textarea rows="5" cols="40" name="userInput" id="userInput"   > <s:property value='reservation.userInput'/></textarea>              
                  
                </div>
            </div>
        </div>
  
  

        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Remarks :</label>
             <textarea rows="5" cols="40" name="remarks" id="remarks"> <s:property value='reservation.remarks'/></textarea>                   
                  
                </div>
            </div>
        </div>
        
        
        
     
        
        
    </div>
    
    <s:if test='%{reservation.status=="A"}'> 
   
   <button type="submit" id="updRes" class="btn btn-success" >Update Reservation</button> &nbsp;&nbsp;
   
    <a href="<%=contextPath %>/reservation/cancelReservationAction?resId=<s:property value='reservation.resId'/>" class="btn btn-danger" role="button"> Cancel Reservation </a>
   
    </s:if>
        
     
        
        
    </div>
   
  
  
  
 
   
   
   </form>
  </div>
  
  </div>


 




</body>

</html>	