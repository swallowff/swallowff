package cn.swallow.platform.practice.io.bio.in;

import java.io.ByteArrayInputStream;

/**
 * @author shenyu
 * @create 2019/10/1
 */
public class TByteArrayInputStream {

    private byte[] getBytes(){
        return new byte[]{0,1,2,3};
    }

    private void testNoneArgsConstructor(){
        byte[] bytes = getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        int i;
        while ((i = inputStream.read()) != -1){
            System.out.println(i);
        }
    }

    private void testOffsetConstructor(){
        byte[] bytes = getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes,1,1);
        int i;
        while ((i = inputStream.read()) != -1){
            System.out.println(i);
        }
    }


    public static void main(String[] args){
        TByteArrayInputStream obj = new TByteArrayInputStream();
        obj.testNoneArgsConstructor();
        obj.testOffsetConstructor();
    }
}
