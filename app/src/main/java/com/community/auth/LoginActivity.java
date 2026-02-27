package com.community.auth;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvRegister;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        initViews();
        setupListeners();
    }
    
    private void initViews() {
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_register);
    }
    
    private void setupListeners() {
        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            
            if (validateInput(username, password)) {
                performLogin(username, password);
            }
        });
        
        tvRegister.setOnClickListener(v -> {
            // 跳转到注册界面
            Toast.makeText(this, "注册功能开发中", Toast.LENGTH_SHORT).show();
        });
    }
    
    private boolean validateInput(String username, String password) {
        if (username.isEmpty()) {
            etUsername.setError("请输入用户名");
            return false;
        }
        if (password.isEmpty()) {
            etPassword.setError("请输入密码");
            return false;
        }
        return true;
    }
    
    private void performLogin(String username, String password) {
        // 此处实现登录逻辑
        Toast.makeText(this, "登录成功: " + username, Toast.LENGTH_SHORT).show();
        
        // 登录成功后跳转到主界面
        // Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        // startActivity(intent);
        // finish();
    }
}