package com.example.buttomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bnView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnView = findViewById (R.id.bottomNavi);

        bnView.setOnNavigationItemSelectedListener (new BottomNavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId ();
                if(id==R.id.nav_home){
                    loadFragments (new HomeFragment () , 0);
                }
                else if(id==R.id.nav_search){

                    loadFragments (new SearchFragment () , 1);
                }
                else if(id==R.id.nav_setting){

                    loadFragments (new SettingsFragment () , 1);
                }
                else if(id==R.id.nav_contacts){

                    loadFragments (new ContactsFragment () , 1);
                }
                else { //profile
                    loadFragments (new ProfileFragment () , 1);
                }
                return true; //this ture is selected items color.
            }
        });

        bnView.setSelectedItemId (R.id.nav_home);
    }
    public void loadFragments(Fragment fragment , int flag)
    {
        FragmentManager fm = getSupportFragmentManager ();
        FragmentTransaction ft = fm.beginTransaction ();
        if(flag==1)
        {
            ft.add (R.id.containerF ,fragment );
        }
        else
        {
            ft.replace (R.id.containerF , fragment);
        }
        ft.commit ();
    }
}