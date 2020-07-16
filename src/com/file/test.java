package com.file;

import java.io.IOException;

/**
 * @author LENOVO
 * @version 1.0 2020/7/15
 */
public class test {
    public static void main(String[] args) throws IOException {
        copyDemo copyDemo = new copyDemo();
        copyDemo.copy("E:\\1","E:\\1\\","txt");
        //copyDemo.copy("F:\\书\\翻书大作战 No.059\\金雀花王朝.mobi","E:\\1\\",".txt");

    }
}
