package cn.swallow.platform.core.util;

import java.io.Closeable;
import java.io.IOException;

public class StreamUtil {

    public static void close(Closeable... closeables){
        for (Closeable c : closeables){
            if (null != c){
                try {
                    c.close();
                    c = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}