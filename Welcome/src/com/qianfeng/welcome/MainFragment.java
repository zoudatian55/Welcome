package com.qianfeng.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment{
	//广告条的实现
	private int[] imagResid=new int[]{};
	private View view;
	private ViewPager pager;
	public MainFragment(){
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
	 view = inflater.inflate(R.layout.fragment_main, null);
	pager = (ViewPager) view.findViewById(R.id.viewpager);
	 pager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));
	 return view;
	}
	class MyPagerAdapter extends FragmentPagerAdapter{

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		
		}

		@Override
		public Fragment getItem(int arg0) {
		
			return null;
		}

		@Override
		public int getCount() {
			
			return imagResid.length;
		}
		
	}
}
