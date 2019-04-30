package com.egar.btphone.fragment;

import com.egar.btphone.R;
import com.egar.btphone.utils.LogUtils;

/**
 * Created by ybf on 2019/4/30.
 * 通话记录
 */
public class CallRecordFragment extends BaseLazyLoadFragment {
    @Override
    protected int setContentView() {
        return R.layout.fragment_call_recod;
    }

    @Override
    protected void lazyLoad() {
        LogUtils.i(TAG,"call_record");
    }
}
