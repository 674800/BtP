package com.egar.btphone.view;

import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.egar.btphone.R;
import com.egar.btphone.service.CallUiService;
import com.egar.btphone.utils.LogUtils;

/**
 * Created by ybf on 2019/5/10.
 */
public class FullCallUI {
    private String TAG ="FullCallUI";
    protected CallUIView mlayout ;
    protected WindowManager.LayoutParams mlayoutParams;
    public FullCallUI(CallUiService service, LayoutInflater mInflater){
        mlayout = (CallUIView) mInflater.inflate(R.layout.call_ui_full_view,null);
        mlayoutParams = new WindowManager.LayoutParams();
        //拦截输入事件
        mlayout.setOnKeyListener(onKeyListener);
        mlayoutParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        mlayoutParams.y = 0;
        mlayoutParams.x = 0;
        mlayoutParams.format = PixelFormat.TRANSLUCENT;
        mlayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        mlayoutParams.flags = WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL ;
        mlayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        mlayoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
    }


    public ViewGroup getLayout() {
        return mlayout;
    }
    public WindowManager.LayoutParams getLayoutParams() {
        return mlayoutParams;
    }
    private final View.OnKeyListener onKeyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {

            LogUtils.i(TAG, "receive keyvode :"  + event.getKeyCode());

            if(event.getKeyCode() == KeyEvent.KEYCODE_HOME) {

            }
            return false;
        }
    };
}
