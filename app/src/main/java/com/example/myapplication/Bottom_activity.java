package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Bottom_activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        replaceFragment(new HomeFragment());
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);

//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()){
//                    case R.id.home:
//                        replaceFragment(new HomeFragment());
//                        return true;
//                    case R.id.shorts:
//                        replaceFragment(new ShortFragment());
//                        return true;
//
//
//                }
//                return false;
//            }
//        });


    }

    public void replaceFragment(Fragment fragment){

           getSupportFragmentManager()
                   .beginTransaction()
                   .replace(R.id.frame_layout,fragment)
                   .commit();

    }

}