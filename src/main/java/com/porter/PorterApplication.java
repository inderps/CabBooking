package com.porter;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

public class PorterApplication extends Application{
  @Override
  public void onCreate() {
    super.onCreate();
//    ActiveAndroid.initialize(this);
  }
}
