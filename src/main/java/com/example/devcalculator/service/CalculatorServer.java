package com.example.devcalculator.service;

import com.example.devcalculator.model.Activity;

import java.util.List;

public class CalculatorServer {

    public static Float calculateCost(String salaryAverage, String discount, List<Activity> activityList) throws Exception{

        Float minimumAmountMonth = 30 * 8 * 1f; //30 days - 8 hours one day - 1 real hour

        if(Integer.parseInt(salaryAverage) < minimumAmountMonth){
            throw new Exception("Minimum amount per month: " + minimumAmountMonth);
        }

        Float costDevApplication = 0f;

        Float costHour = Integer.parseInt(salaryAverage)/minimumAmountMonth;

        for(Activity activity: activityList){
            costDevApplication += activity.getTime()*costHour;
        }

        if(costDevApplication < Integer.parseInt(discount)){
            throw new Exception("Discount cannot be greater than the cost");
        }

        costDevApplication -= Integer.parseInt(discount);

        return costDevApplication;
    }
}
