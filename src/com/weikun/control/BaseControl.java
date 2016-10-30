package com.weikun.control;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/30.
 */
@WebServlet(name = "BaseControl",urlPatterns = {"*.do"},
        initParams = {
                @WebInitParam(name="show",value="/show.jsp"),
                @WebInitParam(name="show1",value="/show1.jsp")

        })
public class BaseControl extends HttpServlet {
    private Map<String,String> map=new HashMap<>();
    public BaseControl(){//1

    }

    @Override
    public void destroy() {//4
        super.destroy();
    }

    @Override         //config
    public void init(ServletConfig config) throws ServletException {//2
        String show=config.getInitParameter("show");
        map.put("show",show);
        String show1=config.getInitParameter("show1");
        map.put("show1",show1);
    }
    //3
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    //3
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action= request.getParameter("action");
        HttpSession session=request.getSession();//session
        ServletContext ctx=request.getServletContext();

        String url="";
        if(action.equals("show")){
            url=map.get("show");
        }

        if(action.equals("show1")){
            url=map.get("show1");
        }
        RequestDispatcher dispatcher=request.getRequestDispatcher(url);


        dispatcher.forward(request,response);

        //服务
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html");
//
//        PrintWriter out=response.getWriter();
//        out.println("<b>我很Handsome</b>");
//
//        out.flush();
//        out.close();
    }
}
