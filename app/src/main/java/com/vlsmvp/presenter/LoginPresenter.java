package com.vlsmvp.presenter;


public interface LoginPresenter {
    void clear();
    void doLogin(String name,String password);
    void setProgressbarVisibility(int visibility);
    void onDestroy();
}
