package com.porter.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PorterShared {
  static final String PREF_USER_NAME= "username";

  static SharedPreferences getSharedPreferences(Context context) {
    return PreferenceManager.getDefaultSharedPreferences(context);
  }

  public static void loginUser(Context context, String userName)
  {
    SharedPreferences.Editor editor = getSharedPreferences(context).edit();
    editor.putString(PREF_USER_NAME, userName);
    editor.apply();
  }

  public static String isLoggedIn(Context context)
  {
    return getSharedPreferences(context).getString(PREF_USER_NAME, "");
  }
}
