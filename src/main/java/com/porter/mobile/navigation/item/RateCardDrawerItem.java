package com.porter.mobile.navigation.item;

import android.app.Fragment;

import com.porter.mobile.booking.NewRideFragment;
import com.porter.mobile.ratecard.RateCardFragment;

import org.porter.R;

public class RateCardDrawerItem extends DrawerItem{
  public RateCardDrawerItem() {
    super(R.string.rate_card_title, R.drawable.rate_icon);
  }

  @Override
  public Fragment getFragment(){
    return RateCardFragment.newInstance();
  }
}
