package cn.tedu.controller;

import cn.tedu.dao.HeroDao;
import cn.tedu.entity.Hero;
import cn.tedu.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "AddServlet",urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String type=request.getParameter("type");
        String money=request.getParameter("money");
        //把接收到的参数封装到实体类中
        Hero hero = new Hero(0,name,type,Integer.parseInt(money));
        //创建Dao 在dao里面处理数据库相关代码
        HeroDao dao=new HeroDao();
        dao.add(hero);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter pw=response.getWriter();
        pw.println("添加完成！");
        pw.close();

    }
}
