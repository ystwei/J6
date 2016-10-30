<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/30
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript">
        function ok(){
            var u=document.getElementById("username");
            var p=document.getElementById("pwd");
            if(u.value.length<0 || u.value==""){
                alert("用户名你不能为空");
                return;
            }
            if(p.value.length<0 || p.value==""){
                alert("密码不能为空");
                return;
            }
            document.all.form1.submit();
        }

    </script>
      <style type="text/css">
          .t1{
              color:red;
          }


      </style>
  </head>
  <body>
    <%
            if(request.getAttribute("error")!=null){
                out.println("<h1 class='t1'>");
         %>
        <%=request.getAttribute("error").toString()%>

        <%
                out.println("<h1>");
            }


    %>
    <form id="form1" name="form1" action="user" method="post">
        用户名：<input type="text" name="username" id="username"><br/>
        密码：<input type="text" name="pwd" id="pwd"><br/>
        <input type="button" value="提交" onclick="ok()">

    </form>
  </body>
</html>
