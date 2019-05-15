package com.egar.btphone;

import android.app.Application;
import android.content.Context;

import com.egar.btphone.Theme.SkinManager;


/**
 * Created by ybf on 2019/4/29.
 */
public class AppApplication extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        SkinManager.getInstance().init(mContext);
    }

    public static Context getContext(){
        return  mContext;
    }
}
