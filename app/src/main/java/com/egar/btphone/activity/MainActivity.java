package com.egar.btphone.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.egar.btphone.R;
import com.egar.btphone.adapter.ViewpagerAdapter;
import com.egar.btphone.view.NoscrollViewPager;

public class MainActivity extends BaseActivity {

    private NoscrollViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniView();
    }

    private void iniView() {
        viewpager = findViewById(R.id.viewpager);
        FragmentManager mFragmentManager = getSupportFragmentManager();
        ViewpagerAdapter adapter = new ViewpagerAdapter(mFragmentManager);
        viewpager.setAdapter(adapter);

    }
}
