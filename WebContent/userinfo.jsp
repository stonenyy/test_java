<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="net.ttny.web.java.test.UserInfo" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>userinfo</title>
</head>
<%
if (session.getAttribute("USER_INFO")==null) {
	response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
	response.setHeader("Location","./LoginForm");
}
%>
<body>

<%=session.getAttribute("USER_INFO")%>
<%
UserInfo userinfo1 = new UserInfo();
userinfo1.setUserId(8);
System.out.println(userinfo1.getUserId());
userinfo1.exec1((int)userinfo1.getUserId());
System.out.println(userinfo1.getUsername());
%>

</body>
</html>
