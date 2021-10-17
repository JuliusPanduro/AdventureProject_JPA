package edu.kea.adventure_project.controllers;

import edu.kea.adventure_project.models.Activity;
import edu.kea.adventure_project.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author Julius Panduro
 */
@Controller
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @GetMapping("/")
    public String index(Model model) {
        List<Activity> activityList = activityService.readAllActivities();
        model.addAttribute("activities", activityList);
        return "index.html";
    }

    @GetMapping("/activityDetails/{activityID}")
    public String readActivityDetails(@PathVariable Long activityID, Model model){
        model.addAttribute("activity", activityService.readActivityByID(activityID));
        return "activityDetails.html";
    }

    @GetMapping("/createActivity")
    public String createActivity() {
        return "createActivity.html";
    }

    @PostMapping("/createActivity")
    public String createActivity(@ModelAttribute Activity activity) {
        activityService.createNewActivity(activity);
        return "redirect:/";
    }

    @GetMapping("/updateActivity/{activityID}")
    public String updateActivity(@PathVariable("activityID") Long activityID, Model model) {
        model.addAttribute("activity", activityService.readActivityByID(activityID));
        return "updateActivity.html";
    }

    @PostMapping("/updateActivity")
    public String updateActivity(@ModelAttribute Activity activity) {
        activityService.updateActivity(activity.getActivityID(), activity);
        return "redirect:/";
    }

    @GetMapping("/deleteActivity/{activityID}")
    public String deleteActivity(@PathVariable("activityID") Long activityID) {
        activityService.deleteActivity(activityID);
        return "redirect:/";
    }

    @GetMapping("/test")
    public String renderTest(Model model) {
        List<Activity> list = activityService.readAllActivities();
        model.addAttribute("list", list);
        return "test.html";
    }

}
