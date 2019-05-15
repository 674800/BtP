package com.egar.btphone.service;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.WindowManager;

import com.egar.btphone.Interface.IReceiver;
import com.egar.btphone.receiver.BootReceiver;
import com.egar.btphone.utils.LogUtils;
import com.egar.btphone.view.FullCallUI;
import com.egar.btphone.view.HalfCallUI;

/**
 * Created by ybf on 2019/5/10.
 */
public class CallUiService extends Service implements IReceiver{
    private String TAG = "CallUiService";
    private final IBinder mBinder= new LocalBinder();
    private WindowManager mWindowManager;
    private LayoutInflater mInflater;
    private FullCallUI mFullCallUI;
    private HalfCallUI mHalfCallUI;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    public class LocalBinder extends Binder{
        public CallUiService getService(){
            return CallUiService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.i(TAG,"onCreate");
        mWindowManager = (WindowManager) getApplication().getSystemService(Application.WINDOW_SERVICE);
        mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mFullCallUI = new FullCallUI(this,mInflater);
        mHalfCallUI = new HalfCallUI(this,mInflater);
        BootReceiver.registerNotifyObject(TAG,this);
    }

    public void openFullCallUI(){
        if(!mFullCallUI.getLayout().isAttachedToWindow()){
            mWindowManager.addView(mFullCallUI.getLayout(),mFullCallUI.getLayoutParams());
        }
    }
    public void closeFullCallUI(){
        if(mFullCallUI.getLayout().isAttachedToWindow()){
            mWindowManager.removeView(mFullCallUI.getLayout());
        }
    }

    public void openCallUIHalf(){
        if(!mHalfCallUI.getLayout().isAttachedToWindow()){
            mWindowManager.addView(mHalfCallUI.getLayout(),mHalfCallUI.getLayoutParams());
        }
    }
    public void closeCallUIHalf(){
        if(mHalfCallUI.getLayout().isAttachedToWindow()){
            mWindowManager.removeView(mHalfCallUI.getLayout());
        }
    }
    @Override
    public void openCallUI() {
        LogUtils.i(TAG,"openCallUI");
        openFullCallUI();
    }

    @Override
    public void closeCallUI() {
        LogUtils.i(TAG,"closeCallUI");
        closeFullCallUI();
    }

    @Override
    public void openHalfCallUI() {
        LogUtils.i(TAG,"openHalfCallUI");
        openCallUIHalf();
    }

    @Override
    public void closeHalfCallUI() {
        LogUtils.i(TAG,"closeHalfCallUI");
        closeCallUIHalf();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        BootReceiver.removeNotifyObject(TAG);
    }
}
