package cn.swallow.platform.modular.system.dao;

import cn.swallow.platform.common.base.dao.CrudMapper;
import cn.swallow.platform.modular.system.entity.Dict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author shenyu
 * @create 2019/3/15
 */
@Mapper
public interface DictMapper extends CrudMapper<Dict> {
    List<Dict> selectByParentCode(String parentCode);
}
