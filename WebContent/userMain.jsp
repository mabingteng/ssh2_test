<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>

<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");

	
	function addUser()
	{
		var myform=document.forms[0];
		myform.action="user/addUser_success";
		myform.method="post";
		myform.submit();
	}
	
	function modifyUser()
	{
		var myform=document.forms[0];
		myform.action="user/modifyUser_success";
		myform.method="post";
		myform.submit();
	}
	
	function deleteUser()
	{
		var myform=document.forms[0];
		myform.action="user/deleteUser_success";
		myform.method="post";
		myform.submit();
	}
	
	

</script>
</head>
<body>
<form id="myform1" >
	�û�����<input type="text" name="user.name" /><br />
	���룺<input type="text" name="user.password" /><br />
	���䣺<input type="text" name="user.age" /><br />
	<input type="button" name="btnadd" onclick="addUser()" value="����" />
	<input type="button" name="btnmodify" onclick="modifyUser()" value="�޸�" />
	<input type="button" name="btndel" onclick="deleteUser()" value="ɾ��"  />
 </form>
</body>
</html>