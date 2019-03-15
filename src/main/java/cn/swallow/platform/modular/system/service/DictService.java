package cn.swallow.platform.modular.system.service;

import cn.swallow.platform.core.common.service.CrudService;
import cn.swallow.platform.modular.system.dao.DictMapper;
import cn.swallow.platform.modular.system.entity.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shenyu
 * @create 2019/3/15
 */
@Service
public class DictService extends CrudService<DictMapper,Dict> {
    @Autowired
    private DictMapper dictMapper;

    public List<Dict> selectByParentCode(String parentCode){
        return dictMapper.selectByParentCode(parentCode);
    }
}
