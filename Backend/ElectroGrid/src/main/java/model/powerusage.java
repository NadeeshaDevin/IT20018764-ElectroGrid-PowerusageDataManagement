package model;

import java.sql.*;

public class powerusage {
	
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
			
	//insert Powerusage data section
			
			public String insertPowerusage(String pwrusagedataID, String username, String useraddress, String noofpwrunits, String unitprice, String totalprice, String payedmonth)
			{
				 String output = "";
				 try
				 {
					 Connection con = connect();
					 if (con == null)
					 {return "Error while connecting to the database for inserting."; }
					 
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
					 output = "Inserted successfully";
				 }
				 catch (Exception e)
				 {
					 output = "Inserted not successfully";
					 System.err.println(e.getMessage());
				 }
				 return output;
			}
			
	//view Powerusage data section
			public String readPowerusage()
			{
					String output = "";
					 try
					 {
						 Connection con = connect();
						 if (con == null)
						 {return "Error while connecting to the database for reading."; }
						 
						 // Prepare the html table to be displayed
						 
						 output = "<table border='1'><tr><th>RecordID</th><th>Power Usage Data ID</th><th>Customer Name</th>" +
								 "<th>Customer Address</th>" +"<th>Number Of Power Units Used</th>" +"<th>One Unit Price (RS)</th>" +
								 "<th>Total Bill Amount</th>" +"<th>Bill Payed Month</th>" +"<th>Update</th>"+"<th>Delete</th></tr>";
					
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
							 
							 output += "<td>" + recordID +  "</td>"; 
							 output += "<td>" + pwrusagedataID + "</td>";
							 output += "<td>" + username + "</td>";
							 output += "<td>" + useraddress + "</td>";
							 output += "<td>" + noofpwrunits + "</td>";
							 output += "<td>" + unitprice + "</td>";
							 output += "<td>" + totalprice + "</td>";
							 output += "<td>" + payedmonth + "</td>";
							 
							 
							 
							 // buttons
							 
							 output += "<td><form method='post' action='UpdatePowerusagePage.jsp'>"
									 + "<input name='btnUpdate' type='submit' value='Update' class='btn btn-secondary'>"
									 + "<input name='recordID' type='hidden' value='" + recordID + "'>" + "</form></td>"
							+ "<td><form method='post' action='ViewPowerusage.jsp'>"
							 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
							 + "<input name='recordID' type='hidden' value='" + recordID + "'>" + "</form></td></tr>";		 
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
			
		//update Powerusage data section
			public String updatePowerusage(String recordID, String pwrusagedataID, String username, String useraddress, String noofpwrunits, String unitprice, String totalprice, String payedmonth)
			{
					 String output = "";
					 try
					 {
						 Connection con = connect();
						 if (con == null)
						 {return "Error while connecting to the database for updating."; }
						 
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
						 output = "Updated successfully";
					 }
					 catch (Exception e)
					 {
						 output = "Error while updating the payment.";
						 System.err.println(e.getMessage());
					 }
					 return output;
			}
				
			// delete Powerusage data section
				public String deletePowerusage(String recordID)
				{
					 String output = "";
					 try
					 {
						 Connection con = connect();
						 if (con == null)
						 {return "Error while connecting to the database for deleting."; }
						 // create a prepared statement
						 String query = "delete from pwrusagedata where recordID=?";
						 PreparedStatement preparedStmt = con.prepareStatement(query);
						 // binding values
						 preparedStmt.setInt(1, Integer.parseInt(recordID));
						 // execute the statement
						 preparedStmt.execute();
						 con.close();
						 output = "Deleted successfully";
					 }
					 catch (Exception e)
					 {
						 output = "Error while deleting the item.";
						 System.err.println(e.getMessage());
					 }
					 return output;
				 }

}
