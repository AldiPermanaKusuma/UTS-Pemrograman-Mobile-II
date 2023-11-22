package com.example.uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Beranda extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private HomeFragment homeFragment = new HomeFragment();
    private DosenFragment dosenFragment = new DosenFragment();
    private AboutFragment aboutFragment = new AboutFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomview);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // Set HomeFragment as default
        getSupportFragmentManager().beginTransaction().replace(R.id.flfragment, homeFragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;

        switch (item.getItemId()) {
            case R.id.profile:
                selectedFragment = homeFragment;
                break;
            case R.id.dosen:
                selectedFragment = dosenFragment;
                break;
            case R.id.about:
                selectedFragment = aboutFragment;
                break;
        }

        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flfragment, selectedFragment).commit();
            return true;
        }
        return false;
    }
}
