package com.test.utils;

import java.io.*;

/**
 * @ProjectName: tomcatDemo
 * @Package: com.test.utils
 * @ClassName: FileUtil
 * @Author: ZhangJunjie
 * @Description:
 * @Date: 2020/4/19 0:27
 * @Version: 1.0
 */
public class FileUtil {
    public static boolean writeFile(InputStream inputStream, OutputStream outputStream) {
        boolean success = false;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(HttpUtil.getHttpResponseContext200().getBytes());
            int count = 0;
            while (count == 0) {
                count = inputStream.available();
            }
            int fileSize = inputStream.available();
            long written = 0;
            int size = 1024;
            byte[] bytes = new byte[size];
            while (written < fileSize) {
                if (written + fileSize > fileSize) {
                    size = (int) (fileSize - written);
                    bytes = new byte[size];
                }
                bufferedInputStream.read(bytes);
                System.out.println(new String(bytes));
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.flush();
                written += size;
            }
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static boolean writeFile(File file, OutputStream outputStream) throws FileNotFoundException {
        return writeFile(new FileInputStream(file), outputStream);
    }

    public static String getResourcePath(String path) {
        path = path.replace("/", "");
        String resource = FileUtil.class.getClassLoader().getResource(path).getPath();
        return resource;
    }
}
