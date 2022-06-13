package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);

//        StartupFragment startupFragment=new StartupFragment();
//        startupFragment.recyclerView=findViewById(R.id.recyclerView);;

        recyclerView=findViewById(R.id.recyclerView);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new StartupFragment()).commit();
        }
    }

    RecyclerView recyclerView;

    private NavigationBarView.OnItemSelectedListener  navListener =
            new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_startup:
                            selectedFragment = new StartupFragment();
                            //((StartupFragment) selectedFragment).getStartupRecyclerView(recyclerView);
                            break;
                        case R.id.nav_account:
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.nav_investor:
                            selectedFragment = new InvestorFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }


            };
}