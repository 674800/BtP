package com.egar.btphone.fragment;

import java.util.HashMap;

/**
 * Created by ybf on 2019/4/30.
 * FIXME 工厂模式
 */
public class FragmentFactory {
    private static final int KEY_BOARD =0;
    private static final int CALL_RECORD =1;
    private static final int PTHONE_BOOK =2;
    private static final int COLLIECTION =3;
    private static final int SETTINGS =4;
    private static HashMap<Integer, BaseLazyLoadFragment> mFragmentHashMap = new HashMap<>();

    public static BaseLazyLoadFragment createFragment(int pos) {

        BaseLazyLoadFragment baseFragment = mFragmentHashMap.get(pos);//从集合中取出Fragment
        if (baseFragment == null) {
            switch (pos) {
                case KEY_BOARD:
                    baseFragment = new KeyboardFragment();
                    break;
                case CALL_RECORD:
                    baseFragment = new CallRecordFragment();
                    break;
                case PTHONE_BOOK:
                    baseFragment = new PhoneBookFragment();
                    break;
                case COLLIECTION:
                    baseFragment = new ColliectionFragment();
                    break;

            }
            mFragmentHashMap.put(pos, baseFragment);//存入集合中
        }
        return baseFragment;
    }

    public static int getFragmentSize(){
        return 4;
    }
}
