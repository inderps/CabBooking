package com.porter.mobile.booking;

import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;

import com.porter.rest.model.AutosuggestedPlace;
import com.porter.utils.PorterTextView;

import org.porter.R;

public class DropLocationLayout extends LinearLayout{
  private AutosuggestedPlace place;

  public DropLocationLayout(Context context) {
    super(context);
    ((Activity)getContext()).getLayoutInflater().inflate(R.layout.drop_location_row, this, true);
  }

  public void setPlace(AutosuggestedPlace place) {
    this.place = place;
    PorterTextView rideLocation = (PorterTextView)findViewById(R.id.ride_location);
    rideLocation.setText(this.place.getPlaceName());
  }

  public AutosuggestedPlace getPlace() {
    return place;
  }
}
