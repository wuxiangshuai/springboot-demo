package com.wxs.listener;

import org.springframework.stereotype.Component;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName: MyListener
 * @Author: WuXiangShuai
 * @Time: 17:04 2019/9/2.
 * @Description:
 */
@Component
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听到web启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听到web销毁");
    }
}
