package com.wmg.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 初始化所有实现ICacheManager接口的缓存
 * 顺序进行缓存，以免系统启动时压力过大
 * Created by gaoming on 2018/2/1.
 */
@Service
public class CacheInitManager {

    @Autowired
    private List<ICacheManager> cacheManagerList;

    @PostConstruct
    public void initAll(){
        for(ICacheManager cacheManager : cacheManagerList){
            cacheManager.init();
        }
    }
}
