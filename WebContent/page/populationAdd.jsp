<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.jialin.entity.Population"%>

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
	<form  method="post" action="p/addPerson_ajaxDone" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layouth="56">
          
          
			<p>
				<label>姓名：</label>
				<input name="population.name" class=" required" type="text" size="20"  />
                    
			</p>
          
            <p>
				<label>房间号：</label>
				<input name="population.room_num" class=" required" type="text" size="15"  />
			</p>
            
            <p>
				<label>性别：</label>
				<input name="population.sex"   type="text" size="15"  class="required"/>
			</p>
			
           <p>
				<label>身份证号：</label>
				<input name="population.id_num" class=" required" type="text" size="25" />
			</p>
        
             <p>
				<label>地址：</label>
               
				<textarea  name="population.address" cols="32" rows="2" maxlength="256" ></textarea>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
                    <div class="buttonContent">
                        <button type="submit">保存</button>
                    </div>
				    </div>
				</li>
				<li>
					<div class="button">
                        <div class="buttonContent">
                            <button type="button" class="close">取消</button>
                        </div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
</body>
</html>