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
	
	$("#reservationDate").change(function(){
		var rDate = $('#reservationDate').val();
		  if(rDate == '')
	      return false;
		  
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
	        		
	        		$('#availableSeats').val(totalSeats-reservedSeats);
	        		
	        	}else{
	        		
	        		$('#availableSeats').val('0');
	        	}
	           

	        },

	        error: function(e){

	            alert('Error: ' + e.name+'  '+ e.message);

	        }

	    });
    	
      });
	
	$("#noOfPerson").change(function(){
		var rDate = $('#reservationDate').val();
		if(rDate ==""){
			alert("Please select Reservation Date");
			$('#noOfPerson').val('');
		}else{
			var availableSeats = $('#availableSeats').val();
			var noOfseats  =     $('#noOfPerson').val();
			
			if(Number(noOfseats) > Number(availableSeats)){
				alert("You are trying to reserve seats more than available seats")
				$('#noOfPerson').val('');
			}
		}
		
		
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
   <div class="modal" style="display: none;position:absolute;margin-left: -241px;margin-top: 190px;">
        <div class="center">
         <img alt="" src="<%=contextPath %>/img/loader.gif" />
        </div>
        </div>
  <form  id="newUserForm" name="newReservationForm" method="post" action="saveReservation">
  
  
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
            <label class="control-label" > Phone No</label>
                    <input type="text"  class="form-control input-sm" name="phoneNo" id="phoneNo"   />
                  
                </div>
            </div>
        </div>
  
        <div class='col-sm-6'>
                       
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Email address :</label>
                    <input type="text"  class="form-control input-sm" name="email" id="email"   />
                  
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
            
            <label class="control-label" > Available Seats :</label>
                    <input type="number"  class="form-control input-sm" name="availableSeats" id="availableSeats" required="required" readonly="readonly" />
                 
                </div>
            </div>
        </div>
        
       
           
        
    </div>
    
    
    <div class="row">
       
        
        
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            
            <label class="control-label" > No of Guests :</label>
                    <input type="number"  class="form-control input-sm" name="noOfPerson" id="noOfPerson" required="required" />
                 
                </div>
            </div>
        </div>
        
         <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            
            <label class="control-label" > Advance amount :</label>
                    <input type="number"  class="form-control input-sm" name="adavanceAmount" id="adavanceAmount" required="required" />
                 
                </div>
            </div>
        </div>
        
       
           
        
    </div>
    
    
    
    
    
    
    <div class="row">
      
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > User Input :</label>
             <textarea rows="5" cols="40" name="userInput" id="userInput"></textarea>              
                  
                </div>
            </div>
        </div>
  
  

        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Remarks :</label>
             <textarea rows="5" cols="40" name="remarks" id="remarks"></textarea>                   
                  
                </div>
            </div>
        </div>
        
        
        
     
        
        
    </div>
   
   
   
        
     
        
        
    </div>
   
  
  
  
 <button type="submit" class="btn btn-success" style="margin-left: 30px;margin-top: 10px;margin-bottom: 25px;">Save Reservation</button>
   
   
   </form>
  </div>
  
  </div>


 




</body>

</html>