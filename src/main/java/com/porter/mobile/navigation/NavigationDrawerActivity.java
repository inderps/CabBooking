package com.porter.mobile.navigation;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;

import com.porter.mobile.booking.NewRideFragment;

import org.porter.R;

public class NavigationDrawerActivity extends Activity
    implements NavigationDrawerFragment.NavigationDrawerCallbacks {

  private NavigationDrawerFragment mNavigationDrawerFragment;
  private CharSequence mTitle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_navigation_drawer);

    mNavigationDrawerFragment = (NavigationDrawerFragment)
        getFragmentManager().findFragmentById(R.id.navigation_drawer);
    mTitle = getTitle();

    mNavigationDrawerFragment.setUp(
        R.id.navigation_drawer,
        (DrawerLayout) findViewById(R.id.drawer_layout));
  }

  @Override
  public void onNavigationDrawerItemSelected(int position) {
    FragmentManager fragmentManager = getFragmentManager();
    Fragment fragment = null;
    switch (position) {
      case 0:
        fragment = NewRideFragment.newInstance();
        break;
    }
    fragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .commit();
  }

  public void onSectionAttached(int number) {
    switch (number) {
      case 1:
        mTitle = getString(R.string.title_section1);
        break;
      case 2:
        mTitle = getString(R.string.title_section2);
        break;
      case 3:
        mTitle = getString(R.string.title_section3);
        break;
    }
  }

  public void restoreActionBar() {
    ActionBar actionBar = getActionBar();
    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
    actionBar.setDisplayShowTitleEnabled(true);
    actionBar.setTitle(mTitle);
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    if (!mNavigationDrawerFragment.isDrawerOpen()) {
      restoreActionBar();
      return true;
    }
    return super.onCreateOptionsMenu(menu);
  }
}
