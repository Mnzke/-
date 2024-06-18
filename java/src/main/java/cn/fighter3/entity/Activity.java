package cn.fighter3.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: ***
 * @Description: 用户实体类
 **/
@TableName(value = "activity")
public class Activity {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer outpatient;
    private Integer extension;
    private Integer science;
    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOutpatient() {
        return outpatient;
    }

    public void setOutpatient(Integer outpatient) {
        this.outpatient = outpatient;
    }

    public Integer getExtension() {
        return extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }

    public Integer getScience() {
        return science;
    }

    public void setScience(Integer science) {
        this.science = science;
    }

    public Activity() {
    }

    public Activity(Integer userId, Integer outpatient, Integer extension, Integer science, String createTime) {
        this.userId = userId;
        this.outpatient = outpatient;
        this.extension = extension;
        this.science = science;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", userId=" + userId +
                ", outpatient=" + outpatient +
                ", extension=" + extension +
                ", science=" + science +
                ", createTime=" + createTime +
                '}';
    }

}
