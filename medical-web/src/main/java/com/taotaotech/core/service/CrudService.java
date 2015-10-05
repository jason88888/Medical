package com.taotaotech.core.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.core.domain.DataEntity;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Service基类
 */
@Transactional(readOnly = true)
public abstract class CrudService<D extends CrudMapper<T>, T extends DataEntity<T>> extends BaseService<T> {

    /**
     * 持久层对象
     */
    @Autowired
    protected D mapper;

    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public T get(Integer id) {
        return mapper.get(id);
    }

    /**
     * 获取单条数据
     * @param entity
     * @return
     */
    public T get(T entity) {
        return mapper.get(entity);
    }

    /**
     * 查询列表数据
     * @param entity
     * @return
     */
    public List<T> findList(T entity) {
        return mapper.findList(entity);
    }

    /**
     * 查询分页数据
     * @param page 分页对象
     * @param entity
     * @return
     */
    public Page<T> findPage(Page<T> page, T entity) {
        entity.setPage(page);
        Map map = MapUtil.bean2Map(entity);
        page.setList((PageList)mapper.findList(map, page.createPageBounds()));
        return page;
    }

    /**
     * 保存数据（插入或更新）
     * @param entity
     */
    @Transactional(readOnly = false)
    public void save(T entity) {
        if (entity.getId() != null) {
            entity.preUpdate();
            mapper.update(entity);
        } else {
            entity.preInsert();
            mapper.insertSelective(entity);
        }
    }

    /**
     * 删除数据
     * @param entity
     */
    @Transactional(readOnly = false)
    public void delete(T entity) {
        mapper.delete(entity);
    }

    /**
     * 批量删除数据
     * @param ids
     */
    @Transactional(readOnly = false)
    public void delete(Integer[] ids) {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer id : ids) {
            mapper.delete(id);
        }
    }
}
