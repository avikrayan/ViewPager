package com.example.avik.viewpager;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView one,two,three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        one = (TextView) findViewById(R.id.tvOne);
        two = (TextView) findViewById(R.id.tvTwo);
        three = (TextView) findViewById(R.id.tvThree);
        setupViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                String pos = String.valueOf(position);
                Toast.makeText(MainActivity.this, pos, Toast.LENGTH_SHORT).show();

                if (position==0){
                    one.setTextColor(Color.BLUE);
                    two.setTextColor(Color.BLACK);
                    three.setTextColor(Color.BLACK);
                }else if (position==1){
                    one.setTextColor(Color.BLACK);
                    two.setTextColor(Color.BLUE);
                    three.setTextColor(Color.BLACK);
                }
                else if (position==2){
                    one.setTextColor(Color.BLACK);
                    two.setTextColor(Color.BLACK);
                    three.setTextColor(Color.BLUE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment());
        adapter.addFragment(new TwoFragment());
        adapter.addFragment(new ThreeFragment());
        viewPager.setAdapter(adapter);

    }
}
