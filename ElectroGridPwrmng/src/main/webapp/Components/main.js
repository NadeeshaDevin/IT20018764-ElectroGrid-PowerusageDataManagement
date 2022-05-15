$(document).ready(function()
		{
	if ($("#alertSuccess").text().trim() == "")
	{
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
		});
//
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
	 $("#hidrecordIDUpdate").val($(this).data("recordID"));
	 $("#pwrusagedataID").val($(this).closest("tr").find('td:eq(0)').text());
	 $("#username").val($(this).closest("tr").find('td:eq(1)').text());
	 $("#useraddress").val($(this).closest("tr").find('td:eq(2)').text());
	 $("#noofpwrunits").val($(this).closest("tr").find('td:eq(3)').text());
	 $("#unitprice").val($(this).closest("tr").find('td:eq(4)').text());
	 $("#totalprice").val($(this).closest("tr").find('td:eq(5)').text());
	 $("#payedmonth").val($(this).closest("tr").find('td:eq(6)').text());
});

//
// validate powerusage form [CLIENT-MODEL]
//
function validatepowerusageDataForm()
{
// PowerusagedataID
if ($("#pwrusagedataID").val().trim() == "")
 {
 return "Insert Powerusage Data ID.";
 }
// Customername
if ($("#username").val().trim() == "")
 {
 return "Insert Customer Name.";
 }
// Customeraddress
if ($("#useraddress").val().trim() == "")
 {
 return "Insert Customer Address.";
 }
 // noofpwrunitsused
if ($("#noofpwrunits").val().trim() == "")
 {
 return "Insert The Number of Power Units Used.";
 }
 // oneunitprice
if ($("#unitprice").val().trim() == "")
 {
 return "Insert The price of a one power unit.";
 }
 // totalbill
if ($("#totalprice").val().trim() == "")
 {
 return "Insert The Total Bill Price.";
 }
 // payedmonth
if ($("#payedmonth").val().trim() == "")
 {
 return "Insert The Bill Payed Month.";
 }
return true;
}

/*** */
// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
// Clear status msges-------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();
// Form validation----------------
var status = validatepowerusageDataForm();
// If not valid-------------------
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }
// If valid-----------------------
//Insert part
 var type = ($("#hidrecordIDUpdate").val() == "") ? "POST" : "PUT";
 $.ajax(
 {
 url : "PowerusageAPI",
 type : type,
 data : $("#formpowerusage").serialize(),
 dataType : "text",
 complete : function(response, status)
 {
 onpowerusagedataSaveComplete(response.responseText, status);
 }
 });
});

function onpowerusagedataSaveComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully saved.");
 $("#alertSuccess").show();
 $("#divpowerusageGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while saving.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while saving..");
 $("#alertError").show();
 }
 14
 $("#hidrecordIDUpdate").val("");
 $("#formpowerusage")[0].reset();
}


// Delete part
$(document).on("click", ".btnRemove", function(event)
		{
		 $.ajax(
		 {
		 url : "PowerusageAPI",
		 type : "DELETE",
		 data : "recordID=" + $(this).data("itemid"),
		 dataType : "text",
		 complete : function(response, status)
		 {
		 onpowerusagedataDeleteComplete(response.responseText, status);
		 }
		 });
		});
function onpowerusagedataDeleteComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully deleted.");
 $("#alertSuccess").show();
 $("#divpowerusageGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while deleting.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while deleting..");
 $("#alertError").show();
 }
}
