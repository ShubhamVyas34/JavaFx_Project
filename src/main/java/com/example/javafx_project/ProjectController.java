package com.example.javafx_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectController implements Initializable {

    @FXML
    private TextField dateTextField;

    @FXML
    private TextField precipTextField;

    @FXML
    private TextField tempTextField;

    @FXML
    private TextField feelsLikeTextFIeld;

    @FXML
    private TextField dailyTextField;

    @FXML
    private TextField windSPeedTextField;

    @FXML
    private Label msgLabel;

    @FXML
    private Button submitButton;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        msgLabel.setVisible(false);
    }

    @FXML
    void createProject(ActionEvent event) {
        int date= Integer.parseInt(dateTextField.getText());
        String precipType= precipTextField.getText();
        float temp= Float.parseFloat(tempTextField.getText());
        float feelsLike= Float.parseFloat(feelsLikeTextFIeld.getText());
        float windSpeed= Float.parseFloat(windSPeedTextField.getText());
        String summary=dailyTextField.getText();
            try {
                projectMain newProject = new projectMain(date,precipType,temp,feelsLike,windSpeed,summary);
                DBUtility.insertProject(newProject);
//                Formatter formatter = new Formatter(new File("camera.txt"));
//                formatter.format("New camera: %s\n",newCamera);
//                formatter.close();
                msgLabel.setText(newProject.toString());
            }catch (IllegalArgumentException e)
            {
                msgLabel.setText(e.getMessage());
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }
