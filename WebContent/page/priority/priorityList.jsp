<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.jialin.entity.Category"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base >
<script>
    $(document).ready(function () {   
       var na = $("a[rel='priority_page']").first();
      $("#wprel").loadUrl(na.attr("href"), null, null);
    });
</script>  
</head>
<body>

<body>
       
        <form id="pagerForm" method="post"  action="/WarningParameter/WarningParameter.aspx">
        <input type="hidden" name="status" value="${param.status}" />
        <input type="hidden" name="keywords" value="${param.keywords}" />
        <input type="hidden" name="pageNum" value="1" />
        <input type="hidden" name="numPerPage" value="20" />      
       
    </form>


<div class="pageContent" >
 
	 <div id="AreaCheckTree" layouth="100" style="float: left; display: block; margin: 10px; overflow: auto; width: 15%; overflow: auto; border: solid 1px #CCC; line-height: 21px; background: #FFF;">
 

            <ul id="areatreeul" class="tree  treeFolder">

               
              
                   
                         <li> <a href="priority/pList_priority?type=1" target="ajax" rel="priority_page">系统管理员</a></li>
				    	<li> <a href="priority/pList_priority?type=2" target="ajax" rel="priority_page">普通管理员</a></li>
						<li> <a href="priority/pList_priority?type=3" target="ajax" rel="priority_page">一般用户</a></li>       
                        
                  
             
               
            </ul>


              
        </div> 
        <div class="unitBox" style="margin-left: 200px;">
                <div id="wprel" class="unitBox" >
                </div>
            </div>
   		<!-- <div    style="float: left; width: 70%" layoutH="100" id="wprel" >
	 
    	</div> -->

</div>
</body> 

</body>
</html>