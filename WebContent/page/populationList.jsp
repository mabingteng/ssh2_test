<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.jialin.entity.Population"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <form onsubmit="return navTabSearch(this);" action="p/execute_populationList" method="post" id="searchForm" rel="pageForm" runat="server">
            <div class="searchBar">

                <table class="searchContent">
                    <tr>
                        <td>姓名关键字：<input type="text" name="population.name" id="population.name" runat="server" />
                        </td>
                        <td>身份证号码关键字：<input type="text" name="population.Id_num" id="population.Id_num" runat="server" />
                        </td>
                          <td>房号关键字：<input type="text" name="population.Room_num" id="population.Room_num" runat="server" />
                        <!-- </td>
                          <td>车牌关键字：<input type="text" name="population" id="SubtxtCode4" runat="server" />
                        </td> -->
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
                <li><a class="add" href="p/PAdd_populationAdd" target="navTab"><span>添加</span></a></li>
                <li><a class="edit" href="p/pUpdate_populationEdit?population.id={SubdeviceID} "target="navTab"><span>修改</span></a></li>
                <li><a class="delete" href="p/pDel_populationList?population.id={SubdeviceID}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
                <li><a class="icon" href="p/pRefresh_populationList" target="ajaxTodo"><span>刷新</span></a></li>

            </ul>
        </div>
         <asp:Repeater ID="rptUserList" runat="server">
            <HeaderTemplate>
                <table class="table" layouth="113" width="100%">
                    <thead>
                        <tr>
                            <th width="3%">序号</th>
                            <th  width="6%">姓名</th>
                            <th  width="4%" >房间号</th>
                            <th  width="3%">性别</th>
                            <th  width="10%" >身份证号</th> 
                            <th  width="10%"">地址</th>  
                         </tr>                         
                    </thead>
             <tbody>
            </HeaderTemplate>
            <ItemTemplate>
              <%     int currentindex=0;
		             List<Population> list1 = (List<Population>)request.getAttribute("perlist"); 
				     if(list1!=null)				     
					 for(Population p : list1)
					{  
						 currentindex++;				
						 
					%>
          	  <tr target="SubdeviceID" rel='<%= p.getId() %>'>
          	 
              <td><%=currentindex %>    </td>             
              <td><%=p.getName() %>     </td>
              <td ><%=p.getRoom_num() %></td>
              <td ><%=p.getSex() %>     </td>
              <td ><%=p.getId_num()  %> </td>
              <td ><%=p.getAddress() %> </td>
             
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