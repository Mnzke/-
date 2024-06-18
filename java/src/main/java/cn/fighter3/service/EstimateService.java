package cn.fighter3.service;

import cn.fighter3.dto.EstimateDTO;
import cn.fighter3.entity.Estimate;
import cn.fighter3.entity.User;

import java.util.List;

/**
 * @Author ***
 * @Description
 */
public interface EstimateService {
    List<Estimate> selectEstimate(EstimateDTO estimateDTO);

    Integer addEstimate(Estimate estimate);

    Integer updateEstimate(Estimate estimate);

    Integer deleteEstimate(Integer id);


}
