package cn.swallow.platform.practice.io.bio.in;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author shenyu
 * @create 2019/10/2
 */
public class TBufferedInputStream {
    private byte[] getBytes(){
        return new byte[]{0,1,2,3};
    }

    private InputStream getInputStream(byte[] bytes){
        return new ByteArrayInputStream(bytes);
    }

    public void testBufferedInputStream() throws Exception{
        //默认创建8kb的缓冲区
        BufferedInputStream bis = new BufferedInputStream(getInputStream("abc".getBytes("UTF-8")));
        byte[] bytes = new byte[1024];
        int i = 0;
        while ((i = bis.read(bytes)) != -1){
            System.out.println(new String(bytes,"UTF-8"));
        }
    }

    public static void main(String[] args) throws Exception {
        TBufferedInputStream obj = new TBufferedInputStream();
        obj.testBufferedInputStream();
    }
}
