package cn.fighter3.mapper;


import cn.fighter3.entity.Estimate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: ***
 * @Description: TODO
 **/

public interface EstimateMapper extends BaseMapper<Estimate> {
    @Select("select * from estimate where symptom_situation = #{situation} AND  user_id= #{userId}")
    List<Estimate> selectEstimate(Integer userId,String situation);

}
