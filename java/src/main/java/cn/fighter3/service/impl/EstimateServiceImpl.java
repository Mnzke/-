package cn.fighter3.service.impl;

import cn.fighter3.dto.EstimateDTO;
import cn.fighter3.entity.Estimate;
import cn.fighter3.mapper.EstimateMapper;
import cn.fighter3.service.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ***
 * @Date 2023/6/4
 * @Description
 */
@Service
public class EstimateServiceImpl implements EstimateService {
    @Autowired
    private EstimateMapper estimateMapper;


    @Override
    public List<Estimate> selectEstimate(EstimateDTO estimateDTO) {
        return estimateMapper.selectEstimate(estimateDTO.getUser(),estimateDTO.getSituation());
    }

    @Override
    public Integer addEstimate(Estimate estimate) {
        return estimateMapper.insert(estimate);
    }

    @Override
    public Integer updateEstimate(Estimate estimate) {
        return estimateMapper.updateById(estimate);
    }

    @Override
    public Integer deleteEstimate(Integer id) {
        return estimateMapper.deleteById(id);
    }
}
