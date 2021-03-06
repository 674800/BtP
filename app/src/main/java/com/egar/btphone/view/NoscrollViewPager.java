package com.egar.btphone.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * Created by ybf on 2019/4/9.
 */
public class NoscrollViewPager extends ViewPager {
    private String TAG = getClass().getSimpleName();
    private boolean noScroll = true;

    public NoscrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoscrollViewPager(Context context) {
        super(context);
    }

    public void setNoScroll(boolean noScroll) {
        this.noScroll = noScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (noScroll)
            return false;
        else
            return super.onTouchEvent(arg0);
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        // TODO Auto-generated method stub
            return super.dispatchKeyEvent(event);


    }
    @Override
    public boolean executeKeyEvent(KeyEvent event){
        Log.e(TAG,"code="+event.getKeyCode());
        if(event.getKeyCode() == KeyEvent.KEYCODE_DPAD_LEFT | event.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT  ){
            return true;
        }else {
            return super.executeKeyEvent(event);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (noScroll)
            return false;
        else
            return super.onInterceptTouchEvent(arg0);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }
}
