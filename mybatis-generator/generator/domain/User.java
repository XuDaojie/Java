package io.github.xudaojie.templates.generator.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xdj
 * @since 2019-04-24
 */
@TableName("news_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * APP下载渠道
     */
    private String appChannel;

    /**
     * 绑定后指向的主账号用户ID。默认0，代表未被绑定到其它账号下
     */
    private Long referId;

    /**
     * 第三方登陆用户 ID
     */
    private String socialUid;

    /**
     * 第三方登陆用户的令牌
     */
    private String socialToken;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户真实姓名
     */
    private String realname;

    /**
     * 身份证号码
     */
    private String identityCard;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 客户端唯一标识号
     */
    private String uuid;

    /**
     * 推送的令牌
     */
    private String pushToken;

    /**
     * 性别(0->男, 1->女)
     */
    private Integer sex;

    /**
     * 用户生日
     */
    private LocalDate birthday;

    /**
     * 设备来源(1->iPhone, 2->Android, 3->H5)
     */
    private Integer source;

    /**
     * 注册来源(1->eds, 2->微信, 8->QQ, 4->微博)
     */
    private Long socialSource;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 经度
     */
    private Float lng;

    /**
     * 纬度
     */
    private Float lat;

    /**
     * 省
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtUpdate;

    /**
     * 用户状态 0.无效用户 1.普通用户 2.认证中 3.爱豆号认证 4.黑名单用户 5.嫌疑用户 6.爱豆号认证不通过
     */
    private Integer status;

    /**
     * 标记每次活动产生的用户，如20170304
     */
    private Long activityCode;

    /**
     * 账号合并/解绑后最新状态, 默认0
     */
    private Integer accountStatus;

    /**
     * 设备等信息
     */
    private String deviceInfo;

    /**
     * 自我介绍
     */
    private String introduction;

    /**
     * 当前用户邀请码，根据userId自定义进制生成
     */
    private String inviteCode;

    /**
     * 存储用户登录token
     */
    private String token;

    /**
     * 身份证照片
     */
    private String identityPic;

    /**
     * 是否风险检测过 0.没有 1.有
     */
    private Boolean isIdentify;

    /**
     * 用户类型（0 : 默认，1：个人，2：媒体，3：国家机构，4：企业，5：其他组织）
     */
    private Long userType;

    /**
     * 用户名称更新时间
     */
    private LocalDateTime unameUptime;

    /**
     * 存储PC用户登录token
     */
    private String tokenPc;

    /**
     * 爱豆号自媒体用户邮箱注册是使用
     */
    private String emailAccounts;

    /**
     * 用户介绍更新时间
     */
    private LocalDateTime introUptime;

    /**
     * 用户头像更新时间
     */
    private LocalDateTime avatarUptime;

    /**
     * 是否修改个人资料 0.没有 1.有
     */
    private Boolean isModify;

    /**
     * 注册类型  0手机注册，1邮箱注册
     */
    private Boolean registerType;

    /**
     * 专注领域 0=默认、1=娱乐、2=美食、3=情感、4=财经、5=影视、6=体育、7=搞笑、8=奇闻、
9=汽车、10=旅游、11=动漫游戏、12=宠物、13=户外运动、14=生活方式、15=小说、16=其它
     */
    private Integer focusAreas;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppChannel() {
        return appChannel;
    }

    public void setAppChannel(String appChannel) {
        this.appChannel = appChannel;
    }

    public Long getReferId() {
        return referId;
    }

    public void setReferId(Long referId) {
        this.referId = referId;
    }

    public String getSocialUid() {
        return socialUid;
    }

    public void setSocialUid(String socialUid) {
        this.socialUid = socialUid;
    }

    public String getSocialToken() {
        return socialToken;
    }

    public void setSocialToken(String socialToken) {
        this.socialToken = socialToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Long getSocialSource() {
        return socialSource;
    }

    public void setSocialSource(Long socialSource) {
        this.socialSource = socialSource;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(LocalDateTime gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(Long activityCode) {
        this.activityCode = activityCode;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdentityPic() {
        return identityPic;
    }

    public void setIdentityPic(String identityPic) {
        this.identityPic = identityPic;
    }

    public Boolean getIdentify() {
        return isIdentify;
    }

    public void setIdentify(Boolean isIdentify) {
        this.isIdentify = isIdentify;
    }

    public Long getUserType() {
        return userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    public LocalDateTime getUnameUptime() {
        return unameUptime;
    }

    public void setUnameUptime(LocalDateTime unameUptime) {
        this.unameUptime = unameUptime;
    }

    public String getTokenPc() {
        return tokenPc;
    }

    public void setTokenPc(String tokenPc) {
        this.tokenPc = tokenPc;
    }

    public String getEmailAccounts() {
        return emailAccounts;
    }

    public void setEmailAccounts(String emailAccounts) {
        this.emailAccounts = emailAccounts;
    }

    public LocalDateTime getIntroUptime() {
        return introUptime;
    }

    public void setIntroUptime(LocalDateTime introUptime) {
        this.introUptime = introUptime;
    }

    public LocalDateTime getAvatarUptime() {
        return avatarUptime;
    }

    public void setAvatarUptime(LocalDateTime avatarUptime) {
        this.avatarUptime = avatarUptime;
    }

    public Boolean getModify() {
        return isModify;
    }

    public void setModify(Boolean isModify) {
        this.isModify = isModify;
    }

    public Boolean getRegisterType() {
        return registerType;
    }

    public void setRegisterType(Boolean registerType) {
        this.registerType = registerType;
    }

    public Integer getFocusAreas() {
        return focusAreas;
    }

    public void setFocusAreas(Integer focusAreas) {
        this.focusAreas = focusAreas;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", appChannel=" + appChannel +
        ", referId=" + referId +
        ", socialUid=" + socialUid +
        ", socialToken=" + socialToken +
        ", name=" + name +
        ", nickname=" + nickname +
        ", realname=" + realname +
        ", identityCard=" + identityCard +
        ", mobile=" + mobile +
        ", email=" + email +
        ", password=" + password +
        ", uuid=" + uuid +
        ", pushToken=" + pushToken +
        ", sex=" + sex +
        ", birthday=" + birthday +
        ", source=" + source +
        ", socialSource=" + socialSource +
        ", avatar=" + avatar +
        ", lng=" + lng +
        ", lat=" + lat +
        ", province=" + province +
        ", city=" + city +
        ", area=" + area +
        ", gmtCreate=" + gmtCreate +
        ", gmtUpdate=" + gmtUpdate +
        ", status=" + status +
        ", activityCode=" + activityCode +
        ", accountStatus=" + accountStatus +
        ", deviceInfo=" + deviceInfo +
        ", introduction=" + introduction +
        ", inviteCode=" + inviteCode +
        ", token=" + token +
        ", identityPic=" + identityPic +
        ", isIdentify=" + isIdentify +
        ", userType=" + userType +
        ", unameUptime=" + unameUptime +
        ", tokenPc=" + tokenPc +
        ", emailAccounts=" + emailAccounts +
        ", introUptime=" + introUptime +
        ", avatarUptime=" + avatarUptime +
        ", isModify=" + isModify +
        ", registerType=" + registerType +
        ", focusAreas=" + focusAreas +
        "}";
    }
}
