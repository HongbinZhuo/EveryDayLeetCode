package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    TCP服务器 接受客户端的请求，读取客户端的发送数据，给客户端回写数据
      java.net.ServerSocket
      构造方法:
      ServerSocket(int port) 创建绑定到特定的端口服务器套接字
       服务器必须知道 哪个客户端的请求服务器，采用accept方法获取客户端对象的Socket
       成员方法：
       Socket accept()

       服务器实现步骤:
       1.创建武器的ServerSocket对象和系统要指定的端口号
       2.使用accept获取到请求客户端对象Socket
       3.使用Socket对象中的方法 getInputStream()获取网络字节输入流InputStream
       4.使用read，读取客户端发送的数据
       5.用户网络字节输出流OutputStream的write 给客户端回数据
       6.释放Socket，ServerSocket
    */
public class TCPServer {
    public static void main(String[] args) throws IOException {
//        1.
        ServerSocket serverSocket = new ServerSocket(8888);
//        2.
        Socket socket=serverSocket.accept();
//        3.
        InputStream inputStream=socket.getInputStream();
//        4.
        byte[] bytes =new byte[1024];
        int len=inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
//        5.
        OutputStream outputStream=socket.getOutputStream();
//        6.
        outputStream.write("收到数据了 谢谢".getBytes());
//        7.
        socket.close();
        serverSocket.close();
    }

}
