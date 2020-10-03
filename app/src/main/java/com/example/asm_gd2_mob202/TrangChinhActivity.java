package com.example.asm_gd2_mob202;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.asm_gd2_mob202.Fragment.fragment_khoanchi;
import com.example.asm_gd2_mob202.Fragment.fragment_thongke;
import com.example.asm_gd2_mob202.Fragment.fragment_khoanthu;
import com.google.android.material.navigation.NavigationView;


public class TrangChinhActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchinh_activity);

        NavigationView navigationView = findViewById(R.id.nv_view);
        navigationView.setItemIconTintList(null);

        mDrawerLayout = findViewById(R.id.dr_ly);
        toolbar = findViewById(R.id.tg_bar);
        navigationView = findViewById(R.id.nv_view);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mDrawerToggle = setupDraweToggle();

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.khoanthu);
            getSupportFragmentManager().beginTransaction().replace(R.id.fr_layout, new fragment_khoanthu()).commit();
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                //
                Class fragmentClass = null;
                switch (item.getItemId()) {
                    case R.id.khoanthu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fr_layout, new fragment_khoanthu()).commit();
                        break;
                    case R.id.khoanchi:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fr_layout, new fragment_khoanchi()).commit();
                        break;
                    case R.id.thongke:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fr_layout, new fragment_thongke()).commit();
                        break;
                    case R.id.gioithieu:
                        Toast.makeText(TrangChinhActivity.this, "Giới thiệu", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.thoat:
                        finish();
                        break;
                    default:
                        fragmentClass = fragment_khoanthu.class;
                }

                item.setChecked(true);
                setTitle(item.getTitle());
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private ActionBarDrawerToggle setupDraweToggle() {
        return new ActionBarDrawerToggle(TrangChinhActivity.this, mDrawerLayout, toolbar, R.string.Open, R.string.Close);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}