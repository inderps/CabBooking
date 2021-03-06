package com.porter.mobile.navigation;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;

import com.porter.mobile.BaseActivity;
import com.porter.mobile.navigation.item.BookMyRidesDrawerItem;
import com.porter.mobile.navigation.item.DrawerItem;
import com.porter.mobile.navigation.item.MyRidesDrawerItem;
import com.porter.mobile.navigation.item.UserInfoDrawerItem;

import org.porter.R;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerActivity extends BaseActivity
    implements NavigationDrawerFragment.NavigationDrawerCallbacks {

  private NavigationDrawerFragment mNavigationDrawerFragment;
  private CharSequence mTitle;
  private List<DrawerItem> drawerItems;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initializeDrawerItems();
    setContentView(R.layout.activity_navigation_drawer);

    mNavigationDrawerFragment = (NavigationDrawerFragment)
        getFragmentManager().findFragmentById(R.id.navigation_drawer);
    mTitle = getTitle();

    mNavigationDrawerFragment.setUp(
        R.id.navigation_drawer,
        (DrawerLayout) findViewById(R.id.drawer_layout));
    onNavigationDrawerItemSelected(1);
  }

  private void initializeDrawerItems() {
    drawerItems = new ArrayList<DrawerItem>();
    drawerItems.add(new UserInfoDrawerItem());
    drawerItems.add(new BookMyRidesDrawerItem());
    drawerItems.add(new MyRidesDrawerItem());
  }

  public List<DrawerItem> getDrawerItems(){
    return drawerItems;
  }

  @Override
  public void onNavigationDrawerItemSelected(int position) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment fragment = drawerItems.get(position).getFragment();
    fragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .commit();
    mTitle = getString(drawerItems.get(position).getTitle());
    setTitleActionBar(mTitle.toString());
  }

  public void restoreActionBar() {
    ActionBar actionBar = getActionBar();
    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
    actionBar.setDisplayShowTitleEnabled(true);
    setTitleActionBar(mTitle.toString());
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
