package cn.swallow.platform.practice.io.bio.in;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author shenyu
 * @create 2019/4/16
 */
public class TInputStream {

    public static void main(String[] args) throws Exception{
        InputStream inputStream = new ByteArrayInputStream(new byte[]{127,126,125});
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream,1024);
        byte[] bytes = new byte[3];
        bufferedInputStream.read(bytes);
        System.out.println(bytes[0]);
        System.out.println(bytes[1]);
        System.out.println(bytes[2]);
    }


}
