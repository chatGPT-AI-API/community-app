package com.community.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkManager {
    
    private Context context;
    
    public NetworkManager(Context context) {
        this.context = context;
    }
    
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = 
            (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }
        return false;
    }
    
    public void showNetworkError() {
        Toast.makeText(context, "网络连接失败，请检查网络设置", Toast.LENGTH_SHORT).show();
    }
    
    public void showServerError() {
        Toast.makeText(context, "服务器连接失败，请稍后再试", Toast.LENGTH_SHORT).show();
    }
}