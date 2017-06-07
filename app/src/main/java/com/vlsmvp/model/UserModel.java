package com.vlsmvp.model;


public class UserModel implements User {
    private String name;
    private String password;

    public UserModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int checkUserValidity(String name, String password) {
        if ((name.equals(getName()) && password.equals(getPassword()))) {
            return 0;
        }
        return -1;
    }

}
