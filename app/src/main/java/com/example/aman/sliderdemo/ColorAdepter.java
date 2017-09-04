package com.example.aman.sliderdemo;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Aman on 8/31/2017.
 */

public class ColorAdepter extends BaseAdapter {
    Context context;
    ArrayList<Integer> arrayList = new ArrayList<>();
    LayoutInflater layoutInflater;

    public ColorAdepter(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ImageView button;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.coloradepter, parent, false);
        }
        button = (ImageView) convertView.findViewById(R.id.button);
//        button.setBackgroundColor(convertView.getResources().getColor(arrayList.get(position)));
        button.setBackgroundColor(convertView.getResources().getColor(arrayList.get(position)));
        return convertView;
    }
}
