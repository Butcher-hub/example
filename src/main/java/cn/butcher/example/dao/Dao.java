package cn.butcher.example.dao;

import cn.butcher.example.bean.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: butcher
 * @Date: 2021/01/30/19:36
 */
public class Dao {
    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static String url="jdbc:mysql://localhost:3306/testdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    public static List<Student> getStudent(){
        List<Student> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","tx2437");
            String sql ="select studentID,name,birth,class from t_mesage";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Student student = new Student();
                student.setStudentID(rs.getString("studentID"));
                student.setName(rs.getString("name"));
                student.setBirth(rs.getString("birth"));
                student.setClassname(rs.getString("class"));
                list.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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
        return list;
    }


    public static List<Student> getStudentAsPage(int index){
        List<Student> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","tx2437");
            String sql ="select studentID,name,birth,class from t_mesage limit ?,12 ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,index);
            rs = ps.executeQuery();

            while (rs.next()){
                Student student = new Student();
                student.setStudentID(rs.getString("studentID"));
                student.setName(rs.getString("name"));
                student.setBirth(rs.getString("birth"));
                student.setClassname(rs.getString("class"));
                list.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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
        return list;
    }

    public static List<Student> queryByName(String name){
        List<Student> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","tx2437");
            String sql ="select studentID,name,birth,class from t_mesage where name LIKE \"%"+name+"%\" ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Student student = new Student();
                student.setStudentID(rs.getString("studentID"));
                student.setName(rs.getString("name"));
                student.setBirth(rs.getString("birth"));
                student.setClassname(rs.getString("class"));
                list.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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
        return list;
    }

    public static void add(Student student){
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","tx2437");
            String sql ="insert into t_mesage(studentID,name,birth,class) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,student.getStudentID());
            ps.setString(2,student.getName());
            ps.setString(3,student.getBirth());
            ps.setString(4,student.getClassname());
            result = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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
        if (result==1){
            System.out.println("数据插入成功！");
        }
    }


    public static int getCount(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","tx2437");
            String sql ="select studentID,name,birth,class from t_mesage";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.last();
            int count = rs.getRow();
            return count;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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
    return 0;
    }
}
