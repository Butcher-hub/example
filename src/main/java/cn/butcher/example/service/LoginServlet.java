package cn.butcher.example.service;

import cn.butcher.example.bean.User;
import cn.butcher.example.dao.DaoUser;
import com.sun.imageio.plugins.common.I18N;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: butcher
 * @Date: 2021/02/03/18:05
 */
@WebServlet("/page/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String userid = request.getParameter("userid");
        String userpassword = request.getParameter("userpassword");
        String unpassword = request.getParameter("unpassword");
        String verifycode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        String v = (String)session.getAttribute("verifyCode");
        User user = DaoUser.getUser(Integer.parseInt(userid));
        String mes ="";


         if (user!=null){
            if (user.getUserid()== Integer.parseInt(userid) && userpassword.equals(user.getUserpassword())){
                if(v.toLowerCase().equals(verifycode.toLowerCase())){
                    mes="yes";
                }else {
                    mes="vfail";
                }
                //返回yes

                if (unpassword.equals("1")){
                    Cookie useridcookie = new Cookie("userid",userid);
                    Cookie userpasswordcookie = new Cookie("userpassword",userpassword);
                    useridcookie.setPath(request.getContextPath());
                    userpasswordcookie.setPath(request.getContextPath());
                    useridcookie.setMaxAge(600);
                    userpasswordcookie.setMaxAge(600);
                    response.addCookie(useridcookie);
                    response.addCookie(userpasswordcookie);

                    session.setAttribute("userid",userid);
                }
            }else {
                //返回no
                mes="no";
            }
        }else {
            //返回nohave
            mes="nohava";
        }

        PrintWriter out = response.getWriter();
        out.print(mes);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
