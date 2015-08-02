<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.jialin.entity.Category"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base>
<title></title>
</head>
<%
    String userType = (String) request.getAttribute("userType");
			String htmlstr = (String) request.getAttribute("htmlstr");
%>
<body>
	<div onscroll="auto">
		<input type="hidden" name="RID" value="<%=17%>" />
		<div onscroll="auto">
			<input type="hidden" name="RID" value="17" />
			<h2 class="contentTitle">
				当前角色：<%=userType%></h2>
			<div class="pageFormContent" layouth="126">
				<%=htmlstr%>
				<!-- <fieldset>
					<legend>
						系统管理<input type="checkbox" name="g4" class="checkboxCtrl"
							value="sysManage" group="c4" />
					</legend>
					<dl class="nowrap">
						<dd style="width: 800px;">
							<label><input type="checkbox" name="c4" value="menuUser" />用户管理</label>
							<label><input type="checkbox" name="c4" value="page_role" />角色管理</label>
							<label><input type="checkbox" name="c4" value="page_roleUser" />角色分配</label>
							<label><input type="checkbox" name="c4" value="page_rolePermit" />角色权限</label>
							<label><input type="checkbox" name="c4" value="menuManage" />菜单管理</label>
							<label><input type="checkbox" name="c4" value="page_log" />日志管理</label>
							<label><input type="checkbox" name="c4" value="page_WarnPara" />系统参数</label>
						</dd>
					</dl>
				</fieldset>
				<fieldset>
					<legend>
						出勤管理<input type="checkbox" name="g14" checked="true"
							class="checkboxCtrl" value="attendanceMgr" group="c14" />
					</legend>
					<dl class="nowrap">
						<dd style="width: 800px;">
							<label><input type="checkbox" checked="true" name="c14"
								value="page_signlist" />签到列表</label>
						</dd>
					</dl>
				</fieldset> -->
			</div>
			<div class="formBar">
				<label style="float: left"> <input type="checkbox"
					id="btnCheckAll" />全选
				</label>
				<ul>
					<li>
						<div class="button">
							<div class="buttonContent">
								<button type="button" class="checkboxCtrl" id="btnCheckReverse">反选</button>
							</div>
						</div>
					</li>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button onclick="mbtMenuID()" type="submit" id="btnSubmit">提交</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
			$("input[name='g4']").click(function ( ) {

			});
			function mbtMenuID ( ) {
				var s = $(":checked[name^='c']");
				var ids = "";
				if (s.size() != 0) {
					$(":checked[name^='c']").each(function ( index , e ) {
						var s1 = e.value;

						ids+=s1+"_";
					});
					$("#mbtstrList").val(ids);
					
					$.post("priority/pSetMenus_priority", {"ids" : ids}, function ( result ) {
					
						alertMsg.info("保存成功！");
						location.href = "login";
						///page/admin.jsp
						//  location.reload();
					},"text");
				}

			}
		</script>
		<input type="hidden" name="strList" id="mbtstrList" />
</body>

</html>