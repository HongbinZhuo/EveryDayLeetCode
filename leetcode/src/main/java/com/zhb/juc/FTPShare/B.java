package com.zhb.juc.FTPShare;

import org.apache.commons.net.ftp.FTPClient;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class B {
    public static void main(String[] args) {

        try {
            //fileName为文件的名称，带后缀。例如：ftpInfo.txt
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect("192.168.0.1", 21); // IP地址和端口
            ftpClient.login("Zhuohongbin", "Zhuo980810"); // 用户名和密码，匿名登陆的话用户名为anonymous,密码为非空字符串
            System.out.println(ftpClient.isConnected());
//            boolean hasDir = ftpClient.changeWorkingDirectory( "userBehavior" ); // 切换到test目录 ,返回boolean值，如果有该文件夹返回true，否则，返回false
//            if(!hasDir){
//                //创建文件夹
//                ftpClient.makeDirectory("userBehavior");
//                ftpClient.changeWorkingDirectory( "userBehavior" );
//            }
            ftpClient.setControlEncoding("utf-8");
            //向指定文件写入内容，如果没有该文件，则先创建文件再写入。写入的方式是追加。
            OutputStream outputStream = ftpClient.storeFileStream("a.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(outputStream), true);
            while(true){
                fileOutputStream.write(98);
                fileOutputStream.flush();
//                outputStream.close();

            }
//            PrintWriter pw = new PrintWriter(new OutputStreamWriter(ftpClient.appendFileStream("a.txt"), "utf-8"), true); // 写入的文件名
//            while (true) {
//                pw.write("早上好！\r\n");
//                pw.flush();
//                pw.close();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
