package com.egar.btphone.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;

import com.egar.btphone.R;
import com.egar.btphone.adapter.RecordAdapter;
import com.egar.btphone.utils.LogUtils;
import com.egar.btphone.view.PullToRefreshListView;

/**
 * Created by ybf on 2019/4/30.
 * 通话记录
 */
public class CallRecordFragment extends BaseLazyLoadFragment {
    private String TAG ="CallRecordFragment";
    private View view = null;
    private PullToRefreshListView pull_listview;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LogUtils.i(TAG,"complete");
            pull_listview.onRefreshComplete();
        }
    };

    @Override
    protected int setContentView() {
        return R.layout.fragment_call_recod;
    }

    @Override
    protected void lazyLoad() {
        LogUtils.i(TAG,"call_record");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view = getContentView();
        pull_listview =(PullToRefreshListView)view.findViewById(R.id.pull_listview);
        RecordAdapter adapter = new RecordAdapter();
        pull_listview.setAdapter(adapter);
        pull_listview.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Message message = new Message();
                message.arg1 = 1;

                handler.sendMessageDelayed(message,2000);

                LogUtils.i(TAG,"onRefresh");
            }
        });
    }

}
