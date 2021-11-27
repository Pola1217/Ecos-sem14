package com.example.ecos_sem14;

public class Tareas {

    private String user, tarea, date, descrip, status, userKey;

    public Tareas(String user, String tarea, String date, String descrip, String status, String userKey) {
        this.user = user;
        this.tarea = tarea;
        this.date = date;
        this.descrip = descrip;
        this.status = status;
        this.userKey = userKey;
    }

    public Tareas (String tarea, String descrip, String user, String status, String userKey) {

        this.tarea = tarea;
        this.descrip = descrip;
        this.user = user;
        this.status = status;
        this.userKey = userKey;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }
}
