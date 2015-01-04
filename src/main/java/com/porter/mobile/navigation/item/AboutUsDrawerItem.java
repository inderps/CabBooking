package com.porter.mobile.navigation.item;

import android.app.Fragment;

import com.porter.mobile.booking.NewRideFragment;

import org.porter.R;

public class AboutUsDrawerItem extends DrawerItem{
  public AboutUsDrawerItem() {
    super(R.string.about_us_title);
  }

  @Override
  public Fragment getFragment(){
    return NewRideFragment.newInstance();
  }
}
