package com.porter.mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import org.porter.R;
import com.porter.mobile.booking.NewRideActivity;

public class SplashScreenActivity extends Activity {

  private Thread splashThread;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);

    splashThread = new Thread() {
      @Override
      public void run() {
        try {
          synchronized (this) {
            wait(4000);
          }
        } catch (InterruptedException ex) { }
        Intent intent = new Intent(getApplicationContext(), NewRideActivity.class);
        startActivity(intent);
        finish();
        splashThread.interrupt();
      }
    };
    splashThread.start();
  }
}
