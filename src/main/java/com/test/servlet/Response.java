package com.test.servlet;

import com.test.utils.FileUtil;
import com.test.utils.HttpUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @ProjectName: tomcatDemo
 * @Package: com.test.servlet
 * @ClassName: Response
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/18 22:11
 * @Version: 1.0
 */
public class Response {

    private OutputStream outputStream;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String context){
        try {
            outputStream.write(context.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeHtml(String path) throws FileNotFoundException {
        String resourcePath = FileUtil.getResourcePath(path);
        File file=new File(resourcePath);
        if (file.exists()){
            FileUtil.writeFile(file, outputStream);
        }else {
            write(HttpUtil.getHttpResponseContext404());
        }
    }
}
