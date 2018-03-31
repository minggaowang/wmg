package com.wmg.service;


import com.wmg.model.UserInfo;
import com.wmg.web.vo.UserInfoVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext-*.xml"})
public class UserInfoServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceTest.class);

    @Autowired
    UserInfoService userInfoService;

    @Test
    public void createTest() {
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setLoginName(UUID.randomUUID().toString().replaceAll("-", ""));
        userInfoVo.setPassword("111111");
        Long id = userInfoService.create(userInfoVo);
        logger.info(id + "");
    }

    @Test
    public void getById(){
        List<UserInfoVo> userInfoVoList = userInfoService.list();
        if(CollectionUtils.isEmpty(userInfoVoList)){
            return;
        }
        for(UserInfoVo userInfoVo : userInfoVoList){
            if(StringUtils.isEmpty(userInfoService.getById(userInfoVo.getId()))){
                return;
            }
            logger.info(userInfoVo.toString());
        }
    }

    @Test
    public void getByLoginName(){
        List<UserInfoVo> userInfoVoList = userInfoService.list();
        if(CollectionUtils.isEmpty(userInfoVoList)){
            return;
        }
        for(UserInfoVo userInfoVo : userInfoVoList){
            if(!StringUtils.isEmpty(userInfoService.getByLoginName(userInfoVo.getLoginName()))){
                logger.info(userInfoVo.toString());
            }
        }
    }

    @Test
    public void userListAsc(){
        List<UserInfo> userInfos =  userInfoService.userListAsc();
        if(CollectionUtils.isEmpty(userInfos)){
            return;
        }
        for(UserInfo userInfo : userInfos){
            UserInfoVo userInfoVo = new UserInfoVo();
            userInfoVo.changeToUserInfoVo(userInfo);
            logger.info(userInfoVo.toString());
        }
    }
}
