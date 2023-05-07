package com.example.monitoringapp;

import java.util.Date;

public class Worker {
    private int ID_worker;
    private String first_name;
    private String second_name;
    private String patronymic;
    private String mail;
    private String job_title;
    private Date employment_date;
    private Boolean responsible;

    public int getID_worker() {
        return ID_worker;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getMail() {
        return mail;
    }

    public String getJob_title() {
        return job_title;
    }

    public Date getEmployment_date() {
        return employment_date;
    }

    public Boolean getResponsible() {
        return responsible;
    }
}
