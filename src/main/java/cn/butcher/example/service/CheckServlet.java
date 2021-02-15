package cn.butcher.example.service;

import cn.butcher.example.bean.User;
import cn.butcher.example.dao.DaoUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Author: butcher
 * @Date: 2021/02/05/20:10
 */
@WebServlet("/check")
public class CheckServlet extends HttpServlet {
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
                    HttpSession session = request.getSession();
                    session.setAttribute("userid",userid);
                    request.getRequestDispatcher("/index.html").forward(request,response);

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
