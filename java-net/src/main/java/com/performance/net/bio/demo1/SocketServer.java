package com.performance.net.bio.demo1;

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

        try {
            ServerSocket server = new ServerSocket(9999);
            while (true){
                //接收消息
                Socket socket = server.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("server accept msg :"+br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
