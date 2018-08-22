package com.performance.net.bio.demo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * bio 客户端
 */
public class SocketClient {

    public  static void main(String[] args){

        //客户端发起10个请求
        for (int i=0;i<10;i++){
           Thread thread = new Thread(new SocketClientThread());
           thread.start();
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

}
