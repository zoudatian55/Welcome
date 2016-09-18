package com.qianfeng.welcome;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
/**
 * ��������
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
				//�û���һ�ΰ�װӦ�ò�����
				sp.edit().putBoolean("isFirst", false).commit();
				intent.setClass(SpiashActivity.this, GuideActivity.class);
			
				
			}else{
				intent.setClass(SpiashActivity.this, MainActivity.class);
				
			}
			startActivity(intent);
			//�������ý���֮����л�����
			finish();
				
			}
		}, 3000);
	}
	

}
