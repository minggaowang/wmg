package com.wmg.cache.model;

import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.expression.Criteria;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * 拼装缓存查询表达式的工具类
 * Created by gaoming on 2018/2/2.
 */
public class CacheQueryBuilder {

    public static Criteria build(List<CacheQueryElement> elements) {
        if (CollectionUtils.isEmpty(elements)) {
            return null;
        }
        Criteria criteria = null;
        for (int i = 0; i < elements.size(); i++) {
            CacheQueryElement element = elements.get(i);
            if (i == 0) {
                criteria = getCriteria(element);
            } else {
                //目前仅支持and
                criteria = criteria.and(getCriteria(element));
            }
        }
        return criteria;
    }

    private static Criteria getCriteria(CacheQueryElement element) {
        Attribute attribute = element.getAttribute();
        CacheExpressionEnum expressionEnum = element.getExpression();
        Criteria criteria = null;
        switch (expressionEnum) {
            case equal:
                criteria = attribute.eq(element.getValue1());
                break;
            case between:
                criteria = attribute.between(element.getValue1(),element.getValue2());
                break;
            case lessEqual:
                criteria = attribute.le(element.getValue1());
                break;
            case in:
                criteria = attribute.in((Collection) element.getValue1());
                break;
            case notEqual:
                criteria = attribute.ne(element.getValue1());
                break;
            case lessThan:
                criteria = attribute.lt(element.getValue1());
                break;
            case greaterThan:
                criteria = attribute.gt(element.getValue1());
                break;
            case greaterEqual:
                criteria = attribute.ge(element.getValue1());
                break;
            case like:
                criteria = attribute.ilike((String)element.getValue1());
                break;
            case notLike:
                criteria = attribute.notIlike((String)element.getValue1());
                break;
            case isNull:
                criteria = attribute.isNull();
                break;
            case isNotNull:
                criteria = attribute.notNull();
                break;
            default:
                break;
        }
        return criteria;
    }
}
