/**
 * Copyright (C), 2018-2020
 * FileName: ProxyTest
 * Author:   xjl
 * Date:     2020/9/19 13:41
 * Description:
 */
package 代理设计模式;

/**
 * 核心业务的主题
 */
interface Sleep {
    public void make();
}

class SleepReal implements Sleep {

    @Override
    public void make() {
        System.out.println("真实业务……");
    }
}

class SleepProxy implements Sleep {
    private Sleep sleep;

    public SleepProxy(Sleep sleep) {
        this.sleep = sleep;
    }

    public void note() {
        System.out.println("代理业务1……");
    }

    public void give() {
        System.out.println("代理业务2……");
    }

    @Override
    public void make() {
        this.note();
        this.give();
        System.out.println("真实业务处理……");
        this.move();
    }

    public void move() {
        System.out.println("代理业务3……");
    }
}

public class ProxyTest {

    public static void main(String[] args) {
        Sleep sleep = new SleepProxy(new SleepReal());
        sleep.make();
    }
}
