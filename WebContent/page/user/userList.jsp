<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.jialin.entity.User"%>
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
        <form onsubmit="return navTabSearch(this);" action="user/uExecute_userList" method="post" id="mbtsearchForm" rel="pageForm" runat="server">
            <div class="searchBar">

                <table class="searchContent">
                    <tr>
                        <td>姓名关键字：<input type="text" name="user.name"  runat="server" />
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
                <li><a class="add" href="page/user/userAdd.jsp" target="navTab"><span>添加</span></a></li>
                <li><a class="edit" href="user/uUpdate_userAdd?user.id={SubdeviceID} "target="navTab"><span>修改</span></a></li>
                <li><a class="delete" href="user/uDel_userList?user.id={SubdeviceID}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
                <li><a class="icon" href="user/uRefresh_userList" target="ajaxTodo"><span>刷新</span></a></li>

            </ul>
        </div>
         <asp:Repeater ID="mbtrptUserList" runat="server">
            <HeaderTemplate>
                <table class="table" layouth="113" width="100%">
                    <thead>
                        <tr>
                            <th width="3%">序号</th>
                            <th  width="6%">姓名</th>
                            <th  width="4%" >登录名</th>
                            <th  width="3%">性别</th>
                            <th  width="13%" >邮箱</th> 
                            <th  width="13%" >电话</th> 
                             <th  width="4%" >状态</th> 
                            <th  width="10%"">用户类型</th>  
                            <th  width="10%"">备注</th>  
                         </tr>                         
                    </thead>
             <tbody>
            </HeaderTemplate>
           
            <ItemTemplate>
              <%     int currentindex=0;
		             List<User> list1 = (List<User>)request.getAttribute("ulist"); 
		             
				     if(list1!=null)				     
					 for(User p : list1)
					{  
						 currentindex++;				
						 
					%>
					
          	  <tr target="SubdeviceID" rel='<%= p.getId() %>'>
          	 
              <td style="text-align: center;"><%=currentindex %>      </td>             
              <td style="text-align: center;"> <%=p.getName() %>      </td>
              <td style="text-align: center;"><%=p.getAccountName() %></td>
              <td style="text-align: center;"><%=p.getSex() %>        </td>
              <td style="text-align: center;"><%=p.getEmail()  %>     </td>
              <td style="text-align: center;"><%=p.getTel() %>        </td>
              <td style="text-align: center;"><%=p.getStatus() %>     </td>
              <td style="text-align: center;"><%=p.getUserType() %>   </td>
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