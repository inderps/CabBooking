package com.porter.mobile;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;

import com.porter.utils.TypefaceSpan;

import org.porter.R;

public abstract class BaseActivity extends Activity {

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.global, menu);
    return true;
  }

  public void setTitleActionBar(String title){
    SpannableString s = new SpannableString(title);
    s.setSpan(new TypefaceSpan(this, "myriad-web-pro.ttf"), 0, s.length(),
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    ActionBar actionBar = getActionBar();
    actionBar.setTitle(s);
  }
}
