package com.wmg.service;


import com.wmg.model.UserInfo;
import com.wmg.web.vo.UserInfoVo;

import java.util.List;

/**
 * Created by lichenzhe on 2017/2/7.
 */
public interface UserInfoService {

    public long create(UserInfoVo user);

    public List<UserInfo> userList();

    public List<UserInfoVo> list();

    public UserInfo getByLoginName(String loginName);

    public UserInfo getById(long id);

    public List<UserInfo> userListAsc();
}
