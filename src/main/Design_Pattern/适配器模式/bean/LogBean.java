/**
 * Copyright (C), 2018-2020
 * FileName: LobBean
 * Author:   xjl
 * Date:     2020/11/11 16:39
 * Description:
 */
package 适配器模式.bean;

public class LogBean {
    /**
     * 日志ID
     */
    private String logId;
    private String logText;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogText() {
        return logText;
    }

    public void setLogText(String logText) {
        this.logText = logText;
    }
}
