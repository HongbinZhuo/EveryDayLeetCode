package com.zhb.othertechnology.src.Recurison;

import java.io.File;

public class RecurisonFile {
    public static void main(String[] args) {
        File file = new File("D:\\BaiduNetdiskDownload\\01.JavaSE Java语言基础+进阶");
      getAllFile(file);
        
    }

    private static void getAllFile(File dir) {
        System.out.println(dir);

        File[] files=dir.listFiles();
        for (File file : files) {
            if(file.isDirectory()) {
                getAllFile(file);
            }else {
                System.out.println(file);
            }
        }
    }
}
