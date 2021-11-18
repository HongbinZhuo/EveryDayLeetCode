package com.zhb.juc.FTPShare;

import java.io.FileOutputStream;
import java.io.IOException;

public class writeLocal {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\ftpShare\\b.txt");
        while (true){
            fileOutputStream.write(97);
            fileOutputStream.write(10);
            Thread.sleep(5000);

        }



    }
}
