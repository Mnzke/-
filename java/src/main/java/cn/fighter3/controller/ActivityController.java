package cn.fighter3.controller;

import cn.fighter3.dto.ActivityDTO;
import cn.fighter3.dto.EstimateDTO;
import cn.fighter3.entity.Activity;
import cn.fighter3.entity.Estimate;
import cn.fighter3.result.Result;
import cn.fighter3.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ***
 * @Description 活动管理
 */
@RestController
public class ActivityController {
    @Autowired
    public ActivityService activityService;
    /**
     * 选出用户的评估数据
     * @param activityDTO
     * @return
     */
    @RequestMapping("/api/activityst")
    public Result selectActivity(@RequestBody ActivityDTO activityDTO){
        return new Result(200,"",activityService.selectActivity(activityDTO));
    }
    /**
     * 添加
     * @param activity
     * @return
     */
    @RequestMapping("/api/activity/add")
    public Result addActivity(@RequestBody Activity activity){
        return new Result(200,"",activityService.addActivity(activity));
    }

    /**
     * 更新
     * @param activity
     * @return
     */
    @RequestMapping("/api/activity/update")
    public Result updateActivity(@RequestBody Activity activity){
        return new Result(200,"",activityService.updateActivity(activity));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/api/activity/delete")
    public Result deleteActivity(Integer id){
        return new Result(200,"",activityService.deleteActivity(id));
    }
}
