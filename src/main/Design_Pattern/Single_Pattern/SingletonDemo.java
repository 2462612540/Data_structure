/**
 * Copyright (C), 2018-2020
 * FileName: SingletonDemo
 * Author:   xjl
 * Date:     2020/8/20 13:03
 * Description: 单例模式
 */
package Single_Pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 枚举类
 */
enum SingletonEnum {
    INSTANCE;

    public void doSomething() {
        System.out.println("do sth.");
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    Singleton1 singleton1 = new Singleton1().getInstance();
                    System.out.println(singleton1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    Singleton1 singleton = new Singleton1().getInstance();
                    System.out.println(singleton);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

/**
 * 饿汉式
 */
class Singleton {
    private static final Singleton Instance = new Singleton();

    private Singleton() {
    }

    public Singleton getInstance() {
        return Instance;
    }
}

/**
 * 懒汉式的synchronize 锁的力度太大
 */
class Singleton0 {
    private static Singleton0 Instance;

    private Singleton0() {
    }

    synchronized public Singleton0 getInstance() {
        if (Instance == null) {
            Instance = new Singleton0();
        }
        return Instance;
    }
}

/**
 * 懒汉式的double_check
 */
class Singleton1 {
    private volatile static Singleton1 Instance;

    public Singleton1 getInstance() {
        if (Instance == null) {
            synchronized (Singleton1.class) {
                if (Instance == null) {
                    Instance = new Singleton1();
                    return Instance;
                }
            }
        }
        return Instance;
    }
}

/**
 * 使用的内部静态方法
 */
class Singleton2 {
    private Singleton2() {
    }

    private static Singleton2 getInstance() {
        return SingletonHolder.Instance;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static final Singleton2 Instance = new Singleton2();
    }
}

/**
 * 使用的Trheadloacal来构建
 */
class Singleton4 {
    private static final ThreadLocal<Singleton4> t;

    static {
        t = new ThreadLocal<Singleton4>() {
            protected Singleton4 initvaue() {
                return new Singleton4();
            }
        };
    }

    private Singleton4() {
        System.out.println("has load");
    }

    public static Singleton4 getInstance() {
        return t.get();
    }
}

/**
 * 使用容器实现单例模式
 */
class Singleton3 {
    private static Map<String, Object> objMap = new HashMap<String, Object>();

    private Singleton3() {
    }

    //将多种单例类型注入到一个统一的管理类，在使用时根据key获取对象对应类型的对象
    public static void registerService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return objMap.get(key);
    }
}


