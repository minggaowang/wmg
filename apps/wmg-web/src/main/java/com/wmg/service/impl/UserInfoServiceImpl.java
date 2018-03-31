package com.wmg.service.impl;

import com.wmg.cache.ICacheManager;
import com.wmg.dao.UserInfoDao;
import com.wmg.model.UserInfo;
import com.wmg.service.UserInfoService;
import com.wmg.web.vo.UserInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(readOnly = true)
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    ICacheManager UserCacheManager;

    @Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ)
    public long create(UserInfoVo userInfoVo) {
        UserInfo userInfo = new UserInfo();
        userInfoVo.changeToUserInfo(userInfo);
        return userInfoDao.create(userInfo);
    }

    public List<UserInfoVo> list() {
        List<UserInfoVo> userInfoVos = new ArrayList<UserInfoVo>();
        List<UserInfo> userInfos = userInfoDao.getByHqlNoParams();
        if (CollectionUtils.isEmpty(userInfos)) {
            return null;
        }
        for (UserInfo userInfo : userInfos) {
            UserInfoVo userInfoVo = new UserInfoVo();
            userInfoVo.changeToUserInfoVo(userInfo);
            userInfoVos.add(userInfoVo);
        }
        return userInfoVos;
    }

    public List<UserInfo> userList() {
        return userInfoDao.getByHqlNoParams();
    }

    public UserInfo getByLoginName(String loginName) {
        Map paramsMap = new HashMap();
        UserInfo userInfo = null;
        paramsMap.put("pageIndex", 1);
        paramsMap.put("pageSize", Integer.MAX_VALUE);
        paramsMap.put("loginName_equal", loginName);
        List<UserInfo> userInfos = UserCacheManager.query(paramsMap);
        if (CollectionUtils.isEmpty(userInfos)) {
            return null;
        }
        userInfo = userInfos.get(0);
        return userInfo;
    }

    @Cacheable(value = "userCache", key = "#id")
    public UserInfo getById(long id) {
        return userInfoDao.getById(UserInfo.class, id);
    }

    public List<UserInfo> userListAsc() {
        return UserCacheManager.query(null);
    }
}
