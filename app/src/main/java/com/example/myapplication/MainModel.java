package com.example.myapplication;

public class MainModel {
    Integer activLogo;
    String activName;

    public MainModel(Integer activLogo, String activName){
        this.activLogo = activLogo;
        this.activName = activName;
    }
    public Integer getActivLogo() {
        return activLogo;
    }
    public String getActivName() {
        return activName;
    }
}
