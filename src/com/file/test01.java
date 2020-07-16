package com.file;

/**
 * @author LENOVO
 * @version 1.0 2020/7/16
 */
public class test01 {
    public static void main(String[] args) {
        String rule =  "(\\w*)\\" +".(txt)";
        System.out.println("1.txt".matches(rule));
        System.out.println("1.111".matches(rule));
    }
}
