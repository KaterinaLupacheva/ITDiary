package by.mycompany.diary.service;


import by.mycompany.diary.dao.ActivityDAO;
import by.mycompany.diary.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDAO activityDAO;

    @Override
    @Transactional
    public List<Activity> getActivities(int page, int limit) {
        return activityDAO.getActivities(page, limit);
    }

    @Override
    @Transactional
    public void saveActivity(Activity theActivity) {
        activityDAO.saveActivity(theActivity);
    }

    @Override
    @Transactional
    public Activity getActivity(int theId) {
        return activityDAO.getActivity(theId);
    }

    @Override
    @Transactional
    public void deleteActivity(int theId) {
        activityDAO.deleteActivity(theId);
    }
}
