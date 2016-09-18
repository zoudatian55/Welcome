package com.qianfeng.welcome;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
/**
 * 启动界面
 * @author Administrator
 *
 */
public class SpiashActivity extends Activity{
	Handler handler=new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spiash);
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
			Intent intent=	new Intent();
			SharedPreferences sp=getPreferences(MODE_PRIVATE);
		boolean isFirst=sp.getBoolean("isFirst", true);
			if(isFirst){
				//用户第一次安装应用并进入
				sp.edit().putBoolean("isFirst", false).commit();
				intent.setClass(SpiashActivity.this, GuideActivity.class);
			
				
			}else{
				intent.setClass(SpiashActivity.this, MainActivity.class);
				
			}
			startActivity(intent);
			//可以设置界面之间的切换动画
			finish();
				
			}
		}, 3000);
	}
	

}
