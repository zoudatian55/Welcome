package com.qianfeng.welcome;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class GuideActivity extends Activity{
	private ViewPager viewPager;
	private List<ImageView> images=new ArrayList<ImageView>();
	private Drawable drawable;
	private TypedArray ta;
	private Button btn;
 //获取图片的资源

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide);
		viewPager = (ViewPager) findViewById(R.id.viewpager_Main);
		btn = (Button) findViewById(R.id.btn_start);
		initData();
		viewPager.setAdapter(new MyPaperAdapter());
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
             startActivity(new Intent(GuideActivity.this,MainActivity.class ));				
			 finish();
			}
		});
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			//ViewPager滚动第几张
			@Override
			public void onPageSelected(int position) {
				//加入ViewPager滚动到最后一张就显示
				if(position==ta.length()-1){
					btn.setVisibility(View.	VISIBLE);
				}else{
                    btn.setVisibility(View.GONE);
			}
				}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
	}
	
	
	
	//初始化数据
	private void initData() {
		ta = getResources().obtainTypedArray(R.array.image_arr);
		for (int i = 0; i < ta.length(); i++) {
			drawable = ta.getDrawable(i);
			 ImageView  image = new ImageView(this);
			 image.setScaleType(ScaleType.FIT_XY);
			 image.setImageDrawable(drawable);
			 images.add(image);
		}

	}
	//引导界面适配器
	class MyPaperAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return images.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {

			return arg0==arg1;
		}
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
          container.addView(images.get(position));
			return images.get(position);
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
		    container.removeView(images.get(position));

		}
	}

}
