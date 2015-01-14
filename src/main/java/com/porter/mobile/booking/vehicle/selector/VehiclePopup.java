package com.porter.mobile.booking.vehicle.selector;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

import com.porter.rest.model.Vehicle;

import org.porter.R;

public class VehiclePopup extends Dialog {
  private Vehicle vehicle;
  public VehiclePopup(Context context, Vehicle vehicle) {
    super(context);
    this.vehicle = vehicle;
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.vehicle_details_popup);
    show();
  }
}
