package com.test.utils;

/**
 * @ProjectName: tomcatDemo
 * @Package: com.test.utils
 * @ClassName: HttpUtil
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/18 14:47
 * @Version: 1.0
 */
public class HttpUtil {

    public static String getHttpResponseContext(int code, String context, String errorMsg) {
        if (code == 200) {
            return "HTTP/1.1 200 OK \n" +
                    "Content-Type: text/html\n" +
                    "\r\n" + context;
        } else if (code == 500) {
            return "HTTP/1.1 500 Internal Error=" + errorMsg + "\n" +
                    "Content-Type: text/html\n" + "\r\n";
        }
        return "HTTP/1.1 404 NOT FOUND \n" +
                "Content-Type: text/html\n" + "\r\n" +
                "<h1>404 NOT FOUND</h1>";
    }
    public static String getHttpResponseContext200(){
        return "HTTP/1.1 200 OK \n" +
                "Content-Type: text/html\n"+
                "\r\n";
    }
    public static String getHttpResponseContext404(){
        return "HTTP/1.1 404 NOT FOUND \n" +
                "Content-Type: text/html\n" + "\r\n" +
                "<h1>404 NOT FOUND</h1>";
    }
    public static String getHttpResponseContext500(){
        return "HTTP/1.1 500 Internal Error=" + "\n" +
                "Content-Type: text/html\n" + "\r\n";
    }
}
