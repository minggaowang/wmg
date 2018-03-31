package com.wmg.cache.model;

/**
 * 缓存查询所支持的表达式
 * Created by gaoming on 2018/2/2.
 */
public enum CacheExpressionEnum {

    between("属性值在给定的范围之间"),
    in("在给定的集合之中"),
    notEqual("不等于给定的值"),
    equal("等于给定的值"),
    lessThan("小于给定的值"),
    lessEqual("小于或等于给定的值"),
    greaterThan("大于给定的值"),
    greaterEqual("大于或等于给定的值"),
    like("匹配给定的表达式，表达式中可以使用“*”来代表任意多个字符，使用“？”来代表任意一个字符"),
    notLike("不匹配给定的表达式"),
    isNull("等于null"),
    isNotNull("不等于null");

    private String desc;

    private CacheExpressionEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
