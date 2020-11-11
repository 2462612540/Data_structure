/**
 * Copyright (C), 2018-2020
 * FileName: LogWriteFileServiceImpl
 * Author:   xjl
 * Date:     2020/11/11 16:43
 * Description:
 */
package 适配器模式.file;

import 适配器模式.bean.LogBean;

import java.util.ArrayList;
import java.util.List;

public class LogWriteFileServiceImpl implements LogWriteFileService {

    @Override
    public void logWritelocal() {
        System.out.println("将文件写入日志文件中");
    }

    @Override
    public List<LogBean> logreadlocal() {
        LogBean log1 = new LogBean();
        log1.setLogId("0001");
        log1.setLogText("Tomcat启动成功..");
        LogBean log2 = new LogBean();
        log2.setLogId("0002");
        log2.setLogText("jetty启动成功..");
        List<LogBean> listArrayList = new ArrayList<LogBean>();
        listArrayList.add(log1);
        listArrayList.add(log2);
        return listArrayList;
    }
}
