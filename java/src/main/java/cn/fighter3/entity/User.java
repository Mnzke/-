package cn.fighter3.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: ***
 * @Description: 用户实体类
 **/
@TableName(value = "user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String loginName;
    private String userName;
    private String password;
    private String sex;
    private String firstLog;
    private Integer growthPoints;
    private Integer redeemablePoints;
    private String registrationTime;

    public String getFirstLog() {
        return firstLog;
    }

    public void setFirstLog(String firstLog) {
        this.firstLog = firstLog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getGrowthPoints() {
        return growthPoints;
    }

    public void setGrowthPoints(Integer growthPoints) {
        this.growthPoints = growthPoints;
    }

    public Integer getRedeemablePoints() {
        return redeemablePoints;
    }

    public void setRedeemablePoints(Integer redeemablePoints) {
        this.redeemablePoints = redeemablePoints;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public User() {
    }

    public User(String loginName, String userName, String password, String sex, String firstLog,
                Integer growthPoints, Integer redeemablePoints, String registrationTime) {
        this.loginName = loginName;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.firstLog = firstLog;
        this.growthPoints = growthPoints;
        this.redeemablePoints = redeemablePoints;
        this.registrationTime = registrationTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", firstLog='" + firstLog + '\'' +
                ", growthPoints='" + growthPoints + '\'' +
                ", redeemablePoints='" + redeemablePoints + '\'' +
                ", registrationTime='" + registrationTime + '\'' +
                '}';
    }
}