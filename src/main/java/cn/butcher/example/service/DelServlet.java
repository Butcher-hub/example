package cn.butcher.example.service;

import cn.butcher.example.dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: butcher
 * @Date: 2021/01/31/14:05
 */
@WebServlet("/html/del")
public class DelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        Dao.del(id);
        response.setContentType("text/html;charset=UTF-8");
        response.sendRedirect(request.getContextPath()+"/html/list.html");
    }
}
