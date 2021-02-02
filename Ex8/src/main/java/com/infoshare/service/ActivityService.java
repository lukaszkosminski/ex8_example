package com.infoshare.service;

import com.infoshare.model.ActivityDTO;
import com.infoshare.util.Util;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ActivityService {

    private static final Path RESOURCES_PATH = Paths.get("src", "main", "resources", "static", "activities.json");

    private List<ActivityDTO> activityList;

    public ActivityService() {
        prepareData();
    }

    public List<ActivityDTO> getAllActivities() {
        return activityList;
    }

    public void addActivity(ActivityDTO activityDTO) {
        activityList.add(activityDTO);
        addActivityToJsonFile();
    }

    private void prepareData() {
        activityList = Util.readActivitiesFromFile(RESOURCES_PATH);
    }

    private void addActivityToJsonFile() {
        Util.saveActivityToJsonFile(RESOURCES_PATH, activityList);
    }

}
