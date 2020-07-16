package com.file;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储文件
 * @author LENOVO
 * @version 1.0 2020/7/16
 */
public class KeepList {
    List<String> files = new ArrayList<>();

    public KeepList( ) {
    }

    public KeepList(String file) {
        files.add(file);
    }

    public KeepList(List<String> files) {
        this.files = files;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files1) {
        files.addAll(files1);
    }

    public void setFiles(String file) {
        files.add(file);
    }
}
