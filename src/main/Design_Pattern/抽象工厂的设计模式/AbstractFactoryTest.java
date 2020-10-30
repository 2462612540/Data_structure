/**
 * Copyright (C), 2018-2020
 * FileName: AbstractFactory
 * Author:   xjl
 * Date:     2020/10/30 10:09
 * Description:
 */
package 抽象工厂的设计模式;

import javax.swing.*;
import java.awt.*;

/**
 * 表示的是一个抽象工厂的 一个抽象工厂   有多个工厂实现了的抽象工厂的  然后在有每一个工厂中的方法实现了类的构建
 */

public class AbstractFactoryTest {

    //抽象产品：动物类
    interface Animal {
        public void show();
    }

    //抽象产品：植物类
    interface Plant {
        public void show();
    }

    //抽象工厂：农场类
    interface Farm {
        public Animal newAnimal();

        public Plant newPlant();
    }

    //具体产品：马类
    class Horse implements Animal {
        JScrollPane sp;
        JFrame jf = new JFrame("抽象工厂模式测试");

        /**
         * 构造函数
         */
        public Horse() {
            Container contentPane = jf.getContentPane();
            JPanel p1 = new JPanel();
            p1.setLayout(new GridLayout(1, 1));
            p1.setBorder(BorderFactory.createTitledBorder("动物：马"));
            sp = new JScrollPane(p1);
            contentPane.add(sp, BorderLayout.CENTER);
            JLabel l1 = new JLabel(new ImageIcon("src/A_Horse.jpg"));
            p1.add(l1);
            jf.pack();
            jf.setVisible(false);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭
        }

        @Override
        public void show() {
            jf.setVisible(true);
        }
    }

    //具体产品：牛类
    class Cattle implements Animal {
        JScrollPane sp;
        JFrame jf = new JFrame("抽象工厂模式测试");

        public Cattle() {
            Container contentPane = jf.getContentPane();
            JPanel p1 = new JPanel();
            p1.setLayout(new GridLayout(1, 1));
            p1.setBorder(BorderFactory.createTitledBorder("动物：牛"));
            sp = new JScrollPane(p1);
            contentPane.add(sp, BorderLayout.CENTER);
            JLabel l1 = new JLabel(new ImageIcon("src/A_Cattle.jpg"));
            p1.add(l1);
            jf.pack();
            jf.setVisible(false);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭
        }

        @Override
        public void show() {
            jf.setVisible(true);
        }
    }

    //具体产品：水果类
    class Fruitage implements Plant {
        JScrollPane sp;
        JFrame jf = new JFrame("抽象工厂模式测试");

        public Fruitage() {
            Container contentPane = jf.getContentPane();
            JPanel p1 = new JPanel();
            p1.setLayout(new GridLayout(1, 1));
            p1.setBorder(BorderFactory.createTitledBorder("植物：水果"));
            sp = new JScrollPane(p1);
            contentPane.add(sp, BorderLayout.CENTER);
            JLabel l1 = new JLabel(new ImageIcon("src/P_Fruitage.jpg"));
            p1.add(l1);
            jf.pack();
            jf.setVisible(false);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭
        }

        @Override
        public void show() {
            jf.setVisible(true);
        }
    }

    //具体产品：蔬菜类
    class Vegetables implements Plant {
        JScrollPane sp;
        JFrame jf = new JFrame("抽象工厂模式测试");

        public Vegetables() {
            Container contentPane = jf.getContentPane();
            JPanel p1 = new JPanel();
            p1.setLayout(new GridLayout(1, 1));
            p1.setBorder(BorderFactory.createTitledBorder("植物：蔬菜"));
            sp = new JScrollPane(p1);
            contentPane.add(sp, BorderLayout.CENTER);
            JLabel l1 = new JLabel(new ImageIcon("src/P_Vegetables.jpg"));
            p1.add(l1);
            jf.pack();
            jf.setVisible(false);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭
        }

        @Override
        public void show() {
            jf.setVisible(true);
        }
    }

    //具体工厂：韶关农场类
    class SGfarm implements Farm {
        @Override
        public Animal newAnimal() {
            System.out.println("新牛出生！");
            return new Cattle();
        }

        @Override
        public Plant newPlant() {
            System.out.println("蔬菜长成！");
            return new Vegetables();
        }
    }

    //具体工厂：上饶农场类
    class SRfarm implements Farm {
        @Override
        public Animal newAnimal() {
            System.out.println("新马出生！");
            return new Horse();
        }

        @Override
        public Plant newPlant() {
            System.out.println("水果长成！");
            return new Fruitage();
        }
    }
}
