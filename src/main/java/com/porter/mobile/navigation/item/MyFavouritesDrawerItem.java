package com.porter.mobile.navigation.item;

import android.app.Fragment;

import com.porter.mobile.booking.NewRideFragment;

import org.porter.R;

public class MyFavouritesDrawerItem extends DrawerItem{
  public MyFavouritesDrawerItem() {
    super(R.string.my_favourites_title);
  }

  @Override
  public Fragment getFragment(){
    return NewRideFragment.newInstance();
  }
}
