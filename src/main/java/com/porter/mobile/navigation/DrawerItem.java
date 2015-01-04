package com.porter.mobile.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.porter.R;

class DrawerItem implements Parcelable {
  private int title;
  private int icon;
  private int actionBarTitle;

  public DrawerItem(int title, int icon, int actionBarTitle) {
    this.title = title;
    this.icon = icon;
    this.actionBarTitle = actionBarTitle;
  }

  public DrawerItem(int title, int actionBarTitle) {
    this.title = title;
    this.actionBarTitle = actionBarTitle;
  }

  public DrawerItem(Parcel parcel) {
    title = parcel.readInt();
    icon = parcel.readInt();
    actionBarTitle = parcel.readInt();
  }

  public int getTitle() {
    return this.title;
  }

  public int getLayout() {
    return R.layout.drawer_item;
  }

  public int getItemViewType() {
    return 0;
  }

  public boolean isEnabled() {
    return true;
  }

  public int getActionBarTitle() {
    return actionBarTitle;
  }

  public void renderData(View view) {
    ViewGroup layout = (ViewGroup) view;
    ImageView iconView = (ImageView) layout.findViewById(R.id.drawer_item_icon);
    iconView.setImageResource(icon);
    TextView titleView = (TextView) layout.findViewById(R.id.drawer_item_text);
    titleView.setText(title);
  }

  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(title);
    dest.writeInt(icon);
    dest.writeInt(actionBarTitle);
  }

  public static final Parcelable.Creator<DrawerItem> CREATOR = new Parcelable.Creator<DrawerItem>() {

    public DrawerItem createFromParcel(Parcel in) {
      return new DrawerItem(in);
    }

    public DrawerItem[] newArray(int size) {
      return new DrawerItem[size];
    }

  };
}
