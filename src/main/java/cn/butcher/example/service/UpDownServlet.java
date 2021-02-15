package cn.butcher.example.service;

import cn.butcher.example.dao.DaoUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: butcher
 * @Date: 2021/02/05/17:34
 */
@WebServlet("/upDown")
public class UpDownServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String  userid = (String)session.getAttribute("userid");
        String type = request.getParameter("type");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date());
        String day = sdf2.format(new Date());
//                    if (Integer.parseInt(time.substring(11, 13))<8){

        if (type!=null){
            if ("up".equals(type)){
//                        上班
                DaoUser.addClockStart(time,userid,day);
                response.sendRedirect(request.getContextPath()+"/page/clockin.html");
//                request.getRequestDispatcher("/page/clockin.html").forward(request,response);
            }else if ("down".equals(type)){
//                        下班
                DaoUser.addClockEnd(time,userid,day);
//                request.getRequestDispatcher("/page/clockin.html").forward(request,response);
                response.sendRedirect(request.getContextPath()+"/page/clockin.html");
            }
        } else {
//                        上班
            DaoUser.addClockStart(time,userid,day);
            response.sendRedirect(request.getContextPath()+"/page/clockin.html");
//            request.getRequestDispatcher("/page/clockin.html").forward(request,response);
        }
    }
}
