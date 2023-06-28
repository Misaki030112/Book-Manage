package com.book.domain;

import com.book.domain.DefaultTairManager;

import java.util.ArrayList;

public class Tair {
    // 声明一个 DefaultTairManager 默认Tair管理器
    private DefaultTairManager defaultTairManager;

    // 初始化 defaultTairManager
    public Tair() {
        ArrayList<String> configList = new ArrayList<String>();
        configList.add("192.168.31.132:5198");

        defaultTairManager = new DefaultTairManager();
        defaultTairManager.setConfigServeList(configList);
        defaultTairManager.setTimeOut(5000);
        defaultTairManager.setCharset("utf-8");
        defaultTairManager.setGroupName("group_test");
        defaultTairManager.init();
    }

    public DefaultTairManager getDefaultTairManager()
    {
        return defaultTairManager;
    }


}
