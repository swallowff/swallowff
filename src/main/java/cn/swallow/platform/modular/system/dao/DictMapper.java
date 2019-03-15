package cn.swallow.platform.modular.system.dao;

import cn.swallow.platform.core.common.dao.CrudMapper;
import cn.swallow.platform.modular.system.entity.Dict;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shenyu
 * @create 2019/3/15
 */
@Repository
public interface DictMapper extends CrudMapper<Dict> {
    List<Dict> selectByParentCode(String parentCode);
}