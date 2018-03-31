package com.wmg.dao;

import com.wmg.model.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by lichenzhe on 2017/2/7.
 */
public interface UserInfoDao {

    //创建用户
    public long create(UserInfo userInfo);

    //更新用户
    public <T> void update(T t);

    //删除用户
    public <T> void delete(Class<T> cla, long id);

    //根据id获取用户
    public  <T> T  getById(Class<T> cla, long id);

    public <T> List<T> getByHqlNoParams();
}
