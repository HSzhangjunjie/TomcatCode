package com.test.servlet;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ProjectName: tomcatDemo
 * @Package: com.test.servlet
 * @ClassName: Request
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/18 22:11
 * @Version: 1.0
 */
public class Request {
    private String url;
    private String method;
    private InputStream inputStream;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Request(InputStream inputStream) throws IOException {
        this.inputStream = inputStream;
        int count = 0;
        while (count == 0) {
            count = inputStream.available();
        }
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        System.out.println(new String(bytes));
        extractFields(new String(bytes));
    }

    public void extractFields(String context) {
        if (context.equals("")) {
            System.out.println("empty");
        } else {
            String firstLine = context.split("\\n")[0];
            String[] split = firstLine.split("\\s");
            setUrl(split[1]);
            setMethod(split[0]);
        }
    }
}
