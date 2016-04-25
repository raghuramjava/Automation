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
<script type="text/javascript">

$(document).ready(function() {

    $("#adultPriceCheck").click(function(){
    	var counter = 0;
    	var price ='';
        $.each($("input[name='adultPrices']"), function(){ 
        	
        	if(counter == 0){
             price =  $(this).val();
            
        	}else{
        		 $(this).val(price);
        	}
        	counter++;
        });
       
        
    });
    
    
    $("#childPriceCheck").click(function(){
    	var counter = 0;
    	var price ='';
        $.each($("input[name='childPrices']"), function(){            
        	if(counter == 0){
                price =  $(this).val();
               
           	}else{
           		 $(this).val(price);
           	}
           	counter++;
        });
       
        
    });
    
    $("#seatCheck").click(function(){
    	var counter = 0;
    	var seats ='';
        $.each($("input[name='seats']"), function(){            
        	if(counter == 0){
        		seats =  $(this).val();
               
           	}else{
           		 $(this).val(seats);
           	}
           	counter++;
        });
       
        
    });
    
    
    $("#month").change(function(){
    	var month  =  $("#month").val();
    	var year   =  $("#year").val();
    	 window.location.href="<%=contextPath %>/admin/pricingInvNewDateAction?month="+month+"&year="+year;
      });
    
    
});

</script>

</head>
<body>
<div class="container">
  <s:if test="hasActionMessages()">
<!-- Modal -->
<div id="reservationPricingModal" class="modal fade" role="dialog">
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
	$('#reservationPricingModal').modal('show'); 
});
</script>

</s:if>


   


     <ul class="breadcrumb">
        <li><a href="<%=contextPath %>/admin/defaultaction">Admin</a></li>
        <li class="active">Price Inventory List</li>
    </ul>

<div class="panel panel-default">
  <div class="panel-body">
   <form  <s:if test="dateMap.size() > 0">action="savePriceInventoryAction"</s:if> <s:else>action="updatePriceInventoryAction"</s:else> >
    <div class="row">
        
        <div class='col-sm-4'>
            <div class="form-group">
            <div class="col-xs-6">
            
           
            <label class="control-label" > Year :</label>
            <s:select list="yearMap" listKey="key" listValue="value" cssClass="form-control"  value="%{year}" name="year" id="year"/>
            
<%--                     <select class="form-control" id="year" name="year"> --%>
<!--                     <option value="2016">2016</option> -->
<!--                     <option value="2017">2017</option> -->
<!--                     <option value="2018">2018</option> -->
<!--                     <option value="2019">2019</option> -->
<!--                     <option value="2020">2020</option> -->
<%--                     </select> --%>
                  
                </div>
            </div>
        </div>
        
        
        <div class='col-sm-4'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Month:</label>
             <s:select list="monthMap" listKey="key" listValue="value" cssClass="form-control" value="%{month}"  name="month" id="month"/>
            
<%--                     <select class="form-control" id="month" name="month"> --%>
<!--                     <option value="0">January</option> -->
<!--                     <option value="1">February</option> -->
<!--                     <option value="2">March</option> -->
<!--                     <option value="3">April</option> -->
<!--                     <option value="4">May</option> -->
<!--                     <option value="5">June</option> -->
<!--                     <option value="6">July</option> -->
<!--                     <option value="7">August</option> -->
<!--                     <option value="8">September</option> -->
<!--                     <option value="9">October</option> -->
<!--                     <option value="10">November</option> -->
<!--                     <option value="11">December</option> -->
<%--                     </select> --%>
                  
                </div>
            </div>
        </div>
        
  <button type="submit" class="btn btn-success" style="margin-top: 19px;">SAVE PRICE INVENTORY </button>
  </div>
  <div class="row" style="line-height: 30px;">
    <div class="col-sm-3" style="background-color:lavenderblush;font-weight: bold;">Date (dd-mm-yyyy)</div>
    <div class="col-sm-3" style="background-color:lavender;font-weight: bold;">Adult Price (SAR) <span><a id="adultPriceCheck" href="#"><i class="fa fa-caret-square-o-down"></i></a></span></div>
    <div class="col-sm-3" style="background-color:lavenderblush;font-weight: bold;">Child Price (SAR)  <span><a id="childPriceCheck"   href="#"><i class="fa fa-caret-square-o-down"></i></a> </span></div>
    <div class="col-sm-3" style="background-color:lavender;font-weight: bold;">Number Of Seats <span><a id="seatCheck" href="#"><i class="fa fa-caret-square-o-down"></i></a></span> </div>
   
    
    
  </div>
  
  <s:if test="dateMap.size() > 0">
   <s:iterator value="dateMap">
    <div class="row" style="line-height: 30px;">
    <div class="col-sm-3" style="background-color:lavenderblush;"> <s:property value="value"/></div>
    <div class="col-sm-3" style="background-color:lavender;"> <input class="form-control input-sm" id="<s:property value='key'/>-adult" type="number" value="0.00" name="adultPrices" min="0" step="any" required="required"></div>
    <div class="col-sm-3" style="background-color:lavenderblush;"><input class="form-control input-sm" id="<s:property value='key'/>-child" type="number" value="0.00" name="childPrices" min="0" step="any" required="required"></div>
    <div class="col-sm-3" style="background-color:lavender;"> <input class="form-control input-sm" id="<s:property value='key'/>-seats" type="number" value="0" name="seats" min="0" required="required"> </div>
    <input type="hidden" id="<s:property value='key'/>-date" name="dates" value="<s:property value='value'/>" >
    </div>
  </s:iterator>
  
  </s:if>
  <s:else>
   
  <s:iterator value="invAarray" var="PriceInventory">
 
    <div class="row" style="line-height: 30px;">
    <div class="col-sm-3" style="background-color:lavenderblush;">      <s:property value="#PriceInventory[1]" /></div>
<%--    <div class="col-sm-3" style="background-color:lavender;"> <input class="form-control input-sm" id="<s:property value='#PriceInventory[0]'/>-adult" type="number" value="0.00" name="adultPrices" min="0" step="any" required="required"></div> --%>
    <div class="col-sm-3" style="background-color:lavender;"> <input class="form-control input-sm" id="adult" type="number" value="<s:property value='#PriceInventory[2]'/>" name="adultPrices" min="0" step="any" required="required"></div>
        <div class="col-sm-3" style="background-color:lavenderblush;"><input class="form-control input-sm"  type="number" value="<s:property value='#PriceInventory[3]'/>" name="childPrices" min="0" step="any" required="required"></div>
        
        <div class="col-sm-3" style="background-color:lavender;"> <input class="form-control input-sm"  type="number" value="<s:property value='#PriceInventory[4]'/>" name="seats" min="0" required="required"> </div>
           <input type="hidden"  name="dates" value="<s:property value='#PriceInventory[1]' />" >
            <input type="hidden"  name="priIds" value="<s:property value='#PriceInventory[0]' />" >
    
  </div>
  
  </s:iterator>
 
  </s:else>
 
 
  
  </div>
  
  </div>
</div>


 




</body>

</html>