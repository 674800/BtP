package com.egar.btphone.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.egar.btphone.Interface.IReceiver;
import com.egar.btphone.service.CallUiService;
import com.egar.btphone.utils.LogUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ybf on 2019/5/10.
 */
public class BootReceiver extends BroadcastReceiver {
    private String TAG="BootReceiver";

    protected static Map<String, IReceiver> mMapNotifyObjects = new HashMap<String, IReceiver>();
    @Override
    public void onReceive(Context context, Intent intent) {
       String action = intent.getAction();
        LogUtils.i(TAG,"action="+action);
        if (action.equals("com.open.ui")){
            openCallUI();
        }else if(action.equals("com.close.ui")){
            closeCallUI();
        }else if(action.equals("com.close.half.ui")){
            closeHalfCallUI();
        }else if(action.equals("com.open.half.ui")){
            openHalfCallUI();
        }else if(action.equals("com.startservice")){
            context.startService(new Intent(context, CallUiService.class));
        }

    }
    public static void registerNotifyObject(String notifyKey, IReceiver notifyObj) {
        if (!mMapNotifyObjects.containsKey(notifyKey)) {
            mMapNotifyObjects.remove(notifyKey);
            mMapNotifyObjects.put(notifyKey, notifyObj);
        }
    }
    public static void removeNotifyObject(String notifyKey) {
        if (mMapNotifyObjects.containsKey(notifyKey)) {
            mMapNotifyObjects.remove(notifyKey);
        }
    }

    public void openCallUI() {
        try {
            for (IReceiver notifyObj : mMapNotifyObjects.values()) {
                notifyObj.openCallUI();
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    public void closeCallUI() {
        try {
            for (IReceiver notifyObj : mMapNotifyObjects.values()) {
                notifyObj.closeCallUI();
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
    public void openHalfCallUI() {
        try {
            for (IReceiver notifyObj : mMapNotifyObjects.values()) {
                notifyObj.openHalfCallUI();
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
    public void closeHalfCallUI() {
        try {
            for (IReceiver notifyObj : mMapNotifyObjects.values()) {
                notifyObj.closeHalfCallUI();
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
}
