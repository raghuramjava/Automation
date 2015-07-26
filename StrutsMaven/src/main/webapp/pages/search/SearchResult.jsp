<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<div class="container">


    <ul class="breadcrumb">

        <li><a href="#">Home</a></li>

         <li><a href="#">Search</a></li>

        <li class="active">Search Result</li>

    </ul>
    
    
    
    <div class="panel panel-default">
<!--     <div class="panel-heading" style="background-color: #ffffff;text-align: center;font-weight: bold;">Search Result</div> -->
  <div class="panel-body">
  



 <div class="row"> 
    <div class="btn-group" >
     <button type="button" class="btn btn-info" style="margin: 10px;"  data-toggle="button"><span><i class="fa fa-motorcycle"></i></span>NEW BIKE</button>
  </div>
   </div>
   
   
    <!-- Modal content for Buyer Details -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
     
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Buyer Details</h4>
        </div>
        <div class="modal-body">
          <div class="row">
          <div class="col-sm-6" >Buyer Name :</div>
          <div class="col-sm-6" >AJMAL</div>
          </div>
        <div class="row">
          <div class="col-sm-6" >Phone No :</div>
          <div class="col-sm-6" >9176072267</div>
          </div>  
           <div class="row">
          <div class="col-sm-6" >Address :</div>
          <div class="col-sm-6" >choramkodath house</div>
          </div>  
          
          <div class="row">
          <div class="col-sm-6" >Price :</div>
          <div class="col-sm-6" ><span><i class="fa fa-inr"></i></span> 90000</div>
          </div> 
          
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
       
       
       
       
      
    </div>
  </div>
  
  <!-- Modal content for Buyer Details -->
  
  
  
  
  
   <!-- Modal content for Buyer Details -->
  <div class="modal fade" id="sellerModal" role="dialog">
    <div class="modal-dialog">
    
     
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Seller Details</h4>
        </div>
        <div class="modal-body">
          <div class="row">
          <div class="col-sm-6" >Buyer Name :</div>
          <div class="col-sm-6" >Murali</div>
          </div>
        <div class="row">
          <div class="col-sm-6" >Phone No :</div>
          <div class="col-sm-6" >8086603982</div>
          </div>  
           <div class="row">
          <div class="col-sm-6" >Address :</div>
          <div class="col-sm-6" >Thekketharakath house</div>
          </div>  
          
          <div class="row">
          <div class="col-sm-6" >Price :</div>
          <div class="col-sm-6" ><span><i class="fa fa-inr"></i></span> 90000</div>
          </div> 
          
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
       
       
       
       
      
    </div>
  </div>
  
  <!-- Modal content for Buyer Details -->
  
  
   <div class="row">
   
  <div class="col-sm-2" style="padding-top: 10px;background-color: #858d93;color: #fff;height: 40px;">No</div>
  <div class="col-sm-2" style="padding-top: 10px;background-color: #858d93;color: #fff;height: 40px;">Bike No</div>
  <div class="col-sm-2" style="padding-top: 10px;background-color: #858d93;color: #fff;height: 40px;">Bike Type</div>
  <div class="col-sm-2" style="padding-top: 10px;background-color: #858d93;color: #fff;height: 40px;">Model No</div>
  <div class="col-sm-2" style="padding-top: 10px;background-color: #858d93;color: #fff;height: 40px;">Bought from</div>
  <div class="col-sm-2" style="padding-top: 10px;background-color: #858d93;color: #fff;height: 40px;">Sold To</div>
  
</div>

 

 <div class="row">
   
  <div class="col-sm-2" >1</div>
  <div class="col-sm-2" ><a href="bikeDetailsAction">KL 10 5436</a></div>
  <div class="col-sm-2" >HERO HONDA</div>
  <div class="col-sm-2" >4545</div>
  <div class="col-sm-2"><a data-toggle="modal" href="#myModal" class="button">AJMAL</a></div>
  <div class="col-sm-2"><a data-toggle="modal" href="#sellerModal" class="button">MURALI </a></div>
  
</div>





   
 
  
  
   <ul class="pagination">
  <li><a href="#">1</a></li>
  <li class="active"><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
</ul>

    </div>
    </div>
 </div>
    <script type="text/javascript">
    
    
    </script>
    
</body>
</html>