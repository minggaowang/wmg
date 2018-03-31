package com.wmg.dao.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * 描述：通用DAO
 * @author GaoMing
 * @date 2012-11-23
 */
public interface CommonDao {
	/**
	 * 保存pojo
	 * @param <T>
	 * @param entity
	 */
	public <T> void save(T entity);
	
	/**
	 * 更新pojo
	 * @param <T>
	 * @param entity
	 */
	public <T> void update(T entity);
	
	/**
	 * 根据pojo状态 自行判断是save还是update
	 * @param <T>
	 * @param entity
	 */
	public <T> void saveOrUpdate(T entity);
	
	/**
	 * 根据id删除pojo
	 * @param <T>
	 * @param cla
	 * @param id
	 */
	public <T> void deleteById(Class<T> cla, Serializable id);
	
	/**
	 * 根据传入实体删除pojo
	 * @param <T>
	 * @param entity
	 */
	public <T> void delete(T entity);
	
	/**
	 * 删除某pojo所有数据
	 * @param <T>
	 * @param cla
	 */
	public <T> void deleteAll(Class<T> cla);
	
	/**
	 * 根据hql删除数据
	 * @param hql
	 * @return
	 */
	public int deleteByHql(String hql);
	
	/**
	 * 根据hql和查询参数删除数据
	 * @param hql
	 * @param params
	 * @return
	 */
	public int deleteByHql(String hql, Map params);
	
	/**
	 * 根据id获取pojo
	 * @param <T>
	 * @param cla
	 * @param id
	 * @return
	 */
	public <T> T getById(Class<T> cla, Serializable id);
	
	/**
	 * 根据hql和分页信息获取pojo列表
	 * @param <T>
	 * @param hql
	 * @param pageIndex	当前页数
	 * @param pageSize	每页记录数
	 * @return
	 */
	public <T> List<T> getListByHqlAndPage(String hql, int pageIndex, int pageSize);
	
	/**
	 * 根据hql、查询参数及分页信息  获取pojo列表
	 * @param <T>
	 * @param hql
	 * @param params
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public <T> List<T> getListByHqlAndPage(String hql, Map params, int pageIndex, int pageSize);
	
	/**
	 * 根据hql和查询参数获取pojo列表
	 * @param <T>
	 * @param hql
	 * @param params
	 * @return
	 */
	public <T> List<T> getListByHql(String hql, Map params);
	
	/**
	 * 根据hql获取pojo列表
	 * @param <T>
	 * @param hql
	 * @return
	 */
	public <T> List<T> getListByHql(String hql);
	
	/**
	 * 根据hql获取唯一数据
	 * @param <T>
	 * @param hql
	 * @return
	 */
	public <T> T getUniqueObjectByHql(String hql);
	
	/**
	 * 根据hql和查询参数获取唯一数据
	 * @param <T>
	 * @param hql
	 * @param params
	 * @return
	 */
	public <T> T getUniqueObjectByHql(String hql, Map params);
	
	/**
	 * 根据hql获取记录数量
	 * @param hql
	 * @return
	 */
	public Long getCount(String hql);
	
	/**
	 * 根据hql和查询参数获取记录数量
	 * @param hql
	 * @param params
	 * @return
	 */
	public Long getCount(String hql, Map params);
	
	/**
	 * 根据传入的hql和参数执行语句
	 * @param hql
	 * @param params
	 * @return 
	 */
	public int executeByHqlAndParams(String hql, Map params);
	
	/**
	 * 执行一个sql
	 * @param sql
	 * @return
	 */
	public int executeBySqlAndParams(String sql, Map params);

    public Object uniqueResult(String hql);
}
