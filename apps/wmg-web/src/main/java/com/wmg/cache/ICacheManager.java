package com.wmg.cache;


import java.util.List;
import java.util.Map;

/**
 * 缓存接口
 * 所有使用框架类缓存的类，都需要实现该接口
 * 目前使用的第三方缓存为EhCache
 * 该接口隐藏了具体的缓存对象，因为外层不必关心
 * 因此，在使用时，请注意所使用的实现类是什么
 * Created by gaoming on 2018/2/1.
 */
public interface ICacheManager {

    /**
     * 缓存初始化
     * 用于系统启动时的自动调用，将数据库中的信息缓存在内存中
     * 该方法会在CacheInitManager中进行调用
     * 如其他地方有初始化需求，也可调用
     */
    public void init();

    /**
     * 手动将k-v对象放置在缓存中
     * 其实也可以使用Spring的@Cacheable或@CachePut
     * @param key 缓存key
     * @param value 缓存值
     *
     */
    public void put(Object key, Object value);

    /**
     * 根据key，获取缓存值
     * 也可使用Spring的@Cacheable
     * @param key 缓存key
     * @return 缓存值
     */
    public <T> T get(Object key);

    /**
     * 根据key 清除缓存值
     * 也可使用Spring的@CacheEvict
     * @param key 删除的缓存key
     */
    public void remove(Object key);

    /**
     * 对缓存进行查询
     * 对于EhCache，可以像sql一样查询缓存的key或value，及其属性对象
     * @param paramsMap 查询条件
     * @param <T> 返回泛型列表
     * @return 返回泛型列表
     */
    public <T> List<T> query(Map paramsMap);

    /**
     * 返回查询记录数，主要用于分页
     * @param paramsMap
     * @return
     */
    public int count(Map paramsMap);

}
