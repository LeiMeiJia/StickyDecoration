package com.example.aiyang.stickydecoration.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.example.aiyang.stickydecoration.R;
import com.example.aiyang.stickydecoration.adapter.SimpleAdapter;
import com.example.aiyang.stickydecoration.bean.ShopBean;
import com.example.aiyang.stickydecoration.view.AppBarStateChangeListener;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ShopBean> sLists =new ArrayList<>();
    private AppBarLayout appbarlayout;
    private Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initData();
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new SimpleAdapter(this,sLists));
        appbarlayout =findViewById(R.id.appbarlayout);

        appbarlayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if( state == State.EXPANDED ) {

                    //展开状态
                    toolbar.setNavigationIcon(null);

                }else if(state == State.COLLAPSED){
                    //折叠状态
                    toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
                }else {
                    //中间状态
                    toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);

                }
            }
        });

    }

    private void initData() {
        ShopBean shop;
        for (int i = 0 ; i<6;i++){
            shop = new ShopBean();
            switch (i){
                case 0:
                    shop.setPicture_loacal(R.mipmap.shop1);
                    break;

                case 1:
                    shop.setPicture_loacal(R.mipmap.shop2);
                    break;

                case 2:
                    shop.setPicture_loacal(R.mipmap.shop3);
                    break;

                case 3:
                    shop.setPicture_loacal(R.mipmap.shop4);
                    break;

                case 4:
                    shop.setPicture_loacal(R.mipmap.shop5);
                    break;

                case 5:
                    shop.setPicture_loacal(R.mipmap.shop6);
                    break;
            }
            shop.setShopDescrition("这是第 "+i+" 个对商家的描述信息");
            shop.setShopName("食尚"+i+"号馆");
            sLists.add(shop);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_search).setIcon(android.support.v7.appcompat.R.drawable.abc_ic_search_api_material);
        menu.findItem(R.id.menu_favorite).setIcon(android.support.v7.appcompat.R.drawable.abc_ic_star_black_36dp);
        menu.findItem(R.id.menu_share).setIcon(android.support.v7.appcompat.R.drawable.abc_ic_menu_share_mtrl_alpha);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_search:
                Toast.makeText(this, "嘿！ 就这点数据还想查？", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_favorite:
                Toast.makeText(this, "嘿 ！眼光不错哦！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_share:
                Toast.makeText(this, "嘿！ 分享到哪？", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}