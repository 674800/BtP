package com.egar.btphone.fragment;

import com.egar.btphone.R;
import com.egar.btphone.utils.LogUtils;

/**
 * Created by ybf on 2019/4/30.\
 *电话本
 */
public class PhoneBookFragment extends BaseLazyLoadFragment {
    @Override
    protected int setContentView() {
        return R.layout.fragment_phone_book;
    }

    @Override
    protected void lazyLoad() {
        LogUtils.i(TAG,"PhoneBookFragment");
    }
}
