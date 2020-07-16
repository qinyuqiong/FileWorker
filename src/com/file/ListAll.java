package com.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * 遍历文件夹下文件及所有子文件夹下文件
 * @author LENOVO
 * @version 1.0 2020/7/15
 */
public class ListAll {

    public static KeepList keepList = new KeepList();

    //读取文件夹
    //输入文件夹目录

    //获得目录下所有文件
    public  List<String> ToFiles(String FileList , String LastName){
        List<String> files = new ArrayList<>();
        File f = new File(FileList);

        //File[] fs1 = f.listFiles(); // 列出所有文件和子目录
        //printFiles(fs1);

        //读取文件
        File[] fs2 = f.listFiles(new FilenameFilter() { // 仅列出.exe文件
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(LastName); // 返回true表示接受该文件
            }
        });
        //printFiles(fs2);
        for (File file : fs2){
            files.add(file.toString());
        }
        return files;
    }

    //获取子目录
    public  List<String> getSonList(String FileList){
        List<String> SonList = new ArrayList<>();

        File f = new File(FileList);

        File[] fs1 = f.listFiles(); // 列出所有文件和子目录
        //printFiles(fs1);

        File[] fs3 = new File[fs1.length];//子目录
        int j = 0;
        //循环遍历目录
        for (int i = 0 ; i < fs1.length ; i++){
            File file = fs1[i];
            //判断文件是否是子目录,不是就删除
            if (file.isDirectory()){
                fs3[j++] = file;
            }
        }
        //printFiles(fs3);
        //判断不为空，添加
        for (File file : fs3){
            if (file != null){
                SonList.add(file.toString());
            }
        }
        return SonList;
    }

    //读取目录
    public  void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {

                    System.out.println(f);
            }
        }
        System.out.println("==========");
    }

    //将子目录中的文件提取出来
    //使用递归
    //查看是否还有子目录
    //1.有，调用自己
    //2.没有，将文件添加
    public  List<String> ToAllList(String FileList , String LastName){
         List<String> files = ToFiles(FileList,LastName);
         List<String> sonList = getSonList(FileList);
         //将第一层的文件加入集合中
         keepList.setFiles(files);
         //将子目录遍历
        for (String file : sonList){
            //files.addAll(ToFiles(file,LastName));
            //通过文件名得子文件夹下的文件和文件夹
            List<String> list = ToFiles(file, LastName);
            List<String> sonList1 = getSonList(file);

            //将子文件夹下的文件加入集合中
            keepList.setFiles(list);

            //判断文件夹是否为空，为空跳过
            if (sonList1 != null){
                //不为空，遍历
                for (String f : sonList1){
                    //判断是否为目录，是则递归，不是添加到文件list中
                    File file1 = new File(f);
                    if(file1.isDirectory()){
                        ToAllList(f,LastName);
                    }else{
                        keepList.setFiles(ToFiles(f, LastName));
                    }
                }
            }
        }
        return files=keepList.getFiles();
    }


}
