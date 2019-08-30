package cn.swallow.platform.modular.system.service;

import cn.swallow.platform.common.base.service.CrudService;
import cn.swallow.platform.modular.system.dao.NoticeMapper;
import cn.swallow.platform.modular.system.entity.Notice;
import org.springframework.stereotype.Service;

/**
 * @author shenyu
 * @create 2019/4/12
 */
@Service
public class NoticeService extends CrudService<NoticeMapper,Notice> {
}
