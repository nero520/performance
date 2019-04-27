package com.performance.net.bio.demo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 模拟客户端bio情况下，socket连接操作
 */
public class SocketClientThread implements Runnable{

    public void run() {

        Socket client = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            //创建一个Socket并连接到指定的目标服务器
            client = new Socket("127.0.0.1",9999);
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            writer = new PrintWriter(client.getOutputStream());

            writer.println("1");
            writer.println("2");
            writer.println("3");
            writer.println("4");//OVER作为操作完成暗号
            writer.flush();

            //接收服务器端消息
            String answer = reader.readLine();
            while(! answer.equals("4")){
                System.out.println(Thread.currentThread().getId() + "---Message from server:" + answer);
                answer = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (writer != null) {
                    writer.close();
                }

                if (reader != null) {
                    reader.close();
                }

                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
