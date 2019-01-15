package by.mycompany.diary.aspect;

import by.mycompany.diary.entity.Activity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Aspect
@Component
public class DateFormatAspect {

    @AfterReturning(pointcut = "execution(* by.mycompany.diary.service.ActivityServiceImpl.getActivities(..))",
            returning = "result")
    public void afterReturningListOfActivities(JoinPoint theJoinPoint, List<Activity> result) {
//        System.out.println("\n\nAfter getting list of Activities result is : " + result);

        plusOneDay(result);

//        System.out.println("\n\nAfter formatting " + result);
    }

    private void plusOneDay(List<Activity> result) {
        for (Activity tempActivity : result) {
            LocalDate theDate =tempActivity.getDate().plusDays(1);
            tempActivity.setDate(theDate);
        }
    }

    @AfterReturning(pointcut = "execution(* by.mycompany.diary.service.ActivityServiceImpl.getActivity(..))",
            returning = "result")
    public void afterReturningActivity(JoinPoint theJoinPoint, Activity result) {
        LocalDate theDate = result.getDate().plusDays(1);
        result.setDate(theDate);
    }


}
