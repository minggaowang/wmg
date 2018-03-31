package com.wmg.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

/**
 * Created by gaoming on 2018/2/1.
 */
public abstract class CacheBaseManager {

    @Autowired
    private EhCacheCacheManager ehcacheManager;

    public void put(String cacheName,Object key,Object value){
        Cache cache = ehcacheManager.getCache(cacheName);
        cache.put(key,value);
    }

    public Object get(String cacheName,Object key){
        Cache cache = ehcacheManager.getCache(cacheName);
        return cache.get(key);
    }

    public void remove(String cacheName,Object key){
        Cache cache = ehcacheManager.getCache(cacheName);
        cache.evict(key);
    }

    public net.sf.ehcache.Cache getEhCache(String cacheName){
        return (net.sf.ehcache.Cache)ehcacheManager.getCache(cacheName).getNativeCache();
    }
}
