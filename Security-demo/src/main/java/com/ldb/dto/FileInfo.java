package com.ldb.dto;

/**
 * @author Bobbi
 * @date 2017/11/16
 */
public class FileInfo {

    private String path;

    public FileInfo(String path){
        this.path=path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
