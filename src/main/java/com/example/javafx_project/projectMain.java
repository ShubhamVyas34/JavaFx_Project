package com.example.javafx_project;

import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Formatter;

public class projectMain {
    private int formattedDate;
    private String precipType;
    private float temp;
    private float apparentTemp;
    private float windSpeed;
    private String dailySummary;

    public projectMain(int formattedDate, String precipType, float temp, float apparentTemp, float windSpeed, String dailySummary) {
        this.formattedDate = formattedDate;
        this.precipType = precipType;
        this.temp = temp;
        this.apparentTemp = apparentTemp;
        this.windSpeed = windSpeed;
        this.dailySummary = dailySummary;
    }

    public projectMain() {
    }

    public int getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(int formattedDate) {
        this.formattedDate = formattedDate;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getApparentTemp() {
        return apparentTemp;
    }

    public void setApparentTemp(float apparentTemp) {
        this.apparentTemp = apparentTemp;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getDailySummary() {
        return dailySummary;
    }

    public void setDailySummary(String dailySummary) {
        this.dailySummary = dailySummary;
    }
}