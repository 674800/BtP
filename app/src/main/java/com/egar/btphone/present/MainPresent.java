package com.egar.btphone.present;

import android.support.v4.app.FragmentManager;

import com.egar.btphone.Interface.ICallBacck;
import com.egar.btphone.activity.MainActivity;
import com.egar.btphone.adapter.ViewpagerAdapter;
import com.egar.btphone.view.NoscrollViewPager;

/**
 * Created by ybf on 2019/4/30.
 */
public class MainPresent {
    private ICallBacck iCallBacck;
    private NoscrollViewPager viewPager;
    private MainActivity activity;
    public final int KEYBOARD_FRAGMENT =0;
    public final int CALL_RECORD_FRAGMENT=1;
    public final int CALL_BOOK_FRAGMENT=2;
    public final int COLLECTION_FRAGMENT=3;
    public final int BTSETTING_FRAGMENT=4;
    public MainPresent(MainActivity mainActivity){
        this.activity = mainActivity;

    }


    public void setCallBackLinstener(ICallBacck iCallBacck){
        this.iCallBacck = iCallBacck;
    }

    public void initViewPagerData(){
        viewPager = iCallBacck.getViewPager();
        FragmentManager mFragmentManager = activity.getSupportFragmentManager();
        ViewpagerAdapter adapter = new ViewpagerAdapter(mFragmentManager);
        viewPager.setAdapter(adapter);
    }

    public void setPositionFragment(int position){
        switch (position){
            case KEYBOARD_FRAGMENT:
                viewPager.setCurrentItem(KEYBOARD_FRAGMENT,false);
                break;
            case CALL_RECORD_FRAGMENT:
                viewPager.setCurrentItem(CALL_RECORD_FRAGMENT,false);
                break;
            case CALL_BOOK_FRAGMENT:
                viewPager.setCurrentItem(CALL_BOOK_FRAGMENT,false);
                break;
            case COLLECTION_FRAGMENT:
               viewPager.setCurrentItem(COLLECTION_FRAGMENT,false);
                break;
            case BTSETTING_FRAGMENT:
                //open Settings btFragment
                viewPager.setCurrentItem(BTSETTING_FRAGMENT,false);

                break;
        }
    }
}
