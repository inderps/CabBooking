package org.porter.mobile.booking;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.porter.R;
import org.porter.database.User;
import org.porter.mobile.BaseActivity;
import org.porter.rest.RestClient;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


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
