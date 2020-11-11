/**
 * Copyright (C), 2018-2020
 * FileName: TestProxy
 * Author:   xjl
 * Date:     2020/11/11 15:50
 * Description:
 */
package 代理设计模式;

//抽象主题
interface Subject {
    void Request();
}

public class TestProxy {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.Request();
    }
}

//真实主题
class RealSubject implements Subject {
    public void Request() {
        System.out.println("访问真实主题方法...");
    }
}

//代理
class Proxy implements Subject {
    private RealSubject realSubject;

    /**
     * 使用的代理的对象 实现了对函数功能的实现
     */
    public void Request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }

    public void preRequest() {
        System.out.println("访问真实主题之前的预处理。");
    }

    public void postRequest() {
        System.out.println("访问真实主题之后的后续处理。");
    }
}
