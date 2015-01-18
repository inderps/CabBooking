package com.porter.mobile.my_rides;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.porter.mobile.BaseFragment;

import org.porter.R;

import java.util.ArrayList;
import java.util.List;

public class MyRidesPagerAdapter extends FragmentPagerAdapter {
  private List<BaseFragment> fragments;
  private Context context;

  public MyRidesPagerAdapter(FragmentManager fm, Context context) {
    super(fm);
    this.context = context;
    fragments = new ArrayList<BaseFragment>();

    fragments.add(MyRidesTabFragment.newInstance("all_rides"));
    fragments.add(MyRidesTabFragment.newInstance("upcoming"));
    fragments.add(MyRidesTabFragment.newInstance("completed"));
  }

  @Override
  public Fragment getItem(int position) {
    return fragments.get(position);
  }

  @Override
  public int getCount() {
    return fragments.size();
  }

  @Override
  public CharSequence getPageTitle(int position) {
    String title = this.context.getString(R.string.my_rides_all_rides);
    switch (position){
      case 0: title = this.context.getString(R.string.my_rides_all_rides);
        break;
      case 1: title = this.context.getString(R.string.my_rides_upcoming);
        break;
      case 2: title = this.context.getString(R.string.my_rides_completed);
        break;
    }
    return title;
  }
}
