package cn.swallow.platform.core.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author Administrator
 * @description
 * @create 2019/6/13
 */
public class JacksonExtUtil {
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final ObjectMapper mapper;

    private static JacksonExtUtil INSTANCE = null;

    JacksonJsonFilter jacksonFilter = new JacksonJsonFilter();

    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        mapper = new ObjectMapper();
        mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        mapper.setDateFormat(dateFormat);
        // 允许对象忽略json中不存在的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 允许出现特殊字符和转义符
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        // 允许出现单引号
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 忽视为空的属性
        mapper.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private JacksonExtUtil(){}

    public static JacksonExtUtil me() {
        if (null == INSTANCE){
            INSTANCE = new JacksonExtUtil();
            return INSTANCE;
        }else {
            return INSTANCE;
        }
    }

    public void filter(Class<?> clazz, String... filters) {
        if (clazz == null)
            return;
        if (ArrayUtils.isNotEmpty(filters)) {
            jacksonFilter.filter(clazz, filters);
        }
        mapper.addMixIn(clazz, jacksonFilter.getClass());
    }

    public void include(Class<?> clazz, String... includes) {
        if (clazz == null)
            return;
        if (ArrayUtils.isNotEmpty(includes)) {
            jacksonFilter.include(clazz, includes);
        }
        mapper.addMixIn(clazz, jacksonFilter.getClass());
    }


    public String toJson(Object obj) {
        try {
            mapper.setFilterProvider(jacksonFilter);
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("转换json字符失败!");
        }
    }

    public <T> T toObject(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("将json字符转换为对象时失败!");
        }
    }

    public <T> T toObject(String json, TypeReference<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("将json字符转换为对象时失败!");
        }
    }
}
