package com.porter.mobile.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.porter.mobile.navigation.NavigationDrawerActivity;
import com.porter.mobile.registration.RegisterNewUserActivity;

import org.porter.R;

public class LoginActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
  }

  public void login(View view) {
    Intent intent = new Intent(this, NavigationDrawerActivity.class);
    startActivity(intent);
  }

  public void signup(View view) {
    Intent intent = new Intent(this, RegisterNewUserActivity.class);
    startActivity(intent);
  }
}
