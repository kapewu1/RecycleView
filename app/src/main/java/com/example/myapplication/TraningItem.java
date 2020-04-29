package com.example.myapplication;

public class TraningItem {
    private int imageId;
    private String traningName;
    private String traningType;
    private String traningDate;

    public TraningItem(int imageId, String traningName, String traningType, String traningDate) {
        this.imageId = imageId;
        this.traningName = traningName;
        this.traningType = traningType;
        this.traningDate = traningDate;
    }

    public int getmImageId() {
        return imageId;
    }

    public String getTraningName() {
        return traningName;
    }

    public String getTraningType() {
        return traningType;
    }

    public String getTraningDate() {
        return traningDate;
    }
}
