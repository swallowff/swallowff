package cn.swallow.platform.practice.lang;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author shenyu
 * @create 2019/4/12
 */
public class MyUtil {

    public static <T> T clone(T obj) throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);

        ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (T) ois.readObject();
    }

    public static void main(String[] args) throws Exception{
        String a = new String("test");
        System.out.println(a);
        String b = MyUtil.clone(a);
        System.out.println(b);
    }


}
