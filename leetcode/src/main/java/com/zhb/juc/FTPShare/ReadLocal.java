package com.zhb.juc.FTPShare;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadLocal {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileInputStream is = new FileInputStream("F:\\ftpShare\\b.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        while (true){
            System.out.println(br.readLine());
            Thread.sleep(1000);
        }

    }
}
