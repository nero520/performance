package com.performance.net.bio.demo2;

import javax.net.ServerSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * bio 服务器端
 */
public class SocketServer {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            //可以设置客户连接请求队列的长度，默认为50。比如5，队列长度超过5后拒绝连接请求
            //serverSocket = ServerSocketFactory.getDefault().createServerSocket(8383, 5);
            serverSocket = ServerSocketFactory.getDefault().createServerSocket(9999);
            while (true){
                try{
                    //监听直到接受连接后返回一个新Socket对象
                    socket = serverSocket.accept();//阻塞
                    //new一个线程处理连接请求
                    new Thread(new SocketServerThread(socket)).start();;
                } catch (Throwable e) {    //防止发生异常搞死服务器
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
