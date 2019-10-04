package cn.swallow.platform.practice.io.bio.in;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;

/**
 * @author shenyu
 * @create 2019/10/1
 */
public class TDataInputStream {
    private byte[] getBytes(){
        return new byte[]{0,1,2,3,4,5,6};
    }

    private InputStream getInputStream(byte[] bytes){
        return new ByteArrayInputStream(bytes);
    }

    private void testReadInt() throws Exception{
        DataInputStream dis = new DataInputStream(getInputStream(getBytes()));
        //int 刚好为4byte 输出66051
        //00000000 00000001 00000010 00000011
        int i;
        while (dis.available() >= 4){
            //如果读取的剩余数据不足4bytes 则readInt会抛出EOFException,读取其它类型同理
            System.out.println(dis.readInt());
        }
    }

    public static void main(String[] args) throws Exception{
        TDataInputStream  obj = new TDataInputStream();
        obj.testReadInt();
    }

}
