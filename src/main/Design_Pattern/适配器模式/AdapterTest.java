/**
 * Copyright (C), 2018-2020
 * FileName: AdapterTest
 * Author:   xjl
 * Date:     2020/11/11 16:10
 * Description:
 */
package 适配器模式;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapterTest {
    /**
     * 使用的是v1的提供的入口入参是map类型
     * 下一个版本的是支持新的list
     *
     * @param map
     */
    public void forMap(Map map) {
        for (int i = 0; i < map.size(); i++) {
            String value = (String) map.get(i);
            System.out.println("value=" + value);
        }
    }
    //采用适配器的方式 中间使用的是适配器模式
}

//继承的map的接口这说明也会是一个的map的子类
class ListAdapter extends HashMap {
    //目标对象新的版本
    private List list;

    public ListAdapter(List list) {
        this.list = list;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Object get(Object key) {
        return list.get(Integer.valueOf(key.toString()).intValue());
    }
}

class Test001 {
    public static void main(String[] args) {
        AdapterTest adapterTest = new AdapterTest();
        ArrayList<String> list = new ArrayList<>();
        list.add("庄小焱0");
        list.add("庄小焱1");
        list.add("庄小焱2");
        list.add("庄小焱3");
        //使用的适配器的实现转换
        ListAdapter listAdapter = new ListAdapter(list);
        //可以实现的list类型
        adapterTest.forMap(listAdapter);
    }
    /**
     * 写入日志 写入本地文件 后期的开发新的功能的时候 支持MQ 写入数据库 使用的是适配器一般是在外部的扩展使用
     * 装饰器的模式的 使用的内部扩展的实现
     */
}
