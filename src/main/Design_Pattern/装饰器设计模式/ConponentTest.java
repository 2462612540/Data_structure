/**
 * Copyright (C), 2018-2020
 * FileName: ConponentTest
 * Author:   xjl
 * Date:     2020/11/12 13:27
 * Description:
 */
package 装饰器设计模式;

/**
 * 接口
 */
interface Component {
    void operation();
}

/**
 * 装饰器的定义是：在不改变原理的对象的基础上将功能附加到对象上 遵从的软件的开闭原则
 * <p>
 * 应用场景是的 扩展一个类的功能或者是的给一个类添加附加的职责
 * <p>
 * 优点是：
 * 1 不改变原来的对象的的情况下给一个对象扩展功能
 * 2 可以使用不同的组合的效果
 * 3 遵从软件的开闭原则
 */
public class ConponentTest {
    public static void main(String[] args) {
        //创建一个的单纯的拍照的相机
        Component component = new ConcreateComponent();
        component.operation();
        System.out.println("————————————————");
        //给单纯拍照的相机附加美颜的功能
        Component component1 = new ConreteDecoratoral(component);
        component1.operation();
        System.out.println("————————————————");
        //给单纯拍照的相机附加滤镜的功能
        Component component2 = new ConreteDecoratoral2(new ConcreateComponent());
        component2.operation();
        System.out.println("--------------------");
        //将有美颜的相机附加滤镜的功能
        Component component02 = new ConreteDecoratoral2(component1);
        component02.operation();
        System.out.println("-------------------");
    }

}

/**
 * 具体类
 */
class ConcreateComponent implements Component {

    @Override
    public void operation() {
        System.out.println("拍照");
    }
}

/**
 * 抽象类 抽象具有拍照的功能的类
 */
abstract class Decorator implements Component {
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

/**
 * 真的调用美颜 的装饰的类
 */
class ConreteDecoratoral extends Decorator {

    public ConreteDecoratoral(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加美颜");
        component.operation();
    }
}

/**
 * 在美颜的基础的上添加滤镜的功能的类
 */
class ConreteDecoratoral2 extends Decorator {

    public ConreteDecoratoral2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加滤镜");
        component.operation();
    }
}