package com.weikun.control;

import com.weikun.service.IUserService;
import com.weikun.service.UserServiceImpl;
import com.weikun.vo.BBSUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/30.
 */
@WebServlet(name="userControl",urlPatterns = {"/user"},
initParams = {
        @WebInitParam(name="success",value="/success.jsp"),
        @WebInitParam(name="index",value="/index.jsp")


})
public class UserControl extends HttpServlet{
    private IUserService service=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String pwd=req.getParameter("pwd");
        BBSUser user=new BBSUser();

        user.setUsename(username);
        user.setPwd(pwd);
        RequestDispatcher dispatcher=null;
        if(service.login(user)){
            req.setAttribute("username",username);
            dispatcher=req.getRequestDispatcher(map.get("success"));

        }else{

            req.setAttribute("error","你是非法登录！");
            dispatcher=req.getRequestDispatcher(map.get("index"));
        }

        dispatcher.forward(req,resp);


    }

    @Override
    public void destroy() {
        super.destroy();
    }
    private Map<String,String> map=new HashMap<>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        map.put("index",config.getInitParameter("index"))  ;
        map.put("success",config.getInitParameter("success"))  ;
    }
}
