package com.vlsmvp.model;


public interface User {
    String getName();
    String getPassword();
    int checkUserValidity(String name, String password);
}
