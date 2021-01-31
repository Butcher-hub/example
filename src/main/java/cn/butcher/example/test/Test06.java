package cn.butcher.example.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @Author: butcher
 * @Date: 2021/01/31/17:58
 */
public class Test06 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        InputStream inputStream = Test06.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(inputStream);
            Enumeration<String> names=(Enumeration<String>)properties.propertyNames();
            while(names.hasMoreElements()){
                //这是key值
                String key=names.nextElement();
                String value=properties.getProperty(key);
                System.out.println(key+"="+value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
