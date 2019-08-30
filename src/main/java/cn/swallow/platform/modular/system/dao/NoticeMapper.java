package cn.swallow.platform.modular.system.dao;

import cn.swallow.platform.common.base.dao.CrudMapper;
import cn.swallow.platform.modular.system.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shenyu
 * @create 2019/4/12
 */
@Mapper
public interface NoticeMapper extends CrudMapper<Notice> {

}
