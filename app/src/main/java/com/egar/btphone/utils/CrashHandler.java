package com.egar.btphone.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * Created by ybf on 2019/5/5.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private String TAG = getClass().getSimpleName();
    /**单例*/
    private static CrashHandler INSTANCE ;
    /**上下文环境*/
    private Context mContext;
    /**错误*/
    private Throwable ex;

    /**初始化*/
    public static CrashHandler init(Context context) {
        return INSTANCE=(INSTANCE==null?new CrashHandler(context):INSTANCE);
    }
    /**构造方法*/
    public CrashHandler(Context ctx) {
        mContext = ctx;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }
    /**捕获异常并处理*/
    @Override
    public void uncaughtException(Thread thread, final Throwable ex) {
        this.ex=ex;

        String subject="应用程序"+" "+"EmailDemo"+" "+"发生了一个崩溃";
       LogUtils.i(TAG,getApplicationName()+"-->"+ex.toString());

    }

    public String getApplicationName() {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = mContext.getApplicationContext().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(mContext.getApplicationContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        String applicationName =
                (String) packageManager.getApplicationLabel(applicationInfo);
        return applicationName;
    }

}
