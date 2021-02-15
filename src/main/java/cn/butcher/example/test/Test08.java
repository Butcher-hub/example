package cn.butcher.example.test;

import cn.butcher.example.bean.Clock;
import cn.butcher.example.bean.Order;
import cn.butcher.example.bean.User;
import cn.butcher.example.dao.DaoClock;
import cn.butcher.example.dao.DaoOrder;
import cn.butcher.example.dao.DaoUser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: butcher
 * @Date: 2021/02/03/18:17
 */
public class Test08 {
    public static void main(String[] args) {
//        User user = DaoUser.getUser(20210101);
//////        System.out.println(user.getUserpassword());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String startime = sdf.format(new Date());
//        System.out.println(startime.substring(11, 13));

//        DaoUser.addClockStart(startime,"20210101");
//boolean a = DaoUser.check("2021023", "2021-02-03");
//        System.out.println(a);

//        List<Order> orderAsPage = DaoOrder.getOrderAsPage("1", "5");
//
//        for (Order o:orderAsPage
//             ) {
//            System.out.println(o.getName());
//        }
//        System.out.println(DaoOrder.getCount());
        List<Clock> orderAsPage = DaoClock.getClockAsPage("1", "10");
        for (Clock c: orderAsPage
             ) {
            System.out.println(c.getEndtime());
        }


    }
}
