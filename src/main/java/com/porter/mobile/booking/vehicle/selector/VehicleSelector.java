package com.porter.mobile.booking.vehicle.selector;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.porter.utils.PorterTextView;

import org.porter.R;

import java.util.ArrayList;

public class VehicleSelector extends RelativeLayout {
  public VehicleSelector(Context context, AttributeSet attrs) {
    super(context, attrs);
    ((Activity)getContext()).getLayoutInflater().inflate(R.layout.vehicle_selector, this, true);
    setSeekbarAutoMovement();
    selectVehicle(R.id.tataace_layout, R.id.tataace_label);
    unSelectVehicle(R.id.tata909_layout, R.id.tata909_label);
  }

  private void setSeekbarAutoMovement() {
    SeekBar seekBar = (SeekBar)findViewById(R.id.vehicle_seek_baar);
    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(progress < 50){
          selectVehicle(R.id.tataace_layout, R.id.tataace_label);
          unSelectVehicle(R.id.tata909_layout, R.id.tata909_label);
        }
        else{
          selectVehicle(R.id.tata909_layout, R.id.tata909_label);
          unSelectVehicle(R.id.tataace_layout, R.id.tataace_label);
        }
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
        if(seekBar.getProgress() < 50){
          seekBar.setProgress(0);
        }
        else{
          seekBar.setProgress(100);
        }
      }
    });
  }

  private void selectVehicle(int vehicleLayoutId, int vehicleLabelId){
    LinearLayout vehicleLayout = (LinearLayout)findViewById(vehicleLayoutId);
    vehicleLayout.setBackgroundResource(R.drawable.vehicle_background_selected);
    PorterTextView vehicleLabel = (PorterTextView)findViewById(vehicleLabelId);
    vehicleLabel.setTextColor(getResources().getColor(R.color.white));
  }

  private void unSelectVehicle(int vehicleLayoutId, int vehicleLabelId){
    LinearLayout vehicleLayout = (LinearLayout)findViewById(vehicleLayoutId);
    vehicleLayout.setBackgroundResource(R.drawable.vehicle_background);
    PorterTextView vehicleLabel = (PorterTextView)findViewById(vehicleLabelId);
    vehicleLabel.setTextColor(getResources().getColor(R.color.blue));
  }
}
