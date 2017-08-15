package com.example.avinashkumaryadav.avinash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open_drawer,
                R.string.close_drawer);
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

       DisplaySelected(R.id.avi);

    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        if(drawerLayout!=null) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }  else {
                super.onBackPressed();
            }
        }

    }

    @SuppressWarnings("Statement With Empty Body")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DisplaySelected(item.getItemId());
            return true;
        }

        private void DisplaySelected(int itemid){
            Fragment fragment=null;
            switch (itemid){
                case R.id.avi:
                    fragment=new menuAvi();
                    break;
                case R.id.happybday:
                    fragment=new Menu1();
                    break;
                case R.id.College:
                    fragment=new Collegemenu();
                    break;
                case R.id.school:
                    fragment=new Schoolmenu();
                    break;
                case R.id.interest:
                    fragment=new Interestmenu();
                    break;
                case R.id.contact:
                    fragment=new Contactsmenu();
                    break;
                case R.id.devel:
                    fragment=new Developermenu();
                    break;

                case R.id.Songs:
                    fragment=new Songsmenu();
                    break;


            }
            if(fragment!=null){
                FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main_content,fragment);

                ft.commit();
            }
            DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }

}
