package com.egar.btphone.activity;

import android.content.Intent;
import android.os.Bundle;

import com.egar.btphone.R;

/**
 * Created by ybf on 2019/4/29.
 */
public class DialogActivity extends BaseActivity {
    /**
     * 判断是否进入主界面，
     *依据：蓝牙是否连接
     */
    private boolean isopen = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isopen) {
            setContentView(R.layout.activity_dialog);
        } else {
            EnterMainActivity();
            finish();
        }
    }

    public void EnterMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
