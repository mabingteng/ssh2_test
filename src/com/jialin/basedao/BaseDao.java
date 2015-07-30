package com.jialin.basedao;

import java.util.List;

public interface BaseDao<T> {
    /**
     * 增加实体
     * @param t
     */
    public void add(T t);
    
    /**
     * 删除
     * @param id
     */
    public void delete(T t);
    
    /**
     * 修改
     * @param id
     */
    public void update(T t);
    
    /**
     * 查询所有
     * @return
     */
    public List<T> findAll();
    /**
     * 查询一个
     * @param id
     * @return
     */
    public T getbyId(long id);
    
    /**
     * 根据hql语句获得list
     */
    public List<T> getByHql(String Hql);
}
