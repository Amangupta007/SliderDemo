package com.example.aman.sliderdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by Aman on 8/30/2017.
 */

 public class PagerAdepter extends PagerAdapter {
    Context context;
    ImageView main_image, imageView;
    View itemView;
    LayoutInflater layoutInflater;
    ArrayList<Integer> arrayList = new ArrayList<>();
    ArrayList<Integer> bg = new ArrayList<>();
    ArrayList<SetterGetterClass> setterGetterClasses = new ArrayList<>();

    public PagerAdepter(Context context, ArrayList<Integer> arrayList, ArrayList<SetterGetterClass> setterGetterClasses, ArrayList<Integer> bg) {
        this.context = context;
        this.arrayList = arrayList;
        this.setterGetterClasses = setterGetterClasses;
        this.bg = bg;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        itemView = layoutInflater.inflate(R.layout.adepter, container, false);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        main_image = (ImageView) itemView.findViewById(R.id.main_image);
        itemView.setTag("View" + position);
        imageView.setImageResource(arrayList.get(position));
        container.addView(itemView);
        return itemView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout) object);
    }


    public void addBack(int pos) {
//        main_image.setImageResource(bg.get(pos - 1));
//        imageView.setImageResource(arrayList.get(pos - 1));
        main_image.setColorFilter(main_image.getResources().getColor(setterGetterClasses.get(pos).getColor()), PorterDuff.Mode.SRC_IN);
    }

}


