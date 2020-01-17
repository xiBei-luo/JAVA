package com.greenplatform.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileUtil {
    public static byte[] readFile(String filename) throws IOException {
        if (filename == null || filename.equals("")) {
            throw new NullPointerException("无效的文件路径");
        }
        File file = new File(filename);
        long len = file.length();
        byte[] bytes = new byte[(int) len];

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        int r = bufferedInputStream.read(bytes);
        if (r != len)
            throw new IOException("读取文件不正确");
        bufferedInputStream.close();
        return bytes;
    }
}
