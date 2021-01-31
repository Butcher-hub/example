package cn.butcher.example.bean;

/**
 * @Author: butcher
 * @Date: 2021/01/30/19:43
 */
public class Student {

    private String id;
    private String studentID;
    private String name;
    private String birth;
    private String classname;
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
