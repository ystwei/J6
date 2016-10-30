<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/30
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.weikun.service.IUserService" %>
<%@ page import="com.weikun.service.UserServiceImpl" %>
<%@ page import="com.weikun.vo.BBSUser" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String username=request.getParameter("username");
        String pwd=request.getParameter("pwd");
        BBSUser user=new BBSUser();
        user.setUsename(username);
        user.setPwd(pwd);
        IUserService service=new UserServiceImpl();
        if(service.login(user)){//true:登录成功
            request.setAttribute("username",username);
    %>
            <jsp:forward page="success.jsp"/>
    <%

        }else{//登录失败
            request.setAttribute("error","登录失败");

    %>
            <jsp:forward page="index.jsp"/>
    <%
        }
    %>
</body>
</html>
