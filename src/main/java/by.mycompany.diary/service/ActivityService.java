package by.mycompany.diary.service;


import by.mycompany.diary.entity.Activity;

import java.util.List;

public interface ActivityService {

    public List<Activity> getActivities(int page, int limit);

    public void saveActivity(Activity theActivity);

    public Activity getActivity(int theId);

    public void deleteActivity(int theId);
}
