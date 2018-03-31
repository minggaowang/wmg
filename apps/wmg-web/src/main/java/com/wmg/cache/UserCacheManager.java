package com.wmg.cache;

import com.wmg.cache.model.CacheExpressionEnum;
import com.wmg.cache.model.CacheQueryBuilder;
import com.wmg.cache.model.CacheQueryElement;
import com.wmg.model.UserInfo;
import com.wmg.service.UserInfoService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.search.*;
import net.sf.ehcache.search.expression.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@Service
public class UserCacheManager extends CacheBaseManager implements ICacheManager {
    private static final Logger logger = LoggerFactory.getLogger(UserCacheManager.class);

    private final String CACHE_NAME = "userCache";

    @Autowired
    UserInfoService userInfoService;

    public void init() {
        List<UserInfo> userInfos = userInfoService.userList();
        if (CollectionUtils.isEmpty(userInfos)) {
            return;
        }
        for (UserInfo userInfo : userInfos) {
            this.put(userInfo.getId(), userInfo);
        }
    }

    public void put(Object key, Object value) {
        super.put(CACHE_NAME, key, value);
    }

    public <T> T get(Object key) {
        return (T) super.get(CACHE_NAME, key);
    }

    public void remove(Object key) {
        super.remove(CACHE_NAME, key);
    }

    public <T> List<T> query(Map paramsMap) {
        Cache cache = getEhCache(CACHE_NAME);
        Query query = cache.createQuery().includeValues().maxResults(500);
        List<CacheQueryElement> queryElementList = getQueryElementList(paramsMap, cache);
        Integer pageIndex = null, pageSize = null;
        if(paramsMap!=null){
            pageIndex = (Integer)paramsMap.get("pageIndex");
            pageSize = (Integer)paramsMap.get("pageSize");
        }
        Criteria criteria = CacheQueryBuilder.build(queryElementList);
        if (criteria != null) {
            query.addCriteria(criteria);
        }
        Attribute<Integer> standardCodeAttr = cache.getSearchAttribute("createTime");
        query.addOrderBy(standardCodeAttr, Direction.ASCENDING);
        Results results = null;
        List<UserInfo> resultList = new ArrayList<UserInfo>();
        try {
            results = query.execute();
            if (results.hasValues()) {
                List<Result> allList = null;
                if (pageIndex != null && pageSize != null) {
                    int startIndex = (pageIndex - 1) * pageSize;
                    allList = results.range(startIndex, pageSize);
                } else {
                    allList = results.all();
                }
                for (Result result : allList) {
                    UserInfo userInfo = (UserInfo) result.getValue();
                    resultList.add(userInfo);
                }
            }

        } catch (Exception e) {
            logger.error("query cache error", e);
        } finally {
            //释放资源
            if (results != null) {
                results.discard();
            }
        }
        return (List<T>) resultList;
    }

    public int count(Map paramsMap) {
        Cache cache = getEhCache(CACHE_NAME);
        Query query = cache.createQuery().includeValues();
        List<CacheQueryElement> queryElementList = getQueryElementList(paramsMap, cache);
        Criteria criteria = CacheQueryBuilder.build(queryElementList);
        if (criteria != null) {
            query.addCriteria(criteria);
        }
        Attribute<Integer> idAttr = cache.getSearchAttribute("id");
        query.includeAggregator(idAttr.count());
        Results results = query.execute();
        if (results.hasAggregators()) {
            List<Result> resultList = results.all();
            if (resultList != null && !resultList.isEmpty()) {
                //每一个查询结果Result中都会包含对查询结果的统计信息。
                Result result = resultList.get(0);
                //多个统计信息将会组成一个List进行返回
                List<Object> aggregatorResults = result.getAggregatorResults();
                Integer count = (Integer) aggregatorResults.get(0);
                return count;
            }
        }
        return 0;
    }

    private List<CacheQueryElement> getQueryElementList(Map paramsMap, Cache cache) {
        List<CacheQueryElement> queryElementList = new ArrayList<CacheQueryElement>();
        if (paramsMap != null) {
            Integer id = (Integer) paramsMap.get("id");
            String standardCodeEqual = (String) paramsMap.get("loginName_equal");
            String standardCodeLike = (String) paramsMap.get("loginName_like");
            Collection<Integer> idCollection = (Collection<Integer>) paramsMap.get("idCollection");
            if (id != null) {
                Attribute<Integer> attribute = cache.getSearchAttribute("id");
                queryElementList.add(new CacheQueryElement(attribute, CacheExpressionEnum.equal, id));
            }
            if (!StringUtils.isEmpty(standardCodeEqual)) {
                Attribute<String> attribute = cache.getSearchAttribute("loginName");
                queryElementList.add(new CacheQueryElement(attribute, CacheExpressionEnum.equal, standardCodeEqual));
            }
            if (!StringUtils.isEmpty(standardCodeLike)) {
                Attribute<String> attribute = cache.getSearchAttribute("loginName");
                queryElementList.add(new CacheQueryElement(attribute, CacheExpressionEnum.like, "*" + standardCodeLike + "*"));
            }
            if (!CollectionUtils.isEmpty(idCollection)) {
                Attribute<String> attribute = cache.getSearchAttribute("id");
                queryElementList.add(new CacheQueryElement(attribute, CacheExpressionEnum.in, idCollection));
            }
        }
        return queryElementList;
    }
}
