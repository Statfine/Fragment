package com.sj.at.five;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sj.at.myfragment.R;

import java.util.ArrayList;


public class ViewPageFragment extends FragmentActivity{


    private static final String TAG = "MainActivity";
    private ViewPager mPager;
    private ArrayList<Fragment> fragmentsList;
    private ImageView ivBottomLine;
    private TextView tvTabActivity, tvTabGroups, tvTabFriends, tvTabChat;

    private int currIndex = 0;
    private int bottomLineWidth;
    private int offset = 0;
    private int position_one;
    private int position_two;
    private int position_three;
    private Resources resources;


    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);

        setContentView(R.layout.fragment_viewpage);
        resources = getResources();

        InitWidth();//初始化 动画的距离
        InitTextView();//初始化 控件
        InitViewPage();//控件添加适配器 绑定事件
    }

    private void InitWidth(){
        ivBottomLine = (ImageView) findViewById(R.id.iv_bottom_line);
        bottomLineWidth = ivBottomLine.getLayoutParams().width;
        Log.d(TAG, "cursor imageview width=" + bottomLineWidth);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;

        offset = (int) ((screenW / 4.0 - bottomLineWidth) / 2);
        Log.i("MainActivity", "offset=" + offset);

//        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)ivBottomLine.getLayoutParams();
//        params.setMargins(offset, 0, 0, 0);
//        ivBottomLine .setLayoutParams(params);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)ivBottomLine.getLayoutParams();
        params.setMargins(offset, 0, 0, 0);
        ivBottomLine .setLayoutParams(params);//适配 动态设置底部移动的图片

        position_one = (int) (screenW / 4.0);
        position_two = position_one * 2;
        position_three = position_one * 3;

    }

    private void InitTextView(){
        tvTabActivity = (TextView) findViewById(R.id.tv_tab_activity);
        tvTabGroups = (TextView) findViewById(R.id.tv_tab_groups);
        tvTabFriends = (TextView) findViewById(R.id.tv_tab_friends);
        tvTabChat = (TextView) findViewById(R.id.tv_tab_chat);

        tvTabActivity.setOnClickListener(new MyOnClickListener(0));
        tvTabGroups.setOnClickListener(new MyOnClickListener(1));
        tvTabFriends.setOnClickListener(new MyOnClickListener(2));
        tvTabChat.setOnClickListener(new MyOnClickListener(3));
    }



    public class MyOnClickListener implements OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            mPager.setCurrentItem(index);
        }
    };

    private void InitViewPage(){
        mPager = (ViewPager) findViewById(R.id.vPager);
        fragmentsList = new ArrayList<Fragment>();

        Fragment activityfragment = TestFragment.newInstance("Hello Activity.");
        Fragment groupFragment = TestFragment.newInstance("Hello Group.");
        Fragment friendsFragment=TestFragment.newInstance("Hello Friends.");
        Fragment chatFragment=TestFragment.newInstance("Hello Chat.");

        fragmentsList.add(activityfragment);
        fragmentsList.add(groupFragment);
        fragmentsList.add(friendsFragment);
        fragmentsList.add(chatFragment);

        //换屏在FragmentPagerAdapter中
        mPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentsList));
        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    //OnPageChangeListener  改变是 顶部的动画滑动
    public class MyOnPageChangeListener implements OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
                case 0:
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(position_one, 0, 0, 0);
                        tvTabGroups.setTextColor(resources.getColor(R.color.lightwhite));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(position_two, 0, 0, 0);
                        tvTabFriends.setTextColor(resources.getColor(R.color.lightwhite));
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(position_three, 0, 0, 0);
                        tvTabChat.setTextColor(resources.getColor(R.color.lightwhite));
                    }
                    tvTabActivity.setTextColor(resources.getColor(R.color.white));
                    break;
                case 1:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(0, position_one, 0, 0);
                        tvTabActivity.setTextColor(resources.getColor(R.color.lightwhite));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(position_two, position_one, 0, 0);
                        tvTabFriends.setTextColor(resources.getColor(R.color.lightwhite));
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(position_three, position_one, 0, 0);
                        tvTabChat.setTextColor(resources.getColor(R.color.lightwhite));
                    }
                    tvTabGroups.setTextColor(resources.getColor(R.color.white));
                    break;
                case 2:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(0, position_two, 0, 0);
                        tvTabActivity.setTextColor(resources.getColor(R.color.lightwhite));
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(position_one, position_two, 0, 0);
                        tvTabGroups.setTextColor(resources.getColor(R.color.lightwhite));
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(position_three, position_two, 0, 0);
                        tvTabChat.setTextColor(resources.getColor(R.color.lightwhite));
                    }
                    tvTabFriends.setTextColor(resources.getColor(R.color.white));
                    break;
                case 3:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(0, position_three, 0, 0);
                        tvTabActivity.setTextColor(resources.getColor(R.color.lightwhite));
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(position_one, position_three, 0, 0);
                        tvTabGroups.setTextColor(resources.getColor(R.color.lightwhite));
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(position_two, position_three, 0, 0);
                        tvTabFriends.setTextColor(resources.getColor(R.color.lightwhite));
                    }
                    tvTabChat.setTextColor(resources.getColor(R.color.white));
                    break;
            }
            currIndex = arg0;
            animation.setFillAfter(true);//保持动画之后的状态
            animation.setDuration(300);
            ivBottomLine.startAnimation(animation);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }


}