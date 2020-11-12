/**
 * Copyright (C), 2018-2020
 * FileName: StrategyTest
 * Author:   xjl
 * Date:     2020/11/12 14:03
 * Description: 策略模式的设计
 */
package 策略模式.v1;

/**
 * 策略模式的定义是算法族 分别将这个封装起来 让他们可以相互的替换此模式的的变化算利于算法的使用者
 */
public class StrategyTest {
    public static void main(String[] args) {
        AbstractxZombie normal = new NormalZombie();
        AbstractxZombie flag = new FlagZombie();

        normal.dispaly();
        normal.attack();
        normal.move();
        System.out.println("--------------------------");
        flag.dispaly();
        flag.attack();
        flag.move();

    }
}

/**
 * 抽象类的僵尸  父类
 */
abstract class AbstractxZombie {
    public abstract void dispaly();

    public void attack() {
        System.out.println("咬");
    }

    public void move() {
        System.out.println("一步一步移动");
    }
}

/**
 * 子类的继承父类的方法AbstractxZombie
 */
class NormalZombie extends AbstractxZombie {

    @Override
    public void dispaly() {
        System.out.println("我是普通的用户……");
    }
}

/**
 * 子类继承AbstractxZombie的方法
 * 父类的中的抽象方法子类的是需要时实现 否则子类是不能实例化的
 */
class FlagZombie extends AbstractxZombie {

    @Override
    public void dispaly() {
        System.out.println("我是手持棋子的用户");
    }
}

class BigHeadZombie extends AbstractxZombie {

    @Override
    public void dispaly() {
        System.out.println("我是大头僵尸");
    }

    @Override
    public void attack() {
        System.out.println("使用的是头部的撞击……");
    }
}

/**
 * 其他的僵尸类
 */
class XXZombie extends BigHeadZombie {
    @Override
    public void move() {
        System.out.println("一边跳舞和一边移动");
    }
}









