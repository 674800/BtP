package com.egar.btphone.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.egar.btphone.fragment.BaseLazyLoadFragment;
import com.egar.btphone.fragment.FragmentFactory;


/**
 * Created by ybf on 2019/3/28.
 */
public class ViewpagerAdapter extends FragmentPagerAdapter {
    private String TAG = getClass().getSimpleName();

    public ViewpagerAdapter(FragmentManager mfragmenManager) {
        super(mfragmenManager);

    }



    @Override
    public Fragment getItem(int position) {
        BaseLazyLoadFragment fragment = FragmentFactory.createFragment(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return FragmentFactory.getFragmentSize();
    }


}
