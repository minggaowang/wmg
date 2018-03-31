package com.wmg.dao;

import com.wmg.dao.common.CommonDao;
import com.wmg.web.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class BaseDao {

    @Autowired
    protected CommonDao commonDao;

    /**
     * 根据hql和分页信息获取pojo列表
     *
     * @param <T>
     * @param hql
     * @param pageIndex 当前页数
     * @param pageSize  每页记录数
     * @return
     */
    protected <T> Page<T> getPageByHqlAndPage(String hql, int pageIndex, int pageSize) {

        return getPageByHqlAndPage(hql, null, pageIndex, pageSize);
    }

    /**
     * 根据hql、查询参数及分页信息  获取pojo列表
     *
     * @param <T>
     * @param hql
     * @param params
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @SuppressWarnings("rawtypes")
    protected <T> Page<T> getPageByHqlAndPage(final String hql, final Map params, int pageIndex, int pageSize) {

        GetCountForPage getCountForPage = new GetCountForPage() {
            public int getCount() {
                int totalCount = commonDao.getCount(hql, params).intValue();//总记录数
                return totalCount;
            }
        };
        return getPageByHqlAndPage(hql, params, pageIndex, pageSize, getCountForPage);
    }

    @SuppressWarnings("rawtypes")
    protected <T> Page<T> getPageByHqlAndPage(String hql, Map params, int pageIndex, int pageSize, GetCountForPage getCountForPage) {

        pageIndex = Math.max(1, pageIndex);//页码从1开始
        int totalCount = getCountForPage.getCount();//总记录数
        int pageCount = totalCount / pageSize;//计算总页数
        if (totalCount % pageSize != 0) {

            pageCount++;
        }
        pageCount = Math.max(1, pageCount);//页码从1开始
        pageIndex = Math.min(pageIndex, pageCount);//如果请求页大于总页数,那么请求最后一页
        List<T> list = commonDao.getListByHqlAndPage(hql, params, pageIndex, pageSize);
        int countMin = (pageIndex - 1) * pageSize + 1;//下标从1开始
        int countMax = Math.min(pageIndex * pageSize, totalCount);
        Page<T> page = new Page<T>(list, totalCount, countMin, countMax, pageCount, pageSize, pageIndex);
        return page;
    }

    public static interface GetCountForPage {

        public int getCount();
    }
}






















