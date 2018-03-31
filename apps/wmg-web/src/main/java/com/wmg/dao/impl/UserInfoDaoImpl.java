package com.wmg.dao.impl;


import com.wmg.dao.BaseDao;
import com.wmg.dao.UserInfoDao;
import com.wmg.dao.common.CommonDao;
import com.wmg.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by lichenzhe on 2017/2/7.
 */
@Repository
public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {

    @Autowired
    private CommonDao commonDao;

    public long create(UserInfo userInfo) {
        commonDao.save(userInfo);
        return userInfo.getId();
    }

    public <T> void update(T t) {
        commonDao.update(t);
    }

    public <T> void delete(Class<T> cla, long id) {
        commonDao.deleteById(cla,id);
    }

    public <T> T getById(Class<T> cla, long id) {
        return commonDao.getById(cla,id);
    }

    public <T> List<T> getByHqlNoParams() {
        String hql = "from UserInfo";
        return commonDao.getListByHql(hql);
    }
}
