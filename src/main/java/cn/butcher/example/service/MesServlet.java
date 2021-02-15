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
 * @Date: 2021/01/30/19:34
 */
@WebServlet("/html/mes")
public class MesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        List<Student> students = Dao.getStudentAsPage(page,limit);
        ObjectMapper objectMapper = new ObjectMapper();
        String stus = objectMapper.writeValueAsString(students);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(stus);
        out.flush();
        out.close();

    }
}
