package 适配器设计模式.file;

import 适配器设计模式.bean.LogBean;

import java.util.List;

public interface LogWriteFileService {
    /**
     * 将日志写入本地文件
     */
    public void logWritelocal();

    /**
     * 读取本地文件
     */
    public List<LogBean> logreadlocal();
}
