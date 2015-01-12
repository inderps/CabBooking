package com.porter.mobile.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.porter.mobile.login.LoginActivity;

import org.porter.R;

public class RegisterNewUserActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register_new_user);
  }

  public void login(View view) {
    Intent intent = new Intent(this, LoginActivity.class);
    startActivity(intent);
  }
}
