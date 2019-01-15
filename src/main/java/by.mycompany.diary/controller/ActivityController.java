package by.mycompany.diary.controller;

import by.mycompany.diary.entity.Activity;
import static by.mycompany.diary.helper.TaskList.readTasks;
import by.mycompany.diary.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getActivities(@RequestParam("page") int page, Model theModel) {
        int limit = 10;
        List<Activity> theActivities = activityService.getActivities(page ,limit);

        theModel.addAttribute("activities", theActivities);

        return "list-activities";
    }


//    @GetMapping("/showFormForAdd")
//    public String showFormForAdd(Model theModel) {
//
//        Activity theActivity = new Activity();
//
//        theModel.addAttribute("activity", theActivity);
//
//        return "activity-form";
//    }

    @GetMapping("/showFormForAdd")
    public ModelAndView showForm() {

        ModelAndView theModelAndView = new ModelAndView("activity-form");

        Set<String> tasks = readTasks();

        theModelAndView.addObject("activityList", tasks);
        theModelAndView.addObject("activity", new Activity());

        return theModelAndView;
    }

//    @PostMapping("/saveActivity")
//    public String saveActivity(@Valid @ModelAttribute("activity") Activity theActivity, BindingResult theBindingResult) {
//
//
//        if(theBindingResult.hasErrors()) {
//            return "activity-form";
//        } else {
//            activityService.saveActivity(theActivity);
//            return "redirect:/activity/list";
//        }
//    }

    @PostMapping("/saveActivity")
    public ModelAndView saveActivity(@Valid @ModelAttribute("activity") Activity theActivity,
                                     BindingResult theBindingResult) {

        if(theBindingResult.hasErrors()) {
            ModelAndView theModelAndView = new ModelAndView("activity-form");
            Set<String> tasks = readTasks();
            theModelAndView.addObject("activityList", tasks);
            return theModelAndView;
        } else {
            activityService.saveActivity(theActivity);
            return new ModelAndView("redirect:/activity/list?page=1");
        }
    }

//    @GetMapping("/showFormForUpdate")
//    public String showFormForUpdate(@RequestParam("activityId") int theId, Model theModel) {
//        Activity theActivity = activityService.getActivity(theId);
//        theModel.addAttribute("activity", theActivity);
//        return "activity-form";
//    }

    @GetMapping("/showFormForUpdate")
    public ModelAndView showFormForUpdate(@RequestParam("activityId") int theId, Model theModel) {
        ModelAndView theModelAndView = new ModelAndView("activity-form");

        Set<String> tasks = readTasks();

        theModelAndView.addObject("activityList", tasks);

        Activity theActivity = activityService.getActivity(theId);
        theModelAndView.addObject("activity", theActivity);

        return theModelAndView;
    }

    @GetMapping("/delete")
    public String deleteActivity(@RequestParam("activityId") int theId,
                                 Model theModel) {
        activityService.deleteActivity(theId);
        return "redirect:/activity/list?page=1";
    }

}
