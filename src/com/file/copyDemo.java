package com.file;

import java.io.*;
import java.util.List;

/**
 * 得到所有文件名
 * 将文件复制到路劲中
 * 删除原路径文件
 * @author LENOVO
 * @version 1.0 2020/7/16
 */
public class copyDemo {

    //得到所有文件名
    public void copy(String FileList ,String FirstName, String LastName) throws IOException {
        //获得文件名
        ListAll listAll = new ListAll();
        List<String> list = listAll.ToAllList(FileList,LastName);
        List<String> sonList = listAll.getSonList(FileList);

        for (String name : list){
            File file = new File(name);

            //目标目录+文件名
            String ToName =FirstName+ file.getName();
            //判断文件中是否有同名文件
            if (list.contains(name)){
                ToName = FirstName+"(1)"+file.getName();
            }
            //目标目录+文件名
            try (InputStream input = new FileInputStream(name);
                 OutputStream output = new FileOutputStream(ToName))
            {
                input.transferTo(output); // transferTo的作用是?
            }
        }

        //删除文件
        for (String name : sonList){
            File file = new File(name);
            deleteFolder(file,LastName);
        }

    }

    // 删除文件及目录
    //1.传入文件名
    public static void deleteFolder(File folder,String LastName) {
        //获取文件名下所有文件和文件夹
        File[] files = folder.listFiles();
        //判断文件夹是否为空，为空直接删除
        if (files != null) {
            //不为空，遍历
            for (File f : files) {
                //判断是否是目录，是则递归，不是删除
                if (f.isDirectory()) {
                    deleteFolder(f,LastName);
                } else {
                    //文件,判断是否是要求的格式格式
                    //定义规则
                    String rule =  "(\\w*)\\.("+LastName+")";
                    if (f.getName().matches(rule)){
                        f.delete();
                    }
                }
            }
        }
        //为空删除
        folder.delete();
    }

}
