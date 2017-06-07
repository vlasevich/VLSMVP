package com.vlsmvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vlsmvp.presenter.LoginPresenter;
import com.vlsmvp.presenter.LoginPresenterCompl;
import com.vlsmvp.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    private EditText editUser;
    private EditText editPass;
    private Button btnLogin;
    private Button btnClear;
    private LoginPresenter loginPresenter;
    private ProgressBar progressBar;

    private void initUI() {
        editUser = (EditText) this.findViewById(R.id.et_login_username);
        editPass = (EditText) this.findViewById(R.id.et_login_password);
        btnLogin = (Button) this.findViewById(R.id.btn_login_login);
        btnClear = (Button) this.findViewById(R.id.btn_login_clear);
        progressBar = (ProgressBar) this.findViewById(R.id.progress_login);

        //set listener
        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        loginPresenter = new LoginPresenterCompl(this);
        loginPresenter.setProgressbarVisibility(View.GONE);
    }

    @Override
    public void onClearText() {
        editPass.setText("");
        editUser.setText("");
    }

    @Override
    public void onLoginResult(boolean result, int code) {
        loginPresenter.setProgressbarVisibility(View.GONE);
        btnClear.setEnabled(true);
        btnLogin.setEnabled(true);
        if (result){
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Login Fail, code = "+code, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSetProgressbarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login_clear:{
                loginPresenter.clear();
                break;
            }
            case R.id.btn_login_login:{
                loginPresenter.setProgressbarVisibility(View.VISIBLE);
                btnClear.setEnabled(false);
                btnLogin.setEnabled(false);
                loginPresenter.doLogin(editUser.getText().toString(),editPass.getText().toString());
                break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }
}
