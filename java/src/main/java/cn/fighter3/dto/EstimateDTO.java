package cn.fighter3.dto;

/**
 * @Author ***
 * @Description 查询业务实体
 * 这里仅仅定义了三个参数，
 */
public class EstimateDTO {
    public Integer userId;//用户
    public String situation;

    public Integer getUser() {
        return userId;
    }

    public void setUser(Integer user) {
        this.userId = user;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

}
