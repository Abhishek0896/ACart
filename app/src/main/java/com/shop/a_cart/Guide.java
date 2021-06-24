package com.shop.a_cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Html;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.daimajia.easing.Glider;
import com.daimajia.easing.Skill;
import com.shop.a_cart.utils.Const;
import com.shop.a_cart.utils.MyPref;

import static com.shop.a_cart.utils.Const.IS_FIRST_TIME_LAUNCH;

public class Guide extends AppCompatActivity {
    TextView tvnext;
    ViewPager viewPager;
    LinearLayout layoutDots;
    MyPref pref;
    Context context;
    private int[] layouts;
    TextView[] dots;
    MyViewPagerAdapter viewPagerAdapter;
    LottieAnimationView laview;
    Button getstarted;
    int width, height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        tvnext = findViewById(R.id.tvnext);
        viewPager = findViewById(R.id.viewPager);
        laview = findViewById(R.id.laview);
        getstarted = findViewById(R.id.getstarted);
//        layoutDots = findViewById(R.id.layoutDots);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        context = Guide.this;
        pref = new MyPref(context);
        if(!pref.getBoolean(IS_FIRST_TIME_LAUNCH,true))
        {
            launchHomeScreen();
        }

        callAnimation();

        layouts = new int[]{
              R.layout.intro_1,
              R.layout.intro_2,
              R.layout.intro_3
        };

        tvnext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                int current = getItem(+1);
                if(current < layouts.length){
                    viewPager.setCurrentItem(current);
                }else{
                    launchHomeScreen();
                }
            }
        });

        getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPager();
            }
        });


    }

    private void initPager() {

        viewPager.setVisibility(View.VISIBLE);
        tvnext.setVisibility(View.VISIBLE);
        laview.setVisibility(View.GONE);
        getstarted.setVisibility(View.GONE);

        viewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(onPageChangeListener);
    }

    private void callAnimation() {
        AnimatorSet set = new AnimatorSet();
        AnimatorSet set2 = new AnimatorSet();
        set.playTogether(
                Glider.glide(Skill.ExpoEaseInOut, 5000, ObjectAnimator.ofFloat(laview, "translationY", 0, -(height/2))),
                Glider.glide(Skill.QuintEaseInOut, 5000, ObjectAnimator.ofFloat(laview, "translationX", 0, ((width/2)+220)))
        );
        set2.playTogether(
                Glider.glide(Skill.BounceEaseOut, 4500, ObjectAnimator.ofFloat(getstarted, "translationY", 0, -((height/2)-60)))
        );
        set.setDuration(2500);
        set.start();

        set2.setDuration(2500);
        set2.start();
    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == layouts.length - 1) {
                tvnext.setText("START");
            }else{
                tvnext.setText("NEXT");
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public class MyViewPagerAdapter extends PagerAdapter{
        LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }


        @Override
        public int getCount() {
            return layouts.length ;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

    private void launchHomeScreen() {
//        pref.putBoolean(IS_FIRST_TIME_LAUNCH, false);
        if(!pref.getString(Const.USER_AUTH_TOKEN, "").isEmpty())
            startActivity(new Intent(context, MainActivity.class));
        else
            startActivity(new Intent(context, Login.class));
        finish();
    }

    private int getItem(int postion){
        return viewPager.getCurrentItem() + 1;
    }
}