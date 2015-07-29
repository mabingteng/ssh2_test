<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.jialin.entity.Population"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Population population = (Population)request.getAttribute("population");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<div class="pageContent">
	<form id="SubForm" name="SubForm" method="post" action="p/Update_ajaxDone" class="pageForm required-validate" onsubmit=" return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layouth="56">
           <p>
				<label>序号：</label>
				 <input type="text" id="population.id"   class="required " name="population.id" size="15" value="<%=population.getId() %>"/>  
			</p>

            <p>
             <label>姓名：</label>
               <input type="text" class="required " name="population.name" size="15" value="<%=population.getName() %>"/>  
            </p>
            
            
			<p>
				<label>房间号：</label>
				<input type="text" class="required " name="population.room_num" size="10" value="<%=population.getRoom_num() %>"/>  
			</p>

			<p>
				<label>性别：</label>
				<input type="text" class="required " name="population.sex" size="10" value="<%=population.getSex() %>"/>  
			</p>

            <p>
				<label>身份证号：</label>
				<input type="text" class="required " name="population.id_num" size="20" value="<%=population.getId_num() %>"/>  
			</p>           

             <p>
				<label>地址：</label>                
                <textarea  name="population.address" cols="32" rows="2" maxlength="256" ><%=population.getAddress() %>></textarea>
			    
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