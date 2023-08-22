package com.example.devcalculator.core;

import com.example.devcalculator.model.Activity;
import javafx.scene.control.TextArea;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Creator {

    public static List<Activity> createListActivities(TextArea activities) throws Exception{

        Integer quantity = StringUtils.countMatches(activities.getText(),",");
        String[] list = activities.getText().replaceAll("\\s","").split(",");

        if (list.length != quantity+1){
            throw new Exception("Invalid structure");
        }

        List<Activity> activityList = new ArrayList<>();

        for(String activityString: list){
            Validator.validateActivity(activityString);
            String[] valueAndHour = activityString.substring(1,activityString.length()-1).split("-");
            Validator.validateNumber(valueAndHour[1]);
            activityList.add(new Activity(valueAndHour[0], Integer.parseInt(valueAndHour[1])));
        }
        
        return activityList;

    }
}
