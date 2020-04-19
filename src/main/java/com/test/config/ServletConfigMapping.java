package com.test.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: tomcatDemo
 * @Package: com.test.config
 * @ClassName: ServletConfigMapping
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/19 15:24
 * @Version: 1.0
 */
public class ServletConfigMapping {
    private static List<ServletConfig> configs = new ArrayList<>();

    static {
        configs.add(new ServletConfig("ServletImpl", "/test", "com.test.servlet.impl.ServletImpl"));
    }

    public static List<ServletConfig> getConfigs() {
        return configs;
    }
}
