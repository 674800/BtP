package com.egar.btphone.Theme;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.egar.btphone.AppApplication;

import java.lang.reflect.Method;

/**
 * Created by ybf on 2019/5/7.
 */
public class SinkManag {

    private String TAG ="SinkManager";
    Resources skinResource ;
    String skinPackageName ;
    public Resources getTheme(String skinPkgPath, Context mContext) throws InstantiationException, IllegalAccessException {

        PackageManager mPm = mContext.getPackageManager();

        PackageInfo mInfo = mPm.getPackageArchiveInfo(skinPkgPath, PackageManager.GET_ACTIVITIES);
        Log.e(TAG,"mInfo="+mInfo);
        //得到插件的包名
        skinPackageName = mInfo.packageName;
        Log.e(TAG,"skinPackageName="+skinPackageName);
        AssetManager assetManager = AssetManager.class.newInstance();
        Method addAssetPath = null;
        try {
            addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, skinPkgPath);
            Resources superRes = mContext.getResources();
             skinResource = new Resources(assetManager, superRes.getDisplayMetrics(), superRes.getConfiguration());
            Log.e(TAG,"thread="+Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return skinResource;
    }




//keyboard_one_selector
    public  Drawable getDrawable(String resourcesName){
        String path = (String)SPUtil.get("path","");
        Drawable drawable =null;
        if(path ==null || path == ""){
            int id = AppApplication.getContext().getResources().getIdentifier(resourcesName, "drawable", AppApplication.getContext().getPackageName());
            Log.i(TAG,"id ="+id );
            return  AppApplication.getContext().getResources().getDrawable(id);
        }else {
            try {
                Resources resources =  getTheme(path, AppApplication.getContext());
                drawable = resources.getDrawable(resources.getIdentifier( resourcesName, "drawable", skinPackageName));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return drawable;
        }
    }

    public int getColor(/*String path,String resourcesName*/){
        int color=-1;
        try {
            Resources resources =  getTheme("/storage/emulated/0/sink.sink", AppApplication.getContext());
            color = resources.getColor(resources.getIdentifier( "colorPrimary", "color", skinPackageName));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return color;
    }

}