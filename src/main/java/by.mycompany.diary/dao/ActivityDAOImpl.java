package by.mycompany.diary.dao;

import by.mycompany.diary.dao.ActivityDAO;
import by.mycompany.diary.entity.Activity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActivityDAOImpl implements ActivityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Activity> getActivities(int page, int limit) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Activity> theQuery = currentSession.createQuery("from Activity order by date desc", Activity.class);
        theQuery.setFirstResult(limit*page - limit);
        theQuery.setMaxResults(limit);
        List<Activity> activities = theQuery.getResultList();

        return activities;
    }

    @Override
    public void saveActivity(Activity theActivity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theActivity);
    }

    @Override
    public Activity getActivity(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Activity theActivity = currentSession.get(Activity.class, theId);
        return theActivity;
    }

    @Override
    public void deleteActivity(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Activity> theQuery = currentSession.createQuery("delete from Activity where id = :activityId");
        theQuery.setParameter("activityId", theId);
        theQuery.executeUpdate();
    }
}
