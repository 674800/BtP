package com.egar.btphone.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.egar.btphone.AppApplication;
import com.egar.btphone.R;

/**
 * Created by ybf on 2019/5/14.
 */
public class RecordAdapter extends BaseAdapter {
    private TextView pd_item_name;
    private String  data[] ={"a","b","c","d","e","f","g","h"};

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Zujian zujian =null;
        if(convertView == null){
            zujian = new Zujian();
            convertView = LayoutInflater.from(AppApplication.getContext()).inflate(R.layout.record_item,null);
            pd_item_name = convertView.findViewById(R.id.pd_item_name);
            pd_item_name.setText(data[position]);
            convertView.setTag(zujian);

        }else {
            zujian =(Zujian) convertView.getTag();
        }
        return convertView;
    }


    /**
     * 组件集合，对应list.xml中的控件
     *
     * @author Administrator
     */
    public final class Zujian {

        public TextView tv_name;
        public TextView tv_number;
        public ImageView icon;
        public ImageView selectIcon;
    }
}
