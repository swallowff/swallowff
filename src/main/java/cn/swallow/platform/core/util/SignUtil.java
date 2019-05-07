package cn.swallow.platform.core.util;

import java.util.*;

/**
 * @author Administrator
 * @description 签名工具
 * @create 2019/5/7
 */
public class SignUtil {
    public String getSign(Map<String,Object> paramsMap, String signKey){
        String result = "";
        try {
            List<Map.Entry<String, Object>> entryList = new ArrayList<Map.Entry<String, Object>>(paramsMap.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(entryList, new Comparator<Map.Entry<String, Object>>() {
                public int compare(Map.Entry<String, Object> entry1, Map.Entry<String, Object> entry2) {
                    return (entry1.getKey()).toString().compareTo(entry2.getKey());
                }
            });

            // 构造签名键值对字符串的格式
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> item : entryList) {
                if (item.getKey() != null || item.getKey() != "") {
                    String key = item.getKey();
                    Object val = item.getValue();
                    if (!(val == "" || val == null)) {
                        sb.append(key + "=" + val + "&");
                    }
                }
            }
            sb.append("key="+signKey);
            result = sb.toString();

            //MD5加密
            result = EncryptAndDecryptUtils.md5Encrypt(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }


}
