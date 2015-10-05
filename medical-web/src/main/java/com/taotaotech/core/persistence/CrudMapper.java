/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.taotaotech.core.persistence;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;
import java.util.Map;

/**
 * DAO支持类实现
 * @param <T>
 */
public interface CrudMapper<T> extends BaseMapper {

	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(Integer id);
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T get(T entity);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(entity, page.createPageBounds());
     * @param entity
     * @return
     */
    @Deprecated
	public List<T> findList(T entity);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(entity, page.createPageBounds());
     * @param entity
     * @param pageBounds
     * @return
     */
    @Deprecated
	public List<T> findList(T entity, PageBounds pageBounds);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(map, page.createPageBounds());
     * @param map
     * @param pageBounds
     * @return
     */
	public List<T> findList(Map map, PageBounds pageBounds);

	/**
	 * 查询所有数据列表
	 * @param entity
	 * @return
	 */
	public List<T> findAllList(T entity);
	
	/**
	 * 查询所有数据列表
	 * @see public List<T> findAllList(T entity)
	 * @return
	 */
	@Deprecated
	public List<T> findAllList();
	
	/**
	 * 插入数据
	 * @param entity
	 * @return
	 */
	public int insert(T entity);
	
	/**
	 * 更新数据
	 * @param entity
	 * @return
	 */
	public int update(T entity);
	
	/**
	 * 删除数据（一般为逻辑删除，更新del_flag字段为1）
	 * @param id
	 * @see public int delete(T entity)
	 * @return
	 */
	@Deprecated
	public int delete(Integer id);
	
	/**
	 * 删除数据（一般为逻辑删除，更新del_flag字段为1）
	 * @param entity
	 * @return
	 */
	public int delete(T entity);
	
}