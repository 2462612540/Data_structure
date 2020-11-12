/**
 * Copyright (C), 2018-2020
 * FileName: LogWriteDbService
 * Author:   xjl
 * Date:     2020/11/11 16:50
 * Description:
 */
package 适配器设计模式.DB;

import 适配器设计模式.bean.LogBean;

public interface LogWriteDbService {
    /**
     * 实现的写入数据库  属于是新的目标
     */
    public void logWriteDb(LogBean logBean);
}
