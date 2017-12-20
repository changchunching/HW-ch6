package com.example.homework_shop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private NavigationAdapter navigationAdapter;
    private ListView nav_custom_listview;
    //private Layout firstcustomrow;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<View> viewPager_views;

    private FirstAdapter firstAdapter;
    private ListView firstlist;
    private SecondAdapter secondAdapter;
    private ListView secondlist;
    private ThirdAdapter thirdAdapter;
    private ListView thirdlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //firstcustomrow = (Layout) findViewById(R.layout.first_custom_row);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //DrawerLayout
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        initNavigationView();
        initviewPager();

        initfirstlistview();
        initsecondlistview();
        initthirdlistview();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initNavigationView(){
        nav_custom_listview = (ListView)findViewById(R.id.nav_custom_listview);
        navigationAdapter=new NavigationAdapter(this);
        nav_custom_listview.setAdapter(navigationAdapter);
    }

    private void initviewPager(){
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        viewPager_views = new ArrayList<View>();
        viewPager_views.add(layoutInflater.inflate(R.layout.layout_first,null));
        viewPager_views.add(layoutInflater.inflate(R.layout.layout_second,null));
        viewPager_views.add(layoutInflater.inflate(R.layout.layout_third,null));

        viewPagerAdapter=new ViewPagerAdapter(viewPager_views,this);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void initfirstlistview(){
        View getview = viewPager_views.get(0);
        firstlist = (ListView)getview.findViewById(R.id.firstlist);
        firstAdapter=new FirstAdapter(getview.getContext());
        firstlist.setAdapter(firstAdapter);

    }

    private void initsecondlistview() {
        View getview = viewPager_views.get(1);
        secondlist=(ListView)getview.findViewById(R.id.secondlist);
        secondAdapter=new SecondAdapter(getview.getContext());
        secondlist.setAdapter(secondAdapter);
    }

    private void initthirdlistview(){
        View getview = viewPager_views.get(2);
        thirdlist=(ListView)getview.findViewById(R.id.thirdlist);
        thirdAdapter=new ThirdAdapter(getview.getContext());
        thirdlist.setAdapter(thirdAdapter);
    }
}
