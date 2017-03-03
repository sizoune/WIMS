package com.example.pattimura.wims;

import android.graphics.Typeface;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class LandingPage extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

        Fragment fragment;
        TextView judul;
        Typeface face;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/sfns.ttf");
            FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/sfns.ttf");
            FontsOverride.setDefaultFont(this, "SERIF", "fonts/sfns.ttf");
            FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/sfns.ttf");
            setContentView(R.layout.activity_landing_page);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            judul = (TextView) toolbar.findViewById(R.id.toolbar_title);
            judul.setText("Pesan");
            face = Typeface.createFromAsset(getAssets(),
                    "fonts/sfns.ttf");


            fragment = new PesanFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainframe, fragment);
            ft.commit();


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
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            //if (id == R.id.action_settings) {
            //    return true;
            //}

            return super.onOptionsItemSelected(item);
        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.nav_beranda) {
                fragment = new PesanFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainframe, fragment);
                judul.setText("Beranda");
                judul.setTypeface(face);
                ft.commit();
            } else if (id == R.id.nav_pesan) {
                fragment = new PesanFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainframe, fragment);
                judul.setText("Pesan");
                judul.setTypeface(face);
                ft.commit();
            } else if (id == R.id.nav_timeline) {
                fragment = new PesanFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainframe, fragment);
                judul.setText("Timeline");
                judul.setTypeface(face);
                ft.commit();
            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

}
