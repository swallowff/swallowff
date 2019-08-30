package cn.swallow.platform.util;

import cn.swallow.platform.core.util.json.GsonHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author shenyu
 * @create 2019/3/22
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CommonUtilTest {


    @Test
    public void mathTest(){
        System.out.println(Math.round(-1.5));
    }

    @Test
    public void stringFormatTest() throws Exception{
        String goodsName = "西兰花";
        String goodsName2 = "云南水白菜冬瓜";
        System.out.println(goodsName.getBytes("UTF-8").length);
        System.out.println(goodsName2.getBytes("UTF-8").length);
        byte[] nameBytes = goodsName.getBytes("UTF-8");
        byte[] nameBytes2 = goodsName2.getBytes("UTF-8");
        if (nameBytes.length > 3*6){
            goodsName = goodsName.substring(0,6);
        }else if (nameBytes.length < 3*6){
            goodsName = org.apache.commons.lang3.StringUtils.rightPad(goodsName,3*6 - nameBytes.length," ");
        }else {
        }

        if (nameBytes2.length > 3*6){
            goodsName2 = goodsName2.substring(0,6);
        }else if (nameBytes2.length < 3*6){
            goodsName2 = org.apache.commons.lang3.StringUtils.rightPad(goodsName2,3*6 - nameBytes2.length," ");
        }else {
        }
        System.out.println(goodsName);
        System.out.println(goodsName2);
        System.out.println(goodsName.getBytes("UTF-8").length);
        System.out.println(goodsName2.getBytes("UTF-8").length);
        System.out.println("  ".getBytes().length);
    }

    @Test
    public void decodeTest() throws Exception{
        String source = "西兰花";
        byte[] sourceByte = source.getBytes("iso-8859-1");
        String iso8859_s = new String(sourceByte,"iso-8859-1");
        System.out.println(sourceByte);
    }

    @Test
    public void encodeTest()throws Exception{
        byte[] bytes = new byte[]{-50,-9};
        String result = new String(bytes,"gbk");
        System.out.println(result);
    }

    @Test
    public void infactTest() throws Exception{
        String template = "名称:%-12.12s   数量:%6s(%1s)   价格:%6s元";
        String name = "西兰花";
        System.out.println("默认编码:"+GsonHelper.toJson(name.getBytes()));
        System.out.println("Unicode:"+GsonHelper.toJson(name.getBytes("unicode")));
        System.out.println("gbk:"+GsonHelper.toJson(name.getBytes("gbk")));
        System.out.println("utf-8:"+GsonHelper.toJson(name.getBytes("utf-8")));
        System.out.println("gb2312:"+GsonHelper.toJson(name.getBytes("gb2312")));
        System.out.println("iso-8859-1:"+GsonHelper.toJson(name.getBytes("iso-8859-1")));
    }
}
