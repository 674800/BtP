package com.egar.btphone;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import com.egar.btphone.permissioin.Permissions;

/**
 * Created by ybf on 2019/4/29.
 */
public class AppApplication extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

    }

    public static Context getContext(){
        return  mContext;
    }
}
