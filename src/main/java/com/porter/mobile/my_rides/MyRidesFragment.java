package com.porter.mobile.my_rides;

import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.porter.mobile.BaseFragment;

import org.porter.R;

public class MyRidesFragment extends BaseFragment{
  private ViewPager viewPager;
  private MyRidesPagerAdapter myRidesPagerAdapter;

  public MyRidesFragment() {
  }
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_my_rides, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewPager = (ViewPager) view.findViewById(R.id.pager);
    myRidesPagerAdapter = new MyRidesPagerAdapter(getChildFragmentManager(), getActivity().getApplicationContext());

    viewPager.setAdapter(myRidesPagerAdapter);
    PagerTabStrip tab = (PagerTabStrip)view.findViewById(R.id.pager_tab_strip);
    tab.setTabIndicatorColorResource(R.color.blue);
  }
}
