package com.wmg.cache.model;

import net.sf.ehcache.search.Attribute;

/**
 * 缓存查询条件拼装，一个对象为一个条件，可拼装多个
 * 多个条件之间暂时仅支持and查询
 * Created by gaoming on 2018/2/2.
 */
public class CacheQueryElement {

    /**
     * 查询属性
     */
    private Attribute attribute;

    /**
     * 比较表达式
     */
    private CacheExpressionEnum expression;

    /**
     * 值1
     * 如果是单值表达式，则将值放在这里
     * 如果是like或notlike，需确保值类型为string
     * 如果是in，则确保值类型为Collection
     */
    private Object value1;

    /**
     * 值2
     * 仅在between中有用
     */
    private Object value2;

    public CacheQueryElement(){}

    public CacheQueryElement(Attribute attribute, CacheExpressionEnum expression, Object value1) {
        this.attribute = attribute;
        this.expression = expression;
        this.value1 = value1;
    }

    public CacheQueryElement(Attribute attribute, CacheExpressionEnum expression, Object value1, Object value2) {
        this.attribute = attribute;
        this.expression = expression;
        this.value1 = value1;
        this.value2 = value2;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public CacheExpressionEnum getExpression() {
        return expression;
    }

    public void setExpression(CacheExpressionEnum expression) {
        this.expression = expression;
    }

    public Object getValue1() {
        return value1;
    }

    public void setValue1(Object value1) {
        this.value1 = value1;
    }

    public Object getValue2() {
        return value2;
    }

    public void setValue2(Object value2) {
        this.value2 = value2;
    }
}
