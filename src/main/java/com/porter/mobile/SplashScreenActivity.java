package com.porter.mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.porter.mobile.login.LoginActivity;
import com.porter.mobile.navigation.NavigationDrawerActivity;

import org.porter.R;

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
            wait(100);
          }
        } catch (InterruptedException ex) { }
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
        splashThread.interrupt();
      }
    };
    splashThread.start();
  }
}
