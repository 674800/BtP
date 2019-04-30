package com.egar.btphone.fragment;

import com.egar.btphone.R;
import com.egar.btphone.utils.LogUtils;

/**
 * Created by ybf on 2019/4/30.
 * 键盘拨号
 */
public class KeyboardFragment extends BaseLazyLoadFragment {
    private String TAG = getClass().getSimpleName();
    @Override
    protected int setContentView() {
        return R.layout.fragment_keyboard;
    }

    @Override
    protected void lazyLoad() {
        LogUtils.i(TAG,"keyboard");
    }
}
