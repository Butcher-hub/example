package cn.butcher.example.service;

import cn.butcher.example.bean.Order;
import cn.butcher.example.dao.Dao;
import cn.butcher.example.dao.DaoOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: butcher
 * @Date: 2021/02/05/12:13
 */
@WebServlet("/page/getOrder")
public class getOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        List<Order> orderAsPage = DaoOrder.getOrderAsPage(page, limit);
        ObjectMapper obj = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", DaoOrder.getCount());
        map.put("data",orderAsPage);
        String s = obj.writeValueAsString(map);
        System.out.println(s);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(s);
    }
}
