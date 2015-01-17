package com.porter.mobile.booking.vehicle.selector;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.porter.rest.model.Vehicle;

import org.porter.R;

public class VehicleSelector extends RelativeLayout {
  public VehicleSelector(Context context, AttributeSet attrs) {
    super(context, attrs);
    ((Activity)getContext()).getLayoutInflater().inflate(R.layout.vehicle_selector, this, true);
    setSeekbarAutoMovement();
    selectVehicle(R.drawable.tata_ace_selected);
  }

  private void setSeekbarAutoMovement() {
    final SeekBar seekBar = (SeekBar)findViewById(R.id.vehicle_seek_baar);
    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(progress < 50){
          selectVehicle(R.drawable.tata_ace_selected);
        }
        else{
          selectVehicle(R.drawable.tata_909_selected);
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

    seekBar.setOnTouchListener(new OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        boolean changedPosition = false;
        if(event.getAction() == MotionEvent.ACTION_MOVE)
        {
          changedPosition = true;
          seekBar.setProgress(seekBar.getProgress());
          return false;
        }
        else if (event.getAction() == MotionEvent.ACTION_UP)
        {
          if(!changedPosition)
          {
            if(seekBar.getProgress() == 0){
              new VehiclePopup(getContext(), new Vehicle());
            }
            else if(seekBar.getProgress() == 100){
              new VehiclePopup(getContext(), new Vehicle());
            }
          }
        }
        return false;
      }
    });
  }

  private void selectVehicle(int vehicleId){
    SeekBar seekBar = (SeekBar)findViewById(R.id.vehicle_seek_baar);
    seekBar.setThumb(getResources().getDrawable(vehicleId));
  }
}
