import Sort.Student;

/**
 * Copyright (C), 2018-2020
 * FileName: TestComparable
 * Author:   xjl
 * Date:     2020/5/31 21:12
 * Description: 实现
 */

public class TestComparable {
    public static Comparable getMax(Comparable c1, Comparable c2) {
        int result = c1.compareTo(c2);
        if (result >= 0) {
            return c1;
        } else {
            return c2;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setUsername("张三");
        s1.setAge(20);

        Student s2 = new Student();
        s2.setUsername("李四");
        s2.setAge(22);

        Comparable max = getMax(s1, s2);
        System.out.println(max.toString());
    }
}
