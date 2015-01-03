package com.porter.mobile;

import android.app.Activity;
import android.view.Menu;

import org.porter.R;

public abstract class BaseActivity extends Activity {

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_base, menu);
    return true;
  }
}
