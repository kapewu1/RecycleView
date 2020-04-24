package com.example.myapplication;

public class MainModel {
    Integer activLogo;
    String activName;
    String activDescription;

    public MainModel(Integer activLogo, String activName, String activDescription){
        this.activLogo = activLogo;
        this.activName = activName;
        this.activDescription = activDescription;
    }
    public MainModel(Integer activLogo, String activName){
        this.activLogo = activLogo;
        this.activName = activName;
    }

    public void changeText(String text){
        activName = text;
    }

    public Integer getActivLogo() {
        return activLogo;
    }
    public String getActivName() {
        return activName;
    }
    public String getActivDescription(){
        return activDescription;
    }

}
