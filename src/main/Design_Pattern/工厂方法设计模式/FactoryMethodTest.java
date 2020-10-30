/**
 * Copyright (C), 2018-2020
 * FileName: FactoryMethodTest
 * Author:   xjl
 * Date:     2020/10/30 10:02
 * Description:
 */
package 工厂方法设计模式;

//抽象产品：提供了产品的接口
interface Product {
    public void show();
}

//抽象工厂：提供了厂品的生成方法
interface AbstractFactory {
    public Product newProduct();
}

public class FactoryMethodTest {
    public static void main(String[] args) {
        //指定一个专门的仓库在生产产品1就可以
        ConcreteFactory1 concreteFactory1 = new ConcreteFactory1();
        Product product1 = concreteFactory1.newProduct();
        product1.show();
    }
}

//具体产品1：实现抽象产品中的抽象方法
class ConcreteProduct1 implements Product {
    @Override
    public void show() {
        System.out.println("具体产品1显示...");
    }
}

//具体产品2：实现抽象产品中的抽象方法
class ConcreteProduct2 implements Product {
    @Override
    public void show() {
        System.out.println("具体产品2显示...");
    }
}

//具体工厂1：实现了厂品的生成方法
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
    }
}

//具体工厂2：实现了厂品的生成方法
class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new ConcreteProduct2();
    }
}

