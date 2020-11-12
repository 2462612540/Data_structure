/**
 * Copyright (C), 2018-2020
 * FileName: LogAdapter
 * Author:   xjl
 * Date:     2020/11/11 19:18
 * Description:
 */
package 适配器设计模式.adapter;

import 适配器设计模式.DB.LogWriteDbService;
import 适配器设计模式.bean.LogBean;
import 适配器设计模式.file.LogWriteFileServiceImpl;

public class LogAdapter implements LogWriteDbService {

    private LogWriteFileServiceImpl logWriteFileServiceimpl;

    public LogAdapter(LogWriteFileServiceImpl logWriteFileServiceimpl) {
        this.logWriteFileServiceimpl = logWriteFileServiceimpl;
    }

    /**
     * 新增的功能
     *
     * @param logBean
     */
    @Override
    public void logWriteDb(LogBean logBean) {
        System.out.println("增加");
    }
}
