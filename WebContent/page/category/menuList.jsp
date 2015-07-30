<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.jialin.entity.Category"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String selectList =(String) request.getAttribute("selectList");%>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script>
       $(document).ready(function () {
    	 
           var objName = $("#txtModuleName");
           var objBtn = $("#SearchBtn1");
           var selectValue = $("#ddlModuleType").val();
           if(selectValue="")
           alert(selectValue);
       })
       function ddlModuleTypeChange()
       {
    	   
           var objName = $("#txtModuleName");
           var objBtn = $("#SearchBtn");
           var selectValue = $("#ddlModuleType").val();
           //if (selectValue == "2") {
           //    objName.attr("readonly", true);
           //    objBtn.attr("unable", true);
           //}
       }
   </script>
</head>
<body>

 <div class="pageContent"> 
    <form > 
     
    <div class="pageFormContent" layoutH="56">
  <ul class="tree expand">
  <%=selectList %>
					 <!--  <li><a href="javascript:"  onclick="$.bringBack({id:'1', districtName:'远程监控'})">远程监控(YuanChengJK)</a>
					  	<ul>
					  		<li><a href="javascript:"  onclick="$.bringBack({id:'4', districtName:'系统管理'})">系统管理(sysManage)</a></li>
					  		<li><a href="javascript:"  onclick="$.bringBack({id:'5', districtName:'基础设置'})">基础设置(baseSetting)</a></li>
					  		<li><a href="javascript:"  onclick="$.bringBack({id:'7', districtName:'数据检测'})">数据检测(DataCheck)</a></li>
							<li><a href="javascript:"  onclick="$.bringBack({id:'8', districtName:'数据分析'})">数据分析(DataAnalsis)</a></li>
							<li><a href="javascript:"  onclick="$.bringBack({id:'9', districtName:'统计报表'})">统计报表(Report)</a></li>
							<li><a href="javascript:"  onclick="$.bringBack({id:'10', districtName:'系统预警'})">系统预警(SysWarn)</a></li>
							<li><a href="javascript:"  onclick="$.bringBack({id:'11', districtName:'全辖区大数据分析'})">全辖区大数据分析(bigDataAnalysis)</a>
								<ul>
									<li><a href="javascript:"  onclick="$.bringBack({id:'53', districtName:'预警列表'})">预警列表(sysWarnList)</a>
										<ul>
											<li><a href="javascript:"  onclick="$.bringBack({id:'53', districtName:'预警列表'})">预警列表(sysWarnList)</a></li>
										</ul>
									</li>
									
								</ul>
							</li>
							<li><a href="javascript:"  onclick="$.bringBack({id:'74', districtName:'大数据分析'})">大数据分析(bigDataAnalysiss)</a></li>
							<li><a href="javascript:"  onclick="$.bringBack({id:'12', districtName:'预警短信管理'})">预警短信管理(MessageWarn)</a></li>
							<li><a href="javascript:"  onclick="$.bringBack({id:'13', districtName:'信息平台'})">信息平台(infoPlatform)</a></li>
							<li><a href="javascript:"  onclick="$.bringBack({id:'14', districtName:'出勤管理'})">出勤管理(attendanceMgr)</a></li>
						</ul>
					</li> -->
		</ul>
			 
		</div>
		<div class="formBar">
			<ul>
				 
				 
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
    
    </form>
         </div>


</body>
</html>