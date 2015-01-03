package com.porter.mobile.booking;

import android.os.Bundle;

import org.porter.R;

import com.porter.mobile.BaseActivity;


public class NewRideActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_ride);
//    RestClient restClient = new RestClient();
//    Callback callback = new Callback() {
//      @Override
//      public void success(Object o, Response response) {
//        Log.d("IPS", o.toString());
//      }
//
//      @Override
//      public void failure(RetrofitError retrofitError) {
//
//      }
//    };
//
//    restClient.getPorterApiService().getData("35", "139", callback);
//    new User("a", "s").save();
//
//    User user = User.getLoggedInUser();
//    Log.d("IPS", user.getName());
  }
}
