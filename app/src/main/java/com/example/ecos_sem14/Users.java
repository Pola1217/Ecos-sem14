package com.example.ecos_sem14;

public class Users {

    private String username, id;

    public Users() {

    }

    public Users(String username, String id) {

        this.username = username;
        this.id = id;

    }

    //gets y sets

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
