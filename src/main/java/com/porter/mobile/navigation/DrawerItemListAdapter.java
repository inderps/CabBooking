package com.porter.mobile.navigation;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.porter.mobile.navigation.item.DrawerItem;

import java.util.List;

class DrawerItemListAdapter extends BaseAdapter {

  private final Context context;
  private List<DrawerItem> drawerItems;

  public DrawerItemListAdapter(Context context, List<DrawerItem> drawerItems) {
    super();
    this.context = context;
    this.drawerItems = drawerItems;
  }

  @Override
  public boolean isEnabled(int position) {
    return drawerItems.get(position).isEnabled();
  }

  @Override
  public int getViewTypeCount() {
    return 3;
  }

  public int getCount() {
    return drawerItems.size();
  }

  public Object getItem(int position) {
    return null;
  }

  public long getItemId(int position) {
    return 0;
  }

  public View getView(int position, View convertView, ViewGroup parent) {
    DrawerItem drawerItem = drawerItems.get(position);
    View view = convertView;
    if (view == null) {
      LayoutInflater inflater = ((Activity) context).getLayoutInflater();
      view = inflater.inflate(drawerItem.getLayout(), null);
    }
    drawerItem.renderData(view);
    return view;
  }

  @Override
  public int getItemViewType(int position) {
    DrawerItem drawerItem = drawerItems.get(position);
    return drawerItem.getItemViewType();
  }
}