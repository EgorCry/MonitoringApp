package com.example.monitoringapp;

public class AdminResponse {
    private String message;
    private int ID_worker;
    private String workshop_name;
    private String worker_2;
    private String worker_3;
    private String first_name;
    private String second_name;
    private Float prediction_worker2;
    private Float prediction_worker3;
    private Float humidity_worker2;
    private Float humidity_worker3;
    private String status_worker2;
    private String status_worker3;
    private int device_worker_name_2;
    private int device_worker_name_3;
    private int device_worker_mask_2;
    private int device_worker_mask_3;

    public int getDevice_worker_name_2() {
        return device_worker_name_2;
    }

    public void setDevice_worker_name_2(int device_worker_name_2) {
        this.device_worker_name_2 = device_worker_name_2;
    }

    public int getDevice_worker_name_3() {
        return device_worker_name_3;
    }

    public void setDevice_worker_name_3(int device_worker_name_3) {
        this.device_worker_name_3 = device_worker_name_3;
    }

    public int getDevice_worker_mask_2() {
        return device_worker_mask_2;
    }

    public void setDevice_worker_mask_2(int device_worker_mask_2) {
        this.device_worker_mask_2 = device_worker_mask_2;
    }

    public int getDevice_worker_mask_3() {
        return device_worker_mask_3;
    }

    public void setDevice_worker_mask_3(int device_worker_mask_3) {
        this.device_worker_mask_3 = device_worker_mask_3;
    }

    public Float getPrediction_worker2() {
        return prediction_worker2;
    }

    public void setPrediction_worker2(Float prediction_worker2) {
        this.prediction_worker2 = prediction_worker2;
    }

    public Float getPrediction_worker3() {
        return prediction_worker3;
    }

    public void setPrediction_worker3(Float prediction_worker3) {
        this.prediction_worker3 = prediction_worker3;
    }

    public Float getHumidity_worker2() {
        return humidity_worker2;
    }

    public void setHumidity_worker2(Float humidity_worker2) {
        this.humidity_worker2 = humidity_worker2;
    }

    public Float getHumidity_worker3() {
        return humidity_worker3;
    }

    public void setHumidity_worker3(Float humidity_worker3) {
        this.humidity_worker3 = humidity_worker3;
    }

    public String getStatus_worker2() {
        return status_worker2;
    }

    public void setStatus_worker2(String status_worker2) {
        this.status_worker2 = status_worker2;
    }

    public String getStatus_worker3() {
        return status_worker3;
    }

    public void setStatus_worker3(String status_worker3) {
        this.status_worker3 = status_worker3;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getID_worker() {
        return ID_worker;
    }

    public void setID_worker(int ID_worker) {
        this.ID_worker = ID_worker;
    }

    public String getWorkshop_name() {
        return workshop_name;
    }

    public void setWorkshop_name(String workshop_name) {
        this.workshop_name = workshop_name;
    }

    public String getWorker_2() {
        return worker_2;
    }

    public void setWorker_2(String worker_2) {
        this.worker_2 = worker_2;
    }

    public String getWorker_3() {
        return worker_3;
    }

    public void setWorker_3(String worker_3) {
        this.worker_3 = worker_3;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }
}
