package com.porter.mobile.navigation.item;

import com.porter.mobile.my_rides.MyRidesFragment;

import org.porter.R;

public class MyRidesDrawerItem extends DrawerItem{
  public MyRidesDrawerItem() {
    super(R.string.my_rides_title, R.drawable.my_ride_icon);
  }

  @Override
  public android.support.v4.app.Fragment getFragment(){
    return new MyRidesFragment();
  }
}
