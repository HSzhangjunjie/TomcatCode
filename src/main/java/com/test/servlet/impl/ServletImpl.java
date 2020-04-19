package com.test.servlet.impl;

import com.test.servlet.Request;
import com.test.servlet.Response;
import com.test.servlet.Servlet;
import com.test.utils.HttpUtil;

/**
 * @ProjectName: tomcatDemo
 * @Package: com.test.servlet.impl
 * @ClassName: ServletImpl
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/19 15:02
 * @Version: 1.0
 */
public class ServletImpl extends Servlet {
    @Override
    public void doGet(Request request, Response response) {
        String content = "<h1> doGet is running </h1>";
        response.write(HttpUtil.getHttpResponseContext200() + content);
    }

    @Override
    public void doPost(Request request, Response response) {
        String content = "<h1> doPost is running </h1>";
        response.write(HttpUtil.getHttpResponseContext200() + content);
    }
}
