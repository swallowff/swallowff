package cn.swallow.platform.common.wrapper;

import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Administrator
 * @description
 * @create 2019/6/28
 */
public abstract class BaseWrapper<T> {
    private T t;

    private List<T> entityList;

    public BaseWrapper(T t) {
        this.t = t;
    }

    public BaseWrapper(List<T> entityList) {
        this.entityList = entityList;
    }

    public <R> R wrap(Function<T,R> function) {
        if (null != t) {
            return function.apply(t);
        } else return null;
    }

    public <R> R wrap() {
        if (null != t) {
            return wrapEntity(t);
        } else return null;
    }

    public <R> List<R> wrapList(Function<T,R> function) {
        if (CollectionUtils.isNotEmpty(entityList)) {
            Iterator<T> iterator = entityList.iterator();
            List<R> resList = new LinkedList<>();
            while (iterator.hasNext()) {
                resList.add(function.apply(iterator.next()));
            }
            return resList;
        } else return Collections.EMPTY_LIST;
    }

    public <R> List<R> wrapList() {
        if (CollectionUtils.isNotEmpty(entityList)) {
            Iterator<T> iterator = entityList.iterator();
            List<R> resList = new LinkedList<>();
            while (iterator.hasNext()) {
                resList.add(wrapEntity(iterator.next()));
            }
            return resList;
        } else return Collections.EMPTY_LIST;
    }

    protected abstract <R> R wrapEntity(T t);

}
