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
<div class="container">


   
<%
String contextPath = request.getContextPath();

%>

 <ul class="breadcrumb">

        <li><a href="<%=contextPath %>/reservation/defaultaction">Reservation</a></li>

      <li class="active">Reservations List </li>

        

    </ul>

<div class="panel panel-default">
  <div class="panel-body">
        <div class="row" style="line-height: 30px;margin: auto;"><span><i class="fa fa-square" aria-hidden="true" style="background-color:#dc1134;"></i> Cancelled Reservation</span></div>
       <div class="row" style="line-height: 30px;">
      <div class="col-sm-2" style="background-color:lavender;font-weight: bold;">Reservation Id</div>
      <div class="col-sm-2" style="background-color:lavenderblush;font-weight: bold;">Company Name</div>
      <div class="col-sm-2" style="background-color:lavender;font-weight: bold;">Contact Person </div>
      <div class="col-sm-2" style="background-color:lavender;font-weight: bold;">Number of Guests</div>
        <div class="col-sm-2" style="background-color:lavender;font-weight: bold;">Reservation Date</div>
        <div class="col-sm-2" style="background-color:lavender;font-weight: bold;">Phone No</div>
  </div>
  

   
  <s:iterator value="reservationList" var="Reservation"> <!-- here myList contains the list of objects -->
 
  <div class="row"  style="line-height: 30px;">
     <s:if test='%{#Reservation.status=="A"}'>
     <div class="col-sm-2" style="background-color:lavender;"><a href="getReservationDetailsAction?resId=<s:property value="%{#Reservation.resId}" />"><s:property value="%{#Reservation.resId}" /></a></div>
    <div class="col-sm-2" style="background-color:lavenderblush;"><s:property value="%{#Reservation.companyName}" /></div>
    <div class="col-sm-2" style="background-color:lavender;"><s:property value="%{#Reservation.contact_person}" /> </div>
    <div class="col-sm-2" style="background-color:lavender;"><s:property value="%{#Reservation.noOfPesons}" /></div>
   
    <div class="col-sm-2" style="background-color:lavender;"><s:date name='%{#Reservation.reservation_date}' format='dd-MM-yyyy' /></div>
     <div class="col-sm-2" style="background-color:lavender;"><s:property value="%{#Reservation.phoneNo}" /></div>
     </s:if>
     <s:else>
     <div class="col-sm-2" style="background-color:#dc1134;color: white;"><a href="getReservationDetailsAction?resId=<s:property value="%{#Reservation.resId}" />"><s:property value="%{#Reservation.resId}" /></a></div>
    <div class="col-sm-2" style="background-color:#dc1134;color: white;"><s:property value="%{#Reservation.companyName}" /></div>
    <div class="col-sm-2" style="background-color:#dc1134;color: white;"><s:property value="%{#Reservation.contact_person}" /> </div>
    <div class="col-sm-2" style="background-color:#dc1134;color: white;"><s:property value="%{#Reservation.noOfPesons}" /></div>
   
    <div class="col-sm-2" style="background-color:#dc1134;color: white;"><s:date name='%{#Reservation.reservation_date}' format='dd-MM-yyyy' /></div>
     <div class="col-sm-2" style="background-color:#dc1134;color: white;"><s:property value="%{#Reservation.phoneNo}" /></div>
     
     </s:else>
  </div>
  
  </s:iterator>
  

  
  </div>
  
  </div>
</div>


 




</body>

</html>