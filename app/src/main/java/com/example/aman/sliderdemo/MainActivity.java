package com.example.aman.sliderdemo;

import android.Manifest;
import android.content.Context;

import com.soundcloud.android.crop.Crop;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> arrayList = new ArrayList<>();
    ArrayList<SetterGetterClass> setterGetterList = new ArrayList<>();
    ArrayList<Integer> colorarraylist = new ArrayList<>();
    ArrayList<Integer> bg = new ArrayList<>();
    ViewPager viewPager;
    GridView gridView;
    PagerAdepter pagerAdepter;
    MyViewPagerAdapter mv;
    ImageView main_image, imageView;


    public static void startWithUri(@NonNull Context context, @NonNull Uri uri) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setData(uri);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        gridView = (GridView) findViewById(R.id.grid);

        arrayList.add(R.drawable.ss1);
        arrayList.add(R.drawable.ss2);
        arrayList.add(R.drawable.ss3);
        arrayList.add(R.drawable.ss4);
        arrayList.add(R.drawable.ss5);
        arrayList.add(R.drawable.ss6);
        arrayList.add(R.drawable.ss7);
        arrayList.add(R.drawable.ss8);
        arrayList.add(R.drawable.ss9);
        arrayList.add(R.drawable.ss10);
        arrayList.add(R.drawable.ss11);
        arrayList.add(R.drawable.ss12);
        bg.add(R.drawable.sample);
        bg.add(R.drawable.sample);
        bg.add(R.drawable.sample);
        bg.add(R.drawable.sample);
        bg.add(R.drawable.sample);
        bg.add(R.drawable.sample);
        bg.add(R.drawable.sample);
        bg.add(R.drawable.sample);
        bg.add(R.drawable.sample);
        bg.add(R.drawable.sample);
        bg.add(R.drawable.sample);
        bg.add(R.drawable.sample);
        bg.add(R.drawable.sample);
        viewPager = (ViewPager) findViewById(R.id.pager);

        colorarraylist.add(R.color.colorPrimary);
        colorarraylist.add(R.color.colorPrimaryDark);
        colorarraylist.add(R.color.colorAccent);
        colorarraylist.add(R.color.red);
        colorarraylist.add(R.color.light_coff);
        colorarraylist.add(R.color.dark_yellow);
        colorarraylist.add(R.color.popat);
        colorarraylist.add(R.color.yellow);
        colorarraylist.add(R.color.aes);
        colorarraylist.add(R.color.pink);
        colorarraylist.add(R.color.black);
        colorarraylist.add(R.color.sky_blue);
        colorarraylist.add(R.color.light_aes);
        colorarraylist.add(R.color.white);
        colorarraylist.add(R.color.dark_red);

        for (int i = 0; i < colorarraylist.size(); i++) {
            SetterGetterClass setterGetterClass = new SetterGetterClass();
            setterGetterClass.setColor(colorarraylist.get(i));
            setterGetterList.add(setterGetterClass);

        }

//        pagerAdepter = new PagerAdepter(MainActivity.this, arrayList, setterGetterList , bg);
//        viewPager.setAdapter(pagerAdepter);
        mv = new MyViewPagerAdapter();
        viewPager.setAdapter(mv);
        final ColorAdepter colorAdepter = new ColorAdepter(MainActivity.this, colorarraylist);
        gridView.setAdapter(colorAdepter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View v = viewPager.findViewWithTag("pos" + viewPager.getCurrentItem());
                ImageView main_image1 = (ImageView) v.findViewById(R.id.main_image);
                main_image1.setColorFilter(getResources().getColor(colorarraylist.get(position)));
//                main_image.setImageResource(R.color.pink);
//                viewPager.getAdapter().notifyDataSetChanged();
//                viewPager.findViewWithTag("View");

//                mv.notifyDataSetChanged();

//                pagerAdepter.addBack(position);

            }
        });

    }



    public class MyViewPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.adepter, container, false);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            main_image = (ImageView) view.findViewById(R.id.main_image);
            view.setTag("pos" + position);
            if (getIntent().getData() != null){
                imageView.setImageURI(getIntent().getData());
            }else{
                imageView.setImageResource(arrayList.get(position));
            }

            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == ((View) obj);
        }

        public ImageView getCurrentView() {
            return main_image;
        }
//        @Override
//        public int getItemPosition(Object object) {
//            return PagerAdapter.POSITION_NONE;
//        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
