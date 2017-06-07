package com.vlsmvp.presenter;


import android.os.Handler;

import com.vlsmvp.model.UserModel;
import com.vlsmvp.view.LoginView;

public class LoginPresenterCompl implements LoginPresenter {
    private LoginView loginView;
    UserModel userModel;

    public LoginPresenterCompl(LoginView loginView) {
        this.loginView = loginView;
        initUser();
    }

    @Override
    public void clear() {
        loginView.onClearText();
    }

    @Override
    public void doLogin(String name, String password) {
        boolean isLoginSuccess = true;
        final int code = userModel.checkUserValidity(name, password);
        if (code != 0) isLoginSuccess = false;
        final boolean result = isLoginSuccess;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginView.onLoginResult(result, code);
            }
        }, 3000);
    }

    @Override
    public void setProgressbarVisibility(int visibility) {
        loginView.onSetProgressbarVisibility(visibility);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    private void initUser() {
        userModel = new UserModel("vls", "vls");
    }
}
