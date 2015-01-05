package com.porter.mobile.navigation.item;

import android.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.porter.mobile.booking.NewRideFragment;

import org.porter.R;

public class UserInfoDrawerItem extends DrawerItem{
  public UserInfoDrawerItem() {
    super(R.string.profiles_title);
  }

  @Override
  public Fragment getFragment(){
    return NewRideFragment.newInstance();
  }

  @Override
  public int getLayout() {
    return R.layout.user_info_drawer_item;
  }

  @Override
  public int getItemViewType() {
    return 1;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public void renderData(View view) {
  }
}
