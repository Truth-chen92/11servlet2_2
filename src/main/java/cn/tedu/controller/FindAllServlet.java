package cn.tedu.controller;

import cn.tedu.dao.HeroDao;
import cn.tedu.entity.Hero;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FindAllServlet", urlPatterns = "/findall")
public class FindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        创建Dao并调用findAll方法
        HeroDao dao = new HeroDao();
//        因为查询到的内容是多个英雄的信息，每个英雄的信息有好几个数据
//        把数据封装到Hero对象中，查询到几个英雄的信息就有几个英雄对象
//        把查询到的多个英雄对象装进集合 返回
        List<Hero> list = dao.findAll();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print("<table border='4'>");
        pw.print("<caption>英雄列表</caption>");
        pw.print("<tr><th>id</th><th>名字</th><th>类型</th><th>价格</th><th>操作</th></tr>");
        for (Hero h : list) {
            pw.print("<tr>");
            pw.print("<td>" + h.getId() + "</td>");
            pw.print("<td>" + h.getName() + "</td>");
            pw.print("<td>" + h.getType() + "</td>");
            pw.print("<td>" + h.getMoney() + "</td>");
            pw.print("<td><a href='delete?id=" + h.getId() + "'>删除</a></td>");
            pw.print("</tr>");
        }
        pw.print("</table>");
        pw.close();
    }
}
