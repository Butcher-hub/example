package cn.butcher.example.dao;

import cn.butcher.example.bean.Student;
import cn.butcher.example.bean.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author: butcher
 * @Date: 2021/02/03/18:08
 */
public class DaoUser {
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


    public static User getUser(int userid){
        try {
            load();
            String sql ="select userid,userpassword from t_user where userid=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userid);
            rs = ps.executeQuery();
            rs.next();
            User user = new User();
            user.setUserid(rs.getInt("userid"));
            user.setUserpassword(rs.getString("userpassword"));
            return user;

        } catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return null;
    }

    public static void addClockStart(String startTime,String userid,String day){
        int res = -1;
        try {

            if (check(userid,day)){
                //如果在日期存在
                load();
                String sql ="UPDATE t_clockin SET startime=? WHERE userid=? and day=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,startTime);
                ps.setString(2,userid);
                ps.setString(3,day);
                res = ps.executeUpdate();
                close();
                return;
            }

            load();
            String sql ="insert into t_clockin(startime,userid,day) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,startTime);
            ps.setString(2,userid);
            ps.setString(3,day);
             res = ps.executeUpdate();

        }catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        if (res==1){
            System.out.println("上班打卡成功");
        }
    }

    public static void addClockEnd(String endTime,String userid,String day){
        int res = -1;
        try {

            if (check(userid,day)){
                //如果日期存在
                load();
                String sql ="UPDATE t_clockin SET endtime=? WHERE userid=? and day=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,endTime);
                ps.setString(2,userid);
                ps.setString(3,day);
                res = ps.executeUpdate();
                close();
                return;
            }
            load();
            String sql ="insert into t_clockin(endtime,userid,day) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,endTime);
            ps.setString(2,userid);
            ps.setString(3,day);
            res = ps.executeUpdate();


        }catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        if (res==1){
            System.out.println("下班打卡成功");
        }
    }

    public static boolean check(String userid,String day){
        boolean isIn = false;
        try {
            load();
            String sql ="select *from t_clockin WHERE userid=? and day=?";
            ps = conn.prepareStatement(sql);

            ps.setString(1,userid);
            ps.setString(2,day);
            rs = ps.executeQuery();
            if (rs.next()){
               isIn = true;
            }

        }catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return isIn;
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
