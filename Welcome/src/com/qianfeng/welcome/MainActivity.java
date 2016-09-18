package com.qianfeng.welcome;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;

import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	private Class[] fragments=new Class[]{MainFragment.class,MoreFragment.class,MineFragment.class};
    private String[] tabtitle=new String[]{"首页","更多","我的"};
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTabHost tabHost=(FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(MainActivity.this, getSupportFragmentManager(),android.R.id.tabcontent);
        for (int i = 0; i < fragments.length; i++) {
			View inflate=getLayoutInflater().inflate(R.layout.tab_item, null);
			TextView tab_tv=(TextView) inflate.findViewById(R.id.tv);
        	tab_tv.setText(tabtitle[i]);
			tabHost.addTab(tabHost.newTabSpec(""+i).setIndicator("tab1").setIndicator(inflate),fragments[i],null);
		}
    
    }
}
