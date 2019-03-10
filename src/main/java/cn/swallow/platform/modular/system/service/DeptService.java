package cn.swallow.platform.modular.system.service;

import cn.swallow.platform.core.common.service.CrudService;
import cn.swallow.platform.modular.system.dao.DeptMapper;
import cn.swallow.platform.modular.system.entity.Dept;
import org.springframework.stereotype.Service;

@Service
public class DeptService extends CrudService<DeptMapper, Dept> {

}
