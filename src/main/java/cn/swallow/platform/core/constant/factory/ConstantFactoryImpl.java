package cn.swallow.platform.core.constant.factory;

import cn.swallow.platform.core.util.context.SpringContextHolder;
import cn.swallow.platform.modular.system.entity.Dict;
import org.springframework.stereotype.Component;

@Component
public class ConstantFactoryImpl implements IConstantFactory {
    @Override
    public String getDictName(Integer dictId) {
        return null;
    }

    @Override
    public Dict getDictByTypeAndValue(String dictType, Integer value) {
        return null;
    }

    public static IConstantFactory me(){
        return SpringContextHolder.getBean(ConstantFactoryImpl.class);
    }
}
