package com.FTPShare;

import org.apache.commons.net.ftp.FTPClient;

import java.io.*;

public class A {
    public static void main(String[] args) throws InterruptedException, IOException {
//        File file = new File("F:\\ftpShare\\fxterm_20210803.log");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
//        String string = "Zhuohonbin";
//        while (true){
//            bw.write(string);
//            bw.newLine();
//            Thread.sleep(30000L);
//            bw.flush();
//            System.out.println("写入成功");
//        }
//        while(true) {
            try {
                //fileName为文件的名称，带后缀。例如：ftpInfo.txt
                FTPClient ftpClient = new FTPClient();
                ftpClient.connect("192.168.0.1", 21); // IP地址和端口
                ftpClient.login("zhb", "123123"); // 用户名和密码，匿名登陆的话用户名为anonymous,密码为非空字符串
//            boolean hasDir = ftpClient.changeWorkingDirectory( "userBehavior" ); // 切换到test目录 ,返回boolean值，如果有该文件夹返回true，否则，返回false
//            if(!hasDir){
//                //创建文件夹
//                ftpClient.makeDirectory("userBehavior");
//                ftpClient.changeWorkingDirectory( "userBehavior" );
//            }
                ftpClient.setControlEncoding("utf-8");
                System.out.println(ftpClient.isConnected());
                //向指定文件写入内容，如果没有该文件，则先创建文件再写入。写入的方式是追加。
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(ftpClient.appendFileStream("b.txt"));
                System.out.println("11");
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(ftpClient.appendFileStream("20210925.log"), "utf-8"), true); // 写入的文件名
                pw.write("早上好!\r\n");
                pw.flush();
                pw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
//        }


    }
}
