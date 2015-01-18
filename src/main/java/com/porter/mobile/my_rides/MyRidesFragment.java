package com.porter.mobile.my_rides;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.porter.mobile.BaseFragment;

import org.porter.R;

public class MyRidesFragment extends BaseFragment implements
    ActionBar.TabListener {
  private ViewPager viewPager;
  private ActionBar actionBar;

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
//    actionBar = getActivity().getActionBar();
//    mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
//
//    viewPager.setAdapter(mAdapter);
//    actionBar.setHomeButtonEnabled(false);
//    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//    // Adding Tabs
//    for (String tab_name : tabs) {
//      actionBar.addTab(actionBar.newTab().setText(tab_name)
//          .setTabListener(this));
//    }
  }

  @Override
  public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

  }

  @Override
  public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

  }

  @Override
  public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

  }
}
