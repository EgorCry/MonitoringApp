package com.example.monitoringapp;

public class WorkerResponse {
    private String message;
    private int id;
    private String workshop_name;
    private String first_name;
    private String surname;
    private Float prediction_worker;
    private Float humidity_worker;
    private String status_worker;
    private int device_worker_name;
    private int device_worker_mask;

    public int getDevice_worker_name() {
        return device_worker_name;
    }

    public void setDevice_worker_name(int device_worker_name) {
        this.device_worker_name = device_worker_name;
    }

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

    public String getWorkshop_name() {
        return workshop_name;
    }

    public void setWorkshop_name(String workshop_name) {
        this.workshop_name = workshop_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String name) {
        this.first_name = name;
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


    public int getDevice_worker_mask() {
        return device_worker_mask;
    }

    public void setDevice_worker_mask(int device_worker_mask) {
        this.device_worker_mask = device_worker_mask;
    }
}
