package com.example.monitoringapp;

public class AdminResponse {
    private String message;
    private int ID_worker;
    private String workshop_name;
    private String worker1;
    private String worker2;
    private String first_name;
    private String second_name;

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

    public String getWorker1() {
        return worker1;
    }

    public void setWorker1(String worker1) {
        this.worker1 = worker1;
    }

    public String getWorker2() {
        return worker2;
    }

    public void setWorker2(String worker2) {
        this.worker2 = worker2;
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
