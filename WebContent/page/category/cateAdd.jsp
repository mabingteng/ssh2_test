<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.jialin.entity.Category"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%= basePath %>" />
<title></title>
</head>
<body>
   <div class="pageContent">
   <%	Category c = (Category)request.getAttribute("cate");
   if(c==null) { %>
	<form method="post" action="cate/cAdd_cateList" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>菜单名称：</label>
				<input name="cate.Name" type="text"  size="30" class="required" maxlength="20"   />
			</p>
		
           
            <p>
				<label>菜单编码：</label>
				<input name="cate.Code" class=" required" type="text" size="30"  />
			</p>
           
            <p>
				<label>访问路径：</label>
				<input name="cate.ActionUrl"   type="text" size="30" maxlength="40"  class="required"/>
			</p>
            <p>
				<label>显示序列：</label>
				<input name="cate.Sort"   type="text" size="30" maxlength="40"  class="required"/>
			</p>
			<p>
				<label>父级菜单：</label>
				<input type="hidden" name="orgLookup.id" value="${orgLookup.id}"/>
				<input type="text" class="required" name="orgLookup.districtName" value="" size="26"  lookupGroup="orgLookup" />
				<a class="btnLook" href="cate/cSelectList_menuList" lookupGroup="orgLookup">选择单位</a>		
			</p> 
			
            <p>
				<label >菜单状态：</label>
				<label  style="width:80px;"> <input required="required" type="radio" name="cate.Status" value="ON" />启用 </label>
		         <label  style="width:85px;"><input type="radio" name="cate.Status" value="OFF" />不启用 </label>
			</p>		
			 <p>
				<label >查看级别：</label>
				<label  style="width:60px;"> <input required="required" type="radio" name="cate.Check_Level" value="1" />系统 </label>
		        <label  style="width:60px;"><input type="radio" name="cate.Check_Level" value="2" />管理员 </label>
		        <label  style="width:60px;"> <input type="radio" name="cate.Check_Level" value="3" />用户 </label>
		         
			</p>	 
			<p>
				<label>备注信息：</label>
				<textarea name="cate.des" cols="28" rows="2"  ></textarea>
			</p>
			
			 
		</div>
		<div class="formBar">
			<ul>
				 
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
	<%} %>
	<%-- <%} else if(c!=null) {%>
	<form method="post" action="user/uUpdateData_ajaxDone" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>用户姓名：</label>
				<input name="user.name" type="text"  size="30" class="required" maxlength="20" value="<%=  %>"  />
			</p>
			<input type="hidden" name ="user.id" value = "<%= %>" />
			<input type="hidden" name ="user.password" value = "<%=  %>" />
			<input type="hidden" name ="user.deleteMark" value = "<%	  %>" />
			<input type="hidden" name ="user.accountName" value = "<%	  %>" />
			<p>
				<label>登陆账号：</label>
				<input name="user.accountName" class="required disabled" disabled="disabled" size="30" type="text" maxlength="20" value="<%= u.getAccountName() %>"/>
			</p>
            
            <p>
                
				<label>用户性别：</label>      
				<%  String mFlag=" checked=\"checked\" ";
				    String  fFlag =" checked=\"checked\" ";
					if(u.getSex().equals("男"))
					    fFlag = "";
					else if(u.getSex().equals("女"))
					    mFlag = "";
					    %>        
				<label  style="width:50px;"> <input type="radio" name="user.sex" value="男" <%= mFlag %> required="required" />男  </label>              
		        <label style="width:50px;"> <input type="radio" name="user.sex" value="女" <%=fFlag  %> />女  </label>              
                  
			</p>
            <p>
				<label>联系电话：</label>
				<input name="user.tel" class=" required" type="text" value="<%= u.getTel() %>" size="30"  />
			</p>
           
            <p>
				<label>E-Mail：</label>
				<input name="user.email"   type="text" size="30" maxlength="40"  value="<%= u.getEmail() %>"  class="required"/>
			</p>
            
			<p>
				<label>所属单位：</label>
				<input type="hidden" name="orgLookup.id" value="${orgLookup.id}"/>
				<input type="text" class="required" name="orgLookup.unitName" value="" size="26"  lookupGroup="orgLookup" />
				<a class="btnLook" href="/TUnitManage/TUnitSelect.aspx" lookupGroup="orgLookup">选择单位</a>		
			</p>
			
            <p>
            <%  String ON=" checked=\"checked\" ";
				    String  OFF =" checked=\"checked\" ";
					if(u.getStatus().equals("OFF"))
					    ON = "";
					else if(u.getStatus().equals("ON"))
					    OFF = "";
					    %>        
				<label >是否启用：</label>
				<label  style="width:80px;"> <input required="required" type="radio" name="user.status" value="ON" <%=ON %> />启用 </label>
		         <label  style="width:85px;"><input type="radio" name="user.status" value="OFF" <%=OFF %> />不启用 </label>
			</p>		
			 <p>
			  <%  String O1=" checked=\"checked\" ";
				  String  O2 =" checked=\"checked\" ";
				  String  O3 =" checked=\"checked\" ";
					if(u.getUserType().equals("系统管理员")){
					    O2 = "";O3 = "";
					    }
					else if(u.getUserType().equals("管理员")){
					    O1 = ""; O3 = "";
					    }
					else if(u.getUserType().equals("用户")){
					    O1="";O2="";
					}
					    %>        
				<label >用户类别：</label>
				<label  style="width:60px;"> <input required="required" type="radio" name="user.userType" value="系统管理员" <%=O1 %> />系统 </label>
		        <label  style="width:60px;"><input type="radio" name="user.userType" value="管理员" <%=O2 %> />管理员 </label>
		        <label  style="width:60px;"> <input type="radio" name="user.userType" value="用户" <%=O3 %> />用户 </label>
		         
			</p>	 
			<p>
				<label>备注信息：</label>
				<textarea name="user.des" cols="28" rows="2"  value="<%=u.getDes()  %>"  ></textarea>
			</p>
			
			 
		</div>
		<div class="formBar">
			<ul>
				 
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
			<%} %> --%>
</div>
</body>
</html>