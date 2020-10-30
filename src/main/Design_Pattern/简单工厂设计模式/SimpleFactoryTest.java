/**
 * Copyright (C), 2018-2020
 * FileName: SimpleFactory
 * Author:   xjl
 * Date:     2020/10/30 9:48
 * Description:
 */
package 简单工厂设计模式;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        //使用父类的应用指向子类的对象
        Product product1 = SimpleFactory.makeProduct(0);
        product1.show();
    }

    //抽象产品
    public interface Product {
        void show();
    }

    //具体产品：ProductA
    static class ConcreteProduct1 implements Product {
        @Override
        public void show() {
            System.out.println("具体产品1显示...");
        }
    }

    //具体产品：ProductB
    static class ConcreteProduct2 implements Product {
        @Override
        public void show() {
            System.out.println("具体产品2显示...");
        }
    }

    /**
     * 工厂类
     */
    static class SimpleFactory {
        //这里是返回的是的product
        public static Product makeProduct(int kind) {
            switch (kind) {
                case Const.PRODUCT_A:
                    return new ConcreteProduct1();
                case Const.PRODUCT_B:
                    return new ConcreteProduct2();
            }
            return null;
        }
    }

    final class Const {
        static final int PRODUCT_A = 0;
        static final int PRODUCT_B = 1;
        static final int PRODUCT_C = 2;
    }
}
