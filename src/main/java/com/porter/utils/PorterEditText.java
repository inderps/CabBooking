package com.porter.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

public class PorterEditText extends EditText {

  public PorterEditText(Context context, AttributeSet attributes) {
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

