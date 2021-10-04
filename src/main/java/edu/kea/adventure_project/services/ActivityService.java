package edu.kea.adventure_project.services;

import edu.kea.adventure_project.models.Activity;
import edu.kea.adventure_project.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Julius Panduro
 */
@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    public void createNewActivity(Activity activity){
        activityRepository.save(activity);
    }

    public List<Activity> readAllActivities() {
        return activityRepository.findAll();
    }

    public Activity readActivityByID(Long activityID) {
        return activityRepository.findById(activityID).orElseThrow(); //todo make an exception to handle Activity not found
    }

    public void updateActivity(Long activityID, Activity activity){
        activityRepository.findById(activityID);
        activityRepository.save(activity);
    }

    public void deleteActivity(Long activityID){
        activityRepository.deleteById(activityID);
    }
}
