package com.sj.at.four;


import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sj.at.myfragment.R;

/**
 * @author ShaoJia
 *  三页滑动
 *
 */
public class ViewPageTest extends Activity implements OnClickListener{

	private ViewPager viewpager;
	TextView record_time_text = null;
	TextView star_len_text = null;
	TextView date_size_text = null;


	TextView readList = null;
	TextView favList = null;
	TextView lengthList = null;
	RankPagerAdapter rankPagerAdapter = null;//如果是 fragment 则调用FragmentPagerAdapter
	private Fragment fOne;
	//点击事件的更换  viewpager.setCurrentItem(0);

	private LinearLayout rank_record;
	private LinearLayout rank_star;
	private LinearLayout rank_date;
	private LinearLayout button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_page);

		initLayout();
	}

	private void initLayout(){
		viewpager = (ViewPager) this.findViewById(R.id.viewpager);
		record_time_text = (TextView) this.findViewById(R.id.record_time_text);
		star_len_text = (TextView) this.findViewById(R.id.star_len_text);
		date_size_text = (TextView) this.findViewById(R.id.date_size_text);

		rank_record = (LinearLayout) this.findViewById(R.id.rank_record);
		rank_star = (LinearLayout) this.findViewById(R.id.rank_star);
		rank_date = (LinearLayout) this.findViewById(R.id.rank_date);
		button = (LinearLayout) this.findViewById(R.id.button);

		rankPagerAdapter = new RankPagerAdapter();

		viewpager.setOffscreenPageLimit(3);
		viewpager.setOnPageChangeListener(changeListener);
		rankPagerAdapter = new RankPagerAdapter();
		rankPagerAdapter.setCount(3);
		viewpager.setAdapter(rankPagerAdapter);
		changeListener.onPageSelected(0);

		rank_record.setOnClickListener(this);
		rank_star.setOnClickListener(this);
		rank_date.setOnClickListener(this);

	}


	public class RankPagerAdapter extends PagerAdapter {

		int mCount;
		private View OneView;
		private View TwoView;
		private View ThreeView;

		public void setCount(int mCount){
			OneView = LayoutInflater.from(ViewPageTest.this).inflate(
					R.layout.activity_page_image, null);
			TwoView = LayoutInflater.from(ViewPageTest.this).inflate(
					R.layout.activity_page_image, null);
			ThreeView = LayoutInflater.from(ViewPageTest.this).inflate(
					R.layout.activity_page_image, null);

			this.mCount = mCount;
		}

		@Override
		public int getCount() {
			return mCount;
		}

		@Override
		public Object instantiateItem(View collection, int position) {
//			View mView = LayoutInflater.from(ViewPageTest.this).inflate(
//					R.layout.activity_page_image, null);
//			TextView view = (TextView) mView
//					.findViewById(R.id.tv_page);
//			ImageView iv_show_pic = (ImageView) mView.findViewById(R.id.iv_show_pic);
//			view.setOnClickListener((OnClickListener) ViewPageTest.this);
//			iv_show_pic.setOnClickListener((OnClickListener) ViewPageTest.this);
//			if (position == 0) {
//				if(mCount == 1){
//					view.setText("点击图标，改变成可滑动，显示三屏");
//				}else{
//					view.setText("点击图标，改变成不可滑动，显示一屏");
//				}
//				iv_show_pic.setVisibility(View.VISIBLE);
//			} else if (position == 1) {
//				view.setText("1");
//				iv_show_pic.setVisibility(View.GONE);
//			} else if (position == 2) {
//				view.setText("2");
//				iv_show_pic.setVisibility(View.GONE);
//			}
			View mView = null;
			if(position == 0){
				mView = OneView;
			}else if(position == 1){
				mView = TwoView;
			}else{
				mView = ThreeView;
			}
			((ViewPager) collection).addView(mView, position);
			return mView;
		}

		@Override
		public void destroyItem(View collection, int position, Object view) {
			((ViewPager) collection).removeView((View) view);
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == (object);
		}

		@Override
		public void finishUpdate(View arg0) {
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}

	}

	OnPageChangeListener changeListener = new OnPageChangeListener() {
		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			switch (arg0) {
				case 0:
					record_time_text.setTextColor(getResources().getColor(
							R.color.color_2087e8));

					star_len_text.setTextColor(getResources().getColor(
							R.color.color_666666));

					date_size_text.setTextColor(getResources().getColor(
							R.color.color_666666));
					break;
				case 1:
					record_time_text.setTextColor(getResources().getColor(
							R.color.color_666666));

					star_len_text.setTextColor(getResources().getColor(
							R.color.color_2087e8));

					date_size_text.setTextColor(getResources().getColor(
							R.color.color_666666));
					break;
				case 2:
					record_time_text.setTextColor(getResources().getColor(
							R.color.color_666666));

					star_len_text.setTextColor(getResources().getColor(
							R.color.color_666666));

					date_size_text.setTextColor(getResources().getColor(
							R.color.color_2087e8));
					break;
			}
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}
	};
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.tv_page:
				Toast.makeText(this, "Here", Toast.LENGTH_SHORT).show();
				break;
			case R.id.iv_show_pic:
				if(rankPagerAdapter.getCount() == 3){
					button.setVisibility(View.INVISIBLE);
					rankPagerAdapter.setCount(1);
					viewpager.setAdapter(rankPagerAdapter);
				}else{
					button.setVisibility(View.VISIBLE);
					rankPagerAdapter.setCount(3);
					viewpager.setAdapter(rankPagerAdapter);
				}

				break;
			case R.id.rank_record:
				viewpager.setCurrentItem(0);
				break;
			case R.id.rank_star:
				viewpager.setCurrentItem(1);
				break;
			case R.id.rank_date:
				viewpager.setCurrentItem(2);
				break;

			default:
				break;
		}
	}

}
