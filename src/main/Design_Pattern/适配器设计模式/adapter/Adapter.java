/**
 * Copyright (C), 2018-2020
 * FileName: Adapter
 * Author:   xjl
 * Date:     2020/11/11 16:47
 * Description:
 */
package 适配器设计模式.adapter;

import 适配器设计模式.DB.LogWriteDbService;
import 适配器设计模式.bean.LogBean;
import 适配器设计模式.file.LogWriteFileServiceImpl;

import java.util.List;

public class Adapter extends LogWriteFileServiceImpl implements LogWriteDbService {
    /**
     * 写入本地文件
     */
    @Override
    public void logWriteDb(LogBean logBean) {
        //读取本地文件
        List<LogBean> logBeans = this.logreadlocal();
        //将数据的写入到数据库中
        logBeans.add(logBean);
        System.out.println("写入数据库中");
        //写入本地文件中
        this.logWritelocal();
    }
}
