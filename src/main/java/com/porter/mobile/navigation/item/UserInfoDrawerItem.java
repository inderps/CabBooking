package com.porter.mobile.navigation.item;

import android.app.Fragment;

import com.porter.mobile.booking.NewRideFragment;

import org.porter.R;

public class UserInfoDrawerItem extends DrawerItem{
  public UserInfoDrawerItem() {
    super(R.string.rate_card_title);
  }

  @Override
  public Fragment getFragment(){
    return NewRideFragment.newInstance();
  }
}
