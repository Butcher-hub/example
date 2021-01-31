package cn.butcher.example.service;

import cn.butcher.example.bean.Student;
import cn.butcher.example.dao.Dao;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author: butcher
 * @Date: 2021/01/31/12:22
 */
@WebServlet("/html/query")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        System.out.println(name);
        List<Student> students = Dao.queryByName(name);
        ObjectMapper objectMapper = new ObjectMapper();
        String sjson = objectMapper.writeValueAsString(students);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(sjson);
        out.flush();
        out.close();
    }
}
