package cn.fighter3.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: ***
 * @Description: 评估实体类
 **/
@TableName(value = "estimate")
public class Estimate {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String symptomDescription;
    private String symptomSituation;
    private String updateTime;

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

    public String getSymptomDescription() {
        return symptomDescription;
    }

    public void setSymptomDescription(String symptomDescription) {
        this.symptomDescription = symptomDescription;
    }

    public String getSymptomSituation() {
        return symptomSituation;
    }

    public void setSymptomSituation(String symptomSituation) {
        this.symptomSituation = symptomSituation;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Estimate() {
    }

    public Estimate(Integer userId, String symptomDescription, String symptomSituation, String updateTime) {
        this.userId = userId;
        this.symptomDescription = symptomDescription;
        this.symptomSituation = symptomSituation;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Estimate{" +
                "id=" + id +
                ", userId=" + userId +
                ", symptomDescription='" + symptomDescription + '\'' +
                ", symptomSituation='" + symptomSituation + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

}