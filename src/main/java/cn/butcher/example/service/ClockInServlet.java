package cn.butcher.example.service;

import cn.butcher.example.bean.User;
import cn.butcher.example.dao.DaoUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: butcher
 * @Date: 2021/02/03/20:16
 */
@WebServlet("/clock")
public class ClockInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Cookie[] cookies = request.getCookies();
        String userid = "";
        String userpassword = "";
        User user =null;
        if (cookies!=null){
            for (Cookie c:cookies
                 ) {
                if (c.getName().equals("userid")){
                    user = DaoUser.getUser(Integer.parseInt(c.getValue()));
                    userid = c.getValue();
                }
                if (c.getName().equals("userpassword")){
                    userpassword = c.getValue();
                }
            }
            if (user!=null){
                //验证账号
                if (userid.equals(user.getUserid()+"")&&userpassword.equals(user.getUserpassword())){
                    response.sendRedirect(request.getContextPath()+"/page/clockin.html");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                    String time = sdf.format(new Date());
                    String day = sdf2.format(new Date());
                    if (Integer.parseInt(time.substring(11, 13))<8){
//                    if (true){
//                        上班
                        DaoUser.addClockStart(time,user.getUserid()+"",day);
                    }else {
//                        下班
                        DaoUser.addClockEnd(time,userid,day);
                    }

                }else {
                    response.sendRedirect(request.getContextPath()+"/page/login.html");
                }
            }else {
                response.sendRedirect(request.getContextPath()+"/page/login.html");
            }

        }else {
            //转到登录界面
            response.sendRedirect(request.getContextPath()+"/page/login.html");
        }

    }
}
