package com.taotaotech.core.service;

import com.taotaotech.core.domain.DataEntity;
import com.taotaotech.core.persistence.Page;

import java.util.List;

public interface IBaseService<T extends DataEntity<T>> {
    public T get(Integer id);

    public T get(T entity);

    T find(T entity);

    public List<T> findList(T entity);

    public Page<T> findPage(Page<T> page, T entity);

    public int save(T entity);

    public int create(T entity);

    public int update(T entity);

    public void delete(T entity);

    public void delete(Integer[] ids);
}