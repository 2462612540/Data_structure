/**
 * Copyright (C), 2018-2020
 * FileName: StrategyTest
 * Author:   xjl
 * Date:     2020/11/12 14:48
 * Description:
 */
package 策略模式.v2;

interface Moveable {
    public void move();
}

interface Attackable {
    public void attack();
}

public class StrategyTest {

    public static void main(String[] args) {
        Zombie z = new NormalZombie();
        z.dispalay();
        z.move();
        z.attack();
        System.out.println("---------构建新的方式------------");
        Zombie zombie = new FalgZombie();
        //这里采用的是将算法 和属性专递过去实现的一种方式 从而实现的的是一种的新的方式
        zombie.setAttackable(new HitAttack());
        zombie.dispalay();
        z.move();
        zombie.attack();
    }
}

/**
 * 父类的僵尸
 */
abstract class Zombie {

    Moveable moveable;
    Attackable attackable;

    public Zombie() {

    }

    public Zombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }

    abstract public void dispalay();

    abstract void move();

    abstract void attack();

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    public Attackable getAttackable() {
        return attackable;
    }

    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
    }
}

/**
 * 移动的具体的算法
 */
class StepByStepMove implements Moveable {

    @Override
    public void move() {
        System.out.println("一步一步一定");
    }
}

/**
 * 攻击的具体的方式
 */
class BiteAttack implements Attackable {

    @Override
    public void attack() {
        System.out.println("咬的部分");
    }
}

class HitAttack implements Attackable {

    @Override
    public void attack() {
        System.out.println("采用的是打的一种方式");
    }
}

/**
 * 基本的僵死的类
 */
class NormalZombie extends Zombie {

    public NormalZombie() {
        super(new StepByStepMove(), new BiteAttack());
    }

    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void dispalay() {
        System.out.println("我是普通用户");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}

/**
 * 旗手僵尸的类
 */
class FalgZombie extends Zombie {

    public FalgZombie() {
        super(new StepByStepMove(), new BiteAttack());
    }

    public FalgZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void dispalay() {
        System.out.println("我是骑手");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}



