package cn.fighter3.service;

import cn.fighter3.dto.ActivityDTO;
import cn.fighter3.entity.Activity;

import java.util.List;

/**
 * @Author ***

 * @Description
 */
public interface ActivityService {
    List<Activity> selectActivity(ActivityDTO activityDTO);

    Integer addActivity(Activity activity);

    Integer updateActivity(Activity activity);

    Integer deleteActivity(Integer id);
}
