package cn.swallow.platform.practice.network.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author shenyu
 * @create 2019/9/30
 */
public class URLConnectionUseCase {

    public static void main(String[] args){
        try {
            URL url = new URL("http://www.baidu.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            byte[] b = new byte[1024];
            int r;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(500*1024);
            while ((r = inputStream.read(b))!= -1){
                outputStream.write(b);
            }
            byte[] result = outputStream.toByteArray();
            String s = new String(result,"UTF-8");
            System.out.println(s);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
