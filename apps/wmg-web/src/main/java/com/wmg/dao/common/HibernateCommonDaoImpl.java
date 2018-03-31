package com.wmg.dao.common;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * 描述：通用DAO实现
 * @author GaoMing
 * @date 2012-11-23
 */
@Repository
public class HibernateCommonDaoImpl implements CommonDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public <T> void save(T entity) {

		getCurrentSession().save(entity);
	}

	public <T> void update(T entity) {

        try {
            getCurrentSession().update(entity);
        } catch (Exception e) {
            getCurrentSession().clear();
            getCurrentSession().update(entity);
        }
    }

	public <T> void saveOrUpdate(T entity){
		getCurrentSession().saveOrUpdate(entity);
	}

	public <T> void deleteById(Class<T> cla, Serializable id) {
		Object obj = getById(cla, id);
		delete(obj);
	}

	public <T> void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public <T> T getById(Class<T> cla, Serializable id) {
		return (T) getCurrentSession().get(cla, id);
	}

	public <T> List<T> getListByHqlAndPage(final String hql, final Map params,
			final int pageIndex, final int pageSize) {
		Query query = getCurrentSession().createQuery(hql);
		setQueryParameters(params, query);
		setPagination(pageSize, pageIndex, query);
		return (List<T>) query.list();
	}

	public <T> List<T> getListByHql(String hql) {
		return (List<T>)getListByHql(hql, null);
	}

	public <T> List<T> getListByHql(String hql, Map params) {
		return (List<T>)getListByHqlAndPage(hql, params, 1, Integer.MAX_VALUE);
	}

	public <T> void deleteAll(Class<T> cla) {
		String hql = "delete from " + cla.getName();
		getCurrentSession().createQuery(hql).executeUpdate();
	}

	public int deleteByHql(final String hql) {
		return deleteByHql(hql, null);
	}

	public int deleteByHql(final String hql, final Map params) {
		Query query = getCurrentSession().createQuery("delete " + hql);
		setQueryParameters(params, query);
		int amount = query.executeUpdate();
		return amount;
	}

	public <T> List<T> getListByHqlAndPage(String hql, int pageIndex,
			int pageSize) {
		return (List<T>)getListByHqlAndPage(hql, null, pageIndex, pageSize);
	}

	public <T> T getUniqueObjectByHql(final String hql) {
		return (T)getUniqueObjectByHql(hql, null);
	}

	public <T> T getUniqueObjectByHql(final String hql, final Map params) {
		Query query = getCurrentSession().createQuery(hql);
		query.setMaxResults(1);
		setQueryParameters(params, query);
		return (T) query.uniqueResult();
	}

	public Long getCount(String hql) {
		return getCount(hql, null);
	}

	public Long getCount(final String hql, final Map params) {
		final String hql_ = formQueryCountHql(hql);
		Query query = getCurrentSession().createQuery(hql_);
		setQueryParameters(params, query);
		Object obj = query.uniqueResult();
		return (Long) obj;
	}

	protected Session getCurrentSession() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (Exception e) {
            session = sessionFactory.openSession();
        }

		return session;
	}

	private void setQueryParameters(final Map params, Query query) {
		if (params != null) {
			Iterator it = params.keySet().iterator();
			String name = null;
			Object value = null;
			while (it.hasNext()) {
				name = (String) it.next();
				value = params.get(name);
				if (value instanceof Collection) {
					query.setParameterList(name, (Collection) value);
				} else if (value instanceof Object[]) {
					query.setParameterList(name, (Object[]) value);
				} else {
					query.setParameter(name, value);
				}
			}
		}
	}

	private void setPagination(final int pageSize, int curPageInx, Query query) {
		if (curPageInx < 1)
			curPageInx = 1;
		query.setFirstResult((curPageInx - 1) * pageSize);
		query.setMaxResults(pageSize);
	}

	/**
	 * 将hql改写为查询总数的hql
	 *
	 * @param hql
	 * @return
	 */
	private String formQueryCountHql(String hql) {
		String tmpHql = hql.toLowerCase();
        int indexOfOrderBy = tmpHql.indexOf("order by");
        if (indexOfOrderBy >= 0){
            hql = hql.substring(0, indexOfOrderBy);
        }
		if (!tmpHql.startsWith("select")) {
			hql = "select count(*) " + hql;
		} else {
            hql = hql.substring(tmpHql.indexOf(" from "));
			hql = "select count(*) " + hql;
		}
		return hql;
	}

	public int executeByHqlAndParams(String hql, Map params) {
		Query query = getCurrentSession().createQuery(hql);
		setQueryParameters(params, query);
		return query.executeUpdate();
	}

	public int executeBySqlAndParams(String sql, Map params) {
		Query query = getCurrentSession().createSQLQuery(sql);
		setQueryParameters(params, query);
		return query.executeUpdate();
	}

    private Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (Exception e) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public Object uniqueResult(String hql) {
        return getSession().createQuery(hql).uniqueResult();
    }
}
