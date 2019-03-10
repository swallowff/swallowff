package cn.swallow.platform.core.common.dao;

import cn.swallow.platform.core.common.entity.BaseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudMapper<E extends BaseEntity<E>> {
    E selectById(Integer id);

    List<E> findList(E entity);

    int insert(E entity);

    int update(E entity);

    int updateSelective(E entity);

    int delete(Integer id);
}
