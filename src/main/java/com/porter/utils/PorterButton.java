package com.porter.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

public class PorterButton extends Button {

  public PorterButton(Context context, AttributeSet attributes) {
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

