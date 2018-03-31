package com.wmg.web.vo;

import com.wmg.model.UserInfo;
import org.apache.commons.beanutils.BeanUtils;

public class UserInfoVo {
    private long id;

    //登录名
    private String loginName;

    //显示名
    private String displayName;

    //密码（MD5加密）
    private String password;

    //手机
    private String mobilePhone;

    //联系人
    private String userName;

    //代理商
    private String agent;

    //产品配送地址省
    private String productionProvince;

    //产品配送地址市
    private String productionCity;

    //产品配送地址
    private String productionAddress;

    //用户地域联系省
    private String province;

    //用户地域联系城市
    private String city;

    //用户地域联系地址
    private String address;

    //用户行业
    private String business;

    //用户邮箱
    private String userEmail;

    //用户单位名称
    private String company;

    //角色
    private int role;

    //产品类型
    private String production;

    //头像
    private String photo;

    //备注
    private String remark;

    //状态  0正常，1删除
    private int status;

    //监控管家用户号
    private String userNo;

    //代理商的入口状态位 1:特殊代理商 2:dls账号创建
    private String agentStatus;

    //申请时间
    private long applyTime;

    //创建时间
    private long createTime;

    public UserInfoVo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getProductionProvince() {
        return productionProvince;
    }

    public void setProductionProvince(String productionProvince) {
        this.productionProvince = productionProvince;
    }

    public String getProductionCity() {
        return productionCity;
    }

    public void setProductionCity(String productionCity) {
        this.productionCity = productionCity;
    }

    public String getProductionAddress() {
        return productionAddress;
    }

    public void setProductionAddress(String productionAddress) {
        this.productionAddress = productionAddress;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getAgentStatus() {
        return agentStatus;
    }

    public void setAgentStatus(String agentStatus) {
        this.agentStatus = agentStatus;
    }

    public long getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(long applyTime) {
        this.applyTime = applyTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", password='" + password + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", userName='" + userName + '\'' +
                ", agent='" + agent + '\'' +
                ", productionProvince='" + productionProvince + '\'' +
                ", productionCity='" + productionCity + '\'' +
                ", productionAddress='" + productionAddress + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", business='" + business + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", company='" + company + '\'' +
                ", role=" + role +
                ", production='" + production + '\'' +
                ", photo='" + photo + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", userNo='" + userNo + '\'' +
                ", agentStatus='" + agentStatus + '\'' +
                ", applyTime=" + applyTime +
                ", createTime=" + createTime +
                '}';
    }

    public void changeToUserInfo(UserInfo info ){
        try {
            BeanUtils.copyProperties(info,this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void changeToUserInfoVo(UserInfo userInfo){
        try {
            BeanUtils.copyProperties(this,userInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
