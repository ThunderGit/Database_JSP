<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial;}
/* Style the tab */
.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
    display: none;
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
}
</style>
<title>Admin</title>
</head>
<body>

<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'COUNTRY_DIRECTORY')">Country Directory</button>
  <button class="tablinks" onclick="openCity(event, 'MANUFACTURER')">Manufacturer</button>
  <button class="tablinks" onclick="openCity(event, 'PRODUCT_DATA')">Product Data</button>
  <button class="tablinks" onclick="openCity(event, 'USERS')">Users</button>
</div>

<div id="COUNTRY_DIRECTORY" class="tabcontent">
  <form method="post" action="AdminCountryDirectory"><table>
  <tr>
  <td colspan="2">ID</td>
  <td colspan="2"><input type="text" name="ID"></td>
  <td colspan="2"><input type="checkbox" name="chID"></td>
  </tr>
  <tr>
  <td colspan="2">Country Name</td>
  <td colspan="2"><input type="text" name="Country_Name"></td>
  <td colspan="2"><input type="checkbox" name="chCountry_Name"></td>
  </tr>  
  <tr>
  <td><button name="CREATE">CREATE</button></td>
  <td><button name="READ">READ</button></td>
  <td><button name="DELETE">DELETE</button></td>
  <td><input type="radio" id="RAnd1" name="RAnd1" value="And" onclick="SetAnd1();">AND</td>
  <td><input type="radio" id="ROr1" name="ROr1" value="Or" onclick="SetOr1();" checked>OR</td>
  </tr>
  </table>
  </form>
</div>

<div id="MANUFACTURER" class="tabcontent">
  <form method="post" action="AdminManufacturer">
  <table>
  <tr>
  <td colspan="2">ID</td>
  <td colspan="2"><input type="text" name="ID"></td>
  <td colspan="2"><input type="checkbox" name="chID"></td>
  </tr>
  <tr>
  <td colspan="2">Firm Name</td>
  <td colspan="2"><input type="text" name="Firm_Name"></td>
  <td colspan="2"><input type="checkbox" name="chFirm_Name"></td>
  </tr>
  <tr>
  <td colspan="2">Adress</td>
  <td colspan="2"><input type="text"  name="Adress"></td>
  <td colspan="2"><input type="checkbox" name="chAdress"></td>
  </tr>
  <tr>
  <td colspan="2">Telephone</td>
  <td colspan="2"><input type="text" name="Telephone"></td>
  <td colspan="2"><input type="checkbox" name="chTelephone"></td>
  </tr>
  <tr>
  <td colspan="2">Website</td>
  <td colspan="2"><input type="text" name="Website"></td>
  <td colspan="2"><input type="checkbox" name="chWebsite"></td>
  </tr>
  <tr>
  <td><button name="CREATE">CREATE</button></td>
  <td><button name="READ">READ</button></td>
  <td><button name="DELETE">DELETE</button></td>
  <td><input type="radio" id="RAnd2" name="RAnd2" value="And" onclick="SetAnd2();">AND</td>
  <td><input type="radio" id="ROr2" name="ROr2" value="Or" onclick="SetOr2();" checked>OR</td>
  </tr>
  </table> 
  </form>
</div>

<div id="PRODUCT_DATA" class="tabcontent">
  <form method="post" action="AdminProductData">
  <table>
  <tr>
  <td colspan="2">ID</td>
  <td colspan="2"><input type="text" name="ID"></td>
  <td colspan="2"><input type="checkbox" name="chID"></td>
  </tr>
  <tr>
  <td colspan="2">Name</td>
  <td colspan="2"><input type="text" name="Name"></td>
  <td colspan="2"><input type="checkbox" name="chName"></td>
  </tr>
  <tr>
  <td colspan="2">Product Type</td>
  <td colspan="2"><input type="text" name="Product_Type"></td>
  <td colspan="2"><input type="checkbox" name="chProduct_Type"></td>
  </tr>
  <tr>
  <td colspan="2">Release Date</td>
  <td colspan="2"><input type="text" name="Release_Date"></td>
  <td colspan="2"><input type="checkbox" name="chRelease_Date"></td>
  </tr>
  <tr>
  <td colspan="2">Term</td>
  <td colspan="2"><input type="text" name="Term"></td>
  <td colspan="2"><input type="checkbox" name="chTerm"></td>
  </tr>
  <tr>
  <td colspan="2">Firm</td>
  <td colspan="2"><input type="text" name="Firm"></td>
  <td colspan="2"><input type="checkbox" name="chFirm"></td>
  </tr>
  <tr>
  <td colspan="2">Country</td>
  <td colspan="2"><input type="text" name="Country"></td>
  <td colspan="2"><input type="checkbox" name="chCountry"></td>
  </tr>
  <tr>
  <td colspan="2">Cost</td>
  <td colspan="2"><input type="text" name="Cost"></td>
  <td colspan="2"><input type="checkbox" name="chCost"></td>
  </tr> 
  <tr>
  <td><button name="CREATE">CREATE</button></td>
  <td><button name="READ">READ</button></td>
  <td><button name="DELETE">DELETE</button></td>
  <td><input type="radio" id="RAnd3" name="RAnd3" value="And" onclick="SetAnd3();">AND</td>
  <td><input type="radio" id="ROr3" name="ROr3" value="Or" onclick="SetOr3();" checked>OR</td>
  </tr>
  </table>
  </form> 
</div>

<div id="USERS" class="tabcontent">
 <form method="post" action="AdminUsers">
  <table>
  <tr>
  <td colspan="2">ID</td>
  <td colspan="2"><input type="text" name="ID"></td>
  <td colspan="2"><input type="checkbox" name="chID"></td>
  </tr>
  <tr>
  <td colspan="2">Username</td>
  <td colspan="2"><input type="text" name="Username"></td>
  <td colspan="2"><input type="checkbox" name="chUsername"></td>
  </tr>
  <tr>
  <td colspan="2">Password</td>
  <td colspan="2"><input type="password"  name="Password" style="width:147px;"></td>
  <td colspan="2"><input type="checkbox" name="chPassword"></td>
  </tr>
  <tr>
  <td><button name="CREATE">CREATE</button></td>
  <td><button name="READ">READ</button></td>
  <td><button name="DELETE">DELETE</button></td>
  <td><input type="radio" id="RAnd4" name="RAnd4" value="And" onclick="SetAnd4();">AND</td>
  <td><input type="radio" id="ROr4" name="ROr4" value="Or" onclick="SetOr4();" checked>OR</td>
  </tr>
  </table>
  </form>
</div>
<br/><br/>
<div class="tab">
 <form method="post" action="/PSP_LAb3_Ivlev/Log.jsp"><button class="tablogout">Log Out</button></form>
</div>
<script>
		//1
function SetAnd1()
{
 var radio1=document.getElementById('RAnd1');
 var radio2=document.getElementById('ROr1');
 if(true==radio1.checked)
 {
    radio2.checked=false;
 }
}
function SetOr1()
{
 var radio1=document.getElementById('RAnd1');
 var radio2=document.getElementById('ROr1');
 if(true==radio2.checked)
 {
    radio1.checked=false;
 }
}
		//2
function SetAnd2()
{
 var radio1=document.getElementById('RAnd2');
 var radio2=document.getElementById('ROr2');
 if(true==radio1.checked)
 {
    radio2.checked=false;
 }
}
function SetOr2()
{
 var radio1=document.getElementById('RAnd2');
 var radio2=document.getElementById('ROr2');
 if(true==radio2.checked)
 {
    radio1.checked=false;
 }
}
		//3
function SetAnd3()
{
 var radio1=document.getElementById('RAnd3');
 var radio2=document.getElementById('ROr3');
 if(true==radio1.checked)
 {
    radio2.checked=false;
 }
}
function SetOr3()
{
 var radio1=document.getElementById('RAnd3');
 var radio2=document.getElementById('ROr3');
 if(true==radio2.checked)
 {
    radio1.checked=false;
 }
}
		//4
function SetAnd4()
{
 var radio1=document.getElementById('RAnd4');
 var radio2=document.getElementById('ROr4');
 if(true==radio1.checked)
 {
    radio2.checked=false;
 }
}
function SetOr4()
{
 var radio1=document.getElementById('RAnd4');
 var radio2=document.getElementById('ROr4');
 if(true==radio2.checked)
 {
    radio1.checked=false;
 }
}
function openCity(evt, cityName) 
{
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
</script>
     
</body>
</html>