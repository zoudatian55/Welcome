package com.qianfeng.welcome;


import android.R.integer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;


public class MainActivity extends FragmentActivity {

	

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTabHost tabHost=(FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(MainActivity.this, getSupportFragmentManager(),android.R.id.tabcontent);
      tabHost.addTab(tabHost.newTabSpec("").setIndicator("tab1"),BlankFragment.class,null);
      tabHost.addTab(tabHost.newTabSpec("").setIndicator("tab2"),BlankFragment.class,null);
      tabHost.addTab(tabHost.newTabSpec("").setIndicator("tab3"),BlankFragment.class,null);
    }
}
