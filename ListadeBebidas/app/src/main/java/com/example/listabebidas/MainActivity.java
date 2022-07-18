package com.example.listabebidas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.listabebidas.Interfaces.NetworkResponseListener;
import com.example.listabebidas.adapter.ViewPageAdapter;
import com.example.listabebidas.fragment.Fragment1;
import com.example.listabebidas.fragment.Fragment2;
import com.example.listabebidas.task.LoadDataTask;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements NetworkResponseListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private MenuItem prevItem;
    private ViewPageAdapter viewPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LoadDataTask loadDataTask=new LoadDataTask(MainActivity.this);
//        loadDataTask.execute();

        final BottomNavigationView navigationMenu=findViewById(R.id.navigation);
        navigationMenu.setOnNavigationItemSelectedListener(MainActivity.this);
        viewPager=findViewById(R.id.viewpager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(prevItem!=null) {
                    prevItem.setChecked(false);
                }
                navigationMenu.getMenu().getItem(position).setChecked(true);
                prevItem=navigationMenu.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPagerAdapter=new ViewPageAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new Fragment1());
        viewPagerAdapter.addTitle("Home");
        viewPagerAdapter.addFragment(new Fragment2());
        viewPagerAdapter.addTitle("Profile");
        viewPager.setAdapter(viewPagerAdapter);


    }

    @Override
    public void SuccessData(String data) {
        Log.d("Response : ",data);
    }

    @Override
    public void SucessData(String data) {

    }

    @Override
    public void FailedData() {
        Toast.makeText(MainActivity.this, "Failed Data", Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if(menuItem.getItemId()==R.id.home){
            viewPager.setCurrentItem(0);
        }
        else {
            viewPager.setCurrentItem(1);
        }
        return false;

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}