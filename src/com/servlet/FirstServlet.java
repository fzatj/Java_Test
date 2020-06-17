package com.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "FirstServlet")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        HttpServletRequest request =  (HttpServletRequest)  req;
        //获取 servletpath
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        System.out.println(getServletContext().getContextPath());
        System.out.println(getServletContext().getAttribute("username"));
        ServletContext servletContext = getServletContext();
        try{

            //获取servletconfig对象
            ServletConfig config =  getServletConfig();
            String driver =  config.getInitParameter("driver");
            String url = config.getInitParameter("url");
            String user = config.getInitParameter("user");
            String pass = config.getInitParameter("passwd");

            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url,user,pass);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from tmp_login ");

            req.setCharacterEncoding("GBK");
            res.setContentType("text/html;charset=GBK");

            PrintStream out = new PrintStream(res.getOutputStream());
            out.println("<html>");
            out.println("<head>");
            out.println("<title>servlet测试</title>");
            out.println("</head>");
            out.println("<body>");

            while (rs.next()) {


                out.println("<tr>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");


            }

            out.println("</body>");
            out.println("</html>");
        }
        catch (Exception e){

            e.printStackTrace();
        }



        //设置解码方式
        /*req.setCharacterEncoding("GBK");
        res.setContentType("text/html;charset=GBK");
        //获取productname的请求参数值
        String ProductName = req.getParameter("productname");
        String ProductPasswd = req.getParameter("productpasswd");
        PrintStream out = new PrintStream(res.getOutputStream());
        out.println("<html>");
        out.println("<head>");
        out.println("<title>servlet测试</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("产品名称：" + ProductName);
        out.println("产品密码：" + ProductPasswd);
        out.println("</body>");
        out.println("</html>");*/



    }
}
