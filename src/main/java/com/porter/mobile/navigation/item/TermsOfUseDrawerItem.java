package com.porter.mobile.navigation.item;

import android.app.Fragment;

import com.porter.mobile.booking.NewRideFragment;

import org.porter.R;

public class TermsOfUseDrawerItem extends DrawerItem{
  public TermsOfUseDrawerItem() {
    super(R.string.terms_of_use_title);
  }

  @Override
  public Fragment getFragment(){
    return NewRideFragment.newInstance();
  }
}
