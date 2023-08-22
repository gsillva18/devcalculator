package com.example.devcalculator.core;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static void validateSalaryAndActivities(TextField salary, TextField discount, TextArea activities) throws Exception{
        if (salary.getText().replaceAll("\\s","").isEmpty()){
            throw new Exception("Salary is empty");
        }

        validateNumber(salary.getText());

        if (discount.getText().replaceAll("\\s","").isEmpty()){
            throw new Exception("Discount is empty");
        }

        validateNumber(discount.getText());

        if (activities.getText().replaceAll("\\s","").isEmpty()){
            throw new Exception("Activities is empty");
        }


    }

    public static void validateActivity(String activity) throws Exception{

        String text = activity.replaceAll("\\s","");
        String pattern = "\\[(.*?)\\-(.*?)\\]";

        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(text);

        if (!matcher.find()){
            throw new Exception("Invalid activity");
        }
    }

    public static void validateNumber(String numberString) throws Exception{
        try{
            Integer.parseInt(numberString);
        }catch (Exception e){
            throw new Exception("Value is not number");
        }
    }

}
