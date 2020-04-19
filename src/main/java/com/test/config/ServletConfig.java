package com.test.config;

/**
 * @ProjectName: tomcatDemo
 * @Package: com.test.config
 * @ClassName: ServletConfig
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/19 15:23
 * @Version: 1.0
 */
public class ServletConfig {

    private String name;
    private String url;
    private String clazz;

    public ServletConfig(String name, String url, String clazz) {
        this.name = name;
        this.url = url;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
