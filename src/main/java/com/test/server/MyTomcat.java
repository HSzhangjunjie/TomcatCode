package com.test.server;

import com.test.config.ServletConfig;
import com.test.config.ServletConfigMapping;
import com.test.servlet.Request;
import com.test.servlet.Response;
import com.test.servlet.Servlet;
import com.test.utils.HttpUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: tomcatDemo
 * @Package: com.test.server
 * @ClassName: MyTomcat
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/18 14:26
 * @Version: 1.0
 */
public class MyTomcat {

    private int port = 8080;

    private Map<String, Class<Servlet>> classMap = new HashMap<>();

    public MyTomcat(int port) {
        this.port = port;
    }

    public MyTomcat() {

    }

    public void initServlet() throws ClassNotFoundException {
        for (ServletConfig servletConfig : ServletConfigMapping.getConfigs()) {
            classMap.put(servletConfig.getUrl(), (Class<Servlet>) Class.forName(servletConfig.getClazz()));
        }
    }

    public void dispatch(Request request, Response response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Servlet> servletClass = classMap.get(request.getUrl());
        if (servletClass != null) {
            Servlet servlet = servletClass.getConstructor().newInstance();
            servlet.service(request, response);
        } else {
            response.write(HttpUtil.getHttpResponseContext404());
        }
    }

    public void start() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        initServlet();
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is running, the port is :" + port);
        while (true) {
            Socket socket = serverSocket.accept();
            Request request = new Request(socket.getInputStream());
            Response response = new Response(socket.getOutputStream());
            if (request.getUrl().equals("/")) {
                response.write(HttpUtil.getHttpResponseContext404());
            } else if (classMap.get(request.getUrl()) == null) {
                response.write(HttpUtil.getHttpResponseContext404());
            } else {
                dispatch(request, response);
            }
            response.writeHtml(request.getUrl());
            socket.getOutputStream().write("hello world!".getBytes());
            socket.close();
        }
    }

    public static void main(String[] args) {
        MyTomcat tomcat = new MyTomcat(9999);
        try {
            tomcat.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
