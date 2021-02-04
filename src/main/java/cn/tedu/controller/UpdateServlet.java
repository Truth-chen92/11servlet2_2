package cn.tedu.controller;

import cn.tedu.dao.HeroDao;
import cn.tedu.entity.Hero;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet",urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String type=request.getParameter("type");
        String money=request.getParameter("money");
        Hero hero=new Hero(Integer.parseInt(id),name,type,Integer.parseInt(money));
        HeroDao dao=new HeroDao();
        dao.update(hero);
        response.sendRedirect("/findall");

    }
}
