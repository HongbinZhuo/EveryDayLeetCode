package com.zhb.juc.FTPShare;

import org.apache.commons.net.ftp.FTPClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FTPread {
    public static void main(String[] args) throws IOException, InterruptedException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("192.168.0.1", 21); // IP地址和端口
        ftpClient.login("Zhuohongbin", "Zhuo980810"); // 用户名和密码，匿名登陆的话用户名为anonymous,密码为非空字符串
        System.out.println(ftpClient.isConnected());
        InputStream is = ftpClient.retrieveFileStream("b.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while (true){
            System.out.println(br.readLine());
            Thread.sleep(1000);
        }
    }
}
