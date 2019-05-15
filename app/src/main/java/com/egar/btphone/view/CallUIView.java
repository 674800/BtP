package com.egar.btphone.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.LinearLayout;

import com.egar.btphone.utils.LogUtils;


public class CallUIView extends LinearLayout {

    private static final String TAG = "CallUIView";

    public CallUIView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public CallUIView(Context context) {
        super(context);
    }

    public CallUIView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CallUIView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        //全部拦截
        LogUtils.i(TAG, "dispatchkeyevent : " + event.getKeyCode());
        int keycode = event.getKeyCode();
        if (keycode == 21 || keycode ==22 || keycode == 66 || keycode == KeyEvent.KEYCODE_HOME) {
            mOnKeyListener.onKey(this, event.getKeyCode(), event);
            return true;
        }

        return super.dispatchKeyEvent(event);
    }



    OnKeyListener mOnKeyListener = null;

    @Override
    public void setOnKeyListener(OnKeyListener l) {
        mOnKeyListener = l;
        super.setOnKeyListener(l);
    }
}
