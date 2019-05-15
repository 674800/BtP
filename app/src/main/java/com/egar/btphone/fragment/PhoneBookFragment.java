package com.egar.btphone.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.egar.btphone.R;
import com.egar.btphone.adapter.PhoneBookAdapter;
import com.egar.btphone.utils.LogUtils;
import com.egar.btphone.view.PullToRefreshListView;

/**
 * Created by ybf on 2019/4/30.\
 *电话本
 */
public class PhoneBookFragment extends BaseLazyLoadFragment  {
    private View view = null;
    private PullToRefreshListView pull_listview;
    @Override
    protected int setContentView() {
        return R.layout.fragment_phone_book;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void lazyLoad() {
        LogUtils.i(TAG,"PhoneBookFragment");
        Log.e("SinkManager","thread Main="+Thread.currentThread().getName());
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view = getContentView();
        pull_listview =(PullToRefreshListView)view.findViewById(R.id.pull_listview);
        PhoneBookAdapter adapter = new PhoneBookAdapter();
        pull_listview.setAdapter(adapter);
    }

}
