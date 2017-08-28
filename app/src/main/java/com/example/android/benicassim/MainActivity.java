package com.example.android.benicassim;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.text.util.Linkify;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static com.example.android.benicassim.R.id.location_address_text_view;

// Implementation of the onFragmentInteractionListener in the main activity class declaration to enable the navigation between fragments
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        HomeFragment.OnFragmentInteractionListener,
        HotelsFragment.OnFragmentInteractionListener,
        RestaurantsFragment.OnFragmentInteractionListener,
        CafesFragment.OnFragmentInteractionListener,
        GroceryStoresFragment.OnFragmentInteractionListener,
        BeachesFragment.OnFragmentInteractionListener,
        SportsFragment.OnFragmentInteractionListener,
        LeisureParksFragment.OnFragmentInteractionListener,
        EventsFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a Toolbar to replace the ActionBar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /* Launch the home fragment
         The piece of code below was found on this tutorial : http://chrisrisner.com/Using-Fragments-with-the-Navigation-Drawer-Activity*/
        Fragment fragment = null;
        Class fragmentClass = null;
        fragmentClass = HomeFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Find our drawer view
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        // Instantiate the navigation view
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    // This method handles the behaviour of the back function according to the state of the navigation view
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass = null;

        switch(item.getItemId()) {
            case (R.id.nav_home):
                fragmentClass = HomeFragment.class;
                break;
            case (R.id.nav_hotels) :
                fragmentClass = HotelsFragment.class;
                break;
            case (R.id.nav_restaurants):
                fragmentClass = RestaurantsFragment.class;
                break;
            case (R.id.nav_cafes):
                fragmentClass = CafesFragment.class;
                break;
            case (R.id.nav_grocery_stores):
                fragmentClass = GroceryStoresFragment.class;
                break;
            case (R.id.nav_beaches):
                fragmentClass = BeachesFragment.class;
                break;
            case (R.id.nav_sports) :
                fragmentClass = SportsFragment.class;
                break;
            case (R.id.nav_leisure_parks):
                fragmentClass = LeisureParksFragment.class;
                break;
            case (R.id.nav_events):
                fragmentClass = EventsFragment.class;
                break;
        }
        //The piece of code below was found on this tutorial : http://chrisrisner.com/Using-Fragments-with-the-Navigation-Drawer-Activity
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // Implementation of the onFragmentInteraction methods for each fragment
    @Override
    public void onHomeFragmentInteraction(Uri uri) {}
    @Override
    public void onHotelsFragmentInteraction(Uri uri) {}
    @Override
    public void onRestaurantsFragmentInteraction(Uri uri) {}
    @Override
    public void onCafesFragmentInteraction(Uri uri) {}
    @Override
    public void onGroceryStoresFragmentInteraction(Uri uri) {}
    @Override
    public void onBeachesFragmentInteraction(Uri uri) {}
    @Override
    public void onSportsFragmentInteraction(Uri uri) {}
    @Override
    public void onLeisureParksFragmentInteraction(Uri uri) {}
    @Override
    public void onEventsFragmentInteraction(Uri uri) {}

}

