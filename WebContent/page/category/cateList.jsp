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
<title>常住人口界面</title>
</head>
<body>

<form id="pagerForm" method="post" action="">
        <input type="hidden" name="status" value="${param.status}" />
        <input type="hidden" name="keywords" value="${param.keywords}" />
        <input type="hidden" name="pageNum" value="1" />
        <input type="hidden" name="numPerPage" value="20" />     
</form>
 <div class="pageHeader">
        <form onsubmit="return navTabSearch(this);" action="cate/cExecute_cateList" method="post" id="mbtsearchForm" rel="pageForm" runat="server">
            <div class="searchBar">

                <table class="searchContent">
                    <tr>
                        <td>菜单名称关键字：<input type="text" name="cate.name"  runat="server" />
                        </td>
                       
                         <td style="text-align:right">
                            <div class="buttonActive">
                                <div class="buttonContent">
                                    <button type="submit">查询</button>
                                </div>
                            </div>

                        </td>
                    </tr>
                </table>

            </div>
        </form>
    </div>
    <div class="pageContent">
        <div class="panelBar">
            <ul class="toolBar">
                <li><a class="add" href="page/category/cateAdd.jsp" target="navTab"><span>添加</span></a></li>
                <li><a class="edit" href="cate/cUpdate_cateAdd?cate.id={SubdeviceID} "target="navTab"><span>修改</span></a></li>
                <li><a class="delete" href="cate/cDel_cateList?cate.id={SubdeviceID}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
                <li><a class="icon" href="cate/cRefresh_cateList" target="ajaxTodo"><span>刷新</span></a></li>

            </ul>
        </div>
         <asp:Repeater ID="mbtrpCateList" runat="server">
            <HeaderTemplate>
                <table class="table" layouth="113" width="100%">
                    <thead>
                        <tr>
                            <th width="3%">序号</th>
                            <th  width="6%">菜单名称</th>
                            <th  width="4%" >菜单状态</th>
                           
                            <th  width="13%" >菜单编码</th> 
                            <th  width="13%" >访问路径</th> 
                             <th  width="4%" >查看级别</th> 
                            <th  width="10%"">父级菜单</th>  
                            <th  width="10%"">备注</th>  
                         </tr>                         
                    </thead>
             <tbody>
            </HeaderTemplate>
           
            <ItemTemplate>
              <%     int currentindex=0;
		             List<Category> list1 = (List<Category>)request.getAttribute("clist"); 
		             
				     if(list1!=null)				     
					 for(Category p : list1)
					{  
						 currentindex++;				
						 
					%>
					
          	  <tr target="SubdeviceID" rel='<%= p.getId() %>'>
          	 
              <td style="text-align: center;"><%=currentindex %>      </td>             
              <td style="text-align: center;"> <%=p.getName() %>      </td>
              <td style="text-align: center;"><%=p.getStatus() %></td>
             
              <td style="text-align: center;"><%=p.getCode()  %>     </td>
              <td style="text-align: center;"><%=p.getActionUrl() %>        </td>
              <% String type ="";
              if(p.getCheck_Level()==1)
        	  	type = "系统";
              if(p.getCheck_Level()==2)
        	  	type ="管理员";
        	  if(p.getCheck_Level()==3)
        	      type = "用户";
              
        	  %>
              <td style="text-align: center;"><%=type %>     </td>
              <td style="text-align: center;"><%=p.getParentID() %>   </td>
              <td style="text-align: center;"><%=p.getDes() %>   </td>
             
               </tr>
              <%} %>          	
         	
            </ItemTemplate>
            <FooterTemplate>
            </tbody> 
            </table>
            </FooterTemplate>
        </asp:Repeater>
        <div class="panelBar">
            <div class="pages">
                <span>显示</span>

                <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})" id="combox2">

                    <option value="20">20</option>
                    <option value="30">30</option>
                    <option value="50">50</option>
                    <option value="100">100</option>
                </select>
                <span>条，共 <%=5%>条</span>
            </div>

            <div id="pagination" runat="server" class="pagination" targettype="navTab" totalcount="200" numperpage="20" pagenumshown="10" currentpage="1"></div>

        </div>
    </div>

</body>
</html>