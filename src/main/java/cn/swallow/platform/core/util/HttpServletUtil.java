package cn.swallow.platform.core.util;

import org.apache.commons.lang3.ArrayUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @description
 * @create 2019/5/14
 */
public class HttpServletUtil {

    /**
     * 获取请求Body
     *
     * @param request
     * @return
     */
    public static String getBodyString(ServletRequest request) {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }


    public static Map<String, Object> getRequestParameters(HttpServletRequest request) {
        String parameters = "";//请求参数
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if ("GET".equals(request.getMethod())) {//GET请求时的参数
                String urlParameter = request.getQueryString();//网址中的参数
                if (urlParameter != null && !"".equals(urlParameter)) {
                    try {
                        urlParameter = URLDecoder.decode(urlParameter, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                } else {
                    urlParameter = "";
                    return map;
                }
                parameters = urlParameter;
            } else if ("POST".equals(request.getMethod())) {//POST请求时的参数
                String totalParameter = "";//表单及网址中全部参数

                Map<String, String[]> params = request.getParameterMap();
                int parametersNum = request.getParameterMap().size();//参数个数
                if (0 == parametersNum) {
                    return map;
                }
                int flag = 1;
                for (String key : params.keySet()) {
                    if (key.equalsIgnoreCase("file")) {
                        continue;
                    }
                    String[] values = params.get(key);
                    for (int i = 0; i < values.length; i++) {
                        String value = values[i];
                        totalParameter += key + "=" + value;
                    }
                    if (flag < parametersNum) {
                        totalParameter += "&";
                    }
                    flag += 1;
                }
                parameters = totalParameter;
            }
            if (!parameters.contains("&")) {
                String[] arr = parameters.split("=");
                String key = arr[0];
                String value = arr[1];
                map.put(key, value);
                return map;
            }
            String[] arr = parameters.split("&");
            if (arr.length > 0 && ArrayUtils.isNotEmpty(arr)) {
                for (int i = 0; i < arr.length; i++) {
                    String key = arr[i].substring(0, arr[i].indexOf("="));
                    String value = arr[i].substring(arr[i].indexOf("=") + 1);
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
