package com.example.monitoringapp;

public class WorkerResponse {
    private String message;
    private int id;
    private String workshopName;
    private String name;
    private String surname;
    private Float prediction_worker;
    private Float humidity_worker;
    private String status_worker;
    private int device_worker;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Float getPrediction_worker() {
        return prediction_worker;
    }

    public void setPrediction_worker(Float prediction_worker) {
        this.prediction_worker = prediction_worker;
    }

    public Float getHumidity_worker() {
        return humidity_worker;
    }

    public void setHumidity_worker(Float humidity_worker) {
        this.humidity_worker = humidity_worker;
    }

    public String getStatus_worker() {
        return status_worker;
    }

    public void setStatus_worker(String status_worker) {
        this.status_worker = status_worker;
    }

    public int getDevice_worker() {
        return device_worker;
    }

    public void setDevice_worker(int device_worker) {
        this.device_worker = device_worker;
    }
}
