package com.porter.mobile.navigation.item;

import android.app.Fragment;

import com.porter.mobile.booking.NewRideFragment;

import org.porter.R;

public class BookMyRidesDrawerItem extends DrawerItem{
  public BookMyRidesDrawerItem() {
    super(R.string.book_my_rides_title);
  }

  @Override
  public Fragment getFragment(){
    return NewRideFragment.newInstance();
  }
}