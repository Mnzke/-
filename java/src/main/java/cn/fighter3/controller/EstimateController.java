package cn.fighter3.controller;

import cn.fighter3.dto.EstimateDTO;
import cn.fighter3.entity.Estimate;
import cn.fighter3.result.Result;
import cn.fighter3.service.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ***
 * @Description 评估管理
 */
@RestController
public class EstimateController {
    @Autowired
    public EstimateService estimateService;
    /**
     * 选出用户的评估数据
     * @param
     * @return
     */
    @RequestMapping("/api/estimatest")
    public Result selectEstimate(@RequestBody EstimateDTO estimateDTO){
        return new Result(200,"",estimateService.selectEstimate(estimateDTO));
    }
    /**
     * 添加
     * @param estimate
     * @return
     */
    @RequestMapping("/api/estimate/add")
    public Result addEstimate(@RequestBody Estimate estimate){
        return new Result(200,"",estimateService.addEstimate(estimate));
    }

    /**
     * 更新
     * @param estimate
     * @return
     */
    @RequestMapping("/api/estimate/update")
    public Result updateEstimate(@RequestBody Estimate estimate){
        return new Result(200,"",estimateService.updateEstimate(estimate));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/api/estimate/delete")
    public Result deleteEstimate(Integer id){
        return new Result(200,"",estimateService.deleteEstimate(id));
    }
}

