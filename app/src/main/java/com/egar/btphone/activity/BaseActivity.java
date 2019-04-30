package com.egar.btphone.activity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.egar.btphone.permissioin.Permissions;



/**
 * Created by ybf on 2019/4/29.
 */
public class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Permissions.requestPermissionAll(this);
    }

    /**
     * 动态权限获取
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Permissions.changePermissionState(this,permissions[0],true);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
