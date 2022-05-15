<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.Powerusage" %>
<!DOCTYPE html>
<html>
<head>
<!-- Page Header Styles -->
<style>
        .pageHead {
            display: flex;
        }

        .left {
            flex: 25%;
            padding: 15px 0;
        }

        .center {
            flex: 50%;
            padding: 15px 0;
        }
        .right {
            flex: 25%;
            padding: 15px 0;
        }   
</style>
<!-- Page Header Styles -->
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/main.js"></script>
<!-- charset meta tag -->
<meta charset="utf-8">
<!-- head code meta tag -->
<meta name="viewport" content="eidth=device-width, initial-scale=1">
<title>Powerusage Data Management</title>
<!-- CSS Links -->
<link rel ="stylesheet" type="text/css" href="css/Styles.css">
<link rel ="stylesheet" type="text/css" href="css/Jobs & req.css">
<!-- CSS Links -->
</head>
<body>
<!-- Page Header section -->
<div class="pageHead">
	<div class="center" align="center">
		<h1 style="font-family:Brush Script MT;"><span>Electro</span>Grid</h1>
		<h2 style="font-family:Courier New;">Your Power Our Service</h2>
	</div >
</div>
<!-- Page Header section -->
<!-- Page Navigation section -->
<div class="pageNav" id="ul">
	<div class="left" id="li">
		<a id="li a" href="ViewPowerUsagePage.jsp" style="font-family:sans-serif;">
                    View Power Usage Data
        </a>
	</div>
</div>
<div class="innerpageNav" id="ul2">
	<div class="left1" id="li2">
	<a href="#">
		<font  style="font-family:Brush Script MT ; text-align:center;"><span>Electro</span>Grid</font>
		</a>
    </div>
	<div  style="text-align:center;" class="right1" id="li2">
		<a id="li2 a" style="font-family:sans-serif;">
                    Power Usage Data Management
        </a>
    </div>
</div>
<!-- Page Navigation section -->
<!-- Page Body section -->
<div class="page-wrapper">
	<div class="container">
<form method="post" id="formpowerusage" name="formpowerusage">
 <div class="row">
					<div class="col-25" id="center">
						 Power Usage Data ID:
					</div>
				 	<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
						 <input  name="pwrusagedataID" id="pwrusagedataID" type="text" >
					</div>
				</div>
				<br>
					<div class="row">
						<div class="col-25" id="center"> 
							Customer Name:
						</div>
						<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
							<input  name="username" type="text" id="username">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-25" id="center"> 
							Customer Address:
						</div>
						<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
							<input  name="useraddress" type="text" id="useraddress">
						</div>
					</div>
					<br> 
					<div class="row">
						<div class="col-25" id="center"> 
							Number Of Power Units Used:
						</div>
						<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
							<input  name="noofpwrunits" type="text" id="noofpwrunits">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-25" id="center">  
							One Unit Price (RS):
						</div>
						<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
							<input  name="unitprice" type="text" id="unitprice">
						</div>
					</div>
					<br> 
					<div class="row">
						<div class="col-25" id="center">  
							Total Bill Amount:
						</div>
						<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
							<input  name="totalprice" type="text" id="totalprice">
						</div>
					</div>
					 <br>
					<div class="row">
						<div class="col-25" id="center">  
							Bill Payed Month:
						</div>
						<div class="col-75" style="width: 25%;" class="form-control form-control-sm">
							<input  name="payedmonth" type="text" id="payedmonth">
						</div>
					</div>
					<br> 
					<div class="pageNav" >
						<div class="left" id="center">
 							<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
 						</div>
 						<div class="right" id="center">
 							<input type="hidden" id="hidrecordIDUpdate" name="hidrecordIDUpdate" value="">
 						</div>
 					</div>		
 
</form>
	<div id="alertSuccess" class="alert alert-success"></div>
	<div id="alertError" class="alert alert-danger"></div>
<br>
	<div class="page-wrapper">
		<div class="container2">
			<div style="overflow-x: auto;" id="center" id="divpowerusageGrid">
			 <%
			 Powerusage powerusageObj = new Powerusage();
			 out.print(powerusageObj.readPowerusage());
			 %>
			</div>
		</div> 
	</div>
</div> 
</div><!-- Footer -->
<div class="footer">
	
	<div class="footer-content">
		  
		<div class="footer-section-about">
			
			<h1 style="font-family:Brush Script MT;"><span>Electro</span>Grid</h1>
			
			<p>We Provide Your Power nedds.
			</p>
			
			<h3> Our Location </h3>
			<font size="3">No 220.<br> Malwaththa Rd, <br> Colombo 03 <br> E-Mail :- ElectroGrid@Gmail.com 
			
			</font>
		</div>	
		
		<div class="footer-section-links">
		
		</div>
		
		<div class="footer-section-contact-form">
			<h2>Contact Us</h2>
			
			<h3> Hotline : 011-289-566-1</h3>
		
			<div class="socials">
				<a href="#"><i class="fab fa-facebook"></i></a>
				<a href="#"><i class="fab fa-instagram"></i></a>
				<a href="#"><i class="fab fa-twitter"></i></a>
				<a href="#"><i class="fab fa-youtube"></i></a>
			</div>
			
		</div>
	</div>
	

	<div class="footer-bottom">
		
		&copy; ElectroGrid.com | Designed by SHAN Designers
	</div>

</div>
<!-- /Footer-->
</body>

</html>