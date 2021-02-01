package cn.butcher.example.test;

import cn.butcher.example.dao.Dao;

/**
 * @Author: butcher
 * @Date: 2021/01/31/10:40
 */
public class Test03 {
    public static void main(String[] args) {
//        System.out.println(1 * 12);
        int count = Dao.getCount();
        System.out.println(count);
    }
}
