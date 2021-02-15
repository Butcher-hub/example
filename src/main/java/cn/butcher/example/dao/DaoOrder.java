package cn.butcher.example.dao;

import cn.butcher.example.bean.Order;
import cn.butcher.example.bean.Student;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author: butcher
 * @Date: 2021/02/05/11:56
 */
public class DaoOrder {
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



    public static void del(String id){
        int result = 0;
        try {
            load();
            String sql ="delete from t_mesage where id="+id;
            ps = conn.prepareStatement(sql);
            result = ps.executeUpdate();

        } catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        if (result==1){
            System.out.println(id+"删除成功");
        }
    }


    public static List<Order> getOrderAsPage(String page, String limit){
        int index = Integer.parseInt(page)-1;
        if (index>0){
            index = index*Integer.parseInt(limit);
        }
        List<Order> list = new ArrayList<>();
        try {
            load();
            String sql ="select year,name,purchaseid,produceid,orderdate,specification,material,raise,surface,quantity,price,totalprice,deliver\n" +
                    "from t_sale  limit ?,?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,index);
            ps.setInt(2,Integer.parseInt(limit));
            rs = ps.executeQuery();

            while (rs.next()){
                Order order = new Order();
                order.setYear(rs.getString("year"));
                order.setName(rs.getString("name"));
                order.setPurchaseid(rs.getString("purchaseid"));
                order.setProduceid(rs.getString("produceid"));
                order.setOrderdate(rs.getString("orderdate"));
                order.setSpecification(rs.getString("specification"));
                order.setMaterial(rs.getString("material"));
                order.setRaise(rs.getString("raise"));
                order.setSurface(rs.getString("surface"));
                order.setQuantity(rs.getString("quantity"));
                order.setPrice(rs.getString("price"));
                order.setTotalprice(rs.getString("totalprice"));
                order.setDeliver(rs.getString("deliver"));
                list.add(order);
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    public static List<Order> queryByName(String name){
        List<Order> list = new ArrayList<>();
        try {
            load();
            String sql ="select id,studentID,name,birth,class from t_mesage where name LIKE \"%"+name+"%\" ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Order order = new Order();

                list.add(order);
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    public static void add(Order order){
        int result = 0;
        try {
            load();
            String sql ="insert into t_mesage(studentID,name,birth,class) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);

            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("啊偶添加失败了喔:"+e.getMessage());
        }finally {
            close();
        }
        if (result==1){
            System.out.println("数据插入成功！");
        }
    }


    public static int getCount(){
        try {
            load();
            String sql ="select count(*) as c from t_sale";
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
