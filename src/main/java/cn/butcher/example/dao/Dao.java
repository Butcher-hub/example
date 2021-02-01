package cn.butcher.example.dao;

import cn.butcher.example.bean.Student;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author: butcher
 * @Date: 2021/01/30/19:36
 */
public class Dao {
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


    public static List<Student> getStudent(){
        List<Student> list = new ArrayList<>();
        try {
            load();
            String sql ="select id,studentID,name,birth,class from t_mesage";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getString("id"));
                student.setStudentID(rs.getString("studentID"));
                student.setName(rs.getString("name"));
                student.setBirth(rs.getString("birth"));
                student.setClassname(rs.getString("class"));
                list.add(student);
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
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


    public static List<Student> getStudentAsPage(int index){
        List<Student> list = new ArrayList<>();
        try {
            load();
            String sql ="select id,studentID,name,birth,class from t_mesage limit ?,12 ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,index);
            rs = ps.executeQuery();

            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getString("id"));
                student.setStudentID(rs.getString("studentID"));
                student.setName(rs.getString("name"));
                student.setBirth(rs.getString("birth"));
                student.setClassname(rs.getString("class"));
                list.add(student);
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    public static List<Student> queryByName(String name){
        List<Student> list = new ArrayList<>();
        try {
           load();
            String sql ="select id,studentID,name,birth,class from t_mesage where name LIKE \"%"+name+"%\" ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getString("id"));
                student.setStudentID(rs.getString("studentID"));
                student.setName(rs.getString("name"));
                student.setBirth(rs.getString("birth"));
                student.setClassname(rs.getString("class"));
                list.add(student);
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    public static void add(Student student){
        int result = 0;
        try {
            load();
            String sql ="insert into t_mesage(studentID,name,birth,class) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,student.getStudentID());
            ps.setString(2,student.getName());
            ps.setString(3,student.getBirth());
            ps.setString(4,student.getClassname());
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
            String sql ="select count(*) as c from t_mesage";
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
