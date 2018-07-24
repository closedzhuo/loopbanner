package com.bonnidee.loopbannerdemo;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager1;
    private ViewPager viewpage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager1 = findViewById(R.id.viewpage1);
        viewpage2 = findViewById(R.id.viewpage2);
        init();
    }

    private void init() {
        viewPager1.setAdapter(new ViewAdapte1());
        viewpage2.setAdapter(new ViewAdapter2(getSupportFragmentManager()));
    }


    class ViewAdapte1 extends PagerAdapter {

        private static final int DEFAULT_BANNER_SIZE = 4;
        private int FAKE_BANNER_SIZE = 100;

        @Override
        public int getCount() {
            return FAKE_BANNER_SIZE;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            position %= DEFAULT_BANNER_SIZE;
            View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_adapter, container, false);
            ImageView iv_image = view.findViewById(R.id.iv_image);
            TextView tv_title = view.findViewById(R.id.title);
            tv_title.setText("position" + position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            try {
                container.removeView((View) object);
            } catch (Exception e) {

            }


        }

        @Override
        public void finishUpdate(@NonNull ViewGroup container) {
            int currentItem = viewPager1.getCurrentItem();
            if (currentItem == 0) {
                currentItem = 4;
                viewPager1.setCurrentItem(currentItem, false);
            } else if (currentItem == FAKE_BANNER_SIZE - 1) {
                currentItem = DEFAULT_BANNER_SIZE - 1;
                viewPager1.setCurrentItem(currentItem, false);

            }


        }
    }


    class ViewAdapter2 extends FragmentStatePagerAdapter {

        private int FAKE_BANNER_SIZE = 100;
        private int DEFAULT_BANNER_SIZE = 4;

        public ViewAdapter2(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            position %= DEFAULT_BANNER_SIZE;
            return new HomeFragment(position);
        }

        @Override
        public int getCount() {
            return FAKE_BANNER_SIZE;
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            super.finishUpdate(container);
            int currentItem = viewpage2.getCurrentItem();
            if (currentItem == 0) {
                currentItem = DEFAULT_BANNER_SIZE;
                viewpage2.setCurrentItem(currentItem, false);
            } else if (currentItem == FAKE_BANNER_SIZE - 1) {
                currentItem = DEFAULT_BANNER_SIZE - 1;
                viewpage2.setCurrentItem(currentItem, false);

            }

        }
    }


}
