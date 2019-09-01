package cn.swallow.platform.common.base.dao;

import cn.swallow.platform.common.base.entity.BaseEntity;

import java.util.List;

public interface CrudMapper<E extends BaseEntity<E>> {
    E selectById(String id);

    List<E> findList(E entity);

    int insert(E entity);

    int insertSelective(E entity);

    int update(E entity);

    int updateSelective(E entity);

    int delete(Integer id);
}
