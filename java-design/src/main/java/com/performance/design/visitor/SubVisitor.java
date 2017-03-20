package com.performance.design.visitor;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.VisitorSupport;
import java.util.HashMap;

/**
 * 访问者模式
 * Visitor接口提供各种visit方法重载,根据XML不同的对象，将采用不同的方式来访问
 * @author xiaoxiong
 */
public class SubVisitor extends VisitorSupport {
    HashMap<String,String> hm=new HashMap<String, String>();
    @Override
    public void visit(Attribute node) {
        System.out.println(node.getValue());
    }

    @Override
    public void visit(Element node) {
        System.out.println(node.getName());
        hm.put(node.getName(), node.getTextTrim());
    }

    public HashMap<String, String> getHm() {
        return hm;
    }
}
