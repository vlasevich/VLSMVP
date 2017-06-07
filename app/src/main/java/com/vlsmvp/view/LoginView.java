package com.vlsmvp.view;


public interface LoginView {
    void onClearText();
    void onLoginResult(boolean result,int code);
    void onSetProgressbarVisibility(int visibility);
}
