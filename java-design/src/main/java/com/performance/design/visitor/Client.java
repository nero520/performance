package com.performance.design.visitor;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * 客户端
 * @author xiaoxiong
 */
public class Client {

    public static  void main(String[] args){

        //接下来使用SAXReader 读取请求输入流,获得document对
        SAXReader sread=new SAXReader();
        Document doct = null;
        try {
            doct = (Document) sread.read(new File(Common.filepath));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        //获得根元素
        Element root=doct.getRootElement();
        System.out.println("获取根元素" + root);
        SubVisitor myv=new SubVisitor();
        root.accept(myv);//在这里需要注意的是,程序将自动遍历子节点!
    }
}
