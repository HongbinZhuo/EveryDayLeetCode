package TCP;
/*
     客户端向服务器 发送数据读取服务器回写的数据
     客户端的类： java.net.Socket 套字节
     构造方法 Soket(Sting host,int port)  创建一个流套接字 并将其连接到制定主机上的端口号
     参数：
          String host: 服务器的主机名称/服务器的IP地址
          int port ：服务器端口号
     成员方法：
     OutputStream getOutputStream()    返回套接字的输出流
       InputStream getInputStream() 返回此字节套的输入流
       void close() 关闭套接字

       实现步骤：
       1.创建一个客户端的对象Socket 构造方法绑定服务器的IP和端口
       2. 使用Socket 对象 getOutputStream()  回去网络字节套输出流的OutputStream对象
       3.使用网络字节输出流OutputStream对象中的方法writr，给服务器发送数据
       4.使用Socket对象中的方法getInputStream()  获取网络字节套数据流InputStream对象
       5.使用网络字节输入流InputStream 对象中的方法read，读取服务器回写的数据
       6.释放资源(Socket)
      注意：
      1客户端服务器交互，必须使用Socket中提供的网络流，不能使用自己创建的流对象
      2.当我们创建客户端对象的Socket,通过三次握手。
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.
        Socket socket = new Socket("127.0.0.1", 8888);
        //2.
        OutputStream os = socket.getOutputStream();
        //3.
        os.write("你好服务器".getBytes());
        //4.
        InputStream is = socket.getInputStream();
       //5.
        byte[] bytes =new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
        //6.
        socket.close();
    }

}
