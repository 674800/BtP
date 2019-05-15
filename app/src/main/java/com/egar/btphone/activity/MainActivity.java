package com.egar.btphone.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.egar.btphone.Interface.ICallBacck;
import com.egar.btphone.R;
import com.egar.btphone.present.MainPresent;
import com.egar.btphone.view.NoscrollViewPager;

public class MainActivity extends BaseActivity implements ICallBacck, View.OnClickListener {

    private NoscrollViewPager viewpager;
    private MainPresent mainPresent;
    private RadioButton mRb_keyboard, mRb_call_record, mRb_call_book, mRb_collection, mRrb_btsetting;
    private RadioGroup mRg_radiogroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniView();
        initData();
    }


    private void iniView() {
        mRb_keyboard = findViewById(R.id.rb_keyboard);
        mRb_call_record = findViewById(R.id.rb_call_record);
        mRb_call_book = findViewById(R.id.rb_call_book);
        mRb_collection = findViewById(R.id.rb_collection);
        mRrb_btsetting = findViewById(R.id.rb_btsetting);
        mRg_radiogroup = findViewById(R.id.rg_radiogroup);

        mRb_keyboard.setOnClickListener(this);
        mRb_call_record.setOnClickListener(this);
        mRb_call_book.setOnClickListener(this);
        mRb_collection.setOnClickListener(this);
        mRrb_btsetting.setOnClickListener(this);

        viewpager = findViewById(R.id.viewpager);
        mainPresent = new MainPresent(this);
        mainPresent.setCallBackLinstener(this);
    }

    private void initData() {
        mainPresent.initViewPagerData();
    }


    @Override
    public NoscrollViewPager getViewPager() {
        return viewpager;
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_keyboard:
                mainPresent.setPositionFragment(mainPresent.KEYBOARD_FRAGMENT);
                break;
            case R.id.rb_call_record:
                mainPresent.setPositionFragment(mainPresent.CALL_RECORD_FRAGMENT);
                break;
            case R.id.rb_call_book:
                mainPresent.setPositionFragment(mainPresent.CALL_BOOK_FRAGMENT);
                break;
            case R.id.rb_collection:
                mainPresent.setPositionFragment(mainPresent.COLLECTION_FRAGMENT);
                break;
            case R.id.rb_btsetting:
                mainPresent.setPositionFragment(mainPresent.BTSETTING_FRAGMENT);
                break;
        }
    }
}
