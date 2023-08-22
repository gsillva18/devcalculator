package com.example.devcalculator.controllers;

import com.example.devcalculator.core.Creator;
import com.example.devcalculator.core.Validator;
import com.example.devcalculator.model.Activity;
import com.example.devcalculator.service.CalculatorServer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    @FXML
    private TextField salaryAverage;
    @FXML
    private TextField discount;
    @FXML
    private TextArea activities;

    @FXML
    private Shape alertShape;
    @FXML
    private Label alertLabel;
    @FXML
    private Button alertButton;

    @FXML
    private Shape modalShape;
    @FXML
    private Label modalLabelCost;
    @FXML
    private Label modalLabelValue;
    @FXML
    private Button modalButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setVisibleAlert(false);
        setVisibleModal(false);
        setEditableFields(true);
    }

    @FXML
    public void calculate(){

        try {
            Validator.validateSalaryAndActivities(salaryAverage, discount, activities);
            List<Activity> activityList = Creator.createListActivities(activities);
            Float cost = CalculatorServer.calculateCost(salaryAverage.getText(), discount.getText(), activityList);
            modalLabelValue.setText(new DecimalFormat("0.00").format(cost));
            setVisibleModal(true);
            setEditableFields(false);
        } catch (Exception e) {
            alertLabel.setText(e.getMessage());
            setVisibleAlert(true);
        }

    }

    @FXML
    public void closeAlert(){
        setVisibleAlert(false);
    }

    @FXML
    public void closeModal(){
        setVisibleModal(false);
        setEditableFields(true);
    }

    private void setVisibleAlert(Boolean condition){
        alertButton.setVisible(condition);
        alertLabel.setVisible(condition);
        alertShape.setVisible(condition);
    }

    private void setVisibleModal(Boolean condition){
        modalButton.setVisible(condition);
        modalLabelCost.setVisible(condition);
        modalLabelValue.setVisible(condition);
        modalShape.setVisible(condition);
    }

    private void setEditableFields(Boolean condition){
        salaryAverage.setEditable(condition);
        discount.setEditable(condition);
        activities.setEditable(condition);
    }

}
