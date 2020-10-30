/**
 * Copyright (C), 2018-2020
 * FileName: 懒汉单例模式
 * Author:   xjl
 * Date:     2020/10/29 10:33
 * Description:
 */
package 单例设计模式;

enum LazySingleton5 {
    Instance;
}

/**
 * 这是一个懒汉的单例设计模式的例子但是可能出现问题
 */

public class LazySingleton {
    private static LazySingleton lazySingleton;

    /**
     * 构造函数
     */
    private LazySingleton() {
    }

    /**
     * 相当于是的getLazySingleton的一个共有函数   pulibc void getLazySingleton(){return lazySingleton}
     * 在多线程的情况下出现的 这样的是不安全的一个的单例模式 需要的是的加锁
     *
     * @return
     */
    public static LazySingleton getInstance() throws Exception {
        if (lazySingleton == null) {
            Thread.sleep(2000);
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    /**
     * 实现了加锁的对整个类进行加锁的限制来保证多线程下的对象的单例实现
     *
     * @return
     */
    public synchronized static LazySingleton getInstance1() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}

/**
 * 使用的double check来实现的保证多线下的线程安全
 */
class LazySingleton2 {
    private volatile LazySingleton2 singleton2;

    /**
     * 构造函数
     */
    public LazySingleton2() {

    }

    /**
     * 使用了双重锁机制来实现的单例模式能够保证的多线程下的安全性
     *
     * @return
     */
    public LazySingleton2 getSingleton2() {
        if (singleton2 == null) {
            synchronized (LazySingleton2.class) {
                if (singleton2 == null) {
                    //字节码的层
                    //JIT CPU
                    //1、分配空间
                    //2、初始化
                    //3、应用赋值
                    singleton2 = new LazySingleton2();
                }
            }
        }
        return singleton2;
    }
}

/**
 * 使用的是的饿汉的模式的 不会出现的多线程的下的安全的问题
 */
class LazySingleton3 {
    private LazySingleton3 singleton3 = new LazySingleton3();

    //这个是的构造函数
    private LazySingleton3() {
    }

    public LazySingleton3 getSingleton() {
        return singleton3;
    }
}

/**
 * 使用内部类 实质也是采用的使用的是的饿汉模式
 */
class LazySingleton4 {

    private static class InnerClassHolder {
        private static InnerClassHolder intsance = new InnerClassHolder();

        /**
         * 构造函数
         */
        private InnerClassHolder() {
        }

        /**
         * 获取实例对象
         *
         * @return
         */
        public static LazySingleton4 getIntsance() {
            return new LazySingleton4();
        }
    }
}

class LazySingleton5Test {
    public static void main(String[] args) {
        LazySingleton5 singleton51 = LazySingleton5.Instance;
        LazySingleton5 singleton52 = LazySingleton5.Instance;

        System.out.println(singleton51 == singleton52);
    }
}

class LazySingletonTest {
    public static void main(String[] args) {

//        LazySingleton lazySingleton1 = LazySingleton.getInstance();
//        LazySingleton lazySingleton2 = LazySingleton.getInstance();
//        //判断是否为一个实例
//        System.out.println(lazySingleton1 == lazySingleton2);

        //在多线程的下的测试 这个是1.8的版本的最多
        new Thread(() -> {
            LazySingleton instance = null;
            try {
                instance = LazySingleton.getInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            LazySingleton instance = null;
            try {
                instance = LazySingleton.getInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(instance);
        }).start();

    }
}







