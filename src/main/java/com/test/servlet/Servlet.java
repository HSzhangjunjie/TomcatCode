package com.test.servlet;

/**
 * @ProjectName: tomcatDemo
 * @Package: com.test.servlet
 * @ClassName: Servlet
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/19 15:00
 * @Version: 1.0
 */
public abstract class Servlet {
    public abstract void doGet(Request request, Response response);

    public abstract void doPost(Request request, Response response);

    public void service(Request request, Response response) {
        if ("GET".equals(request.getMethod())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }
}
