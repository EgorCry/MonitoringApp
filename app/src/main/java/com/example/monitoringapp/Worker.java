package com.example.monitoringapp;

import java.util.Date;

public class Worker {
    private int ID_worker;
    private String First_name;
    private String Second_name;
    private String Patronymic;
    private String Mail;
    private String Job_title;
    private String Employment_date;
    private int Responsible;

    public int getID_worker() {
        return ID_worker;
    }

    public String getFirst_name() {
        return First_name;
    }

    public String getSecond_name() {
        return Second_name;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public String getMail() {
        return Mail;
    }

    public String getJob_title() {
        return Job_title;
    }

    public String getEmployment_date() {
        return Employment_date;
    }

    public Boolean getResponsible() {
        if (Responsible == 1) {
            return true;
        }
        return false;
    }
}
