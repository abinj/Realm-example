package com.example.abin.realm_example.model;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by dxuser on 9/3/16.
 */
public class User extends RealmObject {
    @Required
    private String email;
    @Required
    private String password;
    private String name;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
