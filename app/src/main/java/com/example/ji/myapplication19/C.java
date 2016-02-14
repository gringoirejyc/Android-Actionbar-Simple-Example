package com.example.ji.myapplication19;

import android.nfc.Tag;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
;


public class C extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    Toolbar myChildToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        setupDrawerLayout();

        // my_child_toolbar is defined in the layout file
        myChildToolbar = (Toolbar) findViewById(R.id.my_childtoolbar);
        setSupportActionBar(myChildToolbar);

        ActionBar ab = getSupportActionBar();

        // Get a support ActionBar corresponding to this toolbar
        if(ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setHomeAsUpIndicator(R.drawable.rsz_ic_list_white_48dp);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_c, menu);

        MenuItem searchitem = menu.findItem(R.id.action_search1);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchitem);

        // Define the listener
        MenuItemCompat.OnActionExpandListener expandListener = new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when action item collapses
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                return true;  // Return true to expand action view
            }
        };

        // Get the MenuItem for the action item
        MenuItem actionMenuItem = menu.findItem(R.id.action_sharre);

        MenuItemCompat.setOnActionExpandListener(actionMenuItem, expandListener);

        // Assign the listener to that action item
        return super.onCreateOptionsMenu(menu);
    }

    public void setupDrawerLayout(){
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_c);

        NavigationView view = (NavigationView) findViewById(R.id.navigation_view);

        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Snackbar.make(getWindow().getDecorView(), menuItem.getTitle() + " pressed", Snackbar.LENGTH_LONG).show();
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });

         mDrawerToggle = new ActionBarDrawerToggle(this,
                                                   drawerLayout,
                                                   myChildToolbar, R.string.drawer_open,R.string.drawer_close)
        {
             @Override
             public void onDrawerClosed(View drawerView) {
                 super.onDrawerClosed(drawerView);
             }

             @Override
             public void onDrawerOpened(View drawerView) {
                 super.onDrawerOpened(drawerView);
             }
        };
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });


        drawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){

            case R.id.action_settings:
                return true;

        }
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }


        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
