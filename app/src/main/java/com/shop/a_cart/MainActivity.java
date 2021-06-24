package com.shop.a_cart;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shop.a_cart.Fragments.CartFragment;
import com.shop.a_cart.Fragments.Category;
import com.shop.a_cart.Fragments.HelpFrag;
import com.shop.a_cart.Fragments.Home;
import com.shop.a_cart.Fragments.NotificationFragment;
import com.shop.a_cart.Fragments.Order;
import com.shop.a_cart.Fragments.PrivacyFrag;
import com.shop.a_cart.Fragments.Profile;
import com.shop.a_cart.Fragments.SettingFrag;
import com.shop.a_cart.Fragments.WishlistFragment;
import com.shop.a_cart.adapter.Drawer.DrawerAdapter;
import com.shop.a_cart.model.Drawer.DrawerItem;
import com.shop.a_cart.model.Drawer.SimpleItem;
import com.shop.a_cart.model.Drawer.SpaceItem;
import com.shop.a_cart.utils.Const;
import com.shop.a_cart.utils.MyPref;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener {


    private static final int POS_NOTIFICATION = 3;
    private static final int POS_CART = 0;
    private static final int POS_ORDER = 1;
    private static final int POS_BlANK = 8;
    private static final int POS_LOGOUT = 9;
    private static final int POS_SETTING = 5;
    private static final int POS_WISHLIST = 2;
    private static final int POS_PRIVACY = 7;
    private static final int POS_HELP = 6;
    private static final int POS_PROFILE = 4;
    CircleImageView img;
    FloatingActionButton fabcart;
    private String[] screenTitles;
    private Drawable[] screenIcons;
    BottomAppBar bottomAppBar ;
    private SlidingRootNav slidingRootNav;
    CoordinatorLayout maincontainer;
    MyPref pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        pref = new MyPref(MainActivity.this);

        fabcart = findViewById(R.id.floatingActionButton2);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        fabcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartFragment frag = new CartFragment();
                transaction.replace(R.id.container, frag);
            }
        });

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("Hello User");
//        setSupportActionBar(toolbar);

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withDragDistance(180)
                .withRootViewScale(0.75f)
                .withRootViewElevation(75)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withMenuLayout(R.layout.drawer_menu)
                .withSavedState(savedInstanceState)
                .inject();

        img = slidingRootNav.getLayout().findViewById(R.id.profile);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Profile frag = new Profile();
                transaction.replace(R.id.container,frag);
                transaction.commit();
                img.setBorderColor(Color(R.color.blue));
            }
        });

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
           createItemFor(POS_CART),
           createItemFor(POS_NOTIFICATION),
           createItemFor(POS_ORDER),
           createItemFor(POS_HELP),
           createItemFor(POS_PRIVACY),
           createItemFor(POS_SETTING),
           createItemFor(POS_WISHLIST),
           createItemFor(POS_PROFILE),
           new SpaceItem(10),
           createItemFor(POS_LOGOUT)
//

        ));
        adapter.setListener(this);

        RecyclerView list = findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        bottomAppBar = findViewById(R.id.bottomAppBar2);
//        CoordinatorLayout.LayoutParams layout = (CoordinatorLayout.LayoutParams) bottomAppBar.getLayoutParams();
//        layout.setBehavior(new AppBarLayout.ScrollingViewBehavior());

    }

    private DrawerItem createItemFor(int positon){
        return new SimpleItem(screenIcons[positon], screenTitles[positon])
                .withIconTint(R.color.black)
                .withTextTint(R.color.black)
                .withSelectedIconTint(R.attr.icon)
                .withSelectedTextTint(R.attr.icon);
    }

    @ColorInt
    private int Color(@ColorRes int res){
        return ContextCompat.getColor(this, res);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.id_activityScreenIcon);
        Drawable[] icons = new Drawable[ta.length()];
        for(int i =0; i< ta.length(); i++)
        {
            int id = ta.getResourceId(i, 0);
            if(id !=0){
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    private String[] loadScreenTitles(){
        return getResources().getStringArray(R.array.id_activityScreenTitles);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onItemSelected(int positon) {
        img.setBorderColor(Color(R.color.profile));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(positon == POS_ORDER)
        {
            Order order = new Order();
            transaction.replace(R.id.container,order);
        }

        if(positon == POS_SETTING){
            SettingFrag frag = new SettingFrag();
            transaction.replace(R.id.container,frag);
        }

        else if(positon == POS_PRIVACY){
            PrivacyFrag frag = new PrivacyFrag();
            transaction.replace(R.id.container,frag);
        }

        else if(positon == POS_PROFILE){
            Home frag = new Home();
            transaction.replace(R.id.container,frag);
        }

        else if(positon == POS_HELP){
            HelpFrag frag = new HelpFrag();
            transaction.replace(R.id.container,frag);
        }

        else if(positon == POS_NOTIFICATION){
            Category frag = new Category();
            transaction.replace(R.id.container,frag);
        }

        else if(positon == POS_WISHLIST){
            WishlistFragment frag = new WishlistFragment();
            transaction.replace(R.id.container, frag);
        }

        else if(positon == POS_CART){
            CartFragment frag = new CartFragment();
            transaction.replace(R.id.container, frag);
        }

        else if(positon == POS_LOGOUT){
            pref.remove(Const.USER_AUTH_TOKEN);
            finish();
        }

        slidingRootNav.closeMenu();
        transaction.addToBackStack(null);
        transaction.commit();

    }



}
