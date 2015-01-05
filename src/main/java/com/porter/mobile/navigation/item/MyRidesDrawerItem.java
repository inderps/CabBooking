package com.porter.mobile.navigation.item;

import android.app.Fragment;

import com.porter.mobile.booking.NewRideFragment;

import org.porter.R;

public class MyRidesDrawerItem extends DrawerItem{
  public MyRidesDrawerItem() {
    super(R.string.my_rides_title);
  }

  @Override
  public Fragment getFragment(){
    return NewRideFragment.newInstance();
  }
}