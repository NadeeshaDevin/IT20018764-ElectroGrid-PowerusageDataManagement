package com;
import java.sql.*;
public class Powerusage {
	//Create the connection with Mysql database
	
	private Connection connect()
	 {
		 Connection con = null;
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
		
			 //Provide the Database details: DBServer/DBName, username, password
			 
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electrogrid", "root", "ndksliit");
		 }
			 catch (Exception e)
			 {e.printStackTrace();}
			 return con;
	 }
	//view Powerusage API data section
	public String readPowerusage()
	{
			String output = "";
			 try
			 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for reading."; }
				 
				 // Prepare the html table to be displayed
				 
				 output = "<table class='table' border='1'><thead class='table-success'><tr><th scope='col'>Power Usage Data ID</th><th scope='col'>Customer Name</th>" +
						 "<th scope='col'>Customer Address</th>" +"<th scope='col'>Number Of Power Units Used</th>" +"<th scope='col'>One Unit Price (RS)</th>" +
						 "<th scope='col'>Total Bill Amount</th>" +"<th scope='col'>Bill Payed Month</th>" +"<th scope='col'>Update</th>"+"<th scope='col'>Delete</th></tr></thead><tbody>";
			
				 String query = "select * from pwrusagedata";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(query);
				 
				 // iterate through the rows in the result set
				 
				 while (rs.next())
				 {
					 String recordID = Integer.toString(rs.getInt("recordID"));
					 String pwrusagedataID = rs.getString("pwrusagedataID");
					 String username = rs.getString("username");
					 String useraddress = rs.getString("useraddress");
					 String noofpwrunits = rs.getString("noofpwrunits");
					 String unitprice = rs.getString("unitprice");
					 String totalprice = rs.getString("totalprice");
					 String payedmonth = rs.getString("payedmonth");
					 
					
					 
					 // Add into the html table
					 
					 output += "<tr><td class='table-warning'><input id='hidrecordIDUpdate' name='hidrecordIDUpdate' type='hidden' value='" + recordID +  "'>" + pwrusagedataID + "</td>"; 
					 output += "<td class='table-warning'>" + username + "</td>";
					 output += "<td class='table-warning'>" + useraddress + "</td>";
					 output += "<td class='table-warning'>" + noofpwrunits + "</td>";
					 output += "<td class='table-warning'>" + unitprice + "</td>";
					 output += "<td class='table-warning'>" + totalprice + "</td>";
					 output += "<td class='table-warning'>" + payedmonth + "</td>";
					 
					 
					 
					 // buttons
					 
					 output += "<td><input name='btnUpdate'  type='button' value='Update' class='btnUpdate btn btn-secondary' data-itemid='"+ recordID + "'>" + "</td>" 
					+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='"+ recordID + "'>" + "</td></tr></tbody>";		 
				 }
				 con.close();
				 
				 // Complete the html table
				 
				 output += "</table>";
			 }
			 catch (Exception e)
			 {
				 output = "Error while reading the Powerusage.";
				 System.err.println(e.getMessage());
			 }
			 return output;
	}
	
	//Insert powerusage API Data section
	public String InsertPowerusage(String pwrusagedataID, String username, String useraddress, String noofpwrunits, String unitprice, String totalprice, String payedmonth)
	{
		 String output = "";
		 try
		 {
			 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for inserting."; 
			 }
			 
			 // create a prepared statement
			 
			 String query = " insert into pwrusagedata(`recordID`,`pwrusagedataID`,`username`,`useraddress`,`noofpwrunits`,`unitprice`,`totalprice`,`payedmonth`)" + " values (?, ?, ?, ?, ?, ?, ?, ?)";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 // binding values
			 
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, pwrusagedataID);
			 preparedStmt.setString(3, username);
			 preparedStmt.setString(4, useraddress);
			 preparedStmt.setString(5, noofpwrunits);
			 preparedStmt.setString(6, unitprice);
			 preparedStmt.setString(7, totalprice);
			 preparedStmt.setString(8, payedmonth);
			 
			 
			 
			 // execute the statement
			 
			 preparedStmt.execute();
			 con.close();
			 
			 String newpwrusage = readPowerusage(); 
			 output = "{\"status\":\"success\", \"data\": \"" +
					 newpwrusage + "\"}";
		 }
		 catch (Exception e)
		 {
			 output = "{\"status\":\"error\", \"data\": \"Error while inserting the item.\"}";
			 System.err.println(e.getMessage());
		 }
		 return output;
	}
	
	
	//update Powerusage API data section
	public String UpdatePowerusage(String recordID, String pwrusagedataID, String username, String useraddress, String noofpwrunits, String unitprice, String totalprice, String payedmonth)
	{
			 String output = "";
			 try
			 {
				 Connection con = connect();
				 if (con == null)
				 {
					 return "Error while connecting to the database for updating."; 
				 }
				 
				 // create a prepared statement
				 
				 String query = "UPDATE pwrusagedata SET pwrusagedataID=?, username=?, useraddress=?, noofpwrunits=?, unitprice=?, totalprice=?, payedmonth=? WHERE recordID=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 
				 // binding values
				 
				 
				 preparedStmt.setString(1, pwrusagedataID);
				 preparedStmt.setString(2, username);
				 preparedStmt.setString(3, useraddress);
				 preparedStmt.setString(4, noofpwrunits);
				 preparedStmt.setString(5, unitprice);
				 preparedStmt.setString(6, totalprice);
				 preparedStmt.setString(7, payedmonth);
				 preparedStmt.setInt(8, Integer.parseInt(recordID));
				 
				 // execute the statement
				 
				 preparedStmt.execute();
				 con.close();
				 
				 String newpwrusage = readPowerusage(); 
				 output = "{\"status\":\"success\", \"data\": \"" +
						 newpwrusage + "\"}";
			 }
			 catch (Exception e)
			 {
				 output = "{\"status\":\"error\", \"data\": \"Error while updating the item.\"}";
				 System.err.println(e.getMessage());
			 }
			 return output;
	}
	
	
	// delete PowerusageAPI  data section
	public String DeletePowerusage(String recordID)
	{
		 String output = "";
		 try
		 {
			 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for deleting."; 
			 }
			 // create a prepared statement
			 String query = "delete from pwrusagedata where recordID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(recordID));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 
			 String newpwrusage = readPowerusage(); 
			 output = "{\"status\":\"success\", \"data\": \"" +
					 newpwrusage + "\"}";
			 
		 }
		 catch (Exception e)
		 {
			 output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}";
			 System.err.println(e.getMessage());
		 }
		 return output;
	 }
}
