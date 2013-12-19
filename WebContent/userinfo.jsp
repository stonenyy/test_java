<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="net.ttny.web.java.test.UserInfo" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<html>
<head>
    <title>userinfo</title>
</head>
<%
if (session.getAttribute("USER_ID")==null) {
	response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
	response.setHeader("Location","./LoginForm");
}
%>
<body>

<%=session.getAttribute("USER_ID")%>
<%
UserInfo userinfo = new UserInfo();
userinfo.execute(session.getAttribute("USER_ID"));
%>

</body>
</html>
