package com.porter.mobile.booking.vehicle.selector;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import org.porter.R;

import java.util.ArrayList;

public class VehicleSelector extends RelativeLayout {
  public VehicleSelector(Context context, AttributeSet attrs) {
    super(context, attrs);
    ((Activity)getContext()).getLayoutInflater().inflate(R.layout.vehicle_selector, this, true);
  }
}
