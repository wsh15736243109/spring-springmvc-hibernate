package com.wsh.ssh.view;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.ServletContextResourceLoader;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.File;
import java.util.Locale;
import java.util.logging.Logger;

public class HtmlResourceView extends InternalResourceView {
    @Override
    public boolean checkResource(Locale locale) {
        System.out.println("getUrl:" + getUrl());
        File file = new File(getUrl());
        return file.exists();// 判断该页面是否存在
    }
}
