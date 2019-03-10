package cn.swallow.platform.core.constant.factory;

import cn.swallow.platform.modular.system.entity.Dict;

public interface IConstantFactory {

    /**
     * 根据字典id获取字典名称
     * @param dictId
     * @return
     */
    String getDictName(Integer dictId);

    /**
     * 根据字典类型和值获取字典
     * @param dictType
     * @param value
     * @return
     */
    Dict getDictByTypeAndValue(String dictType, Integer value);




}
