package com.porter.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class PorterTextView extends TextView {

  public PorterTextView(Context context, AttributeSet attributes) {
    super(context, attributes);
    applyPortFont();
  }

  @Override
  public void setTextAppearance(Context context, int resid) {
    super.setTextAppearance(context, resid);
    applyPortFont();
  }

  private void applyPortFont() {
    PorterFont.setBoldTypeface(this);
  }
}

