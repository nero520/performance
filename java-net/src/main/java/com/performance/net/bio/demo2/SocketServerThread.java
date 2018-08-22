package com.performance.net.bio.demo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 服务器端bio情况下的线程
 */
public class SocketServerThread implements Runnable{

    Socket socket;

    public SocketServerThread(Socket socket){
        this.socket = socket;
    }

    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            writer = new PrintWriter(socket.getOutputStream());

            String question = reader.readLine();//没有内容会阻塞

            while(Integer.parseInt(question) !=4){
                String answer = getAnswer(Integer.parseInt(question));
                writer.println(answer);
                question = reader.readLine();
            }

            writer.println("4");//OVER作为操作完成暗号
            writer.flush();

            if(writer != null){
                writer.close();
            }

            if(reader != null){
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getAnswer(int question){
        String answer = null;

        switch(question){
            case 1:
                answer = "我是1";
                break;
            case 2:
                answer = "我是2";
                break;
            case 3:
                answer = "我是3";
                break;
            default:
                answer = "请输入 1， 或者2， 或者3";
        }

        return answer;
    }

}
