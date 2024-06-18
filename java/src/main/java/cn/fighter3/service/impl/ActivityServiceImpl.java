package cn.fighter3.service.impl;

import cn.fighter3.dto.ActivityDTO;
import cn.fighter3.entity.Activity;
import cn.fighter3.mapper.ActivityMapper;
import cn.fighter3.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ***
 * @Date 2023/6/4
 * @Description
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;


    @Override
    public List<Activity> selectActivity(ActivityDTO activityDTO) {
        return activityMapper.selectActivity(activityDTO.getUser());
    }

    @Override
    public Integer addActivity(Activity activity) {
        return activityMapper.insert(activity);
    }

    @Override
    public Integer updateActivity(Activity activity) {
        return activityMapper.updateById(activity);
    }

    @Override
    public Integer deleteActivity(Integer id) {
        return activityMapper.deleteById(id);
    }
}
