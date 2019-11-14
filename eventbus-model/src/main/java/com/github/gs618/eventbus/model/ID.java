package com.github.gs618.eventbus.model;

import java.io.Serializable;

/**
 * @author s.c.gao
 */
public interface ID<T> extends Serializable {

    /**
     * 设置ID
     *
     * @return ID对象
     */
    T getId();

    /**
     * 设置ID
     *
     * @param t id
     * @return ID对象
     */
    ID setId(T t);

}
