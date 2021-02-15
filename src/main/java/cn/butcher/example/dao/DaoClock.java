package cn.butcher.example.dao;

import cn.butcher.example.bean.Clock;
import cn.butcher.example.bean.Order;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author: butcher
 * @Date: 2021/02/05/13:16
 */
public class DaoClock {
    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static String url="";

    private static void load(){
        Properties properties = new Properties();
        InputStream resource = Dao.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(resource);
            String driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("啊偶，资源找不到:"+e.getMessage());
        }
    }

    public static List<Clock> getClockAsPage(String page, String limit){
        int index = Integer.parseInt(page)-1;
        if (index>0){
            index = index*Integer.parseInt(limit);
        }
        List<Clock> list = new ArrayList<>();
        try {
            load();
            String sql ="select startime,endtime,userid,day from t_clockin  limit ?,?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,index);
            ps.setInt(2,Integer.parseInt(limit));
            rs = ps.executeQuery();

            while (rs.next()){
                Clock clock = new Clock();
                clock.setStartime(rs.getString("startime"));
                clock.setEndtime(rs.getString("endtime"));
                clock.setUserid(rs.getString("userid"));
                clock.setDay(rs.getString("day"));
                list.add(clock);
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }


    public static int getCount(){
        try {
            load();
            String sql ="select count(*) as c from t_clockin";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt("c");
            return count;
        } catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return 0;
    }


    private static void close(){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
