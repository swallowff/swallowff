package cn.swallow.platform.core.common.service;

import cn.swallow.platform.core.common.dao.CrudMapper;
import cn.swallow.platform.core.common.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public abstract class CrudService<M extends CrudMapper<E>,E extends BaseEntity<E>> {
    @Autowired
    protected M crudMapper;

    public E selectById(Integer id){
        return crudMapper.selectById(id);
    }

    public List<E> findList(E entity){
        return crudMapper.findList(entity);
    }

    public int insert(E entity){
        entity.setCreateTime(new Date());
        return crudMapper.insert(entity);
    }

    public int update(E entity){
        return crudMapper.update(entity);
    }

    public int updateSelective(E entity){
        return crudMapper.updateSelective(entity);
    }

    public int delete(Integer id){
        return crudMapper.delete(id);
    }
}
