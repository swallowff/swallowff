package cn.swallow.platform.core.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QRCodeUtilTest {

    @Test
    public void encodeQrcode() throws Exception{
        String targetPath = "F:\\data\\a";
        String targetFileName = "test.png";
        String logoFilePath = "C:\\Users\\Lenovo\\Desktop\\headImg.jpeg";
        String content = "https://www.baidu.com/s?ie=UTF-8&wd=我爱你&";
        QRCodeUtil.encode(content,logoFilePath,targetPath,targetFileName,true);
    }

    @Test
    public void encodeQrcode1() {
    }

    @Test
    public void encodeQrcode2() {
    }

    @Test
    public void encodeQrcode3() {
    }

    @Test
    public void decode() {
    }

}