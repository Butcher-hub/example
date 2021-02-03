package cn.butcher.example.test;

import cn.butcher.example.bean.User;
import cn.butcher.example.dao.DaoUser;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: butcher
 * @Date: 2021/02/03/18:17
 */
public class Test08 {
    public static void main(String[] args) {
//        User user = DaoUser.getUser(20210101);
//////        System.out.println(user.getUserpassword());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startime = sdf.format(new Date());
        System.out.println(startime.substring(11, 13));

//        DaoUser.addClockStart(startime,"20210101");
    }
}
