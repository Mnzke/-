package cn.fighter3.mapper;


import cn.fighter3.entity.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: ***

 * @Description: TODO
 **/

public interface ActivityMapper extends BaseMapper<Activity> {

    @Select("select * from activity where user_id = #{userId}")
    public List<Activity> selectActivity(Integer userId);

}
