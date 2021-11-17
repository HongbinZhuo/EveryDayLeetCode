package com.zhb.othertechnology.src.IOFileCopy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class iocopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("D:\\BaiduNetdiskDownload\\01.JavaSE Java语言基础+进阶\\03.Java语言高级\\06-File类与IO流\\1000739.jpg");
        FileOutputStream  fos=new FileOutputStream("D:\\1.jpg");
        /*一个字节的复制*/
//        int len=0;
//        while((len= fis.read()) != -1){
//                fos.write(len);
//        }

        /*每次读取1024字节*/
        byte[] bytes=new byte[1024];
        int len=0;//每次读取的有效字节个数
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }



        fos.close();
        fis.close();
    }

}
